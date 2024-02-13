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
		//1.id pwd Ȯ��
		// ��ġ���� ������ loginForm���� �̵�
		if(!loginCheck(id, pwd)) {
			String msg = URLEncoder.encode("id�Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
		//2. id-pwd ��ġ�ϸ�
		//���� ��ü�� ���̵� ����
		
		if(rememberId) {
			//��Ű ����
			Cookie cookie = new Cookie("id", id);
			// ���信 ����
			response.addCookie(cookie);
		}else {
			//��Ű ����
			Cookie cookie = new Cookie("id", id);
			//��Ű ����
			cookie.setMaxAge(0);
			//���信 ����
			response.addCookie(cookie);
			
		}

		// Ȩ����
		return "redirect:/";
	}
	private boolean loginCheck(String id, String pwd) {
		// TODO Auto-generated method stub
		
		return "asdf".equals(id) && "1234".equals(pwd);
	}
}
