package com.gyojincompany.sbb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SiteUser {
	
	@Id //기본키 PK 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AI 옵션 설정
	private Long id; //기본키 AI 옵션 적용
	
	private String username;
	
	private String password;
	
	private String email;
	
	@Enumerated(EnumType.STRING) //0->admin, 1->user
	//권한 설정(admin, user)
	private UserRole role;
	//role->enum 타입이므로 ADMIN 또는 USER 만 가질 수 있음
	
}
