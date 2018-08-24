package com.gs.sppi.web.controller.pub.principal;




import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/publico/restSecurity")
public class PrincipalRestController  {

	private static Logger log= Logger.getLogger(PrincipalRestController.class);

	

	@RequestMapping(value="/getKey", method = {RequestMethod.POST})
	public @ResponseBody String getUserData(HttpServletRequest request,Model model,HttpSession session, Principal principal) {
		log.info("Generando Key Publica y Privada");
	
		return "servicioRest";
	}
}