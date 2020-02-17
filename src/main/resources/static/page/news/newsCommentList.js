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
        elem: '#comList',
        url : '/com/list', //  ../../json/newsList.json
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limit : 10,
        limits : [5,10,15,20,25],
        id : "comListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'comNewsId', title: '文章ID', width:100, align:"center"},//,style:"display:none"
            {field: 'comId', title: '评论ID', width:100},
            {field: 'comName', title: '发布者', align:'center'},
            {field: 'comContent', title: '评论内容',  align:'center',width:260},
            {field: 'comTime', title: '发布时间', align:'center', minWidth:100, templet:function(d){
                    return new Date(d.comTime).format("yyyy-MM-dd hh:mm");
                }},
            {title: '操作', width:170, templet:'#comListBar',fixed:"right",align:"center"}
        ]],
        done: function () {
            // $("[data-field='newsId']").css('display','none');
        }
    });


    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''||true){//搜索为空时服务器端查询所有
            table.reload("comListTable",{
                where:{
                    commentname:$(".searchVal").val()
                },
                elem: '#comList',
                url : '/com/list', //  ../../json/newsList.json
                cellMinWidth : 95,
                page : true,
                height : "full-125",
                limit : 10,
                limits : [5,10,15,20,25],
                id : "comListTable",
                cols : [[
                    {type: "checkbox", fixed:"left", width:50},
                    {field: 'comNewsId', title: '文章ID', width:100, align:"center"},//,style:"display:none"
                    {field: 'comId', title: '评论ID', width:100},
                    {field: 'comName', title: '发布者', align:'center'},
                    {field: 'comContent', title: '评论内容',  align:'center',width:260},
                    {field: 'comTime', title: '发布时间', align:'center', minWidth:100, templet:function(d){
                            return new Date(d.comTime).format("yyyy-MM-dd hh:mm");
                        }},
                    {title: '操作', width:170, templet:'#comListBar',fixed:"right",align:"center"}
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
        var checkStatus = table.checkStatus('comListTable'),
            data = checkStatus.data,
            comId = [];
        if(data.length > 0) {
            for (var i in data) {
                comId.push(data[i].comId);
            }
            layer.confirm('确定删除选中的评论？', {icon: 3, title: '提示信息'}, function (index) {
                $.get("/com/batch_delete",{
                    cids : comId  //将需要删除的newsId作为参数传入
                },function(data){
                    if (data.status==200){
                        top.layer.msg("评论删除成功！");
                    }else{
                        top.layer.msg(data.msg);
                    }
                    tableIns.reload();
                    layer.close(index);
                })
            })
        }else{
            layer.msg("请选择需要删除的评论");
        }
    })

    //列表操作
    table.on('tool(comList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此评论？',{icon:3, title:'提示信息'},function(index){
                $.get("/com/delete",{
                    comId : data.comId  //将需要删除的newsId作为参数传入
                },function(data){
                    if (data.status==200){
                        top.layer.msg("评论删除成功！");
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