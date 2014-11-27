<!doctype html>
<%@ page language="java" contentType="text/html; charset=iso-8859-1" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html ng-app="FrmMenuModule">
  <head>
  <%
  	ServletContext context = pageContext.getServletContext();
  	String WEB_SERVER = context.getInitParameter("WEB_SERVER");
  %>
    <script src="../../lib/Angular/1.3.2/angular.min.js"></script>
    <script src="../../lib/Angular/1.3.2/angular-ui-tree.js"></script>
    <script src="../../lib/bootstrap/Angular/ui-bootstrap-tpls-0.11.2.min.js"></script>    
    <link  href="../../lib/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link  href="../../lib/CSS/Base.css" rel="stylesheet">
    <link  href="../../lib/CSS/angular-ui-tree.min.css" rel="stylesheet">
    
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
  <body>
  <p/>
	<div ng-controller="FrmMenuController">  
	  
	  <div class="col-lg-6">
           <!-- Nested list template -->
           <script type="text/ng-template" id="items_renderer.html">
                <div ui-tree-handle>
                  <a class="btn btn-danger btn-xs" data-nodrag ng-click="toggle(this)"><span class="glyphicon" ng-class="whatClassIsIt(this,item.menuhijo,item.modudurl)"></span></a>
                  <a ng-click="go(item.modudurl)" data-nodrag >{{item.menutitu}}</a>
                </div>
                <ol ui-tree-nodes="options" ng-model="item.menuhijo" ng-class="{hidden: !collapsed}" data-nodrag>
                  <li ng-repeat="item in item.menuhijo" ng-include="'items_renderer.html'" id="llista_imatges" data-nodrag>
                  </li>
                </ol>
           </script>
           <div ui-tree="options">
             <ol ui-tree-nodes ng-model="menu" id="llista_imatges" data-nodrag>
               <li ng-repeat="item in menu" ui-tree-node ng-include="'items_renderer.html'" data-nodrag></li>
             </ol>
           </div>
         </div>           
	</div>
  </body>
</html>