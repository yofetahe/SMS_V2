package com.fidel.sms.utils;

import org.springframework.web.servlet.ModelAndView;

public class CheckCurrentSessionAndAuthentication {
	
	public ModelAndView checkCurrentSessionAuthentication(){
		
		if(SessionManager.sessionExpire()){
			
			return SessionManager.redirectToLogin();
		}
		
//		if(!SessionManager.checkAuthenticatedURL(CurrentURL.getCurrentURL())){
//			
//			return SessionManager.authenticationDenied();
//		}
		
		return null;
	}
	
	public ModelAndView checkCurrentSession(){
		
		if(SessionManager.sessionExpire()){
			
			return SessionManager.redirectToLogin();
		}
		
		return null;
	}
	
	public ModelAndView checkAuthentication(){
		
		if(!SessionManager.checkAuthenticatedURL(CurrentURL.getCurrentURL())){
			
			return SessionManager.authenticationDenied();
		}
		
		return null;
	}

}
