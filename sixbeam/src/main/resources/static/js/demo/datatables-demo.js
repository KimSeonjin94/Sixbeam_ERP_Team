// Call the dataTables jQuery plugin
$(document).ready(function () {
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
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        buttons: [
            {
                extend: 'copy',
                className: 'btn btn-right ml-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn btn-right ml-sm-1'
            },
            {
                extend: 'print',
                className: 'btn btn-right ml-sm-1'
            }
        ],

        "order": [[0, "desc"]],
        initComplete: function () {
            // DataTables 초기화가 완료된 후 클래스 추가
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-end");

        }
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
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        buttons: [
            {
                text: '신규',
                className: 'btn btn-primary mr-sm-1',
                action: function (e, dt, node, config) {
                    $('#new').modal('show');
                }
            },
            {
                text: '삭제',
                className: 'btn btn-danger mr-auto',
                action: function (e, dt, node, config) {
                    $('#delete').modal('show');
                }
            },
            {
                extend: 'copy',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'print',
                className: 'btn btn-left ml-sm-1'
            }

        ],

        "order": [[1, "desc"]],
        initComplete: function () {
            // DataTables 초기화가 완료된 후 클래스 추가
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-between");

        }
    });

    $('#dataTableAccount').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        buttons: [
            {
                text: '신규',
                className: 'btn btn-primary mr-sm-1',
                action: function (e, dt, node, config) {
                    $('#newAccount').modal('show');
                }
            },
            //            {
            //                text: '수정',
            //                className: 'btn btn-warning mr-sm-1',
            //                action: function (e, dt, node, config) {
            //                    $('#editAccount').modal('show');
            //                }
            //            },
            {
                text: '삭제',
                className: 'btn btn-danger mr-auto',
                action: function (e, dt, node, config) {
                    $('#deleteAccount').modal('show');
                }
            },
            {
                extend: 'copy',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'print',
                className: 'btn btn-left ml-sm-1'
            }
        ],

        //            "order": [[0, "desc"]],
        initComplete: function () {
            // DataTables 초기화가 완료된 후 클래스 추가
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-between");

        }
    });

    $('#dataTableAttendmgt').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        lengthMenu: [
            [5, 10, 25, 50],
            [5, 10, 25, 50]
        ],
        buttons: []

    });

    //zzzzz
    $('#dataTableSalaryId').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        "buttons": [
            //            {
            //                text: '신규',
            //                className: 'btn btn-primary mr-sm-1',
            //                action: function ( e, dt, node, config ) {
            //                    $('#createPurModal').modal('show');
            //                }
            //            },
            //            {
            //                text: '삭제',
            //                className: 'btn btn-danger mr-auto',
            //                action: function ( e, dt, node, config ) {
            //                    $('#deletePurModal').modal('show');
            //                }
            //            },
            {
                extend: 'copy',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'print',
                className: 'btn btn-left ml-sm-1'
            }],
        "order": orderOption
        ,
        "initComplete": function () {
            // DataTables 초기화가 완료된 후 클래스 추가
            var buttonGroup = '<button type = "button" class = "btn btn-primary mr-sm-1" data-toggle = "modal" data-target = "#newestimate">등록</button>' +
            '<button type="button" class="btn btn-warning mr-sm-1" data-toggle="modal" onclick="updateSelectedSalaryId()">수정</button>' +
            '<button type="button" class="btn btn-danger mr-auto" data-toggle="modal" data-target="#deleteSalaryIdModal">삭제</button>' ;

            // 버튼 그룹을 DataTables의 버튼 컨테이너 앞에 추가
            this.api().buttons().container().prepend(buttonGroup);
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-between");
        }

    });
    $('#dataTableReason').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        "buttons": [
            //            {
            //                text: '신규',
            //                className: 'btn btn-primary mr-sm-1',
            //                action: function ( e, dt, node, config ) {
            //                    $('#createPurModal').modal('show');
            //                }
            //            },
            //            {
            //                text: '삭제',
            //                className: 'btn btn-danger mr-auto',
            //                action: function ( e, dt, node, config ) {
            //                    $('#deletePurModal').modal('show');
            //                }
            //            },
            {
                extend: 'copy',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'print',
                className: 'btn btn-left ml-sm-1'
            }],
        "order": orderOption
        ,
        "initComplete": function () {
            // DataTables 초기화가 완료된 후 클래스 추가
            var buttonGroup = '<button type = "button" class = "btn btn-primary mr-sm-1" data-toggle = "modal" data-target = "#newestimate">등록</button>' +
            '<button type="button" class="btn btn-warning mr-sm-1" data-toggle="modal" onclick="updateSelectedReason()">수정</button>' +
            '<button type="button" class="btn btn-danger mr-auto" data-toggle="modal" data-target="#deleteReasonModal">삭제</button>';

            // 버튼 그룹을 DataTables의 버튼 컨테이너 앞에 추가
            this.api().buttons().container().prepend(buttonGroup);
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-between");
        }

    });
    $('#dataTablePosition').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        "buttons": [
            //            {
            //                text: '신규',
            //                className: 'btn btn-primary mr-sm-1',
            //                action: function ( e, dt, node, config ) {
            //                    $('#createPurModal').modal('show');
            //                }
            //            },
            //            {
            //                text: '삭제',
            //                className: 'btn btn-danger mr-auto',
            //                action: function ( e, dt, node, config ) {
            //                    $('#deletePurModal').modal('show');
            //                }
            //            },
            {
                extend: 'copy',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'print',
                className: 'btn btn-left ml-sm-1'
            }],
        "order": orderOption
        ,
        "initComplete": function () {
            // DataTables 초기화가 완료된 후 클래스 추가
            var buttonGroup = '<button type = "button" class = "btn btn-primary mr-sm-1" data-toggle = "modal" data-target = "#newestimate">등록</button>' +
            '<button type="button" class="btn btn-warning mr-sm-1" data-toggle="modal" onclick="updateSelectedPosition()">수정</button>' +
            '<button type="button" class="btn btn-danger mr-auto" data-toggle="modal" data-target="#deletePositionModal">삭제</button>';

            // 버튼 그룹을 DataTables의 버튼 컨테이너 앞에 추가
            this.api().buttons().container().prepend(buttonGroup);
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-between");
        }

    });


    $('#dataTableDepart').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        "buttons": [
            //            {
            //                text: '신규',
            //                className: 'btn btn-primary mr-sm-1',
            //                action: function ( e, dt, node, config ) {
            //                    $('#createPurModal').modal('show');
            //                }
            //            },
            //            {
            //                text: '삭제',
            //                className: 'btn btn-danger mr-auto',
            //                action: function ( e, dt, node, config ) {
            //                    $('#deletePurModal').modal('show');
            //                }
            //            },
            {
                extend: 'copy',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'print',
                className: 'btn btn-left ml-sm-1'
            }],
        "order": orderOption
        ,
        "initComplete": function () {
            // DataTables 초기화가 완료된 후 클래스 추가
            var buttonGroup = '<button type = "button" class = "btn btn-primary mr-sm-1" data-toggle = "modal" data-target = "#newestimate">등록</button>' +
            '<button type="button" class="btn btn-warning mr-sm-1" data-toggle="modal" onclick="updateSelectedDepart()">수정</button>' +
            '<button type="button" class="btn btn-danger mr-auto" data-toggle="modal" data-target="#deleteDepartModal">삭제</button>';

            // 버튼 그룹을 DataTables의 버튼 컨테이너 앞에 추가
            this.api().buttons().container().prepend(buttonGroup);
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-between");
        }

    });

    $('#dataTableSalary').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        "buttons": [
            //            {
            //                text: '신규',
            //                className: 'btn btn-primary mr-sm-1',
            //                action: function ( e, dt, node, config ) {
            //                    $('#createPurModal').modal('show');
            //                }
            //            },
            //            {
            //                text: '삭제',
            //                className: 'btn btn-danger mr-auto',
            //                action: function ( e, dt, node, config ) {
            //                    $('#deletePurModal').modal('show');
            //                }
            //            },
            {
                extend: 'copy',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'print',
                className: 'btn btn-left ml-sm-1'
            }],
        "order": orderOption
        ,
        "initComplete": function () {
            // DataTables 초기화가 완료된 후 클래스 추가
            var buttonGroup = '<button type = "button" class = "btn btn-primary mr-sm-1" data-toggle = "modal" data-target = "#newestimate">등록</button>' +
            '<button type="button" class="btn btn-warning mr-sm-1" data-toggle="modal" onclick="updateSelectedSalary()">수정</button>' +
            '<button type="button" class="btn btn-danger mr-auto" data-toggle="modal" data-target="#deleteSalaryModal">삭제</button>';

            // 버튼 그룹을 DataTables의 버튼 컨테이너 앞에 추가
            this.api().buttons().container().prepend(buttonGroup);
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-between");
        }

    });

    $('#dataTableHr').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        "buttons": [
            //            {
            //                text: '신규',
            //                className: 'btn btn-primary mr-sm-1',
            //                action: function ( e, dt, node, config ) {
            //                    $('#createPurModal').modal('show');
            //                }
            //            },
            //            {
            //                text: '삭제',
            //                className: 'btn btn-danger mr-auto',
            //                action: function ( e, dt, node, config ) {
            //                    $('#deletePurModal').modal('show');
            //                }
            //            },
            {
                extend: 'copy',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'print',
                className: 'btn btn-left ml-sm-1'
            }],
        "order": orderOption
        ,
        "initComplete": function () {
            // DataTables 초기화가 완료된 후 클래스 추가
            var buttonGroup = '<button type="button" class="btn btn-primary mr-sm-1" data-toggle="modal" data-target="#newestimate">등록</button>' +
            '<button type="button" class="btn btn-warning mr-sm-1" onclick="updateSelectedEmpInfo()">수정</button>' +
            '<button type="button" class="btn btn-danger mr-auto" data-toggle="modal" data-target="#deleteEmployeeModal">삭제</button>';

            // 버튼 그룹을 DataTables의 버튼 컨테이너 앞에 추가
            this.api().buttons().container().prepend(buttonGroup);
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-between");
        }

    });
    //---- 구매쪽 데이터테이블 ----
    var orderOption;

    if (window.location.href.indexOf("orinput") !== -1) {
        orderOption = [[1, "desc"]];
    } else if (window.location.href.indexOf("input") !== -1) {
        orderOption = [[2, "desc"]];
    }
    $('#dataTablePur').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        "buttons": [
            {
                text: '신규',
                className: 'btn btn-primary mr-sm-1',
                action: function (e, dt, node, config) {
                    $('#createPurModal').modal('show');
                }
            },
            {
                text: '삭제',
                className: 'btn btn-danger mr-auto',
                action: function (e, dt, node, config) {
                    $('#deletePurModal').modal('show');
                }
            },
            {
                extend: 'copy',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'print',
                className: 'btn btn-left ml-sm-1'
            }],
        "order": orderOption
        ,
        initComplete: function () {
            // DataTables 초기화가 완료된 후 클래스 추가
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-between");

        }
    });
    //---- 재고쪽 데이터테이블 ----
    $('#dataTableSt').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        buttons: [
            {
                text: '신규',
                className: 'btn btn-primary mr-sm-1',
                action: function (e, dt, node, config) {
                    $('#createStModal').modal('show');
                }
            },
            {
                text: '삭제',
                className: 'btn btn-danger mr-auto',
                action: function (e, dt, node, config) {
                    $('#deleteStModal').modal('show');
                }
            },
            {
                extend: 'copy',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'print',
                className: 'btn btn-left ml-sm-1'
            }
        ],
        "order": [[1, "desc"]],
        initComplete: function () {
            // DataTables 초기화가 완료된 후 클래스 추가
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-between");
        }
    });
    $('#dataTableStCh').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        buttons: [
            {
                extend: 'copy',
                className: 'btn btn-right ml-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn btn-right ml-sm-1'
            },
            {
                extend: 'print',
                className: 'btn btn-right ml-sm-1'
            }
        ],

        "order": [[1, "desc"]],
        initComplete: function () {
            // DataTables 초기화가 완료된 후 클래스 추가
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-end");

        }
    });
    $('#dataTablePd').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        buttons: [
            {
                text: '신규',
                className: 'btn btn-primary mr-sm-1',
                action: function (e, dt, node, config) {
                    $('#newPd').modal('show');
                }
            },
            {
                text: '삭제',
                className: 'btn btn-danger mr-auto',
                action: function (e, dt, node, config) {
                    $('#deletePd').modal('show');
                }
            },
            {
                extend: 'copy',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'print',
                className: 'btn btn-left ml-sm-1'
            }
        ],
        "order": [[0, "desc"]],
        initComplete: function () {
            // DataTables 초기화가 완료된 후 클래스 추가
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-between");
        }
    });

    $('#dataTablePdOrder').DataTable({
        "language": {
            "emptyTable": "데이터가 없어요.",
            "lengthMenu": "페이지당 _MENU_ 개씩 보기",
            "info": "현재 _START_ - _END_ / _TOTAL_건",
            "infoEmpty": "데이터 없음",
            "infoFiltered": "( _MAX_건의 데이터에서 필터링됨 )",
            "search": "검색: ",
            "zeroRecords": "일치하는 데이터가 없어요.",
            "loadingRecords": "로딩중...",
            "processing": "잠시만 기다려 주세요...",
            "paginate": {
                "next": "다음",
                "previous": "이전"
            }
        },
        buttons: [
            {
                text: '신규',
                className: 'btn btn-primary mr-sm-1',
                action: function (e, dt, node, config) {
                    $('#newPd').modal('show');
                }
            },
            {
                text: '작업 상태 변경',
                className: 'btn btn-warning mr-sm-1',
                action: function (e, dt, node, config) {
                    $('#turnBoolean').modal('show');
                }
            },
            {
                text: '삭제',
                className: 'btn btn-danger mr-auto',
                action: function (e, dt, node, config) {
                    $('#deletePd').modal('show');
                }
            },
            {
                extend: 'copy',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'excel',
                className: 'btn btn-left mr-sm-1'
            },
            {
                extend: 'print',
                className: 'btn btn-left ml-sm-1'
            }
        ],
        "order": [[1, "desc"]],
        initComplete: function () {

            // DataTables 초기화가 완료된 후 클래스 추가
            this.api().buttons().container().addClass("col-sm-12 d-flex justify-content-between");
        }
    });
});

