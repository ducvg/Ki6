package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        return http.csrf(c -> c.disable())
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/home").authenticated()
                        .requestMatchers("/admin","/edit/**","/delete/**").hasRole("admin")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                    .loginPage("/").permitAll()
                    .loginProcessingUrl("/login").permitAll()
                    .failureUrl("/?error=true").permitAll()
                    .defaultSuccessUrl("/home",true).permitAll()
                )
                .logout(out -> out
                        .logoutUrl("/logout").permitAll()
                        .logoutSuccessUrl("/").permitAll()
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                ).build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserInfoDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
//      ma hoa mat khau
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService());
        return authenticationProvider;
    }
}