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
                className: 'btn-left'
            },
            {
                extend: 'excel',
                className: 'btn-left'
            },
            {
                extend: 'print',
                className: 'btn-left'
            },
            {
                text: '신규',
                className: 'btn-right',
                action: function ( e, dt, node, config ) {
                    // Action for '신규'
                }
            },
            {
                text: '수정',
                className: 'btn-right',
                action: function ( e, dt, node, config ) {
                    // Action for '수정'
                }
            }
        ],
        initComplete: function() {
            // `.btn-left` 버튼들을 첫 번째 `.col-md-6` 내부로 이동
            $('.dt-buttons .btn-left').appendTo("#dataTableEstimate_wrapper .col-md-6:first");

            // `.btn-right` 버튼들을 두 번째 `.col-md-6` 내부로 이동
            // 여기서는 `.dt-buttons` div 안에 신규 및 수정 버튼이 있으므로, 이를 대상으로 이동시킵니다.
            $('.dt-buttons .btn-right').appendTo("#dataTableEstimate_wrapper .col-md-6:eq(1)");
        },
        "order": [[0, "desc"]]
    });
});
//커스텀 버튼 추가 함수
//$(document).ready(function() {
//    $('#테이블id').DataTable({
//        "columnDefs": [{
//            "targets": -1,
//            "data": null,
//            "defaultContent": "추가할 버튼 html입역"
//        }]
//    });
//});




