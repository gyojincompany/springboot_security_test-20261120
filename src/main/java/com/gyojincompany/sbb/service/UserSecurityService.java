package com.gyojincompany.sbb.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gyojincompany.sbb.UserRepository;
import com.gyojincompany.sbb.entity.SiteUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailService{
	
	private final UserRepository userRepository;
	
	//userid->username
	//id 회원번호->기본키
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		SiteUser user = userRepository.findByUsername(username);
		//로그인하려고 사용자가 입력한 아이디(username)로 회원정보 db에서 찾아오기
		
		//조회하려는 회원이 존재하지 않으면 예외 발생
		if(user == null) {
			throw new UsernameNotFoundException("해당 회원 정보를 찾을 수 없습니다.");
		}
		
		return User.builder()
				.username(user.getUsername())
				.password(user.getPassword()) 
				.authorities(user.getRole().getValue())
				.build();
	}
	
	
}
