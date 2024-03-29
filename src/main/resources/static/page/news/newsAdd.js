layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;

    //用于同步编辑器内容到textarea
    layedit.sync(editIndex);

    //上传缩略图
    upload.render({
        elem: '.thumbBox',
        url: '/pic/upload',//../../json/userface.json
        field:"uploadFile",
        size: 2048,
        //method : "get",  //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
        done: function(res, index, upload){
            //var num = parseInt(4*Math.random());  //生成0-4的随机数，随机显示一个头像信息
            if (res.error==0){
                $('.thumbImg').attr('src',res.url);//res.data[num].src
                $('.thumbBox').css("background","#fff");
            }else{
                top.layer.msg("上传图片失败");
            }
        }
    });

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
    laydate.render({
        elem: '#release',
        type: 'datetime',
        trigger : "click",
        done : function(value, date, endDate){
            submitTime = value;
        }
    });
    form.on("radio(release)",function(data){
        if(data.elem.title == "定时发布"){
            $(".releaseDate").removeClass("layui-hide");
            $(".releaseDate #release").attr("lay-verify","required");
        }else{
            $(".releaseDate").addClass("layui-hide");
            $(".releaseDate #release").removeAttr("lay-verify");
            submitTime = time.getFullYear()+'-'+(time.getMonth()+1)+'-'+time.getDate()+' '+time.getHours()+':'+time.getMinutes()+':'+time.getSeconds();
        }
    });

    form.verify({
        newsName : function(val){
            layedit.sync(editIndex);
            if(val == ''){
                return "文章标题不能为空";
            }
        },
        content : function(val){
            layedit.sync(editIndex);
            //console.log(val);
            if(val == ''){
                return "文章内容不能为空";
            }
        }
    })
    form.on("submit(addNews)",function(data){
        //截取文章内容中的一部分文字放入文章摘要
        var abstract = layedit.getText(editIndex).substring(0,50);
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
       // 实际使用时的提交信息
        $.post("/news/add",{
            newsName : $(".newsName").val(),  //文章标题
            newsAbstract : $(".abstract").val(),  //文章摘要
            content : layedit.getContent(editIndex).split('<audio controls="controls" style="display: none;"></audio>')[0],  //文章内容
            newsImg : $(".thumbImg").attr("src"),  //缩略图
            newsClassify : $('input[name="clz"]:checked').val(),    //文章分类
            newsStatus : $('.newsStatus select').val(),    //发布状态
            newsLook : $('.newsLook input[name="openness"]:checked ').val(),
            //newsTime : submitTime,    //发布时间
            newsTop : data.field.newsTop == "on" ? "checked" : "",    //是否置顶
        },function(res){
            if (res.status==200){
                top.layer.close(index);
                top.layer.msg("文章添加成功！");
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
        setTimeout(function(){
            top.layer.close(index);
            top.layer.msg("添加文章超时！");
            layer.closeAll("iframe");
            //刷新父页面
            parent.location.reload();
        },5000);
        return false;
    })

    //预览
    form.on("submit(look)",function(){
        layer.alert("此功能需要前台展示，实际开发中传入对应的必要参数进行文章内容页面访问");
        return false;
    })
    layedit.set({
        uploadImage: {
            url : "/pic/upload2",//  ../../json/newsImg.json
            type: "post",
        }
    });
    //
    //创建一个编辑器
    var editIndex = layedit.build('news_content',{
        height : 535,
        tool: ['strong','italic','underline','del', '|', 'left', 'center', 'right', '|', 'link','unlink','face','image','code'],
    });

})