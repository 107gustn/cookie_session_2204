package com.care.cookie_session;

import org.springframework.stereotype.Service;

@Service
public class sessionService {
	String dbId = "1111";
	String dbPwd = "1111";
	
	public int logChk(String id, String pwd) {
		if(dbId.equals(id)) {
			System.out.println("아이디 존재");
			if(dbPwd.equals(pwd)) {
				System.out.println("비번 일치");
				
				return 0;
			}else {
				System.out.println("비번틀림");
				
				return 1;
			}
		}else {
			System.out.println("아이디 없음");
			
			return -1;
		}
		
	}

}
