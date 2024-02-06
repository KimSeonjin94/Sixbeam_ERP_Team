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
            $('#Tap-home').addClass('show').addClass('active');
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


})(jQuery); // End of use strict
