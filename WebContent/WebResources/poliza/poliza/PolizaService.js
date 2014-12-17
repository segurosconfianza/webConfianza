var FrmMainApp=angular.module('FrmMainApp');

FrmMainApp.service('PolizaService', function($http, $rootScope) {	    	
    	this.id=0;
    	    	
    	this.getParams = function() {    		    		
    		return $http({
    	        method: 'GET',
    	        url:  WEB_SERVER+'FrmParametro/params.json',
    	        params: {paracons: 1}
    	     });
    	 }
    	    	
    	this.loadRecord = function(peficons, pefinomb, pefidesc, pefifecr, pefiesta) {    	
    		
    		data = {peficons: peficons, pefinomb: pefinomb, pefidesc: pefidesc, pefifecr: pefifecr, pefiesta: pefiesta};
    		
    		return $http({
    	        method: 'POST',
    	        url: WEB_SERVER+'FrmPerfil/insert',
    	        data: data
    	     });
    	 }    			
		
		this.getComboMoro = function() {    
    		return $http({
    	        method: 'GET',
    	        url: WEB_SERVER+'FrmPerfmodu/listComboMoro.json'
    	     });
    	 }
    });    	