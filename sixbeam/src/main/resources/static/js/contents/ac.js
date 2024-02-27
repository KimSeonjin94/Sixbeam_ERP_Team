// AC에서 사용

function setAccountInfo(accountCd, accountNm , accountNb, accountAdd, accountRep, accountSectors, accountBank, accountAcnb, accountPic, accountEtc)
{
    $('#editAccount').modal('show');
    $('#editAccountCd').val(accountCd);
    $('#editAccountNm').val(accountNm);
    $('#editAccountNb').val(accountNb);
    $('#editAccountAdd').val(accountAdd);
    $('#editAccountRep').val(accountRep);
    $('#editAccountSectors').val(accountSectors);
    $('#editAccountBank').val(accountBank);
    $('#editAccountAcnb').val(accountAcnb);
    $('#editAccountPic').val(accountPic);
    $('#editAccountEtc').val(accountEtc);
}
function registerAccountFinished() {
    alert('거래처가 등록되었습니다.')
}
function editAccountFinished() {
    alert('거래처 정보가 수정되었습니다.');
}
// 선택된 계정 ID를 수집하여 폼에 설정하는 함수
function prepareDelete() {
    // 체크박스의 값(계정 ID)을 저장할 배열
    var selectedIds = [];

    // 모든 'selectedInfo' 클래스를 가진 체크박스를 찾고 선택된 항목의 값만 배열에 추가
    document.querySelectorAll('.selectedInfo:checked').forEach(function(checkbox) {
        selectedIds.push(checkbox.value);
    });

    // 배열을 쉼표로 구분된 문자열로 변환
    var accountIdsToDelete = selectedIds.join(',');

    // 숨겨진 입력 필드에 값을 설정
    document.getElementById('deleteAccountInfo').value = accountIdsToDelete;

    alert('거래처가 삭제되었습니다.');
    // 폼을 제출하여 서버에 삭제 요청을 보냅니다
    document.getElementById('deleteForm').submit();
}
// AC 끝