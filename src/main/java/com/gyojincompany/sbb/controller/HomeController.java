package com.gyojincompany.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	@GetMapping("/") //root에 대한 요청->서버에 접속하자마자 받게 되는 요청
	public String root() {
		return "index";
	}
	
	@GetMapping("/admin") //admin 요청->관리자만 볼수 있는 관리자 페이지로 매핑
	public String amdin() {
		return "admin";
	}
	
	@GetMapping("/userinfo") //로그인한 사용자만 볼수 있는 요청
	public String userinfo() {
		return "userinfo";
	}
	
	@GetMapping("/login") //로그인 페이지로 가는 요청
	public String login() {
		return "login";
	}
	
	
	@GetMapping("/signup") //회원가입 페이지로 가는 요청
	public String signup() {
		return "signup";
	}
}
