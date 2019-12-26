
String.prototype.replaceAll = function(s1,s2){
    return this.replace(new RegExp(s1,"gm"),s2);
}
layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    form.on("submit(addUser)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        //console.log("---"+$(".password").val()+"---");
        //console.log($(".userDesc").val());
        var pwd = $(".password").val();
        pwd = pwd.replaceAll(" ","&nbsp;")
        // 实际使用时的提交信息
         $.post("/user/update",{
             usersId:$(".usersId").val(),//id
             userName : $(".userName").val(),  //登录名
             password : pwd,  //密码
             userEmail : $(".userEmail").val(),  //邮箱
             userSex : data.field.sex,  //性别
             userGrade : data.field.userGrade,  //会员等级
             userStatus : data.field.userStatus,    //用户状态
             //userTime : submitTime,    //添加时间
             userDesc : $(".userDesc").val(),    //用户简介
         },function(res){
             setTimeout(function(){
                 top.layer.close(index);
                 top.layer.msg("用户修改失败！");
                 layer.closeAll("iframe");
                 //刷新父页面
                 parent.location.reload();
             },5000);
             if (res.status==200){
                top.layer.close(index);
                top.layer.msg("用户修改成功！");
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            }else{
                 top.layer.close(index);
                 top.layer.msg(res.msg);
                 layer.closeAll("iframe");
                 //刷新父页面
                 parent.location.reload();
            }
         })

        return false;
    })

    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());

})