package com.example.rest_demo.Security;


import com.example.rest_demo.Service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.antlr.v4.runtime.atn.SemanticContext.and;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

   // private JwtAuthEntryPoint authEntryPoint;
    private CustomUserDetailService userDetailService;

    @Autowired
    public SecurityConfig(CustomUserDetailService userDetailService) {
        this.userDetailService = userDetailService;
     //   this.authEntryPoint=authEntryPoint;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

                http
                        .authorizeRequests()
                        //.exceptionHandling()
                        //.authenticationEntryPoint(authEntryPoint)
                        //.and()
                        //.sessionManagement()
                        //.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .requestMatchers(HttpMethod.GET).permitAll()
                         .anyRequest().authenticated();
        return http.build();





    }
//@Bean
//    public UserDetailsService users() {
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("password")
//                .roles("ADMIN")
//                .build();
//        UserDetails user=User.builder()
//                .username("user")
//                .password("password")
//                .roles("User")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,user);
//    }

    @Bean
    public AuthenticationManager authenticationManager(
          AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
   }
   @Bean
    PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();

}
}

