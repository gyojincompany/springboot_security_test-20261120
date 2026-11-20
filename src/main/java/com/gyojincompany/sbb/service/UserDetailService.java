package com.gyojincompany.sbb.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailService {
	
	//사용자가 로그인할때 아이디를 전달받아 회원정보를 조회하는 역할
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
