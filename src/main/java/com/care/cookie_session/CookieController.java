package com.care.cookie_session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {
	
	@GetMapping("cookie")
	public String myCookie(HttpServletResponse res, HttpServletRequest req, @CookieValue(value="myCookie" , required = false) Cookie cookie, Model model) { //response 객체를 통해 쿠키 전달 //@CookieValue(value="myCookie"): 지정 쿠키값이 반드시 받아와야 한다. //required = false: 해당 객체가 없으면 해당 값을 null값으로 진행
		
		System.out.println("cookie : " + cookie);
		model.addAttribute("popcookie", cookie);
		
		Cookie[] cooks = req.getCookies(); //쿠키값을 받아옴
		for(Cookie c : cooks) {
			System.out.println( c.getName() );
		}
		
		Cookie cook = new Cookie("myCookie", "test"); //쿠키생성
		cook.setMaxAge( 5 ); //쿠키 지속 시간 설정 - 5초
		cook.setPath("/"); //쿠키값 범위 설정 - 최상위 경로로 설정(쿠키값을 하위경로에서 사용할 수 있음)
		res.addCookie( cook ); //사용자에게 쿠키를 보내줌
		
		return "cookie";
	}
	
	@GetMapping("cookie_quiz")
	public String cookieQuiz(HttpServletResponse response, Model model, @CookieValue(value="myCookie", required = false) Cookie cook) { //Model에 쿠키값 담아서 사용자에게 전달 //@CookieValue: 사용자가 넘겨줄 쿠키값 확인용
		if( cook == null ) { //쿠키가 없으면
			
		}else { //쿠키값이 있으면
			model.addAttribute("cook", cook.getValue() ); //쿠키값 모델에 저장
		}
		return "cookie_quiz";
	}
	
	@GetMapping("popup")
	public String popup() {
		return "popup";
	}
	
	@GetMapping("chk")
	public void chk(HttpServletResponse rep) {
		Cookie cook = new Cookie("myCookie", "testCookie"); //쿠키값 생성
		cook.setMaxAge(5); //쿠키값 5초간 지속
		rep.addCookie(cook); //사용자에게 쿠키값 보내줌
	}
	
}
