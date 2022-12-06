package com.hrm.finalpj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.hrm.finalpj.service.HrmHomeService;

@Configuration //이 클래스를 통해 bean 등록이나 각종 설정을 하겠다는 표시
@EnableWebSecurity // Spring Security 설정할 클래스라고 정의합니다.
public class HrmSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	HrmHomeService homeService;

	@Bean //회원가입시 비번 암호화에 필요한 bean 등록
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean //실제 인증을 한 이후에 인증이 완료되면 Authentication객체를 반환을 위한 bean등록
	public DaoAuthenticationProvider authenticationProvider(HrmHomeService homeService) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(homeService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	


	@Override
	public void configure(WebSecurity web) throws Exception {
		// static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
		web.ignoring().antMatchers("/resource/**");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
		.authorizeRequests() 
			.antMatchers("/admin/**").hasAnyAuthority("ADMIN")// 관리자페이지를 위한 곳
			.antMatchers("/**").permitAll() 
			.anyRequest().authenticated()// 여기까지는 기본적으로 경로를 어떻게 사용할 것인가를 위한 곳이다
		.and()
			.csrf().ignoringAntMatchers("/admin/goods/ckUpload") //기본적으로 springSecurity에선 post로 controller로 정보를 보내줄떼 csrf라는 토큰이 필요하다 이것을 무시하기위한 경로
		.and()
			.formLogin()
			.loginPage("/member/signin")
			.failureUrl("/member/signin?error") /*로그인 실패시 url*/ 
			.defaultSuccessUrl("/", true) /*로그인 성공시 url*/
		.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.deleteCookies("JSESSIONID")
			.invalidateHttpSession(true)
			.logoutSuccessUrl("/home")
		.and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider(homeService));
	}
}