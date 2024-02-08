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
        // 테이블 선택
        const $table = $('.table.item');

        // 이전 행 선택
        const $previousRow = $table.find('tr').last();

        // 새 행 추가
        const $newRow = $previousRow.clone().appendTo($table).find('input').val('');

        // 복제된 새 행의 input 요소 초기화
        //$newRow.find('input').val('');
    }
    function deleteLastRow() {
        // 테이블 선택
        const $table = $('.table.item');

        // 마지막 행 삭제
        $table.find('tr:last').remove();
    }
    $(document).ready(function() {
        $('.form-control.item').on('change', function() {
            // 현재 이벤트가 발생한 input 요소를 선택
            var currentInput = $(this);
            //input 값 저장
            var itemCd = $(this).val();
            // 해당 input이 속한 row를 찾아서 인덱스를 가져옴
            var rowIndex = currentInput.closest('tr').index();
            // AJAX 요청
            $.ajax({
                type: 'GET',
                url: '/getitemdata',
                data: { itemCd: itemCd },
                success: function(response) {
                    // 응답을 받았을 때 데이터를 테이블에 반영
                    var itemNwColumn = response.itemNw;

                    // 현재 행의 첫 번째 열 값을 업데이트
                    currentInput.closest('tr').find('td:eq(1)').find('input').val(itemNwColumn);
                },
                error: function(xhr, status, error) {
                    console.error('Error:', error);
                }
            });
        });
    });
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
