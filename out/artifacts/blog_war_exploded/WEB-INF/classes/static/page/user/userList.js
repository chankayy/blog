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
layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#userList',
        url : '/user/list',    //     原来是 ../../json/userList.json
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [5,10,15,20,25],
        limit : 10,
        id : "userListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'usersId', title: 'id',style:'display:none'},
            {field: 'userName', title: '用户名', minWidth:100, align:"center"},
            {field: 'userEmail', title: '用户邮箱', minWidth:200, align:'center',templet:function(d){
                return '<a class="layui-blue" href="mailto:'+d.userEmail+'">'+d.userEmail+'</a>';
            }},
            {field: 'userSex', title: '用户性别', align:'center',width:100},
            {field: 'userStatus', title: '用户状态',  align:'center',templet:function(d){
                return d.userStatus == "0" ? "正常使用" : "限制使用";
            }},
            {field: 'userGrade', title: '用户等级', align:'center',templet:function(d){
                if(d.userGrade == "0"){
                    return "注册会员";
                }else if(d.userGrade == "1"){
                    return "中级会员";
                }else if(d.userGrade == "2"){
                    return "高级会员";
                }else if(d.userGrade == "3"){
                    return "钻石会员";
                }else if(d.userGrade == "4"){
                    return "超级会员";
                }else if(d.userGrade == "5"){
                    return "超级管理员";
                }
            }},
            {field: 'userEndTime', title: '最后登录时间', align:'center',minWidth:150, templet:function (d) {
                    //2019-05-09T15:38:45.000+0000
                    var val = d.userEndTime;
                    var now = new Date(val);
                    return now.format("yyyy-MM-dd hh:mm:ss");
                }},
            {title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
        ]],
        done: function () {
        $("[data-field='usersId']").css('display','none');
    }

});

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示
    $(".search_btn").on("click",function(){
      //  var key =  $(".searchVal").val();
        if($(".searchVal").val() != ''||true){//搜索为空时服务器端查询所有
            table.reload("userListTable",{
                where:{
                    username:$(".searchVal").val()
                },
                elem: '#userList',
                url : '/user/list/',    //     原来是 ../../json/userList.json
                cellMinWidth : 95,
                page : true,
                height : "full-125",
                limits : [5,10,15,20,25],
                limit : 10,
                id : "userListTable",
                cols : [[
                    {type: "checkbox", fixed:"left", width:50},
                    {field: 'usersId', title: 'id',style:'display:none'},
                    {field: 'userName', title: '用户名', minWidth:100, align:"center"},
                    {field: 'userEmail', title: '用户邮箱', minWidth:200, align:'center',templet:function(d){
                            return '<a class="layui-blue" href="mailto:'+d.userEmail+'">'+d.userEmail+'</a>';
                        }},
                    {field: 'userSex', title: '用户性别', align:'center',width:100},
                    {field: 'userStatus', title: '用户状态',  align:'center',templet:function(d){
                            return d.userStatus == "0" ? "正常使用" : "限制使用";
                        }},
                    {field: 'userGrade', title: '用户等级', align:'center',templet:function(d){
                            if(d.userGrade == "0"){
                                return "注册会员";
                            }else if(d.userGrade == "1"){
                                return "中级会员";
                            }else if(d.userGrade == "2"){
                                return "高级会员";
                            }else if(d.userGrade == "3"){
                                return "钻石会员";
                            }else if(d.userGrade == "4"){
                                return "超级会员";
                            }else if(d.userGrade == "5"){
                                return "超级管理员";
                            }
                        }},
                    {field: 'userEndTime', title: '最后登录时间', align:'center',minWidth:150, templet:function (d) {
                            //2019-05-09T15:38:45.000+0000
                            var val = d.userEndTime;
                            var now = new Date(val);
                            return now.format("yyyy-MM-dd hh:mm:ss");
                        }},
                    {title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
                ]],
                done: function () {
                    $("[data-field='usersId']").css('display','none');
                }
            })
        }else{//搜索为空时服务器端查询所有
           // layer.msg("请输入搜索的内容");
        }
    });

    //添加用户
    function addUser(edit){
        var index = layui.layer.open({
            title : "添加用户",
            type : 2,
            content : "userAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                  //  body.find(".usersId").val(edit.usersId);  //用户id
                    body.find(".userName").val(edit.userName);  //登录名
                    body.find(".userEmail").val(edit.userEmail);  //邮箱
                    body.find(".userSex input[value="+edit.userSex+"]").prop("checked","checked");  //性别
                    body.find(".userGrade").val(edit.userGrade);  //会员等级
                    body.find(".userStatus").val(edit.userStatus);    //用户状态
                    body.find(".userDesc").text(edit.userDesc);    //用户简介
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    //修改用户
    function updateUser(edit){
        var index = layui.layer.open({
            title : "修改用户",
            type : 2,
            content : "userUpdate.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find(".usersId").val(edit.usersId);  //用户id
                    body.find(".userName").val(edit.userName);  //登录名
                    body.find(".userEmail").val(edit.userEmail);  //邮箱
                    body.find(".userSex input[value="+edit.userSex+"]").prop("checked","checked");  //性别
                    body.find(".userGrade").val(edit.userGrade);  //会员等级
                    body.find(".userStatus").val(edit.userStatus);    //用户状态
                    body.find(".userDesc").text(edit.userDesc);    //用户简介
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        })
        layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    $(".addNews_btn").click(function(){
        addUser();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('userListTable'),
            data = checkStatus.data,
            userIds = [];
        if(data.length > 0) {
            for (var i in data) {
                userIds.push(data[i].usersId);//将选中的用户ID添加到容器
            }
            layer.confirm('确定删除选中的用户？', {icon: 3, title: '提示信息'}, function (index) {
                 $.post("/user/batch_delete",{
                     uids : userIds  //将需要删除的newsId作为参数传入
                 },function(data){
                     if (data.status==200){
                         top.layer.msg("用户删除成功！");
                     }else{
                         top.layer.msg(data.msg);
                     }
                    tableIns.reload();
                    layer.close(index);
                     })
            })
        }else{
            layer.msg("请选择需要删除的用户");
        }
    })

    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            updateUser(data);
        }else if(layEvent === 'usable'){ //启用禁用
            var _this = $(this),
                usableText = "是否确定禁用此用户？",
                btnText = "已禁用";
            if(_this.text()=="已禁用"){
                usableText = "是否确定启用此用户？",
                btnText = "已启用";
            }
            layer.confirm(usableText,{
                icon: 3,
                title:'系统提示',
                cancel : function(index){
                    layer.close(index);
                }
            },function(index){
                _this.text(btnText);
                layer.close(index);
            },function(index){
                layer.close(index);
            });
        }else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
                $.post("/user/delete",{
                     usersId : data.usersId  //将需要删除的newsId作为参数传入
                 },function(data){
                     if (data.status==200){
                         top.layer.msg("用户删除成功！");
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
