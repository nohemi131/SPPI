package com.gs.sppi.web.controller.security;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.security.auth.login.LoginContext;

import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.jaas.JaasAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	private Logger log=Logger.getLogger(CustomAuthenticationProvider.class);

    public static String username;


	@SuppressWarnings("unused")
	public Authentication authenticate(Authentication authentication) {
		LoginContext loginContext = null;
		Authentication custom = null;
		UserDetails user=null;


        Assert.isInstanceOf(UsernamePasswordAuthenticationToken.class, authentication, "Solo UsernamePasswordAuthenticationToken es soportado.");
        username=(authentication.getPrincipal()==null) ? "NONE-PROVIDED": authentication.getName();
        String password = ((UsernamePasswordAuthenticationToken) authentication).getCredentials().toString();
        
 
        boolean isAccess=false;
        try {
        	
        	try {
        		
        		if(username.equals("dcadmin")){
        			if(password.equals("dcadmin")){
        				isAccess=true;
        			}
        		}


            } catch (Exception e) {
            	log.error("Message Error " +e.fillInStackTrace());
            }

            log.info("Acceso: "+isAccess);
            if(!isAccess) {   
            	log.info("El usuario no tiene accesso");
                throw new  AuthenticationServiceException("Bad credentials");
            } else {
            	log.info("El login del usuario es correcto, revisar si existe session anterior");
            	
            	HashMap<String, String> cre = new HashMap<String, String>();
            	cre.put("u", username);
            	cre.put("p", authentication.getCredentials().toString());

            	
        		log.info("Login unico, correcto para login");
        		log.info("Seteando los roles  el usuario");
            	Vector<GrantedAuthority> authorities = new Vector<GrantedAuthority>();
            	List<String> roles = new ArrayList<String>();
            	roles.add("ROLE_USER");

            	for (String rolName : roles) {
            		authorities.addElement( new SimpleGrantedAuthority(rolName));
            	}

            	List<ConfigAttribute> attrs =
            			SecurityConfig.createList("ROLE_USER");

            	user = new User( username, authentication.getCredentials().toString(), true, true, true, true, authorities );

                List<GrantedAuthority> listaA=new ArrayList<GrantedAuthority>();
                listaA.addAll(user.getAuthorities());

                custom = new JaasAuthenticationToken(authentication.getPrincipal(),authentication.getCredentials(),listaA,loginContext);
                log.info("El usuario tiene accesso");
            }
        }
        catch(UsernameNotFoundException notFound)
        {
        	 log.error("Message Error " +notFound.fillInStackTrace());
        	 log.error("Autentificacion.authenticate()");
            throw new AuthenticationServiceException( "Bad credentials" );
        }

        return custom;
    }

    public boolean supports(Class<?> authentication) {
    	return true;
    }

}
