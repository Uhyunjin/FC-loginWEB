package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
	// 여러개의 예외를 하나의 클래스에 담을 땐 맵 형태로 받는다
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
//	@ExceptionHandler(Exception.class)
//	public String catcher(Exception ex, Model m) {
//		m.addAttribute("ex", ex);
//		return "error";
//	}	
	
	@RequestMapping("/ex")
	public String main() throws Exception{
			throw new Exception("예외가 발생했습니다.");
			//항상 예외가 발생
	}
	@RequestMapping("/ex2")
	public String main2() throws Exception{
			throw new FileNotFoundException("예외가 발생했습니다.");
			//FileNotFoundException 발생
	}

}
