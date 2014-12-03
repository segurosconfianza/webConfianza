var FrmMainApp=angular.module('FrmMainApp', ['ui.tree', 'ngGrid', 'ngRoute', 'ui.bootstrap']);  

FrmMainApp.config(['$routeProvider',
   	function($routeProvider) {
   	  $routeProvider.
   	    when('/FrmPerfil', {
   	      templateUrl: function(params) {
   	          return  WEB_SERVER+'FrmPerfil/';
   	      },
   	      controller: 'FrmPerfilController'
   	    }).	    
   	    otherwise({
   	      
   	    });
}]);