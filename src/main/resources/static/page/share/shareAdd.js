layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;
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
    form.verify({
        shareName : function(val){
            if(val == ''){
                return "资源标题不能为空";
            }
        }
    })
    form.on("submit(addShare)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
       // 实际使用时的提交信息
        $.post("/share/add",{
            shareName : $(".shareName").val(),  //文章标题
            shareIntro : $(".abstract").val(),  //文章摘要
            shareUrl : $(".shareUrl").val(),  //文章摘要
            shareDownload : $(".shareDownload").val(),  //文章摘要
            shareImg : $(".thumbImg").attr("src"),  //缩略图
            shareClassify : $('input[name="clz"]:checked').val(),    //文章分类
            shareStatus : $('.shareStatus select').val(),    //发布状态
        },function(res){
            if (res.status==200){
                top.layer.close(index);
                top.layer.msg("添加资源成功！");
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
            top.layer.msg("添加资源超时！");
            layer.closeAll("iframe");
            //刷新父页面
            parent.location.reload();
        },5000);
        return false;
    })


})