var MyShopApp = function () {
    /**
     * 全选
     * @type {any[]}
     */
    var ids = new Array();
    document.getElementById("firstBox").onclick = function () {
        let boxs = document.getElementsByName("box");
        for (let i = 0;i<boxs.length;i++){
            boxs[i].checked = this.checked;
        }
    };

    /**
     * 删除选中
     * @param url
     */
    var handlerInitDelSelected = function (url) {
        let boxs = document.getElementsByName("box");
        for (let i = 0;i<boxs.length;i++){
            if (boxs[i].checked){
                let valueId = boxs[i].value;
                ids.push(valueId);
            }
        }
        if (ids.length == 0){
            alert("请选择要删除的条目");
        }else if (confirm("确定要删除选中的条目嘛？")){
            let selectedId = "";
            for (let i = 0; i < ids.length; i++) {
                if (i == ids.length-1){
                    selectedId += ids[i];
                }else {
                    selectedId += ids[i]+",";
                }
            }
            location.href = url+selectedId;
        }
    };

    /**
     * 初始化DataTables
     * @param url
     * @param columns
     * @returns {jQuery}
     */
    var handlerInitDataTables = function (url,columns) {
        var _dataTable = $("#dataTable111").DataTable({
            "autoWidth": true,
            "paging": true,
            "info": true,
            "lengthChange": false,
            "ordering": false,
            "processing": true,
            "searching": false,
            "serverSide": true,
            "deferRender": true,
            "ajax":{
                "url":url
            },
            "columns":columns,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            }
        });
        return _dataTable;
    };



    return {
        initDataTables:function (url,columns) {
            return handlerInitDataTables(url,columns);
        },
        initDelSelected:function (url) {
            return handlerInitDelSelected(url);
        }
    }
}();
