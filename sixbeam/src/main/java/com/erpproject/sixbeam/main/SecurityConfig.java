package com.erpproject.sixbeam.main;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Optional;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final EmpInfoRepository empInfoRepository;

    public SecurityConfig(EmpInfoRepository empInfoRepository) {
        this.empInfoRepository = empInfoRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 평문 비밀번호 처리를 위해 NoOpPasswordEncoder 사용
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/sixbeam", "/login", "/register", "/css/**", "/js/**", "/vendor/**","/img/**", "/hr/empinfo/pw","/hr/workSchedule/**").permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/hr/**")).hasAnyAuthority("인사", "회계")//인사
                        .requestMatchers(new AntPathRequestMatcher("/pd/**")).hasAnyAuthority("인사", "생산", "재고", "영업", "구매", "회계")//생산
                        .requestMatchers(new AntPathRequestMatcher("/st/**")).hasAnyAuthority("인사", "생산", "재고", "영업", "구매", "회계")//재고
                        .requestMatchers(new AntPathRequestMatcher("/ss/**")).hasAnyAuthority("인사", "생산", "재고", "영업", "구매", "회계")//영업
                        .requestMatchers(new AntPathRequestMatcher("/pur/**")).hasAnyAuthority("인사", "생산", "재고", "영업", "구매", "회계")//구매
                        .requestMatchers(new AntPathRequestMatcher("/ac/**")).hasAnyAuthority("인사", "영업", "구매", "회계")//회계
                        .anyRequest()
                        .authenticated()
                )
                .formLogin((login) -> login
                        .loginPage("/sixbeam")    // [A] 커스텀 로그인 페이지 지정
                        .loginProcessingUrl("/login-process")    // [B] submit 받을 url
                        .usernameParameter("userid")    // [C] submit할 아이디
                        .passwordParameter("pw")    // [D] submit할 비밀번호
                        .defaultSuccessUrl("/sixbeam/home", true)
                        //이름 넣는거 추가
                        .successHandler((request, response, authentication) -> {
                            String username = authentication.getName();
                            request.getSession().setAttribute("username", username);
                            username = SecurityContextHolder.getContext().getAuthentication().getName();
                            Long empInfoId = Long.parseLong(username);
                            Optional<EmpInfoEntity> emp = empInfoRepository.findByEmpInfoId(empInfoId);
                            if (emp.isPresent()) {
                                EmpInfoEntity empp = emp.get();
                                String name = empp.getEmpInfoNm();
                                request.getSession().setAttribute("name", name);
                            } else {
                                // 적절한 기본값 설정 또는 예외 처리
                                request.getSession().setAttribute("name", "Unknown");
                            }
                            response.sendRedirect("/sixbeam/home");
                        })
                        //
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/Hr/logout"))
                        .logoutSuccessUrl("/sixbeam")
                        .invalidateHttpSession(true)
                        .permitAll()
                )
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/sixbeam"))
                );
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*")); // 모든 출처 허용
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // 허용할 HTTP 메소드 지정
        configuration.setAllowedHeaders(Arrays.asList("*")); // 모든 헤더 허용
        configuration.setAllowCredentials(true); // 쿠키를 포함한 요청 허용
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // 모든 경로에 대해 이 정책 적용
        return source;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
