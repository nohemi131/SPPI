<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page session="false"%>

<script type="text/javascript">
<!--
	if(typeof $ != 'undefined' && $!= null  ){
		$.Login.init();
	}else{
		window.location.href="<c:url value='/' />";
	}	
//--> 
</script>

<section class="{{page1Style}}" ng-style="{'-webkit-transition-duration': speed + 'ms','-moz-transition-duration': speed + 'ms','-ms-transition-duration': speed + 'ms','-o-transition-duration': speed + 'ms','transition-duration': speed + 'ms'}">
	
     	<md-content id="login"> 
     		 
					<md-card>
					 
					  <form method="post"  name="formlogin"  id="formlogin" ng-submit="login()"   autocomplete="off"  > 
						<md-card-header>
          					<md-card-avatar>
            					<img class="md-user-avatar" src="resources/images/pages/logos/DCWNICONO.png" />
          					</md-card-avatar>
          					<md-card-header-text>
					            <span class="md-title">Sign in</span>
					            <span class="md-subhead">With your DC Designer Account</span>
					        </md-card-header-text>
        				</md-card-header>
        				<md-card-title>
	  						<md-card-title-text>
	  						
        			   			<div id="loginError" class="loginError" ng-class="{'': displayLoginError == true, 'none': displayLoginError == false}" style="display:none;">
						            <spring:message code="login.error" /><br/>
						        </div>
								<md-input-container class="md-block" flex-gt-sm>
									<label><spring:message code='Placeholder.user'/></label>									
									<input mdInput name="username" id="username"  type="text" ng-model="credentials.username"  required=""/>	
									
									<div class="hint" ng-show="showHints">What is your username!</div>		
									 
									<div ng-messages="formlogin.username.$error" ng-show="showHints">
							           <div ng-message="required">UserName is required.</div>
							        </div>
								</md-input-container>
										
														
								<md-input-container class="md-block" flex-gt-sm >
									<label ><spring:message code='Placeholder.password'/></label>										
									<input mdInput name="password" id="password" type="password" ng-model="credentials.password"   required=""  />
									
									<div class="hint" ng-show="showHints">What is your username!</div>
									
									<div ng-messages="formlogin.password.$error" ng-show="showHints">
									 	<div ng-message="required">Password is required.</div>
									 </div>	
								</md-input-container>								
										
									 			
								<sec:csrfInput />	
								
			 			 	</md-card-title-text>			  
  						</md-card-title>
	  					<md-card-actions layout="row" layout-align="end center">
				        	<md-button type="submit"  class="md-raised md-primary" name="submit" ><spring:message code='Button.login'/></md-button>
				        </md-card-actions>
				        </form>
				        </div>				      
					</md-card>				
		</md-input-container>		
	
</section>