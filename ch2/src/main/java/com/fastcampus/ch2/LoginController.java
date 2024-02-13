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
		//HttpRequest�κ��� ������ �� ������ �� ������� ���� �� �ȴ�
		session.invalidate();
		return "redirect:/";
	}
	@PostMapping("/login")
	public String login(String id, String pwd, boolean rememberId, HttpServletRequest request, HttpServletResponse response) throws Exception{
		//1.id pwd Ȯ��
		// ��ġ���� ������ loginForm���� �̵�
		if(!loginCheck(id, pwd)) {
			String msg = URLEncoder.encode("id�Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
		//2. id-pwd ��ġ�ϸ�
		// ���� ��ü ������
		HttpSession session = request.getSession();
		//���� ��ü�� ���̵� ����
		session.setAttribute("id", id);
		
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
