Date.prototype.format = function(format){
    var o =  {
        "M+" : this.getMonth()+1, //month
        "d+" : this.getDate(), //day
        "h+" : this.getHours(), //hour
        "m+" : this.getMinutes(), //minute
        "s+" : this.getSeconds(), //second
        "q+" : Math.floor((this.getMonth()+3)/3), //quarter
        "S" : this.getMilliseconds() //millisecond
    };
    if(/(y+)/.test(format)){
        format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    for(var k in o)  {
        if(new RegExp("("+ k +")").test(format)){
            format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
        }
    }
    return format;
};
layui.use(['form','layer','laydate','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;

    //新闻列表
    var tableIns = table.render({
        elem: '#shareList',
        url : '/share/list', //  ../../json/newsList.json
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [5,10,15,20,25],
        id : "shareListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'shareId', title: 'ID', width:100, align:"center"},//,style:"display:none"
            {field: 'shareName', title: '资源名', width:150},
            {field: 'shareAuthor', title: '发布者', width:120,align:'center'},
            {field: 'shareClassify', title: '分类', width:120,align:'center'},
            {field: 'shareIntro', title: '资源简介', width:250,align:'center'},
            {field: 'shareStatus', title: '发布状态',width:120,  align:'center',templet:"#shareStatus"},
            {field: 'shareTime', title: '发布时间', align:'center', minWidth:170, templet:function(d){
                    return new Date(d.shareTime).format("yyyy-MM-dd hh:mm");
                    //(d.newsTime).replace("T"," ").substring(0,(d.newsTime).length-12);
                }},
            {title: '操作', width:170, templet:'#shareListBar',fixed:"right",align:"center"}
        ]],
        done: function () {
           // $("[data-field='newsId']").css('display','none');
        }
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''||true){//搜索为空时服务器端查询所有
            table.reload("shareListTable",{
                where:{
                    sharename:$(".searchVal").val()
                },
                elem: '#shareList',
                url : '/share/list', //  ../../json/newsList.json
                cellMinWidth : 95,
                page : true,
                height : "full-125",
                limit : 10,
                limits : [5,10,15,20,25],
                id : "newsListTable",
                cols : [[
                    {type: "checkbox", fixed:"left", width:50},
                    {field: 'shareId', title: 'ID', width:100, align:"center"},//,style:"display:none"
                    {field: 'shareName', title: '资源名', width:150},
                    {field: 'shareAuthor', title: '发布者', width:120,align:'center'},
                    {field: 'shareClassify', title: '分类', width:120,align:'center'},
                    {field: 'shareIntro', title: '资源简介', width:250,align:'center'},
                    {field: 'shareStatus', title: '发布状态',width:120,  align:'center',templet:"#shareStatus"},
                    {field: 'shareTime', title: '发布时间', align:'center', minWidth:170, templet:function(d){
                            return new Date(d.shareTime).format("yyyy-MM-dd hh:mm");
                            //(d.newsTime).replace("T"," ").substring(0,(d.newsTime).length-12);
                        }},
                    {title: '操作', width:170, templet:'#shareListBar',fixed:"right",align:"center"}
                ]],
                /*done: function () {
                    $("[data-field='newsId']").css('display','none');
                }*/
            })
        }else{//搜索为空时服务器端查询所有
            // layer.msg("请输入搜索的内容");
        }
    });

    //添加文章
    function addShare(edit){
        var index = layui.layer.open({
            title : "添加资源",
            type : 2,
            content : "shareAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".shareName").val(edit.shareName);
                    body.find(".abstract").val(edit.shareIntro);
                    body.find(".thumbImg").attr("src",edit.shareImg);
                    body.find("input[name='clz'][value='"+edit.shareClassify+"']").prop("checked","checked");
                    body.find(".shareUrl").val(edit.shareUrl);
                    body.find(".shareDownload").val(edit.shareDownload);
                    body.find(".shareStatus select").val(edit.shareStatus);
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回资源列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }
    //修改文章
    function updateShare(edit){
        var index = layui.layer.open({
            title : "更新资源",
            type : 2,
            content : "shareUpdate.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".shareId").val(edit.shareId);
                    body.find(".shareName").val(edit.shareName);
                    body.find(".abstract").val(edit.shareIntro);
                    body.find(".thumbImg").attr("src",edit.shareImg);
                    body.find("input[name='clz'][value='"+edit.shareClassify+"']").prop("checked","checked");
                    body.find(".shareUrl").val(edit.shareUrl);
                    body.find(".shareDownload").val(edit.shareDownload);
                    body.find(".shareStatus select").val(edit.shareStatus);
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返资源列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(index);
        })
    }
    $(".addShare_btn").click(function(){
        addShare();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('shareListTable'),
            data = checkStatus.data,
            shareId = [];
        if(data.length > 0) {
            for (var i in data) {
                shareId.push(data[i].shareId);
            }
            layer.confirm('确定删除选中的资源？', {icon: 3, title: '提示信息'}, function (index) {
                 $.get("/share/batch_delete",{
                     sids : shareId  //将需要删除的newsId作为参数传入
                 },function(data){
                     if (data.status==200){
                         top.layer.msg("资源删除成功！");
                     }else{
                         top.layer.msg(data.msg);
                     }
                     tableIns.reload();
                     layer.close(index);
                 })
            })
        }else{
            layer.msg("请选择需要删除的资源");
        }
    })

    //列表操作
    table.on('tool(shareList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'edit'){ //编辑
            updateShare(data);
        } else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此资源？',{icon:3, title:'提示信息'},function(index){
                 $.get("/share/delete",{
                     shareId : data.shareId  //将需要删除的newsId作为参数传入
                 },function(data){
                    if (data.status==200){
                        top.layer.msg("资源删除成功！");
                    }else{
                        top.layer.msg(data.msg);
                    }
                    tableIns.reload();
                    layer.close(index);
                 })
            });
        }
    });

})