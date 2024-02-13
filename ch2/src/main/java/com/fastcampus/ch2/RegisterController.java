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
		// 1.��ȿ���˻�
		if (!isValid(user)) {
			String msg = URLEncoder.encode("id����", "utf-8");
			m.addAttribute("msg", msg);
			System.out.println("redirecting...");
			return "forward:/register/add"; //msg�� �ѱ۾��� ������,,���ϱ�=> encoder�� �ذ�
		}
		// 2.DB�� �ű�ȸ�� ������ ����
		return "registerInfo";
	}

	private boolean isValid(User user) {
		System.out.println("valid checking");
		// TODO Auto-generated method stub
		return false;
	}

}
