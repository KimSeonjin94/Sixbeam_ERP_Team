$('#detailEstimateCd[data-id]').on('click', function() {
    console.log($(this).data('id'));
    var estimateId = $(this).data('id'); // data-id 속성에서 ID 가져오기
    $('#estimatedetail').modal('hide');
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

                $('#detail').modal('show'); // 모달 표시
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
            var modaltBody = $('.formEntry .table.item tbody');
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

            $('#detail').modal('show'); // 모달 표시

        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
})
$('#estimatedetail').on('show.bs.modal', function () {
    // 다른 모든 모달을 숨김
    $('#new').modal('hide');
});

// estimatedetail 모달이 닫힐 때
$('#estimatedetail').on('hidden.bs.modal', function () {
    // 다른 모달을 다시 보이게 함 (예를 들어, 특정 조건에 따라)
    // 여기서는 예시로 다른 모달의 ID를 사용합니다.
    $('#new').modal('show');
});