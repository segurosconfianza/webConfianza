var FrmMainApp=angular.module('FrmMainApp', ['ui.tree', 'ngGrid', 'ngRoute', 'ui.bootstrap']);  

FrmMainApp.config(['$routeProvider',
   	function($routeProvider) {
   	  $routeProvider.
   	    when('/Poliza', {
   	      templateUrl: function(params) {
   	          return  WEB_SERVER+'FrmConsulta/PolizaConsulta/';
   	      },
   	      controller: 'PolizaController'
   	    }).	    
   	    otherwise({
   	    	templateUrl: function(params) {
     	          return  WEB_SERVER+'index.jsp';
     	      }
   	    }); 
}]);
