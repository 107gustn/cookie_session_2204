package com.care.cookie_session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
	
	@Autowired
	sessionService ss;
	
	@GetMapping("makeSession")
	public String makeSession(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(); //request를 통해 세션을 얻어옴
		model.addAttribute("id", "model"); //동일 키 사용시 범위가 작은값 우선시되어 값 전달 //model = request (연계되는 JSP페이지까지만 값 유지)
		session.setAttribute("id", "aaa");
		session.setAttribute("name", "홍길동");
		return "makeSession";
	}
	
	@GetMapping("resultSession")
	public String resultSession() {
		return "resultSession";
	}
	
	@GetMapping("delSession")
	public String delSession(HttpSession session) { //매개변수를 통해 현재 연결되어 있는 사용자의 세션값이 자동적으로 주입된다
		session.removeAttribute("id"); //특정 세션만 삭제
		//session.invalidate(); //모든 세션 삭제
		return "delSession";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("logChk")
	public String logChk(HttpServletRequest request, String id, String pwd) {
		int m = 1;
		m = ss.logChk(id, pwd);
		
		if(m == 0) {
			HttpSession session = request.getSession();
			session.setAttribute("name", "홍길동");
			return "main";
		}
		return "login";
	}
	
	
	@RequestMapping("main")
	public String main( ) {
		return "main";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("name");
		return "login";
	}

}
