package com.care.cookie_session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
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
	
	@GetMapping("popup")
	public String popup() {
		return "popup";
	}
	
	@GetMapping("close")
	public String clPopup() {
		return "close";
	}

}
