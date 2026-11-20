package com.gyojincompany.sbb.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gyojincompany.sbb.UserRepository;
import com.gyojincompany.sbb.entity.SiteUser;
import com.gyojincompany.sbb.entity.UserRole;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSevice {
	
	private final UserRepository userRepository;
	//DI -> @Autowired 보다 추천하는 주입 방법
	
	private final PasswordEncoder passwordEncoder; // 비밀번호 암호화 객체 주입
	
	//회원가입 메소드
	public SiteUser create(String username, String password, String email) {
		
		SiteUser siteUser = new SiteUser();
		siteUser.setUsername(username);
		siteUser.setEmail(email);
		siteUser.setPassword(passwordEncoder.encode(password)); 
		//비밀번호가 평문 그대로 db에 저장
		//->비밀번호를 db에 넣기 전에 암호화 한 후에 암호문으로 db에 저장 
		
		//롤(권한)설정->기본회원권한은 일반회원으로 설정
		siteUser.setRole(UserRole.USER); //일반회원
		//siteUser.setRole(UserRole.ADMIN); //관리자회원
		userRepository.save(siteUser); //DB에 회원정보 저장
		
		return siteUser;
	}
	
	
}
