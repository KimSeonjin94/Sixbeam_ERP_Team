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
        $('#addnewrowbtn').click(function() {
            addRow();
        });

        $('#deleterowbtn').click(function() {
            deleteLastRow();
        });
    });

    function addRow() {
        const $table = $('.table.item');
        const rowCount = $table.find('tr').length; // 현재 행의 개수를 기반으로 인덱스 생성

        // 새 행 추가
        const $newRow = $table.find('tr:last').clone().appendTo($table);

        // 새 행의 각 입력 요소에 대해 고유한 id 부여
        $newRow.find('input, select').each(function() {
            const newId = $(this).attr('id') + '_' + rowCount; // 예: currentDate_1, accountCode_1 등
            $(this).attr('id', newId);

            // 연관된 label의 for 속성도 업데이트
            if ($(this).is('input')) { // select 요소는 label과 연결되지 않을 수 있음
                $newRow.find('label[for="' + $(this).attr('id') + '"]').attr('for', newId);
            }
        });

        // 복제된 새 행의 입력 요소 값 초기화
//        $newRow.find('input').val('');
//        $newRow.find('select').val('');
    }
    function deleteLastRow() {
        // 테이블 선택
        const $table = $('.table.item');

        // 테이블의 행 개수 확인
        const rowCount = $table.find('tr').length;

        // 행이 하나만 남았을 때
        if (rowCount <= 1) {
            // Bootstrap 모달 표시
            $('#cannotDeleteModal').modal('show');
        } else {
            // 마지막 행 삭제
            $table.find('tr:last').remove();
        }
    }
    $('[name="date"]').each(function() {
        // 현재 요소의 값을 변경
        $(this).val($('#date').val());

    });
    $('[name="ac"]').each(function() {
        // 현재 요소의 값을 변경
        $(this).val($('#ac').val());

    });
    $('[name="name"]').each(function() {
        // 현재 요소의 값을 변경
        $(this).val("newValue");

    });
    $('[name="acNw"]').each(function() {
        // 현재 요소의 값을 변경
        $(this).val("newValue");

    });


})(jQuery); // End of use strict

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

//테이블에서 품목 코드 선택하면 폼목명, 단가 불러오고 수량 작성하면 공급가액, 부가세, 총합 계산되도록 하는 제이쿼리
$('.table.item').on('change input', '.selectbox, .itemamt', function() {
    var $row = $(this).closest('tr');
    var itemamt = parseFloat($row.find('.itemamt').val());
    var itemup = parseFloat($row.find('.itemup').val().replace(/[^\d.-]/g, '')); // 숫자가 아닌 문자 제거

    if ($(this).hasClass('selectbox')) { // .selectbox에서의 변경인 경우에만 처리
        var valueitemname = $(this).val();
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
    $('#estimateitem').on('input', '.itemamt, .itemup, .itemsp, .itemvar, .itemsum', function() {
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