
function setItemInfo(itemCd, itemNm, itemStnd, itemUp) {
    $('#editItem').modal('show');
    $('#editItemCd').val(itemCd);
    $('#editItemNm').val(itemNm);
    $('#editItemStnd').val(itemStnd);
    $('#editItemUp').val(itemUp);
}

function setEmpInfo(empInfoNm, empInfoPhone, empInfoEmail) {
    $('#detailOrder').modal('show');
    $('#detailEmpInfoNm').val(empInfoNm);
    $('#detailEmpInfoPhone').val(empInfoPhone);
    $('#detailEmpInfoEmail').val(empInfoEmail);
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
    document.querySelectorAll('.selectedInfo:checked').forEach(function (checkbox) {
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

$('#editDetailItembtn[data-id]').on('click', function () {

    var itemCd = $(this).data('id'); // this - 클릭된 요소
    var itemSum = 0;

    // 선택한 품목에 대한 부속품 정보를 요청하기 위해 Ajax를 사용
    $.ajax({

        // 서버의 해당 URL로 요청
        url: '/pd/bom/detail/' + itemCd,
        type: 'GET',
        success: function (response) {
            console.log(response);

            // 부속품 정보를 받아온 후, 테이블에 동적으로 추가
            var ritemDetailsTable = $('#ritemDetails');

            // 기존에 표시된 내용을 모두 지우고 새로운 내용으로 대체
            ritemDetailsTable.empty();

            response.forEach(function (bomEntity, index) {

                itemSum += (bomEntity.ritemEntity.itemUp * bomEntity.bomUseMt);

                // 부속품의 각 정보를 테이블에 추가
                var row = $('<tr>');

                row.append('<td>' + bomEntity.ritemEntity.itemCd + '</td>' +
                    '<td><input type="text" class="form-control" value="' + bomEntity.ritemEntity.itemNm + '"></td>' +
                    '<td><input type="text" class="form-control" value="' + bomEntity.ritemEntity.itemStnd + '"></td>' +
                    '<td><input type="text" class="form-control" value="' + bomEntity.bomUseMt + '"></td>' +
                    '<td><input type="text" class="form-control" value="' + bomEntity.ritemEntity.itemUp + '"></td>');

                // 새로운 행을 테이블에 추가
                ritemDetailsTable.append(row);
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