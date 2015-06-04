var FrmMainApp=angular.module('FrmMainApp');

FrmMainApp.service('PolizaService', function($http, $rootScope) {	    	
    	
		$http.defaults.useXDomain = true;
		
		this.id=0;
    	    	
    	this.getParams = function() {    		    		
    		return $http({
    	        method: 'GET',
    	        url:  WEB_SERVER+'FrmParametro/params.json',
    	        params: {paracons: 1}
    	     });
    	 }
    	
    	this.getParamsAmparo = function() {    		    		
    		return $http({
    	        method: 'GET',
    	        url:  WEB_SERVER+'FrmParametro/params.json',
    	        params: {paracons: 2}
    	     });
    	 }
    	
    	this.loadRecord = function(params) {    	
    		   		
    		return $http({
    	        method: 'GET',
    	        url: WEB_SERVER+'FrmConsulta/loadRecord.json',
    	        params: {conscons: 1, params: params}
    	     });
    	 }    			
		
    	this.loadRecordAmparo = function(params) {    	
	   		
    		return $http({
    	        method: 'GET',
    	        url: WEB_SERVER+'FrmConsulta/loadRecord.json',
    	        params: {conscons: 2, params: params}
    	     });
    	 } 
    	    	
    	this.validateReCaptchaSpring = function(g_recaptcha) {    	
    		
    		return $http({
    	        method: 'POST',
    	        url: WEB_SERVER+'validateReCaptcha',
    	        params: {g_recaptcha: g_recaptcha}
    	     });
    	 }
    	
    	this.getContent = function(conscons) {    		    		
    		return $http({
    	        method: 'GET',
    	        url:  WEB_SERVER+'FrmConsulta/loadData.json',
    	        params: {conscons: conscons}
    	     });
    	 } 
    	
    	this.loadRecordFecha = function() {    	
	   		
    		return $http({
    	        method: 'GET',
    	        url: WEB_SERVER+'FrmConsulta/loadRecordFecha.json',
    	        params: {conscons: 27}
    	     });
    	 } 
    	    	
    });    	