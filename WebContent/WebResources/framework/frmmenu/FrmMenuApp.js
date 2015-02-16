var FrmMainApp=angular.module('FrmMainApp', ['ui.tree', 'ngGrid', 'ngRoute', 'ui.bootstrap']);  

FrmMainApp.config(['$routeProvider',
   	function($routeProvider) {
   	  $routeProvider.
   	    when('/Poliza', {
   	      templateUrl: WEB_SERVER+'FrmConsulta/PolizaConsulta/Poliza.html',
   	      controller: 'PolizaController'
   	    }); 
}]);

FrmMainApp.filter('to_trusted', ['$sce', function($sce){
    return function(text) {
        return $sce.trustAsHtml(text);
    };
}]);