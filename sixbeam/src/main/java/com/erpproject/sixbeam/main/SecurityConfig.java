package com.erpproject.sixbeam.main;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .anyRequest()
                        .authenticated())
                .formLogin(login -> login
//                        .loginPage("/contents/home/Login_Form")	// [A] 커스텀 로그인 페이지 지정
                                .loginProcessingUrl("/login-process")	// [B] submit 받을 url
                                .usernameParameter("userid")	// [C] submit할 아이디
                                .passwordParameter("pw")	// [D] submit할 비밀번호
                                .defaultSuccessUrl("/sixbeam/home", true)
                                .permitAll()
                )
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/Hr/logout"))
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                );
        //

        return http.build();
    }
}