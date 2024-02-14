package com.fastcampus.ch2;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		if(!loginCheck(request)) {
//			return "redirect:/login/login";
			return "redirect:/login/login?toURL="+request.getRequestURL();
			//로그인 안했으면 로그인창으로 이동, get방식으로 로그인 화면에 정보주기
		}
		
		return "boardList";
	}

	private boolean loginCheck(HttpServletRequest request) {
		// 1.세션을얻는다
		HttpSession session = request.getSession();
		// 2.세션에 아이디가 있는지 확인
//		if(session.getAttribute("id")!=null)
//			return true;
//		else
//			return false;
		return session.getAttribute("id")!=null;
	}
}