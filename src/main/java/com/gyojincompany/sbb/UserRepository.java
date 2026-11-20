package com.gyojincompany.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gyojincompany.sbb.entity.SiteUser;
import java.util.List;


public interface UserRepository extends JpaRepository<SiteUser, Long>{
	
	SiteUser findByUsername(String username); //회원아이디로 회원정보 가져오기
	
}
