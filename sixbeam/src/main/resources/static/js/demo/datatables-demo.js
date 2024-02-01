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
        "buttons": ['copy', 'excel', 'pdf', 'print'],

    },
        {
            dom: "Bfrtip",
            buttons: [
                {
                    extend: "excel",                    // Extend the excel button
                    excelStyles: {                      // Add an excelStyles definition
                        cells: "2",                     // to row 2
                        style: {                        // The style block
                            font: {                     // Style the font
                                name: "Arial",          // Font name
                                size: "14",             // Font size
                                color: "FFFFFF",        // Font Color
                                b: false,               // Remove bolding from header row
                            },
                            fill: {                     // Style the cell fill (background)
                                pattern: {              // Type of fill (pattern or gradient)
                                    color: "457B9D",    // Fill color
                                }
                            }
                        }
                    },
                },
            ],
        });
});

