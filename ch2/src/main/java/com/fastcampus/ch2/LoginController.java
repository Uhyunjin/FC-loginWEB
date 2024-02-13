package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//HttpRequest로부터 세션을 얻어도 되지만 위 방법으로 직접 얻어도 된다
		session.invalidate();
		return "redirect:/";
	}
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, HttpServletRequest request, HttpServletResponse response) throws Exception{
		//1.id pwd 확인
		// 일치하지 않으면 loginForm으로 이동
		if(!loginCheck(id, pwd)) {
			String msg = URLEncoder.encode("id또는 pwd가 일치하지 않습니다.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
		//2. id-pwd 일치하면
		// 세션 객체 얻어오기
		HttpSession session = request.getSession();
		//세션 객체에 아이디 저장
		session.setAttribute("id", id);
		
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
