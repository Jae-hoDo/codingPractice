package dw.movieDic.Config;

import dw.movieDic.Exception.MyAccessDeniedHandler;
import dw.movieDic.Exception.MyAuthenticationEntryPoint;
import dw.movieDic.Service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/* 'SecurityConfig'는 애플리케이션의 보안 설정을 구성합니다. @configuration은 이 클래스가 Spring의 설정
클래스임을 나타냅니다. @EnableWebSecurity은 Spring Security 설정을 활성화 합니다. @Autowired는 필요한
빈(Bean)을 자동으로 주입합니다.
'SecurityFilterChain filterChain(HttpSecurity http) throws Exception'은 보안 필터 체인을 구성합니다.

*/

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private UserDetailService userDetailService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(auth -> auth
                        .requestMatchers(
//                                new AntPathRequestMatcher("/"),
//                                new AntPathRequestMatcher("/**"),
                                new AntPathRequestMatcher("/products/**"),
                                new AntPathRequestMatcher("/movieDic/**"),
                                new AntPathRequestMatcher("/movieDic/signup"),
                                new AntPathRequestMatcher("/movieDic/survey"),
                                new AntPathRequestMatcher("/movieDic/user/show"),
                                new AntPathRequestMatcher("/csat/survey"),
                                new AntPathRequestMatcher("/user/login"),
                                new AntPathRequestMatcher("/user/signup"),
                                new AntPathRequestMatcher("/user/show"),
                                new AntPathRequestMatcher("/survey"),
                                new AntPathRequestMatcher("/signup"),
                                new AntPathRequestMatcher("/index"),
                                new AntPathRequestMatcher("/reviews"),
                                new AntPathRequestMatcher("/post/**"),

//                                // ↑ WAS까지 가서 통과해야되는 것들
                                new AntPathRequestMatcher("/login"),
                                new AntPathRequestMatcher("/css/**"),
                                new AntPathRequestMatcher("/js/**")
                                // ↑ TOMCAT까지 가서 통과해야되는 것들
                        ).permitAll()
                        .anyRequest().authenticated())
                .formLogin(form->form.loginPage("/login").defaultSuccessUrl("/articles"))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(new MyAuthenticationEntryPoint())
                        .accessDeniedHandler(new MyAccessDeniedHandler()))
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
        return new ProviderManager(authProvider);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
