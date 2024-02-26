// pd 사용 js

function setItemInfo(itemCd, itemNm , itemStnd, itemUp)
{
    $('#editItem').modal('show');
    $('#editItemCd').val(itemCd);
    $('#editItemNm').val(itemNm);
    $('#editItemStnd').val(itemStnd);
    $('#editItemUp').val(itemUp);
}

function createItemFinished() {

    var itemNm = $('#itemNm').val();
    var itemStnd = $('#itemStnd').val();
    var itemUp = $('#itemUp').val();

    // 품목 코드가 공백인 경우
    if (!itemNm || itemNm.trim() === '') {
        alert('품목명을 입력하세요.');
        event.preventDefault();
        return;

    } else if (!itemStnd || itemStnd.trim() === '') {
        alert('규격을 입력하세요.');
        event.preventDefault();
        return;

    } else if (!itemUp || itemUp.trim() === '') {
        alert('단가를 입력하세요.');
        event.preventDefault();
        return;

    } else {
        alert('품목이 등록되었습니다.')
    }
}

function editItemFinished() {
    alert('품목 정보가 수정되었습니다.');
}

function deleteItemFinished() {

    // 체크박스의 값(계정 ID)을 저장할 배열
    var selectedIds = [];

    // 모든 'selectedInfo' 클래스를 가진 체크박스를 찾고 선택된 항목의 값만 배열에 추가
    document.querySelectorAll('.selectedInfo:checked').forEach(function(checkbox) {
        selectedIds.push(checkbox.value);
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
        document.getElementById('deleteItemInfo').value = itemIdsToDelete;

        alert('품목이 삭제되었습니다.');
        // 폼을 제출하여 서버에 삭제 요청을 보냅니다
        document.getElementById('deleteForm').submit();
    }
}

$(document).ready(function() {
    // 폼이 제출될 때마다 실행되도록 변경
    $('.itemformEntry').submit(function(e) {
        // 기본폼 제출을 막음
        e.preventDefault();
        // 입력 필드에서 숫자가 아닌 문자 제거
        $('.itemamt, .itemup, .itemsp, .itemvar, .itemsum').each(function() {
            var value = $(this).val().replace(/[^0-9]/g, '');
            $(this).val(value);
        });
        // 폼 데이터 변경
        var selectedEmp = $('#orinputname').val();
        // 거래처 코드의 현재 값을 가져옴
        var accountCode = $('#accountCode').val();
        // 견적 일자의 현재 값을 가져옴
        var currentDate = $('#currentDate').val();
        // 발주 요청 일자(발주에서 사용)
        var requestDate = $('#orinputReqDate').val();
        // 납기 일자(발주에서 사용)
        var deliveryDate = $('#orinputDlvyDate').val();

        $('.table.item tbody tr').each(function(index) {
            // 현재 행의 인덱스를 사용하여 입력 필드에 값을 설정
            $(this).find('.RegisDate').val(currentDate);
            $(this).find('.AccountCode').val(accountCode);
            $(this).find('.EmpInfoId').val(selectedEmp);
            $(this).find('.OrinputReqDate').val(requestDate);
            $(this).find('.OrinputDlvyDate').val(deliveryDate);
        });

        var formData = new FormData(this);
        // FormData 객체를 반복하여 폼 데이터 확인
        formData.forEach(function(value, key) {
            console.log(key + ': ' + value);
        });
        // AJAX를 사용하여 폼 데이터 제출
        $.ajax({
            type: $(this).attr('method'), // POST 또는 GET
            url: $(this).attr('action'),
            data: $(this).serialize(), // 폼 데이터 직렬화
            success: function(response) {
                // 성공 시 리다이렉션
                $('#successModal').modal('show');
                // 모달이 닫힐 때 리다이렉션
                $('#successModal').on('hidden.bs.modal', function () {
                    window.location.href = response.redirectUrl;
                });
            },
            error: function(xhr) {
                // 오류 처리 로직
                var response = JSON.parse(xhr.responseText); // 응답 텍스트를 JSON 객체로 변환
                // 서버로부터 받은 에러 메시지를 알림
                // 오류 처리 로직
                var response = JSON.parse(xhr.responseText);
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

$(document).ready(function() {

    // 품목 코드 선택하면 품목명이 나올 수 있도록 하는 제이쿼리
    $("#itemCode").on('input', function() {
        // 입력된 값 가져오기
        var itemCd = $(this).val();
        // 모든 품목 코드 선택 옵션을 반복하면서 입력된 값과 일치하는지 확인.
        $("#itemCodeSelectBox option").each(function () {
            // 현재 옵션의 값이 입력된 값과 일치하는지 확인
            if ($(this).val() === itemCd) {
                // 일치하는 경우 해당 옵션의 텍스트 값을 가져와서 품목명 입력란에 설정
                var itemNm = $(this).text();
                $("#itemName").val(itemNm);
                return false; // 반복문 종료
            }
        });
    });
});

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

function checkInput2(event) {
    // 입력된 값 가져오기
    var inputValue = event.target.value;
    // 숫자가 아닌 입력이 발생할 경우 처리
    if (!/^\d*$/.test(inputValue)) {
        // 입력을 막기 위해 빈 문자열로 설정
        event.target.value = event.target.value.replace(/[^\d]/g, '');
    }
}

function checkInput3(event) {

    var inputVal = event.target.value;

    var regex = /^[가-힣A-Z0-9]*$/;

    event.target.value = inputVal.toUpperCase();
}

// pd 끝 라인
