package com.studentrecord.project.config;


import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import com.studentrecord.project.exception.AuthenticationPassWrong;
import com.studentrecord.project.exception.AuthenticationUserWrong;
import com.studentrecord.project.exception.CustomAuthenticationFailureHandler;
import com.studentrecord.project.service.JpaUserDetailsService;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JpaUserDetailsService myUserDetailsService;

    public SecurityConfig(JpaUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    } 
    
    @Bean
    public AuthenticationEntryPoint customAuthenticationEntryPoint() {
        return new AuthenticationPassWrong();
    }
    
    @Bean
    public AccessDeniedHandler customAccessDeniedHandler() {
        return new AuthenticationUserWrong();
    }
    

//    @Bean
//    public AccessDeniedHandler accessDeniedHandler() {
//       return new CustomAccessDeniedHandler();
//    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
        		.csrf().disable()
                .authorizeRequests(auth -> auth
                        .antMatchers("/School-reg/**").permitAll()
                        .anyRequest().permitAll())
                .userDetailsService(myUserDetailsService)
                .headers(headers -> headers.frameOptions().sameOrigin()) //.headers(headers -> headers.frameOptions().sameOrigin()) configuration is a security measure to control 													//how your pages can be embedded in iframes and helps protect against certain types of attacks.
                .httpBasic() //withDefault set default api we can define login api here
                		.authenticationEntryPoint(customAuthenticationEntryPoint()) //is responsible for handling authentication failures
                .and()
                .formLogin()
                		.failureHandler(authenticationFailureHandler())
                .and()
                .exceptionHandling()
                		.accessDeniedHandler(customAccessDeniedHandler()) //is used for handling access denied situations.
        		.and()
                .build();

    }
    
}



//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class SecurityConfig {
//
//	private final JpaUserDetailsService myUserDetailsService;
//	@Autowired
//	public SecurityConfig(JpaUserDetailsService myUserDetailsService) {
//	        this.myUserDetailsService = myUserDetailsService;
//	    }
//	
//
//	    @Bean
//	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	        return http
//	        		.csrf(csrf -> csrf.ignoringAntMatchers("/h2-console/**"))
//	                .authorizeRequests(auth -> auth
//	                        .antMatchers("/School-reg/**").permitAll()
//	                        .mvcMatchers("School-reg/**").permitAll()
////	                        .mvcMatchers("School-reg/get/**").permitAll()
//	                        .anyRequest().authenticated()
//	                )
//	                .userDetailsService(myUserDetailsService)
//	                .headers(headers -> headers.frameOptions().sameOrigin())
//	                .httpBasic(withDefaults())
//	                .build();
//	    }
////
//	    @Bean
//	    PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
//}
