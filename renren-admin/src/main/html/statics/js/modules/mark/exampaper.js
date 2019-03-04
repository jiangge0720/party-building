$(function () {
    gridTable = layui.table.render({
        id: "gridid",
        elem: '#grid',
        url: baseURL + 'mark/exampaper/list?token='+token,
        cols: [[
            {type:'checkbox'},
            {field:'paperId', minWidth:100, title: ''},
            {field:'paperName', minWidth:100, title: '试卷名称'},
            {field:'paperTotal', minWidth:100, title: '试卷总分'},
            {field:'paperPass', minWidth:100, title: '试卷及格线'},
            {field:'paperContent', minWidth:100, title: '试卷内容'},
            {field:'createdBy', minWidth:100, title: '录入人'},
            {field:'createdTime', minWidth:100, title: '录入时间'},
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
        var paperIds = vm.selectedRows();
        if(paperIds == null){
            return;
        }
        vm.del(paperIds);
    });

    //操作
    layui.table.on('tool(grid)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        if(layEvent === 'edit'){
            vm.update(data.paperId);
        } else if(layEvent === 'del'){
            var paperId = [data.paperId];
            vm.del(paperId);
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
        examPaper: {}
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

            var paperIds = [];
            $.each(list, function(index, item) {
                paperIds.push(item.paperId);
            });
            return paperIds;
        },
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.examPaper = {};

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
        update: function (paperId) {
            $.get(baseURL + "mark/exampaper/info/"+paperId, function(r){
                vm.examPaper = r.examPaper;
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
        del: function (paperIds) {
            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "mark/exampaper/delete",
                    contentType: "application/json",
                    data: JSON.stringify(paperIds),
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
            var url = vm.examPaper.paperId == null ? "mark/exampaper/save" : "mark/exampaper/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.examPaper),
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
            var url = baseURL + 'mark/exampaper/export?token='+token;
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