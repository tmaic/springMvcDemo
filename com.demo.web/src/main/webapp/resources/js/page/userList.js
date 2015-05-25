$(function(){

    var dataTables = $('.table').DataTable({
        "bFilter": true, //去掉搜索框
        "bDestroy": false,
        "bProcessing": false,
        "bServerSide": true,
        "sAjaxSource": "userJson.html",
        "fnServerData": function (sSource, aoData, fnCallback, oSettings) {
            for (var i = 0; i < aoData.length; i++) {
                if (aoData[i]['name'] === 'iSortCol_0') {
                    var cols = this.fnSettings().aoColumns;
                    var index = parseInt(aoData[i]['value']);
                    aoData.push({"name": "sColName", "value": cols[index]['mData']});
                    break;
                }
            }
            oSettings.jqXHR = $.ajax({
                "dataType": 'json',
                "type": "GET",
                "url": sSource,
                "data": aoData,
                "success": fnCallback,
                "error": function () {

                }
            });
        },
        "aoColumns": [
            {"mData": "id"},
            {"mData": "email"},
            {"mData": "password"},
            {"mData": "created"}
        ],
        "aoColumnDefs": [
            //{
            //    "aTargets": [2],
            //    "sClass": "details-control center-align",
            //    "mRender": function (data, type, row) {
            //        return '<a href="user/' + row.userId + '_loanreceiptUserDetail" target=\"_blank\">' + data + '</a>';
            //    }
            //}

        ],
        "oLanguage": {
            "sLengthMenu": "显示 _MENU_ 条记录",
            "sSearch": "搜索:",
            "sInfo": "显示第 _START_ - _END_ 条记录，共 _TOTAL_ 条",
            "sInfoEmpty": "没有符合条件的记录",
            "sZeroRecords": "没有符合条件的记录"
        },
        "fnDrawCallback": function () {

        }
    });

});