package com.hrm.finalpj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import com.hrm.finalpj.service.MemberService;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
    private MemberService memberService;
    
	
    @Autowired
    public SecurityConfig(MemberService memberService){
        this.memberService = memberService;
    }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeRequests()
	        .mvcMatchers("/css/**", "/js/**", "/img/**","/new/**").permitAll()
	        .mvcMatchers("/", "/members/**", "/item/**", "/images/**").permitAll()
	        .mvcMatchers("/admin/**").hasRole("ADMIN")
	        .anyRequest().authenticated()
		;
        http.formLogin()
	        .loginPage("/members/login")
	        .defaultSuccessUrl("/")
	        .usernameParameter("Id")
	        .passwordParameter("password")
	        .failureUrl("/members/login/error")
	        .and()
	        .logout()
	        .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
	        .logoutSuccessUrl("/")
		;


		http.exceptionHandling()
		    .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
		;

//		http.csrf().disable();
        return http.build();
	}
	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}

