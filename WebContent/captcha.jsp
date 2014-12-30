<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<html lang="es" ng-app="FrmMenuModule">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Seguros Confianza</title>
		
		<%
		  	ServletContext context = pageContext.getServletContext();
		  	String WEB_SERVER = context.getInitParameter("WEB_SERVER");
		%>
	    
    
		<script>
	    var FrmMenuApp=angular.module('FrmMenuModule', ['ui.tree']);
	    
	    FrmMenuApp.service('FrmMenuService', function($http) {	    	
	    	this.getData = function() {
	    		return $http({
	    	        method: 'GET',
	    	        url: '<%out.print(WEB_SERVER);%>Confianza/confianza/FrmMenu/listAll.json'
	    	     });
	    	 }
	    });
	    
	    FrmMenuApp.controller('FrmMenuController', ['$scope', 'FrmMenuService', function ($scope, FrmMenuService) {
	    	$scope.oneAtATime = false;
	    	FrmMenuService.getData().then(function(dataResponse) {
	            console.log(dataResponse);
	            console.log("data: "+dataResponse.data);
	            $scope.menu = dataResponse.data;
	        });
	    	
	    	$scope.selectedItem = {};

	        $scope.options = {
	        };
	        
	        $scope.toggle = function(scope) {
	          scope.toggle();
	        };	        
	      
	        $scope.go = function ( path ) {
	        	console.log(path);
	        	window.open(path, "contenido");
	        };
	        	
	        $scope.whatClassIsIt= function(scope, hijos, durl){
	        	var clase;
	            if((hijos==null || hijos.length<1) && durl!=null)
	            	clase="glyphicon-list-alt";
	            else if(scope.collapsed)
	            	clase="glyphicon-folder-open";
	            else
	            	clase="glyphicon-folder-close";
	            return clase;
	        }
    	}]);
	    	   
    </script>    
    
	</head>
	<!-- Bootstrap core CSS -->
    <link href="lib/CSS/Base.css" rel="stylesheet">
	<body>				
		<aside>
			<form:form action="confianza/validate" method="POST" >
		        <div id="captcha_paragraph">
		            <c:if test="${invalidRecaptcha == true}">
		                <span class="error_form_validation"><spring:message code="invalid.captcha" text="Invalid captcha please try again"/></span>
		            </c:if>
		            <%
		                ReCaptcha c = ReCaptchaFactory.newReCaptcha("6Ld7av4SAAAAAINAmuKYWEBsNV_LQxiiEkm3F6_S", 
		                                    "6Ld7av4SAAAAAPqyLaN63Q2qNBZVu1-ESWUvUjLq", false);
		                out.print(c.createRecaptchaHtml(null, null));
		            %>                
		        </div>                 
    		</form:form>   				
		</aside>
	</body>
</html>
