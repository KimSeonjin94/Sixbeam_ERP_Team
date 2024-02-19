// Call the dataTables jQuery plugin
$(document).ready(function() {
    $('#dataTable').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing":     "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }},
        "buttons": ['copy', 'excel', 'print'],
        "order" :[[0,"desc"]]
    });
    $('#dataTableEstimate').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing":     "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }},
        buttons: [
            {
                extend: 'copy',
                className: 'btn-left mr-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn-left mr-sm-1'
            },
            {
                extend: 'print',
                className: 'btn-left mr-auto'
            },
            {
                text: '신규',
                className: 'btn-right ml-sm-1',
                action: function ( e, dt, node, config ) {
                    $('#new').modal('show');
                }
            },
            {
                text: '수정',
                className: 'btn-right ml-sm-1',
                action: function ( e, dt, node, config ) {
                    $('#detail').modal('show');
                }
            }
        ],

        "order": [[0, "desc"]],
        initComplete: function() {
            // DataTables 초기화가 완료된 후 클래스 추가
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-between");

        }
    });

});




