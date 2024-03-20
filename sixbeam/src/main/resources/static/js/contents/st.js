//재고_As등록--------------------------------------------------------------------------------시작
$(document).ready(function() {
    // 폼이 제출될 때마다 실행되도록 변경
    $('.AsformEntry').submit(function(e) {
        // 폼 제출을 막음
        e.preventDefault();

        var asDt = $('#currentDate').val();
        var empInfoId = $('#empInfoId').val();
        var accountCd = $('#accountCode').val();
        var ascmptDt = $('#ascmptDt').val();
        var asSt = $('#asSt').val();
        var asTi = $('#asTi').val();
        var whregistNm = $('#whregistCode').val();
        var asMo = $('#asMo').val();

        $('.table.Asitem tbody tr').each(function(index) {
            // 현재 행의 인덱스를 사용하여 입력 필드에 값을 설정
            $(this).find('.RegisDate').val(asDt);
            $(this).find('.EmpInfoId').val(empInfoId);
            $(this).find('.AccountCode').val(accountCd);
            $(this).find('.WhregistCode').val(whregistNm);
            $(this).find('.AsSt').val(asSt);
            $(this).find('.AscmptDt').val(ascmptDt);
            $(this).find('.AsTi').val(asTi);
            $(this).find('.AsMo').val(asMo);
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
                $('#successModal .modal-body').text(response.message);  //controller에서 받은 message 출력
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
//재고_As등록--------------------------------------------------------------------------------끝
//재고_AS모달등록-------------------------------------------------------------------------------------------시작
$('.table.Asitem').on('change input', '.selectbox, .itemamt', function() {
    var $row = $(this).closest('tr');
    var itemamt = parseFloat($row.find('.itemamt').val());

    if ($(this).hasClass('selectbox')) { // .selectbox에서의 변경인 경우에만 처리
        var valueitemname = $(this).find(':selected').attr("data-itemNm");
        var valueitmestnd = $(this).find(':selected').attr("data-itemStnd");

        $(this).closest('tr').find('.itemname').val(valueitemname);
        $(this).closest('tr').find('.itemstnd').val(valueitmestnd);
    }
});
//재고_AS모달등록-------------------------------------------------------------------------------------------끝
//재고_출하등록--------------------------------------------------------------------------------시작
$(document).ready(function() {
    // 폼이 제출될 때마다 실행되도록 변경
    $('.ReleaseformEntry').submit(function(e) {
        // 폼 제출을 막음
        e.preventDefault();

        var releaseDt = $('#currentDate').val();
        var empInfoId = $('#empInfoId').val();
        var saleCd  = $('#saleCd').val();
        var releaseRv = $('#releaseRv').val();
        var releasePhone = $('#releasePhone').val();
        var releaseAddr = $('#releaseAddr').val();
        var accountCd=$('#accountCd').val();
        var whregistCd=$('#whregistCode').val();

        $('.table.item tbody tr').each(function(index) {
            // 현재 행의 인덱스를 사용하여 입력 필드에 값을 설정
            $(this).find('.RegisDate').val(releaseDt);
            $(this).find('.EmpInfoId').val(empInfoId);
            $(this).find('.AccountCode').val(accountCd);
            $(this).find('.WhregistCode').val(whregistCd);
            $(this).find('.ReleaseRv').val(releaseRv);
            $(this).find('.ReleasePhone').val(releasePhone);
            $(this).find('.ReleaseAddr').val(releaseAddr);
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
                // 성공적으로 제출된 경우의 처리 로직
                console.log('Form Submitted Successfully');
                $('#successModal .modal-body').text(response.message);
                // 성공 시 리다이렉션
                $('#successModal').modal('show');
                // 모달이 닫힐 때 리다이렉션
                $('#successModal').on('hidden.bs.modal', function () {
                    window.location.href = response.redirectUrl;
                });
            },
            error: function(response) {
                $('#failModal .modal-body').text(response.message); // 에러 메시지를 모달에 설정
                // 오류 메시지 모달 표시
                $('#failModal').modal('show'); // 올바른 셀렉터 사용
                // 모달이 닫힐 때 리다이렉션
                $('#failModal').on('hidden.bs.modal', function () {
                    window.location.href = response.redirectUrl;
                });
                // 오류 처리 로직
                console.log('Error Submitting Form');
            }
        });
    });
});
//재고_출하등록--------------------------------------------------------------------------------끝
//재고_출하모달수정---------------------------------------------------------------------------------시작
$('#detailReleaseCd[data-id]').on('click', function() {
    console.log($(this).data('id'));
    var releaseCd = $(this).data('id'); // data-id 속성에서 ID 가져오기
    $('#releasedetail').modal('hide');
    // AJAX 요청
    $.ajax({
        url: '/st/release/list/detail/' + releaseCd, // 서버 엔드포인트
        type: 'GET',
        success: function(data) {

            console.log(data);
            if (data.releaseEntities && data.releaseEntities.length > 0) {
                // 성공 시 모달 내용 업데이트
                var modaltBody = $('.ReleaseformEntry .table.item tbody');
                modaltBody.empty();
                var releaseEntity = data.releaseEntities[0]; // 첫 번째 releaseEntity 사용
                $('#releaseCd').val(releaseEntity.releaseCd);
                $('#releaseCurrentDate').val(releaseEntity.releaseDt);
                $('#releasename').val(releaseEntity.empInfoEntity.empInfoNm);
                $('#updatereleaseAddr').val(releaseEntity.releaseAddr);
                $('#updatereleaseRv').val(releaseEntity.releaseRv);
                $('#updatereleasePhone').val(releaseEntity.releasePhone);

                // 데이터 항목별로 행 추가
                data.saleAndEstimateDtos.forEach(function(saleAndEstimateDto, dtoIndex) {
                    // 각 SaleAndEstimateDto의 estimateEntities 배열을 순회
                    saleAndEstimateDto.estimateEntity.forEach(function(item, index) {
                        var row = $('<tr>'); // 행 생성
                        // 각 셀에 입력 요소와 name 속성 추가
                        row.append('<td><input type="text" class="form-control" name="estimateDtos[' + index + '].itemEntity.itemCd" value="' + item.itemEntity.itemCd + '"></td>');
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
//재고_출하수정---------------------------------------------------------------------------------끝
//재고_AS수정---------------------------------------------------------------------------------시작
$('#detailAsCd[data-id]').on('click', function() {
    console.log($(this).data('id'));
    var asCd = $(this).data('id'); // data-id 속성에서 ID 가져오기
    $('#asdetail').modal('hide');
    // AJAX 요청
    $.ajax({
        url: '/st/as/list/detail/' + asCd, // 서버 엔드포인트
        type: 'GET',
        success: function(data) {
            data.forEach(function(value, key) {
                console.log(key + ': ' + value);
            });
            if (data && data.length > 0) {
                // 성공 시 모달 내용 업데이트
                var modaltBody = $('.AsformEntry .table.Asitem tbody');
                modaltBody.empty();
                $('#asCd').val(data[0].asCd);
                $('#updateCurrentDate').val(data[0].asDt);
                $('#updateaccountCode').val(data[0].accountEntity.accountCd);
                $('#updatename').val(data[0].empInfoEntity.empInfoNm);
                $('#updateaccountName').val(data[0].accountEntity.accountNm);
                $('#updateascmptDt').val(data[0].ascmptDt);
                $('#updateasSt').val(data[0].asSt);
                $('#updateasTi').val(data[0].asTi);
                $('#updatewhregistName').val(data[0].whregistEntity.whregistNm);
                $('#updateasMo').val(data[0].asMo);
                // 데이터 항목별로 행 추가
                data.forEach(function(Asitem, index) {
                    var row = $('<tr>'); // 행 생성
                    // 각 셀에 입력 요소와 name 속성 추가
                    row.append('<td><input type="hidden" name="asCd" class="form-control" value="' + Asitem.asCd + '">'+
                    '<input type="hidden" name="empInfoEntity" class="form-control" value="' + Asitem.empInfoEntity.empInfoId + '">'+
                    '<input type="hidden" name="whregistEntity" class="form-control" value="' + Asitem.whregistEntity.whregistCd+ '">'+
                    '<input type="text" class="form-control" name="itemEntity" value="' + Asitem.itemEntity.itemCd + '"></td>');
                    row.append('<td><input type="text" class="form-control itemname" value="' + Asitem.itemEntity.itemNm + '"></td>');
                    row.append('<td><input type="text" class="form-control itemstnd" value="' + Asitem.itemEntity.itemStnd + '"></td>');
                    row.append('<td><input type="text" name="asAmt" class="form-control itemamt" value="' + Asitem.asAmt + '"></td>');
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
//재고_AS수정---------------------------------------------------------------------------------끝
//재고_삭제---------------------------------------------------------------------------------시작
$(document).ready(function() {
    $('#stcddelete').click(function() {
        $('#deleteStModal').modal('hide');
        // 선택 정보의 ID 가져오기
        var selectedStId = $('#dataTableSt input[name="selectedSt"]:checked').map(function(){
            return $(this).val();
        }).get();

        // 선택한 ID를 hidden input에 설정
        $('#selectedSt').val(selectedStId);
        // 폼 제출
        $('.deleteStForm').submit();
    });

    // 폼 제출 이벤트 핸들러
    $('.deleteStForm').submit(function(e) {
        // 폼 제출을 막음
        e.preventDefault();

        // AJAX를 사용하여 폼 데이터 제출
        $.ajax({
            type: $(this).attr('method'), // POST 또는 GET
            url: $(this).attr('action'),
            data: $(this).serialize(), // 폼 데이터 직렬화
            success: function(response) {
                $('#successModal .modal-body').text(response.message);  //controller에서 받은 message 출력
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
                $('#failModal .modal-body').text(response.message);
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
//재고_삭제---------------------------------------------------------------------------------끝
//재고_창고등록--------------------------------------------------------------------------------시작
$(document).ready(function() {
    // 폼이 제출될 때마다 실행되도록 변경
    $('.WhregistformEntry').submit(function(e) {
        // 폼 제출을 막음
        e.preventDefault();

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
                $('#successModal .modal-body').text(response.message);  //controller에서 받은 message 출력
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
//재고_창고등록--------------------------------------------------------------------------------끝
//재고_창고수정---------------------------------------------------------------------------------시작
$('#detailWhregistCd[data-id]').on('click', function() {
    console.log($(this).data('id'));
    var whregistCd = $(this).data('id'); // data-id 속성에서 ID 가져오기
    $('#whregistdetail').modal('hide');
    // AJAX 요청
    $.ajax({
        url: '/st/whregist/list/detail/' + whregistCd, // 서버 엔드포인트
        type: 'GET',
        success: function(data) {
            data.forEach(function(value, key) {
                console.log(key + ': ' + value);
            });
            if (data && data.length > 0) {
                // 성공 시 모달 내용 업데이트
                var modaltBody = $('.WhregistformEntry .table.Whregistitem tbody');
                modaltBody.empty();
                $('#whregistCd').val(data[0].whregistCd);
                $('#updateWhregistNm').val(data[0].whregistNm);

                // 데이터 항목별로 행 추가
                data.forEach(function(Whregistitem, index) {
                    var row = $('<tr>'); // 행 생성
                    // 각 셀에 입력 요소와 name 속성 추가
                    row.append('<td><input type="hidden" name="whregistCd" class="form-control" value="' + Whregistitem.whregistCd + '"></td>');
                    row.append('<td><input type="text" name="whregistNm" class="form-control" value="' + Whregistitem.whregistNm + '"></td>');
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
//재고_창고수정---------------------------------------------------------------------------------끝