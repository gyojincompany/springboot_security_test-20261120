package com.gyojincompany.sbb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
//enum은 정해진 값만 사용할 수 있도록 만드는 자료형
public enum UserRole { 
	
	ADMIN("ROLE_ADMIN"),
	USER("ROLE_USER");
	
	private final String value;

}
