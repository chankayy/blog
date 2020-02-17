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
        elem: '#messageList',
        url : '/message/list', //  ../../json/newsList.json
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [5,10,15,20,25],
        id : "messageListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'msgId', title: '留言ID', width:100, align:"center"},//,style:"display:none"
            {field: 'msgName', title: '发布者', align:'center'},
            {field: 'msgContent', title: '留言内容',  align:'center',width:260},
            {field: 'msgTime', title: '发布时间', align:'center', minWidth:100, templet:function(d){
                    return new Date(d.msgTime).format("yyyy-MM-dd hh:mm");
                }},
            {title: '操作', width:170, templet:'#messageListBar',fixed:"right",align:"center"}
        ]],
        done: function () {
            // $("[data-field='newsId']").css('display','none');
        }
    });


    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''||true){//搜索为空时服务器端查询所有
            table.reload("messageListTable",{
                where:{
                    messagename:$(".searchVal").val()
                },
                elem: '#messageList',
                url : '/message/list', //  ../../json/newsList.json
                cellMinWidth : 95,
                page : true,
                height : "full-125",
                limit : 10,
                limits : [5,10,15,20,25],
                id : "messageListTable",
                cols : [[
                    {type: "checkbox", fixed:"left", width:50},
                    {field: 'msgId', title: '留言ID', width:100, align:"center"},//,style:"display:none"
                    {field: 'msgName', title: '发布者', align:'center'},
                    {field: 'msgContent', title: '留言内容',  align:'center',width:260},
                    {field: 'msgTime', title: '发布时间', align:'center', minWidth:100, templet:function(d){
                            return new Date(d.msgTime).format("yyyy-MM-dd hh:mm");
                        }},
                    {title: '操作', width:170, templet:'#messageListBar',fixed:"right",align:"center"}
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
        var checkStatus = table.checkStatus('messageListTable'),
            data = checkStatus.data,
            messageId = [];
        if(data.length > 0) {
            for (var i in data) {
                messageId.push(data[i].msgId);
            }
            layer.confirm('确定删除选中的留言？', {icon: 3, title: '提示信息'}, function (index) {
                $.get("/message/batch_delete",{
                    mids : messageId  //将需要删除的newsId作为参数传入
                },function(data){
                    if (data.status==200){
                        top.layer.msg("留言删除成功！");
                    }else{
                        top.layer.msg(data.msg);
                    }
                    tableIns.reload();
                    layer.close(index);
                })
            })
        }else{
            layer.msg("请选择需要删除的留言");
        }
    })

    //列表操作
    table.on('tool(messageList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此留言？',{icon:3, title:'提示信息'},function(index){
                $.get("/message/delete",{
                    msgId : data.msgId  //将需要删除的newsId作为参数传入
                },function(data){
                    if (data.status==200){
                        top.layer.msg("留言删除成功！");
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