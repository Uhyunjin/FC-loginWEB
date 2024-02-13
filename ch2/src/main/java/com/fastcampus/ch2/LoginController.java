package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		
		return "loginform";
	}
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, HttpServletResponse response) throws Exception{
		System.out.println("id="+id);
		System.out.println("pwd="+pwd);
		System.out.println("rememberID="+rememberId);
		//1.id pwd 확인
		// 일치하지 않으면 loginForm으로 이동
		if(!loginCheck(id, pwd)) {
			String msg = URLEncoder.encode("id또는 pwd가 일치하지 않습니다.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
		//2. id-pwd 일치하면
		//세션 객체에 아이디 저장
		
		if(rememberId) {
			//쿠키 생성
			Cookie cookie = new Cookie("id", id);
			// 응답에 저장
			response.addCookie(cookie);
		}else {
			//쿠키 생성
			Cookie cookie = new Cookie("id", id);
			//쿠키 삭제
			cookie.setMaxAge(0);
			//응답에 저장
			response.addCookie(cookie);
			
		}

		// 홈으로
		return "redirect:/";
	}
	private boolean loginCheck(String id, String pwd) {
		// TODO Auto-generated method stub
		
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}
