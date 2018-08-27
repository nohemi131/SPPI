<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html >
			
	<body class="fondo">	
		<tiles:insertAttribute name="header" />			
	   	<section id="ControllerMaster" ui-view="ControllerMaster" layout="row"  autoscroll="false" class="anim-in-out {{mainViewStyle}} md-inline-form" data-anim-sync="{{sync}}" data-anim-speed="{{speed}}" ng-style="{'-webkit-transition-duration': speed + 'ms','-moz-transition-duration': speed + 'ms','-ms-transition-duration': speed + 'ms','-o-transition-duration': speed + 'ms','transition-duration': speed + 'ms'}" ></section>	   	
	    <tiles:insertAttribute name="footer" /> 
	</body>
</html>