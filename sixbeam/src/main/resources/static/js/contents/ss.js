$('#detailEstimateCd[data-id]').on('click', function() {
    console.log($(this).data('id'));
    var estimateId = $(this).data('id'); // data-id 속성에서 ID 가져오기
    $('#estimatedetail').modal('hide');
    var originalTbody = $('.formEntry .table .item tbody').html();
    // AJAX 요청
    $.ajax({
        url: '/ss/estimate/list/detail/' + estimateId, // 서버 엔드포인트
        type: 'GET',
        success: function(data) {
            data.forEach(function(value, key) {
                console.log(key + ': ' + value);
            });
            if (data && data.length > 0) {
                // 성공 시 모달 내용 업데이트

                var modaltBody = $('.formEntry .table.item tbody');
                modaltBody.empty();
                $('#estimateCd').val(data[0].estimateCd);
                $('#updateCurrentDate').val(data[0].estimateDt);
                $('#updateaccountCode').val(data[0].accountEntity.accountCd);
                $('#updatename').val(data[0].empInfoEntity.empInfoNm);
                $('#updateaccountName').val(data[0].accountEntity.accountNm);

                // 데이터 항목별로 행 추가
                data.forEach(function(item, index) {
                    var row = $('<tr>'); // 행 생성

                    // 각 셀에 입력 요소와 name 속성 추가
                    row.append('<td><input type="hidden" name="estimateDtos[' + index + '].estimateDt" class="form-control" value="' + item.estimateDt + '">'+
                    '<input type="hidden" name="estimateDtos[' + index + '].accountEntity.accountCd" class="form-control" value="' + item.accountEntity.accountCd + '">'+
                    '<input type="hidden" name="estimateDtos[' + index + '].empInfoEntity.empInfoId" class="form-control" value="' + item.empInfoEntity.empInfoId+ '">'+
                    '<input type="hidden" name="estimateDtos[' + index + '].estimateCd" class="form-control" value="' + item.estimateCd+ '">'+
                    '<input type="text" class="form-control" name="estimateDtos[' + index + '].itemEntity.itemCd" value="' + item.itemEntity.itemCd + '"></td>');
                    row.append('<td><input type="text" class="form-control itemname" value="' + item.itemEntity.itemNm + '"></td>');
                    row.append('<td><input type="text" class="form-control itemstnd" value="' + item.itemEntity.itemStnd + '"></td>');
                    row.append('<td><input type="text" name="estimateDtos[' + index + '].estimateAmt" class="form-control itemamt" value="' + item.estimateAmt + '"></td>');
                    row.append('<td><input type="text" name="estimateDtos[' + index + '].estimateUp" class="form-control itemup" value="' + item.estimateUp + '"></td>');
                    row.append('<td><input type="text" name="estimateDtos[' + index + '].estimateSp" class="form-control itemsp" value="' + item.estimateSp + '"></td>');
                    row.append('<td><input type="text" name="estimateDtos[' + index + '].estimateVat" class="form-control itemvar" value="' + item.estimateVat + '"></td>');
                    row.append('<td><input type="text" name="estimateDtos[' + index + '].estimateTamt" class="form-control itemsum" value="' + item.estimateTamt + '"></td>');
                    row.append('<td><input type="text" name="estimateDtos[' + index + '].estimateEtc" class="form-control" value="' + item.estimateEtc + '"></td>');
                    modaltBody.append(row); // 생성된 행을 테이블에 추가
                });

                var currentUrl = window.location.href;
                if (currentUrl.includes("estimate")) {
                    $('#detail').modal('show'); // 모달 표시
                }
            } else {
                console.error('데이터가 비어있습니다.');
            }
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
});

$('#detailSaleCd[data-id]').on('click', function(){
    console.log($(this).data('id'));
    var saleCd = $(this).data('id'); // data-id 속성에서 ID 가져오기
    $('#saledetail').modal('hide');
    // AJAX 요청
    $.ajax({
        url: '/ss/sale/list/detail/' + saleCd, // 서버 엔드포인트
        type: 'GET',
        success: function(response) {

            // 성공 시 모달 내용 업데이트
            var modaltBody = $('#detail .formEntry .table.item tbody');
            modaltBody.empty();
            $('#saleCd').val(response.saleEntity.saleCd);
            $('#updateCurrentDate').val(response.saleEntity.saleUploadDt);
            $('#updateaccountCode').val(response.estimateEntities[0].accountEntity.accountCd);
            $('#updatename').val(response.estimateEntities[0].empInfoEntity.empInfoNm);
            $('#updateaccountName').val(response.estimateEntities[0].accountEntity.accountNm);
            $('#updatewhregistname').find('option[value="' + response.saleEntity.whregistEntity.whregistCd + '"]').prop('selected', true);


            if (response.estimateEntities[0].accountEntity.accountNm === '개인거래') {
                // accountNm이 '개인거래'일 경우, 특정 필드에 값을 설정
                $('#releaseRv').val(response.memberEntity.memberNm);
                $('#releaseAddr').val(response.memberEntity.memberAddr);
                $('#releasePhone').val(response.memberEntity.memberPhone);

            } else {
                // '개인거래'가 아닐 경우, 다른 값이나 기본값을 설정할 수 있음
                $('#releaseRv').val(response.estimateEntities[0].estimateNm);
                $('#releaseAddr').val(response.estimateEntities[0].accountEntity.accountAdd);

            }

            // 데이터 항목별로 행 추가
            response.estimateEntities.forEach(function(item, index) {
                var row = $('<tr>'); // 행 생성

                // 각 셀에 입력 요소와 name 속성 추가
                row.append('<td><input type="text" class="form-control" name="estimateDtos[' + index + '].itemEntity.itemCd" value="' + item.itemEntity.itemCd +'"></td>');
                row.append('<td><input type="text" class="form-control itemname" value="' + item.itemEntity.itemNm + '"></td>');
                row.append('<td><input type="text" class="form-control itemstnd" value="' + item.itemEntity.itemStnd + '"></td>');
                row.append('<td><input type="text" name="estimateDtos[' + index + '].estimateAmt" class="form-control itemamt" value="' + item.estimateAmt + '"></td>');
                row.append('<td><input type="text" name="estimateDtos[' + index + '].estimateUp" class="form-control itemup" value="' + item.estimateUp + '"></td>');
                row.append('<td><input type="text" name="estimateDtos[' + index + '].estimateSp" class="form-control itemsp" value="' + item.estimateSp + '"></td>');
                row.append('<td><input type="text" name="estimateDtos[' + index + '].estimateVat" class="form-control itemvar" value="' + item.estimateVat + '"></td>');
                row.append('<td><input type="text" name="estimateDtos[' + index + '].estimateTamt" class="form-control itemsum" value="' + item.estimateTamt + '"></td>');
                row.append('<td><input type="text" name="estimateDtos[' + index + '].estimateEtc" class="form-control" value="' + item.estimateEtc + '"></td>');
                modaltBody.append(row); // 생성된 행을 테이블에 추가
            });
            var currentUrl = window.location.href;
            if (currentUrl.includes("sale")) {
                $('#detail').modal('show'); // 모달 표시
            }

        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
})
$('#detailMember[data-id]').on('click', function(){
    console.log($(this).data('id'));
    var estimateCd = $(this).data('id'); // data-id 속성에서 ID 가져오기
    $('#memberdetail').modal('hide');
    // AJAX 요청
    $.ajax({
        url: '/ss/member/list/detail/' + estimateCd, // 서버 엔드포인트
        type: 'GET',
        success: function(response) {
            // 성공 시 모달 내용 업데이트
            $('#updateEstimateCd').val(response.memberEntity.estimateEntity.estimateCd)
            $('#updateId').val(response.memberEntity.memberId);
            $('#updateNm').val(response.memberEntity.memberNm);
            $('#updatePhone').val(response.memberEntity.memberPhone);
            $('#updateAddr').val(response.memberEntity.memberAddr);
            $('#detail').modal('show');
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
})
$('#new').on('show.bs.modal', function () {
    // 다른 모든 모달을 숨김
    $(this).find('input[type="text"]').val('');
    var modaltBody = $('#detail .formEntry .table.item tbody');
    modaltBody.empty();
});
$('#estimatedetail').on('show.bs.modal', function () {
    // 다른 모든 모달을 숨김
    $('#new').modal('hide');
});
$(document).ready(function() {
    // tbody의 원래 상태를 저장
    var originalTbody = $('.formEntry .table .item tbody').html();

    // 모달이 hide되는 이벤트를 감지
    $('#detail').on('hidden.bs.modal', function () {
        // 모달이 숨겨졌을 때 tbody의 내용을 원래 상태로 복구
        $('.formEntry .table .item tbody').html(originalTbody);
    });
});
// estimatedetail 모달이 닫힐 때
$('#estimatedetail').on('hidden.bs.modal', function () {
    // 다른 모달을 다시 보이게 함 (예를 들어, 특정 조건에 따라)
    // 여기서는 예시로 다른 모달의 ID를 사용합니다.
    $('#new').modal('show');
});

$(document).ready(function() {
    $('#deleteAll').click(function() {
        $('#delete').modal('hide');
        // 선택한 발주 정보의 ID 가져오기
        var selectedId = $('#dataTableEstimate input[name="selectedid"]:checked').map(function(){
            return $(this).val();
        }).get();

        // 선택한 ID를 hidden input에 설정
        $('#selectedid').val(selectedId);
        // 폼 제출
        $('.deleteForm').submit();
    });

    // 폼 제출 이벤트 핸들러
    $('.deleteForm').submit(function(e) {
        e.preventDefault();
        // AJAX를 사용하여 폼 데이터 제출
        $.ajax({
            type: $(this).attr('method'), // POST 또는 GET
            url: $(this).attr('action'),
            data: $(this).serialize(), // 폼 데이터 직렬화
            success: function(response) {
                $('#successModal .modal-body').text(response.message);
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
                $('#failModal .modal-body').text(response.message); // 에러 메시지를 모달에 설정
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

