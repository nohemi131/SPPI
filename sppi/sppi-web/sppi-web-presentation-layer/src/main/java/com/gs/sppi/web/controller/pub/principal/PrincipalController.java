package com.gs.sppi.web.controller.pub.principal;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PrincipalController {

	
	@RequestMapping( value="/", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView home(HttpServletRequest request,HttpSession session) {	
		session.invalidate();
		session.getId();
		return new ModelAndView("PrincipalController.index");
	}


	

}
