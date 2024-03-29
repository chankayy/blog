layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;

    $(".loginBody .seraph").click(function(){
        layer.msg("这只是做个样式，至于功能，你见过哪个后台能这样登录的？还是老老实实的找管理员去注册吧",{
            time:5000
        });
    })
    //登录按钮
    var flag = false;
    var img = document.getElementById("imgCodeDetail");
    form.on("submit(login)",function(data){
        var btn =  $(this);
        btn.text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
        $.post("/login",{
            username : $("#userName").val(),  //登录名
            password : $("#password").val(),  //密码
            //"remember-me":"on",
            captcha:$("#code").val(),//验证码
        },function(res){
            //console.log(res);
            if (res.status==200){
                layer.msg("登录成功！",{
                    time:1000
                });
                window.location.href = "/index.html";
                btn.text("登录").removeAttr("disabled").removeClass("layui-disabled");
                flag = true;
                //刷新父页面
            }else if (res.status==400){
                setTimeout(function(){
                    layer.msg("验证码错误！",{//res.msg
                        time:2000
                    });
                    //刷新父页面
                    // parent.location.reload();
                    setTimeout(function(){
                        //window.location.href = "/layuicms2.0";
                       // window.location.href = "/page/login/login.html";
                        btn.text("登录").removeAttr("disabled").removeClass("layui-disabled");
                        flag = true;
                        $("#code").val("").focus();
                        refresh(img);
                    },2000);
                },1000);
                //刷新父页面
            }else if (res.status==403){
                setTimeout(function(){
                    layer.msg(res.data,{//res.msg
                        time:2000
                    });
                    //刷新父页面
                    // parent.location.reload();
                    setTimeout(function(){
                        //window.location.href = "/layuicms2.0";
                        //window.location.href = "/page/login/login.html";
                        btn.text("登录").removeAttr("disabled").removeClass("layui-disabled");
                        flag = true;
                        $("#code").val("").focus();
                        refresh(img);
                    },2000);
                },1000);
                //刷新父页面
            }else{
                setTimeout(function(){
                    layer.msg("登录失败！",{//res.msg
                        time:2000
                    });
                    //刷新父页面
                   // parent.location.reload();
                    setTimeout(function(){
                        //window.location.href = "/layuicms2.0";
                       //window.location.href = "/page/login/login.html";
                        btn.text("登录").removeAttr("disabled").removeClass("layui-disabled");
                        flag = true;
                        $("#code").val("").focus();
                        refresh(img);
                    },2000);
                },1000);
            }
        })
        setTimeout(function(){
            if (!flag){
                layer.msg("登录超时！管理员可能关闭了登录接口",{
                    time:2000
                });
                setTimeout(function(){
                    //window.location.href = "/layuicms2.0";
                    //window.location.href = "/page/login/login.html";///layuicms2.0
                    $(this).text("登录").removeAttr("disabled").removeClass("layui-disabled");
                },2000);
                $("#code").val("").focus();
                refresh(img);
            }
        },5000);
        return false;
    })

    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
})
function refresh(obj) {
    obj.src = "/user/captcha.jpg?t=" + new Date().getMilliseconds();
}
