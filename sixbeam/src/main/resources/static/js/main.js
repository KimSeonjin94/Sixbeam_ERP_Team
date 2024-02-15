(function($) {
    "use strict"; // Start of use strict

    // Toggle the side navigation
    $("#sidebarToggle, #sidebarToggleTop").on('click', function(e) {
        $("body").toggleClass("sidebar-toggled");
        $(".sidebar").toggleClass("toggled");
        if ($(".sidebar").hasClass("toggled")) {
            $('.sidebar .collapse').collapse('hide');
        };
    });

    // Close any open menu accordions when window is resized below 768px
    $(window).resize(function() {
        if ($(window).width() < 768) {
            $('.sidebar .collapse').collapse('hide');
        };

        // Toggle the side navigation when window is resized below 480px
        if ($(window).width() < 480 && !$(".sidebar").hasClass("toggled")) {
            $("body").addClass("sidebar-toggled");
            $(".sidebar").addClass("toggled");
            $('.sidebar .collapse').collapse('hide');
        };
    });

    // Prevent the content wrapper from scrolling when the fixed side navigation hovered over
    $('body.fixed-nav .sidebar').on('mousewheel DOMMouseScroll wheel', function(e) {
        if ($(window).width() > 768) {
            var e0 = e.originalEvent,
            delta = e0.wheelDelta || -e0.detail;
            this.scrollTop += (delta < 0 ? 1 : -1) * 30;
            e.preventDefault();
        }
    });

    // Scroll to top button appear
    $(document).on('scroll', function() {
        var scrollDistance = $(this).scrollTop();
        if (scrollDistance > 100) {
            $('.scroll-to-top').fadeIn();
        } else {
            $('.scroll-to-top').fadeOut();
        }
    });

    // Smooth scrolling using jQuery easing
    $(document).on('click', 'a.scroll-to-top', function(e) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: ($($anchor.attr('href')).offset().top)
        }, 1000, 'easeInOutExpo');
        e.preventDefault();
    });


    $(document).ready(function () {
        var activeTabId = localStorage.getItem('activeTabId');  // 활성 탭 ID를 Local Storage에서 읽어옴

        // 초기 로딩 시 저장된 활성 탭 ID를 기준으로 해당 탭을 활성화
        if (activeTabId) {
            $('.tab-pane').removeClass('show').removeClass('active');
            $('#Tap-' + activeTabId).addClass('show').addClass('active');
        }

        // 각 버튼에 대한 클릭 이벤트 처리
        $('[data-tab-id]').click(function () {
            // 모든 탭을 숨기고 클릭한 탭에 대한 사이드바를 보여줌
            $('.tab-pane').removeClass('show').removeClass('active');
            $('#Tap-' + $(this).data('tab-id')).addClass('show').addClass('active');

            // 활성 탭 ID 저장
            activeTabId = $(this).data('tab-id');
            localStorage.setItem('activeTabId', activeTabId);  // 활성 탭 ID를 Local Storage에 저장
        });

        // 각 탭 내부의 링크에 대한 클릭 이벤트 처리
        $('.tab-pane a').click(function () {
            // 저장된 활성 탭을 기준으로 해당 탭을 활성화
            if (activeTabId) {
                $('.tab-pane').removeClass('show').removeClass('active');
                $('#Tap-' + activeTabId).addClass('show').addClass('active');
            }
        });
    });
    $(document).ready(function() {
        $('#deleterowbtn').click(function() {
            deleteLastRow();
        });
    });

    $(document).ready(function() {
        $('#addnewrowbtn').click(function() {
            // 테이블의 마지막 행을 복제합니다.
            var $lastRow = $('.table.item tbody tr:last');
            var $newRow = $lastRow.clone();

            // 복제된 행의 name 속성에 포함된 인덱스를 증가시킵니다.
            $newRow.find('input, select').each(function() {
                var name = $(this).attr('name');
                if (name) {
                    var match = name.match(/(\d+)/);
                    if (match) {
                        var index = parseInt(match[0], 10);
                        var newName = name.replace('[' + index + ']', '[' + (index + 1) + ']');
                        $(this).attr('name', newName);
                    }
                }

                // 입력 필드의 값을 초기화합니다.
                if($(this).is('input[type="text"]')) {
                    $(this).val('');
                } else if($(this).is('select')) {
                    $(this).val($(this).find('option:first').val());
                } else if($(this).is('input[type="hidden"]')) {
                    // 숨겨진 필드의 처리가 필요한 경우 여기에 로직을 추가
                }
            });

            // 새로운 행을 테이블에 추가합니다.
            $newRow.appendTo('.table.item tbody');
        });
    });
    function deleteLastRow() {
        // tbody 내의 행을 대상으로 선택
        const $tbody = $('.table.item tbody');

        // tbody 내의 행 개수 확인
        const rowCount = $tbody.find('tr').length;

        // 행이 1개만 남았을 때, 모달 표시
        if (rowCount <= 1) {
            $('#cannotDeleteModal').modal('show');
        } else {
            // 그 외의 경우, 마지막 행 삭제
            $tbody.find('tr:last').remove();
        }
    }




})(jQuery); // End of use strict
$(document).ready(function() {
    //id를 currentData로 하면 현재 날짜를 볼러 올 수 있도록 하는 제이쿼리
    $('#currentDate').val(new Date().toISOString().substring(0,10));

    //거래처 코드 선택하면 거래처명이 나올 수 있도록 하는 제이쿼리
    $("#accountCode").on('input', function() {
        var inputVal = $(this).val();
        $("#accountCodeSelectBox option").each(function() {
            if ($(this).val() === inputVal) {
                var accountNm = $(this).text();
                $("#accountName").val(accountNm);
                return false; // 반복문 종료
            }
        });
    });
});
//테이블에서 품목 코드 선택하면 폼목명, 단가 불러오고 수량 작성하면 공급가액, 부가세, 총합 계산되도록 하는 제이쿼리
$('.table.item').on('change input', '.selectbox, .itemamt', function() {
    var $row = $(this).closest('tr');
    var itemamt = parseFloat($row.find('.itemamt').val());
    var itemup = parseFloat($row.find('.itemup').val().replace(/[^\d.-]/g, '')); // 숫자가 아닌 문자 제거

    if ($(this).hasClass('selectbox')) { // .selectbox에서의 변경인 경우에만 처리
        var valueitemname = $(this).find(':selected').attr("data-itemNm");
        var valueitmestnd = $(this).find(':selected').attr("data-itemStnd");
        var valueitmeup = parseFloat($(this).find(':selected').attr("data-itemUp")); // 문자열을 숫자로 변환

        $(this).closest('tr').find('.itemname').val(valueitemname);
        $(this).closest('tr').find('.itemstnd').val(valueitmestnd);
        $(this).closest('tr').find('.itemup').val(valueitmeup.toLocaleString('ko-KR', { style: 'currency', currency: 'KRW' }));
    }

    if (!isNaN(itemamt) && !isNaN(itemup)) {
        var itemsp = itemamt * itemup;
        var itemvar = itemsp * 0.1;
        var itemsum = itemsp + itemvar;

        $row.find('.itemsp').val(itemsp.toLocaleString('ko-KR', { style: 'currency', currency: 'KRW' }));
        $row.find('.itemvar').val(itemvar.toLocaleString('ko-KR', { style: 'currency', currency: 'KRW' }));
        $row.find('.itemsum').val(itemsum.toLocaleString('ko-KR', { style: 'currency', currency: 'KRW' }));
    }
});

// 폼 제출 시 데이터 저장 함수 호출
$('#orinputform').submit(function(event) {
    event.preventDefault(); // 기본 제출 이벤트 막기
    orinPutSaveData(); // 데이터 저장 함수 호출
});

function orinPutSaveData() {
    // 품목 데이터 수집
    const items = [];
    $('#orinputitem tbody tr').each(function () {
        const item = {
            // 각 행에서 필요한 데이터를 수집하여 객체로 만듦
            // 예시: itemCd, itemName, itemStnd, itemAmt, itemUp, itemSp, itemVar, itemSum
            itemCd: $(this).find('.selectbox').val(),
            itemName: $(this).find('.itemname').val(),
            itemStnd: $(this).find('.itemstnd').val(),
            itemAmt: $(this).find('.itemamt').val(),
            itemUp: $(this).find('.itemup').val(),
            itemSp: $(this).find('.itemsp').val(),
            itemVar: $(this).find('.itemvar').val(),
            itemSum: $(this).find('.itemsum').val()
        };
        items.push(item);
    });

    // 기타 필요한 데이터 수집 (발주 일자, 담당자, 거래처 등)

    // 데이터를 JSON 형식으로 만듦
    const data = {
        currentDate: $('#currentDate').val(),
        orinputname: $('#orinputname').val(),
        accountCode: $('#accountCode').val(),
        accountName: $('#accountName').val(),
        orinputReqDate: $('#orinputReqDate').val(),
        orinputDlvyDate: $('#orinputDlvyDate').val(),
        items: items
    };

    // Ajax를 사용하여 서버로 데이터 전송
    $.ajax({
        type: 'POST',
        url: '/pur/orinput/save',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (response) {
            // 저장 성공 시 처리
            console.log('Data saved successfully!');
        },
        error: function (error) {
            // 저장 실패 시 처리
            console.error('Error while saving data:', error);
        }
    });
}
$(document).ready(function() {
    calculateTotals();

    // 데이터가 변경될 때마다 합계를 다시 계산합니다.
    // 예를 들어, 행이 추가되거나 삭제될 때, 입력 값이 변경될 때 등
    $('.table.item').on('input', '.itemamt, .itemup, .itemsp, .itemvar, .itemsum', function() {
        calculateTotals();
    });
});
function calculateTotals() {
    var totalAmt = 0, totalUp = 0, totalSp = 0, totalVat = 0, totalSum = 0;

    $('.itemamt').each(function() {
        totalAmt += parseInt($(this).val()) || 0;
    });
    $('.itemup').each(function() {
        var value = $(this).val().replace(/[^\d]/g, '');
        totalUp += parseInt(value) || 0;
    });
    $('.itemsp').each(function() {
        var value = $(this).val().replace(/[^\d]/g, '');
        totalSp += parseInt(value) || 0;
    });
    $('.itemvar').each(function() {
        var value = $(this).val().replace(/[^\d]/g, '');
        totalVat += parseInt(value) || 0;
    });
    $('.itemsum').each(function() {
        var value = $(this).val().replace(/[^\d]/g, '');
        totalSum += parseInt(value) || 0;
    });

    // 계산된 합계를 통화 형식으로 표시
    $('#totalAmt').text(totalAmt);
    $('#totalUp').text(formatCurrency(totalUp));
    $('#totalSp').text(formatCurrency(totalSp));
    $('#totalVat').text(formatCurrency(totalVat));
    $('#totalSum').text(formatCurrency(totalSum));
}

function formatCurrency(value) {
    // 숫자를 지역화된 통화 문자열로 변환 (소수점 없이)
    return "₩" + value.toLocaleString('ko-KR');
}

$(document).ready(function() {
    // 폼이 제출될 때마다 실행되도록 변경
    $('#formEntry').submit(function(e) {
        // 폼 제출을 막음
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
        var requestDate = $('#orinputReqDate').val()
        // 납기 일자(발주에서 사용)
        var deliveryDate = $('#orinputDlvyDate').val()

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
                // 성공적으로 제출된 경우의 처리 로직
                console.log('Form Submitted Successfully');
            },
            error: function(response) {
                // 오류 처리 로직

                console.log('Error Submitting Form');
            }
        });
    });
});
$('#successModal').on('hidden.bs.modal', function () {
    // 페이지를 새로 고침
    window.location.reload();
});



function editAccountInfo(accountCd, accountNm , accountAdd, accountRep, accountSectors, accountBank, accountAcnb, accountPic, accountEtc)
{
    $('#editAccount').modal('show');
    $('#editAccountCd').val(accountCd);
    $('#editAccountNm').val(accountNm);
    $('#editAccountAdd').val(accountAdd);
    $('#editAccountRep').val(accountRep);
    $('#editAccountSectors').val(accountSectors);
    $('#editAccountBank').val(accountBank);
    $('#editAccountAcnb').val(accountAcnb);
    $('#editAccountPic').val(accountPic);
    $('#editAccountEtc').val(accountEtc);
}
//function registerAccountFinished() {
////             document.getElementById("createEmployeeForm").submit();
//             alert('거래처가 등록되었습니다.');
//         }
//function editAccountFinished() {
////             document.getElementById("createEmployeeForm").submit();
//             alert('거래처 정보가 수정되었습니다.');
//         }


$('.table.item a[data-id]').on('click', function() {
    console.log($(this).data('id')); // 클릭된 요소의 ID를 콘솔에 출력
    var whregistCd = $(this).data('id');
    $.ajax({
        url: '/whregist/list/detail/' + whregistCd,
        type: 'GET',
        success: function(data) {
            console.log(data); // 받은 데이터를 콘솔에 출력하여 확인
            if (data && data.length > 0) {
                $('#updatewhregistCode').val(data[0].whregistEntity.whregistCd);
                $('#updatewhregistName').val(data[0].whregistEntity.whregistNm);
                $('#detail').modal('show');
            } else {
                console.error('데이터가 비어있습니다.');
            }
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
});



// 테이블의 행 클릭 이벤트 핸들러
$('.table.item a[data-id]').on('click', function() {
    console.log($(this).data('id'));
    var estimateId = $(this).data('id'); // data-id 속성에서 ID 가져오기
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
                var modaltBody = $('#entity .table.item tbody');
                modaltBody.empty();
                $('#updateCurrentDate').val(data[0].estimateDt);
                $('#updateaccountCode').val(data[0].accountEntity.accountCd);
                $('#updatename').val(data[0].empInfoEntity.empInfoNm);
                $('#updateaccountName').val(data[0].accountEntity.accountNm);
                for(var i =0;i<data.length;i++){
                    var row = $('<tr>'); // 행 생성

                    // 각 셀에 입력 요소 추가
                    row.append('<td><input type="text" class="form-control" value="' + data[i].itemEntity.itemCd + '"></td>');
                    row.append('<td><input type="text" class="form-control" value="' + data[i].itemEntity.itemNm + '"></td>');
                    row.append('<td><input type="text" class="form-control" value="' + data[i].itemEntity.itemStnd + '"></td>');
                    row.append('<td><input type="text" class="form-control" value="' + data[i].estimateAmt + '"></td>');
                    row.append('<td><input type="text" class="form-control" value="' + data[i].estimateUp + '"></td>');
                    row.append('<td><input type="text" class="form-control" value="' + data[i].estimateSp + '"></td>');
                    row.append('<td><input type="text" class="form-control" value="' + data[i].estimateVat + '"></td>');
                    row.append('<td><input type="text" class="form-control" value="' + data[i].estimateTamt + '"></td>');
                    row.append('<td><input type="text" class="form-control" value="' + data[i].estimateEtc + '"></td>');
                    modaltBody.append(row);

                }
                // 모달 표시
                $('#detail').modal('show');
            } else {
                console.error('데이터가 비어있습니다.');
            }
        },
        error: function(error) {
            console.log('Error:', error);
        }
    });
});
$(document).ready(function() {
    $('#entity').submit(function(event) {
        // 폼의 기본 동작인 서버로의 POST 요청 방지
        event.preventDefault();

        // 폼 데이터를 JSON 객체로 직렬화
        var formData = $('#entity').serializeArray();
        console.log(formData);

        // AJAX 요청 설정
        $.ajax({
            url: '/ss/estimate/update',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(response) {
                // 성공 시 동작
                window.location.href = response.redirectUrl;
                console.log('서버로부터 응답 받음:', response);
                // 추가적인 동작 수행 가능
            },
            error: function(xhr, status, error) {
                // 오류 시 동작
                console.error('오류 발생:', error);
                // 오류 처리 또는 메시지 표시
            }
        });
    });
});

