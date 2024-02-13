package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	//@RequestMapping(value="/register/save", method={RequestMethod.GET, RequestMethod.POST})
//	@PostMapping("/register/save")
	public String save(User user, Model m) throws Exception {
		// 1.유효성검사
		if (!isValid(user)) {
			String msg = URLEncoder.encode("id에러", "utf-8");
			m.addAttribute("msg", msg);
			System.out.println("redirecting...");
			return "forward:/register/add"; //msg에 한글쓰면 오류남,,왜일까=> encoder로 해결
		}
		// 2.DB에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		System.out.println("valid checking");
		// TODO Auto-generated method stub
		return false;
	}

}
