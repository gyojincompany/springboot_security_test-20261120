package com.gyojincompany.sbb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //설정파일
public class SecurityConfig {
	
	//비밀번호 암호화 bean(객체)
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(auth -> auth //권한 부여
					//.anyRequest().permitAll() 
					//모든 페이지에 대한 요청을 허가->누구나 모든 페이지에 접근 가능
					
					//로그인 페이지나 회원가입 페이지 처럼 누구나 봐야할 페이지만 접근 가능하게 설정
					.requestMatchers( //허가해야 할 요청 목록 작성
						"/", //루트 요청 허용(대문 페이지 허용)
						"/login", //로그인 요청 허용
						"/signup", //회원가입 요청 허용
						"/css/**", //css 파일이 허용되도록 등록
						"/img/**", //이미지 파일이 허용되도록 등록
						"/js/**" //자바스크립트 파일이 허용되도록 등록
					).permitAll()
					
					//관리자만 접근 가능하게 설정
					.requestMatchers( 
						"/admin" //관리자 페이지 요청							
					).hasRole("ADMIN")
					
					//위 요청들을 제외한 요청들은 모두 로그인해야만 접근 가능 설정
					.anyRequest().authenticated()					
					
			)
			//로그인 설정->로그인 하지 않으면 볼 수 없는 요청이 들어왔을때->loginPage("/login")로 강제이동
			.formLogin(login -> login
				.loginPage("/login") //로그인 페이지(컨트롤러에 등록된 로그인 요청) 등록
			    .loginProcessingUrl("/login") //로그인 처리 url 등록
				.defaultSuccessUrl("/", true) //로그인 성공했을때 이동할 페이지(요청) 등록 -> 성공시 root로 이동				
				.permitAll()
			)
			//로그아웃 설정
			.logout(logout -> logout
				.logoutUrl("/logout") //로그아웃 요청 주소 등록	
				.logoutSuccessUrl("/") //로그아웃 성공 시 이동할 요청 주소 등록 -> 성공 시 root로 이동
				.invalidateHttpSession(true) //세션 초기화->세션에 올라와 있는 로그인 정보 삭제
				.deleteCookies("JSESSIONID") //쿠키 삭제(선택)
			);
			
		return http.build();	
	}
}
