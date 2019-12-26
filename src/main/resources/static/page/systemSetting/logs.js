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
layui.use(['table'],function(){
	var table = layui.table;

	//系统日志
    table.render({
        elem: '#logs',
        url : '/log/list',
        cellMinWidth : 95,
        page : true,
        height : "full-20",
        limit : 15,
        limits : [5,10,15,20,25],
        id : "systemLog",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'logId', title: '序号', width:60, align:"center"},
            {field: 'logUrl', title: '请求地址', width:250},
            {field: 'logReq', title: '操作方式', align:'center',width:100,templet:function(d){
                if(d.logReq.toUpperCase() == "GET"){
                    return '<span class="layui-blue">'+d.logReq+'</span>'
                }else{
                    return '<span class="layui-red">'+d.logReq+'</span>'
                }
            }},
            {field: 'logIp', title: '操作IP',  align:'center',width:170,minWidth:130},
            {field: 'logTaking', title: '耗时', align:'center',width:100,templet:function(d){
                return '<span class="layui-btn layui-btn-normal layui-btn-xs">'+d.logTaking+'</span>'
            }},
            {field: 'logStatus', title: '是否异常', align:'center',width:100,templet:function(d){
                if(d.logStatus == "0"){
                    return '<span class="layui-btn layui-btn-green layui-btn-xs">正常</span>'
                }else{
                    return '<span class="layui-btn layui-btn-danger layui-btn-xs">异常</span>'
                }
            }},
            {field: 'logContent',title: '操作人', minWidth:100,width:100, templet:'#newsListBar',align:"center" ,templet:function (d) {
                    var username = d.logContent.substr(0,d.logContent.indexOf(" "));
                    return username;
                }},
            {field: 'logMethod', title: '执行操作',  align:'center',width:170,minWidth:130},
            {field: 'logTime', title: '操作时间', align:'center', width:170,templet:function (d) {
                    console.log(d);
                    //return (d.logTime).replace("T"," ").substring(0,(d.logTime).length-12);
                    return new Date(d.logTime).format("yyyy-MM-dd hh:mm");
                }}
        ]]
    });
 	
})
