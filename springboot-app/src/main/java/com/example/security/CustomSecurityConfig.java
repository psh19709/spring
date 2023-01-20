package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * spring security 설정정보를 제공하는 클래스다. <br />
 *
 */
@EnableWebSecurity
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

	// 인증에 필요한 사용자정보와 권한정보를 포함하는 UserDetails 객체를 반환하는 CustomUserDetailService객체를 의존성 주입받는다.
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	// 회원가입시 비밀번호 암호화에 사용했던 비밀번호인코더 객체를 의존성 주입받는다.
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeHttpRequests()
			.antMatchers("/", "/register", "/registered", "/login").permitAll()	// 제시된 요청은 접근을 허용한다.
			.antMatchers("/post/**").hasAnyRole("GUEST", "USER")				// 제시된 요청은 ROLE_GUEST 혹은 ROLE_USER 권한이 필요한다.
			.antMatchers("/user/**").hasRole("USER")							// 제시된 요청은 ROLE_USER 권한이 필요하다.
			.antMatchers("/admin/**").hasRole("ADMIN")							// 제시된 요청은 ROLE_ADMIN 권한이 필요하다.
			.anyRequest().authenticated()										// 위에서 제시된 요청 외의 모든 요청도 반드시 인증이 필요하다.
		.and()
			.formLogin()						// 인증방식은 폼인증 방식을 사용하도록 지정한다. FormLoginConfigurer객체를 반환한다.
			.loginPage("/login")				// 로그인 폼을 요청하는 URI을 지정한다.
			.loginProcessingUrl("/login")		// 로그인 처리를 요청하는 URI를 지정한다.
			.usernameParameter("id")			// 로그인 폼의 사용자이름 입력필드 이름을 지정한다.
			.passwordParameter("password")		// 로그인 폼의 비밀번호 입력필드 이름을 지정한다.
			.defaultSuccessUrl("/")				// 로그인 성공시 리다이렉션할 URI를 지정한다.
			.failureUrl("/login?error=fail")	// 로그인 실패시 재요청할 URI를 지정한다.
		.and()
			.logout()							// 로그아웃, LogoutConfigurer객체를 반환한다.
			.logoutUrl("/logout")				// 로그아웃 처리를 요청하는 URI를 지정한다.
			.logoutSuccessUrl("/")				// 로그아웃 성공시 리다이렉션할 URI를 지정한다.
		.and()
			.exceptionHandling()				// 예외처리, ExceptionHandlingConfigurer객체를 반환한다.
			.accessDeniedPage("/access-denied");// 접근이 거부되었을 때 요청할 URI를 지정한다.
	}
	
	// 이미지, 스타일시트, 자바스크립트소스와 같은 정적 컨텐츠는 인증/인가 작업을 수행하지 않도록 설정한다.
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/favicon.ico");
	}
	
	@Override
	// 사용자 정의 UserDetailService 객체와 이 애플리케이션에서 사용하는 비밀번호 인코더를 AuthenticationManager에 등록한다.
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
	}
	
}
