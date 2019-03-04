$(function () {
    gridTable = layui.table.render({
        id: "gridid",
        elem: '#grid',
        url: baseURL + 'dangjian/article/list?token='+token,
        cols: [[
            {type:'checkbox'},
            {field:'id', minWidth:100, title: ''},
            {field:'title', minWidth:100, title: ''},
            {field:'content', minWidth:100, title: ''},
            {field:'category', minWidth:100, title: '栏目类别'},
            {field:'createdBy', minWidth:100, title: ''},
            {field:'createTime', minWidth:100, title: '创建时间'},
            {field:'updateTime', minWidth:100, title: '修改时间'},
            {field:'commentCount', minWidth:100, title: ''},
            {field:'img', minWidth:100, title: '图片'},
            {title: '操作', width:120, templet:'#barTpl',fixed:"right",align:"center"}
        ]],
        page: true,
        loading: true,
        limits: [20, 50, 100, 200],
        limit: 20
    });

    layui.form.on('submit(saveOrUpdate)', function(){
        vm.saveOrUpdate();
        return false;
    });


    //批量删除
    $(".delBatch").click(function(){
        var ids = vm.selectedRows();
        if(ids == null){
            return;
        }
        vm.del(ids);
    });

    //操作
    layui.table.on('tool(grid)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'edit'){
            vm.update(data.id);
        } else if(layEvent === 'del'){
            var id = [data.id];
            vm.del(id);
        }
    });

});

var vm = new Vue({
    el:'#rrapp',
    data:{
        q:{
            keyword: null
        },
        showForm: false,
        article: {}
    },
    updated: function(){
        layui.form.render();
    },
    methods: {
        selectedRows: function () {
            var list = layui.table.checkStatus('gridid').data;
            if(list.length == 0){
                alert("请选择一条记录");
                return ;
            }

            var ids = [];
            $.each(list, function(index, item) {
                ids.push(item.id);
            });
            return ids;
        },
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.article = {};

            var index = layer.open({
                title: "新增",
                type: 1,
                content: $("#editForm"),
                end: function(){
                    vm.showForm = false;
                    layer.closeAll();
                }
            });

            vm.showForm = true;
            layer.full(index);
        },
        update: function (id) {
            $.get(baseURL + "dangjian/article/info/"+id, function(r){
                vm.article = r.article;
            });

            var index = layer.open({
                title: "修改",
                type: 1,
                content: $("#editForm"),
                end: function(){
                    vm.showForm = false;
                    layer.closeAll();
                }
            });

            vm.showForm = true;
            layer.full(index);
        },
        del: function (ids) {
            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "dangjian/article/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function(r){
                        if(r.code == 0){
                            alert('操作成功', function(index){
                                vm.reload();
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function (event) {
            var url = vm.article.id == null ? "dangjian/article/save" : "dangjian/article/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.article),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            layer.closeAll();
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        exports: function () {
            var url = baseURL + 'dangjian/article/export?token='+token;
            if(vm.q.keyword != null){
                url += '&keyword='+vm.q.keyword;
            }
            window.location.href = url;
        },
        reload: function (event) {
            layui.table.reload('gridid', {
                page: {
                    curr: 1
                },
                where: {
                    keyword: vm.q.keyword
                }
            });
        }
    }
});