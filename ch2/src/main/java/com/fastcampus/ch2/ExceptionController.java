package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	//메서드가 여러개일 때 try-catch 코드가 중복되므로 별도로 예외처리 메서드를 추가해준다+exceptionhandler어노테이션
	
	
	@RequestMapping("/ex")
	public String main() throws Exception{
			throw new Exception("예외가 발생했습니다.");
			//항상 예외가 발생
	}
	@RequestMapping("/ex2")
	public String main2() throws Exception{
			throw new NullPointerException("예외가 발생했습니다.");
			//NullPointerException 발생
	}

}
