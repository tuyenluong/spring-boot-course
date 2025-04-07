package com.jeremy.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    private static final String[] PUBLIC_PATH = new String[]{"/", "/home","/contact","/holidays/*",
            "/saveMsg","/courses","/assets/**","/login","/logout","/public/**","/favicon.ico",
            "/index.php/apps/files/preview-service-worker.js"};

    private static final String[] AUTHENTICATED_PATH = new String[]{"/dashboard", "/displayProfile", "/updateProfile"};
    private static final String[] ADMIN_PATH = new String[]{"/displayMessages", "/closeMsg/**", "/admin/**"};

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.ignoringRequestMatchers("/saveMsg")
                        .ignoringRequestMatchers(PathRequest.toH2Console())
                        .ignoringRequestMatchers("/public/**"))
                .authorizeHttpRequests((requests) -> requests.requestMatchers(AUTHENTICATED_PATH).authenticated()
                        .requestMatchers(ADMIN_PATH).hasAuthority("ROLE_ADMIN")
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .requestMatchers(PUBLIC_PATH).permitAll())

                .formLogin(loginConfigurer -> loginConfigurer.loginPage("/login")
                        .defaultSuccessUrl("/dashboard")
                        .failureUrl("/login?error=true"))

                .logout(logoutConfigurer -> logoutConfigurer.logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true))

                .httpBasic(Customizer.withDefaults());

        http.headers(headersConfigurer -> headersConfigurer
                .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}