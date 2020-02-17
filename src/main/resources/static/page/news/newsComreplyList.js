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
        elem: '#comreplyList',
        url : '/comreply/list', //  ../../json/newsList.json
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [5,10,15,20,25],
        id : "comreplyListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'replyComId', title: '评论ID', width:100, align:"center"},//,style:"display:none"
            {field: 'replyId', title: '回复ID', width:100},
            {field: 'replyName', title: '发布者', align:'center'},
            {field: 'replyContent', title: '回复内容',  align:'center',width:260},
            {field: 'replyTime', title: '发布时间', align:'center', minWidth:100, templet:function(d){
                    return new Date(d.replyTime).format("yyyy-MM-dd hh:mm");
                }},
            {title: '操作', width:170, templet:'#comreplyListBar',fixed:"right",align:"center"}
        ]],
        done: function () {
            // $("[data-field='newsId']").css('display','none');
        }
    });


    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''||true){//搜索为空时服务器端查询所有
            table.reload("comreplyListTable",{
                where:{
                    comreplyname:$(".searchVal").val()
                },
                elem: '#comreplyList',
                url : '/comreply/list', //  ../../json/newsList.json
                cellMinWidth : 95,
                page : true,
                height : "full-125",
                limit : 10,
                limits : [5,10,15,20,25],
                id : "comreplyListTable",
                cols : [[
                    {type: "checkbox", fixed:"left", width:50},
                    {field: 'replyComId', title: '评论ID', width:100, align:"center"},//,style:"display:none"
                    {field: 'replyId', title: '回复ID', width:100},
                    {field: 'replyName', title: '发布者', align:'center'},
                    {field: 'replyContent', title: '回复内容',  align:'center',width:260},
                    {field: 'replyTime', title: '发布时间', align:'center', minWidth:100, templet:function(d){
                            return new Date(d.replyTime).format("yyyy-MM-dd hh:mm");
                        }},
                    {title: '操作', width:170, templet:'#comreplyListBar',fixed:"right",align:"center"}
                ]],
                done: function () {
                    // $("[data-field='newsId']").css('display','none');
                }
            })
        }else{//搜索为空时服务器端查询所有
            // layer.msg("请输入搜索的内容");
        }
    });

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('comreplyListTable'),
            data = checkStatus.data,
            comreplyId = [];
        if(data.length > 0) {
            for (var i in data) {
                comreplyId.push(data[i].replyId);
            }
            layer.confirm('确定删除选中的评论？', {icon: 3, title: '提示信息'}, function (index) {
                $.get("/comreply/batch_delete",{
                    crids : comreplyId  //将需要删除的newsId作为参数传入
                },function(data){
                    if (data.status==200){
                        top.layer.msg("回复删除成功！");
                    }else{
                        top.layer.msg(data.msg);
                    }
                    tableIns.reload();
                    layer.close(index);
                })
            })
        }else{
            layer.msg("请选择需要删除的回复");
        }
    })

    //列表操作
    table.on('tool(comreplyList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此回复？',{icon:3, title:'提示信息'},function(index){
                $.get("/comreply/delete",{
                    comreplyId : data.replyId  //将需要删除的newsId作为参数传入
                },function(data){
                    if (data.status==200){
                        top.layer.msg("回复删除成功！");
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