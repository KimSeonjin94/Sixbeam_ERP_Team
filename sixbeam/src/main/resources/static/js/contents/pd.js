function createItemFinished() {

    var itemNm = $('#itemNm').val();
    var itemStnd = $('#itemStnd').val();
    var itemUp = $('#itemup').val();

    var isValid = true; // 유효성 검사 변수 초기화

    // 각 텍스트 입력란에 대해 반복하여 유효성을 검사합니다.
    $('.orderAmt').each(function () {
        var orderAmt = $(this).val();

        // 값이 비어있는 경우
        if (!orderAmt || orderAmt.trim() === '') {
            alert('수량을 입력하세요.');
            isValid = false; // 유효성 검사 변수를 false로 설정
            return false; // 반복문 탈출
        }
    });

    // 품목 코드가 공백인 경우
    if (!itemNm || itemNm.trim() === '') {
        alert('품목명을 입력하세요.');
        event.preventDefault();
        return false;

    } else if (!itemStnd || itemStnd.trim() === '') {
        alert('규격을 입력하세요.');
        event.preventDefault();
        return false;

    } else if (!itemUp || itemUp.trim() === '') {
        alert('가격을 입력하세요.');
        event.preventDefault();
        return false;

    } else {
        // 모든 텍스트 입력란이 유효한 경우
        if (isValid) {
            alert('품목이 등록되었습니다.');
            return true; // 폼 제출 허용
        } else {
            event.preventDefault(); // 폼 제출 방지
            return false;
        }
    }
}

function createOrderFinished() {
    var isValid = true; // 유효성 검사 변수 초기화

    // 각 텍스트 입력란에 대해 반복하여 유효성을 검사합니다.
    $('.orderAmt').each(function () {
        var orderAmt = $(this).val();

        // 값이 비어있는 경우
        if (!orderAmt || orderAmt.trim() === '') {
            alert('수량을 입력하세요.');
            isValid = false; // 유효성 검사 변수를 false로 설정
            return false; // 반복문 탈출
        }
    });

    // 모든 텍스트 입력란이 유효한 경우
    if (isValid) {
        alert('작업지시서가 등록되었습니다.');
        return true; // 폼 제출 허용
    } else {
        event.preventDefault(); // 폼 제출 방지
        return false;
    }
}


function deleteOrderFinished() {

    // 체크박스의 값(계정 ID)을 저장할 배열
    var selectedIds = [];
    var itemLength = selectedIds.length;

    // 모든 'selectedInfo' 클래스를 가진 체크박스를 찾고 선택된 항목의 값만 배열에 추가
    document.querySelectorAll('.' +
        '' +
        'selectedInfo:checked').forEach(function (checkbox) {
        selectedIds.push(checkbox.value);
        console.log(selectedIds);
    });

    // 선택된 체크박스가 없으면 에러 메시지를 표시하고 함수를 종료
    if (selectedIds.length === 0) {
        alert('삭제할 항목을 선택해주세요.');

        // 빈 폼을 전달하고 모달 닫기
        document.getElementById('deleteForm').submit();
    } else {
        // 배열을 쉼표로 구분된 문자열로 변환
        var itemIdsToDelete = selectedIds.join(',');

        // 숨겨진 입력 필드에 값을 설정
        document.getElementById('deletePdInfo').value = itemIdsToDelete;

        // 폼을 제출하여 서버에 삭제 요청
        document.getElementById('deleteForm').submit();

        // 모달 창을 표시
        // $('#deletePd').modal('show');

        // 모달 창을 표시

        if (selectedIds === 0) {
            alert('작업 지시서가 삭제되었습니다.');

        } else if (selectedIds > 0 && selectedIds < itemLength) {
            alert('창고불출된 작업지시서를 제외하고 삭제되었습니다.');

        } else {
            // alert('창고불출된 작업지시서를 삭제할 수 없습니다.');
            alert('처리가 완료되었습니다.');
        }

        /*// 삭제된 체크박스를 리스트에서 제거
        selectedIds.forEach(function (id) {
            var checkbox = document.querySelector('input[type="checkbox"][value="' + id + '"]');
            if (checkbox) {
                var listItem = checkbox.closest('li');
                if (listItem) {
                    listItem.remove();
                }
            }
        });

        // 특정 페이지 표시
        if (selectedIds.length === 0) {
            alert('작업 지시서가 삭제되었습니다.');
        } else if (selectedIds.length > 0 && selectedIds.length < itemLength) {
            alert('창고불출된 작업지시서를 제외하고 삭제되었습니다.');
        } else {
            alert('창고불출된 작업지시서를 삭제할 수 없습니다.');
        }*/

        $('#deletePd').modal('show');
        // alert('품목이 삭제되었습니다.');
    }
}

function deleteItemFinished() {

    // 체크박스의 값(계정 ID)을 저장할 배열
    var selectedIds = [];
    var itemLength = selectedIds.length;

    // 모든 'selectedInfo' 클래스를 가진 체크박스를 찾고 선택된 항목의 값만 배열에 추가
    document.querySelectorAll('.' +
        '' +
        'selectedInfo:checked').forEach(function (checkbox) {
        selectedIds.push(checkbox.value);
        console.log(selectedIds);
    });

    // 선택된 체크박스가 없으면 에러 메시지를 표시하고 함수를 종료
    if (selectedIds.length === 0) {
        alert('삭제할 항목을 선택해주세요.');

        // 빈 폼을 전달하고 모달 닫기
        document.getElementById('deleteForm').submit();
    } else {
        // 배열을 쉼표로 구분된 문자열로 변환
        var itemIdsToDelete = selectedIds.join(',');

        // 숨겨진 입력 필드에 값을 설정
        document.getElementById('deletePdInfo').value = itemIdsToDelete;

        // 폼을 제출하여 서버에 삭제 요청
        document.getElementById('deleteForm').submit();

        alert('품목이 삭제되었습니다.')

        $('#deletePd').modal('show');
        // alert('품목이 삭제되었습니다.');
    }
}

// boolean값인 작업 상태 변경 기능
function turnBoolean() {

    // 체크박스의 값(계정 ID)을 저장할 배열
    var selectedIds = [];

    // 모든 'selectedInfo' 클래스를 가진 체크박스를 찾고 선택된 항목의 값만 배열에 추가
    document.querySelectorAll('.' +
        '' +
        'selectedInfo:checked').forEach(function (checkbox) {
        selectedIds.push(checkbox.value);
    });
    console.log(selectedIds);

    if (selectedIds.length === 0) {
        alert('변경할 항목을 선택해주세요.');

        // 빈 폼을 전달하고 모달 닫기
        document.getElementById('turnForm').submit();
    } else {
        console.log(selectedIds);

        $.ajax({
            type: 'POST', // 또는 'GET', 요청 방식에 따라 변경할 수 있습니다.
            url: '/pd/order/turnboolean', // 서버의 엔드포인트 URL을 지정합니다.
            contentType: 'application/json', // 데이터 타입을 JSON으로 설정합니다.
            data: JSON.stringify(selectedIds), // 선택된 orderCd를 JSON 형식으로 전송합니다.
            success: function (response) {
                // 성공적으로 응답을 받았을 때 처리하는 코드를 작성합니다.
                console.log('작업 상태 변경에 성공했습니다.');
                $('#turnBoolean').modal('hide'); // 모달 닫기
                alert('상태가 변경되었습니다.');
                window.location.href = response.redirectUrl;
            },
            error: function (xhr, status, error) {
                // 요청이 실패했을 때 처리하는 코드를 작성합니다.
                console.error('작업 상태 변경에 실패했습니다.');
                window.location.href = response.redirectUrl;
            }
        });
    }
}

// 숫자와 대문자만 입력할 수 있는 메서드
function checkInput(event) {

    // 입력된 값 가져오기
    var inputValue = event.target.value;

    // 입력된 값이 숫자와 대문자인지 확인하는 정규식
    var regex = /^[A-Z0-9]*$/;

    // 입력된 값이 한글인 경우
    if (/[\uAC00-\uD7AF\u1100-\u11FF\u3130-\u318F\uA960-\uA97F\uAC00-\uD7A3]/.test(inputValue)) {

        // 빈 문자열로 설정하여 한글 입력 방지
        event.target.value = event.target.value.replace(/[\uAC00-\uD7AF\u1100-\u11FF\u3130-\u318F\uA960-\uA97F\uAC00-\uD7A3fr]/g, '');
    }

    // 입력된 값을 대문자로 변환하여 설정
    event.target.value = inputValue.toUpperCase();
}


// 숫자만 입력받는 메서드
function checkInput2(event) {

    // 입력된 값 가져오기
    var inputValue = event.target.value;

    // 숫자가 아닌 입력이 발생할 경우 처리
    if (!/^\d*$/.test(inputValue)) {

        // 입력을 막기 위해 빈 문자열로 설정
        event.target.value = event.target.value.replace(/[^\d]/g, '');
    }
}

// 영문은 대문자로 받는 메서드
function checkInput3(event) {

    var inputVal = event.target.value;

    var regex = /^[가-힣A-Z0-9]*$/;

    event.target.value = inputVal.toUpperCase();
}

// id = detailItembtn 버튼 클릭 이벤트 함수
$('#detailItembtn[data-id]').on('click', function () {

    var itemCd = $(this).data('id'); // this - 클릭된 요소
    var itemSum = 0;

    // 선택한 품목에 대한 부속품 정보를 요청하기 위해 Ajax를 사용
    $.ajax({

        // 서버의 해당 URL로 요청 - 엔드포인트
        url: '/pd/bom/detail/' + itemCd,
        type: 'GET',
        success: function (response) {

            console.log(response);

            // 부속품 정보를 받아온 후, 테이블에 동적으로 추가
            var ritemDetailsTable = $('#ritemDetails');

            // 기존에 표시된 내용을 모두 지우고 새로운 내용으로 대체
            ritemDetailsTable.empty();

            response.forEach(function (bomEntity, index) {

                // 부속품의 각 정보를 테이블에 추가
                var row = $('<tr>');

                row.append('<td>' + bomEntity.ritemEntity.itemCd + '</td>' +
                    '<td>' + bomEntity.ritemEntity.itemNm + '</td>' +
                    '<td>' + bomEntity.ritemEntity.itemStnd + '</td>' +
                    '<td>' + bomEntity.bomUseMt + '</td>' +
                    '<td>' + bomEntity.ritemEntity.itemUp + '</td>');

                // 새로운 행을 테이블에 추가
                ritemDetailsTable.append(row);

                itemSum += (bomEntity.ritemEntity.itemUp * bomEntity.bomUseMt);
            });

            $('#detailItemCd').val(response[0].fitemEntity.itemCd)
            $('#detailItemNm').val(response[0].fitemEntity.itemNm)
            $('#detailItemStnd').val(response[0].fitemEntity.itemStnd)
            $('#detailItemUp').val(itemSum);
        },

        error: function (xhr, status, error) {

            // 요청이 실패한 경우 오류 메시지를 콘솔에 출력
            console.error('Failed to fetch ritem details:', error);
        }
    });
});

$('#editItembtn[data-id]').on('click', function () {

    var edititemcd = $(this).data('id'); // this - 클릭된 요소

    // 선택한 품목에 대한 부속품 정보를 요청하기 위해 Ajax를 사용
    $.ajax({

        // 서버의 해당 URL로 요청
        url: '/pd/item/update/',
        type: 'POST',
        success: function (response) {
            console.log(response);

            // 부속품 정보를 받아온 후, 테이블에 동적으로 추가
            var ritemEditTable = $('#ritemEdit');

            // 기존에 표시된 내용을 모두 지우고 새로운 내용으로 대체
            ritemEditTable.empty();

            response.forEach(function (ritemEntity, index) {

                // 부속품의 각 정보를 테이블에 추가
                var row = $('<tr>');

                row.append('<td>' + ritemEntity.itemCd + '</td>' +
                    '<td><input type="text" class="form-control" value="' + ritemEntity.itemNm + '"></td>' +
                    '<td><input type="text" class="form-control" value="' + ritemEntity.itemStnd + '"></td>' +
                    '<td><input type="text" class="form-control" value="' + ritemEntity.itemUp + '"></td>');

                // 새로운 행을 테이블에 추가
                ritemDetailsTable.append(row);
            });

            $('#editItemCd').val(response[0].ritemEntity.itemCd)
            $('#editItemNm').val(response[0].ritemEntity.itemNm)
            $('#editItemStnd').val(response[0].ritemEntity.itemStnd)
            $('#editItemUp').val(itemSum);
        },

        error: function (xhr, status, error) {

            // 요청이 실패한 경우 오류 메시지를 콘솔에 출력
            console.error('Failed to fetch ritem details:', error);
        }
    });
});

$('#detailOrderbtn[data-id]').on('click', function () {

    var orderCd = $(this).data('id'); // this - 클릭된 요소

    // 선택한 품목에 대한 부속품 정보를 요청하기 위해 Ajax를 사용
    $.ajax({

        // 서버의 해당 URL로 요청 - 엔드포인트
        url: '/pd/order/detail/' + orderCd,
        type: 'GET',
        success: function (response) {

            console.log(response);

            // 부속품 정보를 받아온 후, 테이블에 동적으로 추가
            var orderdetail = $('#detailOrderList');

            // 기존에 표시된 내용을 모두 지우고 새로운 내용으로 대체
            orderdetail.empty();

            // 부속품의 각 정보를 테이블에 추가
            var row = $('<tr>');
            row.append('<td>' + response.empInfoEntity.empInfoId + '</td>' +
                '<td>' + response.empInfoEntity.empInfoPhone + '</td>' +
                '<td>' + response.empInfoEntity.empInfoEmail + '</td>' +
                '<td>' + response.itemEntity.itemCd + '</td>' +
                '<td>' + response.itemEntity.itemNm + '</td>');
            // 새로운 행을 테이블에 추가
            orderdetail.append(row);
        },

        error: function (xhr, status, error) {

            // 요청이 실패한 경우 오류 메시지를 콘솔에 출력
            console.error('Failed to fetch order details:', error);
        }
    });
});

$('#detailOrderbtn[data-id]').on('click', function () {

    var orderCd = $(this).data('id'); // this - 클릭된 요소

    // 선택한 품목에 대한 부속품 정보를 요청하기 위해 Ajax를 사용
    $.ajax({

        // 서버의 해당 URL로 요청 - 엔드포인트
        url: '/pd/order/detail/' + orderCd,
        type: 'GET',
        success: function (response) {

            console.log(response);

            // 부속품 정보를 받아온 후, 테이블에 동적으로 추가
            var orderdetail = $('#detailOrderList');

            // 기존에 표시된 내용을 모두 지우고 새로운 내용으로 대체
            orderdetail.empty();

            // 부속품의 각 정보를 테이블에 추가
            var row = $('<tr>');
            row.append('<td>' + response.empInfoEntity.empInfoId + '</td>' +
                '<td>' + response.empInfoEntity.empInfoPhone + '</td>' +
                '<td>' + response.empInfoEntity.empInfoEmail + '</td>' +
                '<td>' + response.itemEntity.itemCd + '</td>' +
                '<td>' + response.itemEntity.itemNm + '</td>');
            // 새로운 행을 테이블에 추가
            orderdetail.append(row);
        },

        error: function (xhr, status, error) {

            // 요청이 실패한 경우 오류 메시지를 콘솔에 출력
            console.error('Failed to fetch order details:', error);
        }
    });
});

$('#detailInoutbtn[data-id]').on('click', function () {

    var inoutCmptCd = $(this).data('id'); // this - 클릭된 요소

    // 선택한 품목에 대한 부속품 정보를 요청하기 위해 Ajax를 사용
    $.ajax({

        // 서버의 해당 URL로 요청 - 엔드포인트
        url: '/pd/inout/detail/' + inoutCmptCd,
        type: 'GET',
        success: function (response) {

            console.log(response);

            // 부속품 정보를 받아온 후, 테이블에 동적으로 추가
            var inoutdetail = $('#detailInoutList');

            // 기존에 표시된 내용을 모두 지우고 새로운 내용으로 대체
            inoutdetail.empty();

            // 부속품의 각 정보를 테이블에 추가
            var row = $('<tr>');
            row.append('<td>' + response.empInfoEntity.empInfoId + '</td>' +
                '<td>' + response.empInfoEntity.empInfoPhone + '</td>' +
                '<td>' + response.empInfoEntity.empInfoEmail + '</td>' +
                '<td>' + response.itemEntity.itemCd + '</td>' +
                '<td>' + response.itemEntity.itemNm + '</td>' +
                '<td>' + response.whregistEntity.whregistCd + '</td>');
            // 새로운 행을 테이블에 추가
            inoutdetail.append(row);
        },

        error: function (xhr, status, error) {

            // 요청이 실패한 경우 오류 메시지를 콘솔에 출력
            console.error('Failed to fetch inout details:', error);
        }
    });
});

// itemcd
$(document).ready(function () {

    // 품목코드 선택하면 품목명, 품목규격, 가격이 나올 수 있도록 하는 제이쿼리
    $("#itemcode").on('input', function () {
        var inputVal = $(this).val();

        $("#itemcodeSelectBox option").each(function () {
            if ($(this).val() === inputVal) {
                var itemNm = $(this).text();
                var dataid = $(this).data('id');
                $("#itemname").val(itemNm);
                $("#itempic").val(dataid);
                return false; // 반복문 종료
            }
        });
    });
});

// 작업 지시서 등록 selectbox 2개 선택 기능
$('.table.order').on('change input', '.selectbox', function () {

    console.log($(this).val());
    if ($(this).hasClass('selectbox')) { // .selectbox에서의 변경인 경우에만 처리

        if ($(this).attr('name').includes("item")) {

            var valueitemcd = $(this).find(':selected').attr("data-itemCd");
            var valueitemname = $(this).find(':selected').attr("data-itemNm");
            var valueitmestnd = $(this).find(':selected').attr("data-itemStnd");
            var valueitemup = $(this).find(':selected').attr("data-itemUp");

            $(this).closest('tr').find('.itemCd').val(valueitemname);
            $(this).closest('tr').find('.itemNm').val(valueitemname);
            $(this).closest('tr').find('.itemStnd').val(valueitmestnd);
            $(this).closest('tr').find('.itemup').val(valueitemup);

        } else if ($(this).attr('name').includes("emp")) {

            var valueempInfoId = $(this).find(':selected').attr("data-empId")
            var valueempInfoPhone = $(this).find(':selected').attr("data-empPhone");
            var valueempInfoEmail = $(this).find(':selected').attr("data-empEmail");

            $(this).closest('tr').find('.empInfoId').val(valueempInfoId);
            $(this).closest('tr').find('.empInfoPhone').val(valueempInfoPhone);
            $(this).closest('tr').find('.empInfoEmail').val(valueempInfoEmail);
        }

        $(this).find('.itemCd').val(valueitemcd);
        $(this).find('.itemNm').val(valueitemname);
        $(this).find('.itemStnd').val(valueitmestnd);
        $(this).find('.itemup').val(valueitemup);

        $(this).find('.empInfoId').val(valueempInfoId);
        $(this).find('.empInfoPhone').val(valueempInfoPhone);
        $(this).find('.empInfoEmail').val(valueempInfoEmail);
    }
});

$(document).ready(function () {

    // 데이터가 변경될 때마다 합계를 다시 계산합니다.
    // 예를 들어, 행이 추가되거나 삭제될 때, 입력 값이 변경될 때 등
    $('.table.order').on('input', '.itemamt, .itemup, .itemsp, .itemvar, .itemsum', function () {
        var $row = $(this).closest('tr');
        var itemamt = $row.find('.itemamt').val();
        console.log(itemamt);
        var itemup = $row.find('.itemup').val();
        console.log(itemup);
        var itemsum = itemup * itemamt;

        $row.find('.itemsum').val(itemsum);
        console.log(itemsum);
        calculateTotal();

    });
});

function calculateTotal() {

    var totalAmt = 0, totalUp = 0, totalSum = 0;

    $('.itemamt').each(function () {
        totalAmt += parseInt($(this).val().replace(/[^\d]/g, '')) || 0;
    });
    $('.itemup').each(function () {
        var value = $(this).val().replace(/[^\d]/g, '');
        totalUp += parseInt(value) || 0;
    });
    $('.itemsum').each(function () {
        var value = $(this).val().replace(/[^\d]/g, '');
        totalSum += parseInt(value) || 0;
    });
    console.log(totalSum);
    // 계산된 합계를 통화 형식으로 표시
    $('#totalUp').text(formatCurrency(totalSum));
}

$(document).ready(function () {
    // 폼이 제출될 때마다 실행되도록 변경
    $('.formEntryOrder').submit(function (e) {
        // 폼 제출을 막음
        e.preventDefault();

        // 작업지시서 등록 3개(id)
        // 지시 일자의 값
        var orderinstdt = $('#currentDate').val();
        // 납기 날짜의 값
        var orderdelivdt = $('#orderDelivDt').val();
        // 작업 상태의 값
        var orderst = $('#orderSt').val();

        // bom 등록 3개(id)
        var itemnm = $('#itemNm').val();
        var itemstnd = $('#itemStnd').val();
        var itemup = $('#itemup').val();

        console.log(itemnm);
        console.log(itemstnd);
        console.log(itemup);

        $('.table.order tbody tr').each(function (index) {
            // 현재 행의 인덱스를 사용하여 입력 필드에 값을 설정
            // 작업 지시서 내용 저장(클래스)
            $(this).find('.orderInstDt').val(orderinstdt);
            $(this).find('.orderDelivDt').val(orderdelivdt);
            $(this).find('.orderSt').val(orderst);

            // bom 내용 저장(클래스)
            $(this).find('.fitemNm').val(itemnm);
            $(this).find('.fitemStnd').val(itemstnd);
            $(this).find('.fitemup').val(itemup);
        });

        var formData = new FormData(this);

        // FormData 객체를 반복하여 폼 데이터 확인
        formData.forEach(function (value, key) {
            console.log(key + ': ' + value);
        });

        // AJAX를 사용하여 폼 데이터 제출
        $.ajax({
            type: $(this).attr('method'), // POST 또는 GET
            url: $(this).attr('action'),
            data: $(this).serialize(), // 폼 데이터 직렬화
            success: function (response) {
                window.location.href = response.redirectUrl;
                /*$('#successModal .modal-body').text(response.message);  //controller에서 받은 message 출력
                // 성공 시 리다이렉션
                $('#successModal').modal('show');
                // 모달이 닫힐 때 리다이렉션
                $('#successModal').on('hidden.bs.modal', function () {
                    window.location.href = response.redirectUrl;
                });*/
            },
            error: function (xhr) {
                // 오류 처리 로직
                var response = JSON.parse(xhr.responseText); // 응답 텍스트를 JSON 객체로 변환
                // 서버로부터 받은 에러 메시지를 알림
                // 오류 처리 로직
                var response = JSON.parse(xhr.responseText);
                $('#failModal .modal-body').text(response.message);  //controller에서 받은 message 출력
                // 오류 메시지 모달 표시
                $('#failModal').modal('show'); // 올바른 셀렉터 사용
                // 모달이 닫힐 때 리다이렉션
                $('#failModal').on('hidden.bs.modal', function () {
                    window.location.href = response.redirectUrl;
                });
                console.log('Error Submitting Form');
            }
        });
    });
});

$(document).ready(function () {

    // 사원 코드 선택시 연락처와 메일이 나올 수 있도록 하는 제이쿼리
    $(".empInfoId").on('input', function () {

        var inputVal = $(this).val();
        console.log(inputVal);

        $("#empIdSelectBox option").each(function () {

            if ($(this).val() === inputVal) {

                var empInfoPhone = $(this).attr("data-empPhone");
                var empInfoEmail = $(this).attr("data-empEmail");
                console.log(empInfoPhone);

                $(this).closest('tr').find('.empInfoPhone').val(empInfoPhone);
                $(this).closest('tr').find('.empInfoEmail').val(empInfoEmail);
                return false; // 반복문 종료
            }
        });
    });
});

function addNewOrder() {

    // 테이블의 마지막 행을 복제
    var $lastOrder = $('form .table.order tbody tr:last');
    var $newOrder = $lastOrder.clone();

    // 복제된 행의 name 속성(itemCd)에 포함된 인덱스를 증가
    $newOrder.find('input, select').each(function () {

        var name = $(this).attr('name');
        console.log(name);

        if (name) {

            var match = name.match(/(\d+)/);
            if (match) {

                var index = parseInt(match[0], 10);
                var newName = name.replace('[' + index + ']', '[' + (index + 1) + ']');
                $(this).attr('name', newName);
            }
        }

        // 입력 필드의 값을 초기화합니다.
        if ($(this).is('input[type="text"]')) {
            $(this).val('');

        } else if ($(this).is('select')) {
            $(this).val($(this).find('option:first').val());

        } else if ($(this).is('input[type="hidden"]')) {
            // 숨겨진 필드의 처리가 필요한 경우 여기에 로직을 추가
        }
    });

    // 새로운 행을 테이블에 추가합니다.
    $newOrder.appendTo('form .table.order tbody');
}

function deleteLastOrder() {
    // tbody 내의 행을 대상으로 선택
    const $tbody = $('form .table.order tbody');

    // tbody 내의 행 개수 확인
    const orderCount = $tbody.find('tr').length;

    // 행이 1개만 남았을 때, 모달 표시
    if (orderCount <= 1) {
        $('#cannotDeleteModal').modal('show');
    } else {
        // 그 외의 경우, 마지막 행 삭제
        $tbody.find('tr:last').remove();
    }
}

/*function addNewBom() {

    // 테이블의 마지막 행을 복제
    var $lastBom = $('form .table.bom tbody tr:last');
    var $newBom = $lastBom.clone();

    // 복제된 행의 name 속성(itemCd)에 포함된 인덱스를 증가
    $newBom.find('input, select').each(function () {

        var name = $(this).attr('name');
        console.log(name);

        if (name) {

            var match = name.match(/(\d+)/);
            if (match) {

                var index = parseInt(match[0], 10);
                var newName = name.replace('[' + index + ']', '[' + (index + 1) + ']');
                $(this).attr('name', newName);
            }
        }

        // 입력 필드의 값을 초기화합니다.
        if ($(this).is('input[type="text"]')) {
            $(this).val('');

        } else if ($(this).is('select')) {
            $(this).val($(this).find('option:first').val());

        } else if ($(this).is('input[type="hidden"]')) {
            // 숨겨진 필드의 처리가 필요한 경우 여기에 로직을 추가
        }
    });

    // 새로운 행을 테이블에 추가합니다.
    $newBom.appendTo('form .table.bom tbody');
}

function deleteLastBom() {
    // tbody 내의 행을 대상으로 선택
    const $tbody = $('form .table.bom tbody');

    // tbody 내의 행 개수 확인
    const bomCount = $tbody.find('tr').length;

    // 행이 1개만 남았을 때, 모달 표시
    if (bomCount <= 1) {
        $('#cannotDeleteModal').modal('show');
    } else {
        // 그 외의 경우, 마지막 행 삭제
        $tbody.find('tr:last').remove();
    }
}*/

$(document).ready(function () {

    $('.addNewOrderbtn').click(function () {
        addNewOrder();
    });

    $('.deleteOrderbtn').click(function () {
        deleteLastOrder();
    });
});

$(document).ready(function () {

    $('#addNewOrderbtn').click(function () {
        addNewOrder();
    });

    $('#deleteOrderbtn').click(function () {
        deleteLastOrder();
    });
});

/*
$(document).ready(function () {

    $('.addNewBombtn').click(function () {
        addNewBom();
    });

    $('.deleteBombtn').click(function () {
        deleteLastBom();
    });
});

$(document).ready(function () {

    $('#addNewBombtn').click(function () {
        addNewBom();
    });

    $('#deleteBombtn').click(function () {
        deleteLastBom();
    });
});*/

$('.reset2').click(function () {
    // 폼 내의 모든 input 필드의 값을 초기화
    $('.formEntryOrder input[type="text"]').val('');
    $('.formEntryOrder input[type="date"]').val('');
    $('.formEntryOrder select').each(function () {
        this.selectedIndex = 0;
    });
    $('#currentDate').val(new Date().toISOString().substring(0, 10));
});