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
        //초기 로딩시 주소가 home일떄 활성탭을 home으로 함
        if (window.location.pathname === '/sixbeam/home') {
            activeTabId = 'home'; // 활성 탭 ID를 'home'으로 설정
        }
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
        $('.addnewrowbtn').click(function() {
            addnewrow();
        });
        $('.deleterowbtn').click(function() {
            deleteLastRow();
        });
    });
    $(document).ready(function() {
        $('#addnewrowbtn').click(function() {
            addnewrow();
        });
        $('#deleterowbtn').click(function() {
            deleteLastRow();
        });
    });

    function addnewrow() {
        // 테이블의 마지막 행을 복제합니다.
        var $lastRow = $('form .table.item tbody tr:last');
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
            $(this).find( '.itemamt, .itemup, .itemsp, .itemvar, .itemsum').val('0');
        });

        // 새로운 행을 테이블에 추가합니다.
        $newRow.appendTo('form .table.item tbody');
    }

    function deleteLastRow() {
        // tbody 내의 행을 대상으로 선택
        const $tbody = $('form .table.item tbody');

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
    //id를 currentData로  하면 현재 날짜를 볼러 올 수 있도록 하는제이쿼리
    $('#currentDate').val(new Date().toISOString().substring(0,10));

    //거래처 코드 선택하면 거래처명이 나올 수 있도록 하는 제이쿼리
    $("#accountCode").on('input', function() {
        var inputVal = $(this).val();

        $("#accountCodeSelectBox option").each(function() {
            if ($(this).val() === inputVal) {
                var accountNm = $(this).text();
                var dataid=$(this).data('id');
                $("#accountName").val(accountNm);
                $("#accountPic").val(dataid);
                return false; // 반복문 종료
            }
        });
    });

    //창고 코드 선택하면 창고명이 나올 수 있도록 하는 제이쿼리
    $("#whregistCode").on('input', function() {
        var inputVal = $(this).val();
        $("#whregistCodeSelectBox option").each(function() {
            if ($(this).val() === inputVal) {
                var whregistNm = $(this).text();
                $("#whregistName").val(whregistNm);
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
    $('.formEntry').submit(function(e) {
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
                $('#successModal .modal-body').text(response.message);  //controller에서 받은 message 출력
                // 성공 시 리다이렉션
                $('#successModal').modal('show');
                // 모달이 닫힐 때 리다이렉션
                $('#successModal').on('hidden.bs.modal', function () {
                    window.location.href = response.redirectUrl;
                });
            },
            error: function(xhr) {
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
$('#successModal').on('hidden.bs.modal', function () {
    // 페이지를 새로 고침
    window.location.reload();
});




$(document).ready(function() {
    // 모달의 'data-show-modal' 값을 읽어와 boolean으로 변환
    var showModal = $('#successModal').data('show-modal') === true;
    var failModal = $('#failModal').data('show-modal') === false;
    // 값이 true일 경우 모달 표시
    if (showModal) {
        $('#successModal').modal('show');
    }
    if(failModal){
        $('#failModal').modal('show');
    }
});




function refreshPage() {
    window.location.reload(); // 페이지 새로고침
}

//$(document).ready(function() {
//    var date = new Date();
//    var currentMonth = date.getMonth();
//    var currentYear = date.getFullYear();
//
//    function updateCalendar() {
//        var firstDay = new Date(currentYear, currentMonth, 1).getDay();
//        var daysInMonth = new Date(currentYear, currentMonth + 1, 0).getDate();
//        var months = ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"];
//
//        // 현재 연도와 월을 표시
//        $('#currentYearMonth').text(`${currentYear}년 ${months[currentMonth]}`);
//
//        // 달력 초기화 및 날짜 채우기
//        var calendarHtml = '<table class="table table-bordered"><thead><tr>';
//        calendarHtml += '<th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th>';
//        calendarHtml += '</tr></thead><tbody><tr>';
//
//        for (let i = 0; i < firstDay; i++) {
//            calendarHtml += '<td></td>';
//        }
//
//        for (let day = 1; day <= daysInMonth; day++) {
//            if ((day + firstDay - 1) % 7 === 0) {
//                calendarHtml += '</tr><tr>';
//            }
//            calendarHtml += `<td>${day}</td>`;
//        }
//
//        calendarHtml += '</tr></tbody></table>';
//
//        $('#calendar').html(calendarHtml);
//    }
//
//    updateCalendar();
//
//    $('#prevMonth').click(function() {
//        currentMonth--;
//        if (currentMonth < 0) {
//            currentMonth = 11;
//            currentYear--;
//        }
//        updateCalendar();
//    });
//
//    $('#nextMonth').click(function() {
//        currentMonth++;
//        if (currentMonth > 11) {
//            currentMonth = 0;
//            currentYear++;
//        }
//        updateCalendar();
//    });
//});
$('.reset').click(function() {
    // 폼 내의 모든 input 필드의 값을 초기화
    $('.formEntry input[type="text"]').val('');
    $('.formEntry input[type="date"]').val('');
    $('.formEntry select').each(function() {
        this.selectedIndex = 0;
    });
    $('#currentDate').val(new Date().toISOString().substring(0,10));
});
$(document).ready(function() {
    // 로그인 버튼 클릭 이벤트
    $('#loginButton').click(function() {
        // '아이디 기억하기' 체크박스 상태 확인
        var isRemember = $('#customCheck').is(':checked');
        if (isRemember) {
            // 체크박스가 체크된 상태이면, 입력된 아이디 값을 로컬 저장소에 저장
            var userId = $('#id').val();
            localStorage.setItem('rememberedUserId', userId);
        } else {
            // 체크박스가 해제된 상태이면, 로컬 저장소에서 아이디 값 제거
            localStorage.removeItem('rememberedUserId');
        }
        $("#loginForm").submit();
    });

    // 페이지 로드 시 로컬 저장소에서 아이디 값 가져와서 입력 필드에 채우기
    var rememberedUserId = localStorage.getItem('rememberedUserId');
    if (rememberedUserId) {
        $('#id').val(rememberedUserId);
        $('#customCheck').prop('checked', true); // 체크박스도 체크 상태로 설정
    }

    // 폼 제출 함수
    function submitForm() {

    }
    // 필요에 따라 submitForm 함수를 사용할 수 있습니다.
});
$(document).ready(function() {
    $('#submit').click(function(e){
        e.preventDefault();
        $.ajax({
            type: $('#findPasswordForm').attr('method'), // POST 또는 GET
            url: $('#findPasswordForm').attr('action'),
            data: $('#findPasswordForm').serialize(), // 폼 데이터 직렬화
            success: function(response) {
                alert(response.message);

            },
            error: function(xhr){
                alert(xhr.message);
            }
        });
    });
});
$('.formEntry').on('keydown', function(event) {
    if (event.keyCode === 13) { // 엔터 키 입력 확인
        event.preventDefault(); // 기본 동작 중지
    }
});

