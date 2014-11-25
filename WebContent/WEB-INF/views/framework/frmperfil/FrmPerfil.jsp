<!doctype html>
<%@ page language="java" contentType="text/html; charset=iso-8859-1" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize ifAnyGranted="ADMINISTRATOR_ADMINISTRATOR,FRM_PERFIL_ALL,FRM_PERFIL_READ">
<html ng-app="FrmPerfil">
  <head>
  <%
  	ServletContext context = pageContext.getServletContext();
  	String WEB_SERVER = context.getInitParameter("WEB_SERVER");
  %>
	<script src="../../lib/Angular/angular-ui-ng-grid/3.0/jquery.min.js"></script>
    <script src="../../lib/Angular/angular-ui-ng-grid/3.0/angular.min.js"></script>
    <script src="../../lib/Angular/angular-ui-ng-grid/3.0/ng-grid.debug.js" type="text/javascript" ></script>
    
    <link href="../../lib/Angular/angular-ui-ng-grid/3.0/ng-grid.css" rel="stylesheet" type="text/css" />
    
    <script src="../../lib/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script src="../../lib/bootstrap/3.1.1/js/bootstrap.js"></script>
    <script src="../../lib/bootstrap/3.1.1/js/select2.min.js"></script>
    
    <link  href="../../lib/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">		
    <link  href="../../lib/bootstrap/3.1.1/css/select2.css" rel="stylesheet">
    <link  href="../../lib/bootstrap/3.1.1/css/select2-bootstrap.css" rel="stylesheet">			      
    <script>
    var FrmPerfilApp = angular.module('FrmPerfil', ['ngGrid']);
    
    FrmPerfilApp.service('FrmPerfilService', function($http, $rootScope) {	    	
    	this.id=0;
    	
    	this.getData = function(pageSize, page) {    		    		
    		return $http({
    	        method: 'GET',
    	        url: '<%out.print(WEB_SERVER);%>Confianza/confianza/FrmPerfil/listAll.json',
    	        params: {page: page, pageSize: pageSize }
    	     });
    	 }
    	
    	this.getI18n = function() {    		    		
    		return $http({
    	        method: 'GET',
    	        url: '<%out.print(WEB_SERVER);%>Confianza/confianza/FrmI18n/listModulo.json',
    	        params: {modulo: 'FRM_PERFIL,FRM_PERFMODU,FRM_MODUROPE,FRM_MODULO,FRM_ROLEPERM,FRM_APLICACIONES' }
    	     });
    	 }
    	
    	this.insertRecord = function(peficons, pefinomb, pefidesc, pefifecr, pefiesta) {    	
    		
    		data = {peficons: peficons, pefinomb: pefinomb, pefidesc: pefidesc, pefifecr: pefifecr, pefiesta: pefiesta};
    		
    		return $http({
    	        method: 'POST',
    	        url: '<%out.print(WEB_SERVER);%>Confianza/confianza/FrmPerfil/insert',
    	        data: data
    	     });
    	 }
    	
		this.updateRecord = function(peficons, pefinomb, pefidesc, pefifecr, pefiesta) {    	
    		
			data = {peficons: peficons, pefinomb: pefinomb, pefidesc: pefidesc, pefifecr: pefifecr, pefiesta: pefiesta};
    		
			return $http({
    	        method: 'POST',
    	        url: '<%out.print(WEB_SERVER);%>Confianza/confianza/FrmPerfil/update',
    	        data: dataUpdate
    	     });
    	 }
		
		this.deleteRecord = function(peficons, pefinomb, pefidesc, pefifecr, pefiesta) {    	
    		
    		data = {peficons: peficons, pefinomb: pefinomb, pefidesc: pefidesc, pefifecr: pefifecr, pefiesta: pefiesta};
    		
    		return $http({
    	        method: 'POST',
    	        url: '<%out.print(WEB_SERVER);%>Confianza/confianza/FrmPerfil/deleteR',
    	        data: data
    	     });
    	 }
		
		//Children
		this.prepForLoad = function(id, pefinomb) {
	        this.id = id;
	        this.pefinomb=pefinomb;
	        this.loadChildren();
    	};
    	
    	this.loadChildren= function() {
            $rootScope.$broadcast('handleBroadcast');
        };
        
    	$rootScope.$broadcast('handleBroadcast');
		
		this.getDataChildren = function(pageSize, page, id) {  
			if(id!=0)
			{
	    		return $http({
	    	        method: 'GET',
	    	        url: '<%out.print(WEB_SERVER);%>Confianza/confianza/FrmPerfmodu/listAll.json',
	    	        params: {page: page, pageSize: pageSize, pemopefi: id }
	    	     });
			}
    	 }
    	    	
    	this.insertRecordChildren = function(pemocons, pemopefi, pemomoro) {    	
    		
    		data = {pemocons: pemocons, pemopefi: pemopefi, pemomoro: pemomoro};
    		
    		return $http({
    	        method: 'POST',
    	        url: '<%out.print(WEB_SERVER);%>Confianza/confianza/FrmPerfmodu/insert',
    	        data: data
    	     });
    	 }
    	
		this.updateRecordChildren = function(pemocons, pemopefi, pemomoro) {    	
    		
			data = {pemocons: pemocons, pemopefi: pemopefi, pemomoro: pemomoro};
    		
			return $http({
    	        method: 'POST',
    	        url: '<%out.print(WEB_SERVER);%>Confianza/confianza/FrmPerfmodu/update',
    	        data: data
    	     });
    	 }
		
		this.deleteRecordChildren = function(pemocons, pemopefi, pemomoro) {    	
    		
			data = {pemocons: pemocons, pemopefi: pemopefi, pemomoro: pemomoro};
    		
    		return $http({
    	        method: 'POST',
    	        url: '<%out.print(WEB_SERVER);%>Confianza/confianza/FrmPerfmodu/delete',
    	        data: data
    	     });
    	 }
		
		this.getComboMoro = function() {    
    		return $http({
    	        method: 'GET',
    	        url: '<%out.print(WEB_SERVER);%>Confianza/confianza/FrmPerfmodu/listComboMoro.json'
    	     });
    	 }
    });    	
    
    FrmPerfilApp.controller('FrmPerfilController', ['$scope', 'FrmPerfilService',function($scope, FrmPerfilService) {
    	//botones de los formularios modal
    	$scope.buttonNew=false;
    	$scope.buttonEdit=false;
    	$scope.buttonDelete=false;
    	//botones del toolbal
    	$scope.rAll=false;
    	$scope.rCreate=false;
    	$scope.rUpdate=false;
    	$scope.rDelete=false;
    	$scope.rRead=false;
    	
    	<sec:authorize ifAnyGranted="ADMINISTRATOR_ADMINISTRATOR,FRM_PERFIL_ALL">$scope.rAll = true;</sec:authorize>    	
    	if($scope.rAll!=true){    	
			<sec:authorize ifNotGranted="ADMINISTRATOR_ADMINISTRATOR,FRM_PERFIL_ALL">
				<sec:authorize ifAllGranted="FRM_PERFIL_CREATE">$scope.rCreate = true;</sec:authorize>
				<sec:authorize ifAllGranted="FRM_PERFIL_UPDATE">$scope.rUpdate = true;</sec:authorize>
				<sec:authorize ifAllGranted="FRM_PERFIL_DELETE">$scope.rDelete = true;</sec:authorize>
				<sec:authorize ifAllGranted="FRM_PERFIL_READ">$scope.rRead = true;</sec:authorize>
			</sec:authorize>
    	}
    	else{
    		$scope.rCreate=true;
        	$scope.rUpdate=true;
        	$scope.rDelete=true;
        	$scope.rRead=true;
    	}
		
		console.log($scope.rCreate);
		console.log($scope.rUpdate);
		console.log($scope.rDelete);
		console.log($scope.rRead);
		
        $scope.filterOptions = {
            filterText: "",
            useExternalFilter: true
        };
        
        $scope.totalServerItems = 0;
        
        $scope.pagingOptions = {
            pageSizes: [5, 10, 20, 50],
            pageSize: 50,
            currentPage: 1
        };  
        
        $scope.setPagingData = function(data, page, pageSize){	            
            $scope.myData = data;
            $scope.totalServerItems = data.length;
            if (!$scope.$$phase) {
                $scope.$apply();
            }
        };
        
        $scope.getPagedDataAsync = function (pageSize, page, searchText) {
            setTimeout(function () {
                var data;
                if (searchText) {
                    var ft = searchText.toLowerCase();
                    
                    FrmPerfilService.getData(pageSize, page).then(function(dataResponse) {        	            
        	            data = dataResponse.data.data.filter(function(item) {
                            return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
                        });
                        $scope.setPagingData(data,page,pageSize);
                        $scope.totalServerItems = dataResponse.data.count;
        	        });   
                } else {
                	FrmPerfilService.getData(pageSize, page).then(function(dataResponse) {                    		
                		$scope.setPagingData(dataResponse.data.data,page,pageSize);
                		$scope.totalServerItems = dataResponse.data.count;
        	        });    
                }
            }, 100);
        };
    	
        $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
    	
        $scope.$watch('pagingOptions', function (newVal, oldVal) {
            if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
              $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
            }
        }, true);
        
        $scope.$watch('filterOptions', function (newVal, oldVal) {
            if (newVal !== oldVal) {
              $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
            }
        }, true);
    	        
              
        function getName(i18n,colum){
        	var log = [];
        	angular.forEach(i18n, function(fila, index) {
        		if(fila.etincamp==colum)  
        			this.push(fila);
       		}, log);
        	
        	return log[0].etinetiq;
        				         
        }
        
        FrmPerfilService.getI18n().then(function(dataResponse) {        	                                        	
        	 
        	columns=[ { field: "peficons", displayName: getName(dataResponse.data, "peficons"), visible: false },
                   { field: "pefinomb", displayName: getName(dataResponse.data, "pefinomb") }, 
                   { field: "pefidesc", displayName: getName(dataResponse.data, "pefidesc") }, 
                   { field: "pefifecr", displayName: getName(dataResponse.data, "pefifecr"), visible: false },
                   { field: "pefiesta", displayName: getName(dataResponse.data, "pefiesta"), visible: false }
                 ];
            
            $scope.columnDefs=columns;
            
            $scope.ventanaTitulo=getName(dataResponse.data, "-");
        });
        
        $scope.whatClassIsIt= function(column){
        	var log = [];
        	
        	angular.forEach($scope.columnDefs, function(fila, index) {
        		if(fila.field==column)
        			this.push(fila);
       		}, log);
        	
        	return log[0].displayName;
        }
        
        $scope.gridOptions = {
                data: 'myData',
                enablePaging: true,
                showFooter: true,
                totalServerItems:'totalServerItems',
                pagingOptions: $scope.pagingOptions,
                filterOptions: $scope.filterOptions,
                multiSelect: false,
                columnDefs:'columnDefs',
                selectedItems: [],                
                showColumnMenu: true,
                enableColumnResize: true,
                showFilter : true,
                afterSelectionChange: function (rowItem, event) {                	
                	FrmPerfilService.prepForLoad(rowItem.entity.peficons, rowItem.entity.pefinomb);                    
                }
        };
               
       $scope.createRecordForm= function(){
    	    $scope.buttonNew=true;
			$scope.buttonEdit=false;
			$scope.buttonDelete=false;
			
        	$scope.peficons="";
        	$scope.pefinomb="";
        	$scope.pefidesc="";
        	$scope.pefifecr="";
        	$scope.pefiesta="";
        }                
        
		$scope.loadDatatoForm= function(){			
			
			if($scope.gridOptions.selectedItems.length>0){
				$scope.buttonNew=false;
				$scope.buttonEdit=true;
				$scope.buttonDelete=false;
				
	        	var row=$scope.gridOptions.selectedItems[0];
	        	
	        	$scope.peficons=row.peficons;
	        	$scope.pefinomb=row.pefinomb;
	        	$scope.pefidesc=row.pefidesc;
	        	$scope.pefifecr=row.pefifecr;    
	        	$scope.pefiesta=row.pefiesta;
			}
			else
				alert("Favor seleccione una fila");
        }                       
		
		$scope.deleteRecordForm= function(){
			
			if($scope.gridOptions.selectedItems.length>0){
				$scope.buttonNew=false;
				$scope.buttonEdit=false;
				$scope.buttonDelete=true;
				
	        	var row=$scope.gridOptions.selectedItems[0];
	        	
	        	$scope.peficons=row.peficons;
	        	$scope.pefinomb=row.pefinomb;
	        	$scope.pefidesc=row.pefidesc;
	        	$scope.pefifecr=row.pefifecr;    
	        	$scope.pefiesta=row.pefiesta;
			}
			else
				alert("Favor seleccione una fila");
        }
		
		$scope.insertRecord= function(){
			
			$scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
			
			FrmPerfilService.insertRecord($scope.peficons, $scope.pefinomb, $scope.pefidesc,$scope.pefifecr,$scope.pefiesta).then(function(dataResponse) {        	            
				row=dataResponse.data;
				$scope.peficons=row.peficons;
	        	$scope.pefinomb=row.pefinomb;
	        	$scope.pefidesc=row.pefidesc;
	        	$scope.pefifecr=row.pefifecr;	        	
	        	$scope.pefiesta=row.pefiesta;
	        }); 
        }
		
		$scope.updateRecord= function(){
			
			var selected_date = new Date($scope.pefifecr);			
			
			$scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
			
			FrmPerfilService.updateRecord($scope.peficons, $scope.pefinomb, $scope.pefidesc, selected_date,$scope.pefiesta).then(function(dataResponse) {        	            
				row=dataResponse.data;
				$scope.peficons=row.peficons;
	        	$scope.pefinomb=row.pefinomb;
	        	$scope.pefidesc=row.pefidesc;
	        	$scope.pefifecr=row.pefifecr;	        	
	        	$scope.pefiesta=row.pefiesta;
	        }); 
        }
		
		$scope.deleteRecord= function(){
						
			$scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);
			
			FrmPerfilService.deleteRecord($scope.peficons, $scope.pefinomb, $scope.pefidesc,$scope.pefifecr,$scope.pefiesta).then(function(dataResponse) {        	            
				row=dataResponse.data;
				$scope.peficons=row.peficons;
	        	$scope.pefinomb=row.pefinomb;
	        	$scope.pefidesc=row.pefidesc;
	        	$scope.pefifecr=row.pefifecr;	        	
	        	$scope.pefiesta=row.pefiesta;
	        }); 
        }				
    }            
    ])
	
    FrmPerfilApp.controller('FrmPerfmoduController', ['$scope', 'FrmPerfilService',function($scope, FrmPerfilService) {
    	//botones del formulario modal
    	$scope.buttonNewChildren=false;
    	$scope.buttonEditChildren=false;
    	$scope.buttonDeleteChildren=false;
    	//botones del toolbal
    	$scope.rAll=false;
    	$scope.rCreate=false;
    	$scope.rUpdate=false;
    	$scope.rDelete=false;
    	$scope.rRead=false;
    	
    	<sec:authorize ifAnyGranted="ADMINISTRATOR_ADMINISTRATOR,FRM_PERFMODU_ALL">$scope.rAll = true;</sec:authorize>    	
    	if($scope.rAll!=true){    	
			<sec:authorize ifNotGranted="ADMINISTRATOR_ADMINISTRATOR,FRM_PERFMODU_ALL">
				<sec:authorize ifAllGranted="FRM_PERFMODU_CREATE">$scope.rCreate = true;</sec:authorize>
				<sec:authorize ifAllGranted="FRM_PERFMODU_UPDATE">$scope.rUpdate = true;</sec:authorize>
				<sec:authorize ifAllGranted="FRM_PERFMODU_DELETE">$scope.rDelete = true;</sec:authorize>
				<sec:authorize ifAllGranted="FRM_PERFMODU_READ">$scope.rRead = true;</sec:authorize>
			</sec:authorize>
    	}
    	else{
    		$scope.rCreate=true;
        	$scope.rUpdate=true;
        	$scope.rDelete=true;
        	$scope.rRead=true;
    	}
    	
    	$scope.$on('handleBroadcast', function() {
    		
    		$scope.pefinomb = FrmPerfilService.pefinomb;
    		
	        FrmPerfilService.getDataChildren(50, 1, FrmPerfilService.id).then(function(dataResponse) {   
	        	//carga el combo
		        getComboMoro();
	        	
        		if(dataResponse.data.data!=null){
        			$scope.setPagingDataChildren(dataResponse.data.data,50,1);
        			$scope.totalServerItemsChildren = dataResponse.data.count;
        		}
	        });	        
	    }); 
    	
    	$scope.filterOptionsChildren = {
            filterText: "",
            useExternalFilter: true
        };
        
        $scope.totalServerItemsChildren = 0;
        
        $scope.pagingOptionsChildren = {
            pageSizes: [5, 10, 20, 50],
            pageSize: 50,
            currentPage: 1
        };  
        
        $scope.setPagingDataChildren = function(data, page, pageSize){	            
            $scope.myDataChildren = data;
            $scope.totalServerItemsChildren = data.length;
            if (!$scope.$$phase) {
                $scope.$apply();
            }
        };
        
        $scope.getPagedDataAsyncChildren = function (pageSize, page, searchText) {
        	
        	id=0;
        	
            setTimeout(function () {
                var data;
                if (searchText) {
                    var ft = searchText.toLowerCase();
                    
                    FrmPerfilService.getDataChildren(pageSize, page, id).then(function(dataResponse) {        	            
        	            data = dataResponse.data.data.filter(function(item) {
                            return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
                        });
                        $scope.setPagingDataChildren(data,page,pageSize);
                        $scope.totalServerItemsChildren = dataResponse.data.count;
        	        });   
                } else {
                	FrmPerfilService.getDataChildren(pageSize, page, id).then(function(dataResponse) {                    		
                		if(dataResponse.data.data!=null){
                			$scope.setPagingDataChildren(dataResponse.data.data,page,pageSize);
                			$scope.totalServerItemsChildren = dataResponse.data.count;
                		}
        	        });    
                }
            }, 100);
        };
    	
        $scope.getPagedDataAsyncChildren($scope.pagingOptionsChildren.pageSize, $scope.pagingOptionsChildren.currentPage);
    	
        $scope.$watch('pagingOptionsChildren', function (newVal, oldVal) {
            if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
              $scope.getPagedDataAsyncChildren($scope.pagingOptionsChildren.pageSize, $scope.pagingOptionsChildren.currentPage, $scope.filterOptionsChildren.filterText);
            }
        }, true);
        
        $scope.$watch('filterOptionsChildren', function (newVal, oldVal) {
            if (newVal !== oldVal) {
              $scope.getPagedDataAsyncChildren($scope.pagingOptionsChildren.pageSize, $scope.pagingOptionsChildren.currentPage, $scope.filterOptionsChildren.filterText);
            }
        }, true);
    	        
              
        function getNameChildren(i18n,colum){
        	var log = [];
        	angular.forEach(i18n, function(fila, index) {
        		if(fila.etincamp==colum)  
        			this.push(fila);
       		}, log);
        	
        	return log[0].etinetiq;
        				         
        }
        
        FrmPerfilService.getI18n().then(function(dataResponse) {        	                                        	
        	
        	columns=[ { field: "pemocons", displayName: getNameChildren(dataResponse.data, "pemocons"), visible: false },
                      { field: "pemopefi", displayName: getNameChildren(dataResponse.data, "pemopefi"), visible: false }, 
                      { field: "pemomoro", displayName: getNameChildren(dataResponse.data, "pemomoro"), visible: false }, 
                      { field: "morocons", displayName: getNameChildren(dataResponse.data, "morocons"), visible: false },
                      { field: "moromodu", displayName: getNameChildren(dataResponse.data, "moromodu"), visible: false },
                      { field: "mororope", displayName: getNameChildren(dataResponse.data, "mororope"), visible: false },
                      { field: "moducons", displayName: getNameChildren(dataResponse.data, "moducons"), visible: false },
                      { field: "moduapli", displayName: getNameChildren(dataResponse.data, "moduapli"), visible: false },
                      { field: "modunomb", displayName: getNameChildren(dataResponse.data, "modunomb"), width: 150 },
                      { field: "modunemo", displayName: getNameChildren(dataResponse.data, "modunemo"), visible: false },                      
                      { field: "ropecons", displayName: getNameChildren(dataResponse.data, "ropecons"), visible: false },
                      { field: "ropenomb", displayName: getNameChildren(dataResponse.data, "ropenomb"), width: 50 },
                      { field: "ropedesc", displayName: getNameChildren(dataResponse.data, "ropedesc"), visible: false },
                      { field: "ropetipo", displayName: getNameChildren(dataResponse.data, "ropetipo"), visible: false  },
                      { field: "aplicons", displayName: getNameChildren(dataResponse.data, "aplicons"), visible: false },
                      { field: "aplinomb", displayName: getNameChildren(dataResponse.data, "aplinomb"), width: 100 },
                      { field: "aplidesc", displayName: getNameChildren(dataResponse.data, "aplidesc"), visible: false },
                      { field: "apliesta", displayName: getNameChildren(dataResponse.data, "apliesta"), visible: false },
                      { field: "aplifecr", displayName: getNameChildren(dataResponse.data, "aplifecr"), visible: false },                      
                      { field: "tablvast", displayName: getNameChildren(dataResponse.data, "ropetipo"), width: 70 },
                      { field: "modudurl", displayName: getNameChildren(dataResponse.data, "modudurl") }
                 ];
            
            $scope.columnDefsChildren=columns;
            
            $scope.ventanaTituloChildren="Permisos";
        });
        
        $scope.whatClassIsItChildren= function(column){
        	var log = [];
        	
        	angular.forEach($scope.columnDefsChildren, function(fila, index) {
        		if(fila.field==column)
        			this.push(fila);
       		}, log);
        	
        	return log[0].displayName;
        }
        
        $scope.gridOptionsChildren = {
                data: 'myDataChildren',
                enablePaging: true,
                showFooter: true,
                totalServerItems:'totalServerItemsChildren',
                pagingOptions: $scope.pagingOptionsChildren,
                filterOptions: $scope.filterOptionsChildren,
                multiSelect: false,
                columnDefs:'columnDefsChildren',
                selectedItems: [],
                showColumnMenu: true,
                enableColumnResize: true
        };
        
       $scope.createRecordFormChildren= function(){
    	   
    	   console.log(FrmPerfilService.id);
    	   
    	   if( FrmPerfilService.id!=null && FrmPerfilService.id!=0){
	    	    $scope.buttonNewChildren=true;
				$scope.buttonEditChildren=false;
				$scope.buttonDeleteChildren=false;
				
	        	$scope.pemocons="";
	        	$scope.pemopefi="";
	        	$scope.pemomoro="";
    		}
    	   else
    		   alert("Favor seleccione un Perfil");
        }                
        
		$scope.loadDatatoFormChildren= function(){
			
			if(FrmPerfilService.id!=null && FrmPerfilService.id!=0){
				$scope.buttonNewChildren=false;
				$scope.buttonEditChildren=true;
				$scope.buttonDeleteChildren=false;
				
				if($scope.gridOptionsChildren.selectedItems.length>0){
		        	var row=$scope.gridOptionsChildren.selectedItems[0];
		        	$scope.pemocons=row.pemocons;
		        	$scope.pemopefi=row.pemopefi;
		        	$scope.pemomoro=row.pemomoro;
				}
				else
					alert("Favor seleccione una fila");
			}
			else
	    		alert("Favor seleccione un Perfil");
        }                       
		
		$scope.deleteRecordFormChildren= function(){

			if(FrmPerfilService.id!=null && FrmPerfilService.id!=0){
				$scope.buttonNewChildren=false;
				$scope.buttonEditChildren=false;
				$scope.buttonDeleteChildren=true;
				
				if($scope.gridOptionsChildren.selectedItems.length>0){
		        	var row=$scope.gridOptionsChildren.selectedItems[0];
		        	
		        	$scope.pemocons=row.pemocons;
		        	$scope.pemopefi=row.pemopefi;
		        	$scope.pemomoro=row.pemomoro;
				}
				else
					alert("Favor seleccione una fila");
			}
			else
	    		alert("Favor seleccione un Perfil");
        }
		
		$scope.insertRecordChildren= function(){						
			
			FrmPerfilService.insertRecordChildren($scope.pemocons, FrmPerfilService.id, $scope.pemomoro).then(function(dataResponse) {        	            
				row=dataResponse.data;
				$scope.pemocons=row.pemocons;
	        	$scope.pemopefi=row.pemopefi;
	        	$scope.pemomoro=row.pemomoro;
	        	
	        	FrmPerfilService.loadChildren();
	        }); 
        }
		
		$scope.updateRecordChildren= function(){
			
			console.log("$scope.updateRecordChildren");
			
			FrmPerfilService.updateRecordChildren($scope.pemocons, FrmPerfilService.id, $scope.pemomoro).then(function(dataResponse) {        	            
				row=dataResponse.data;
				$scope.pemocons=row.pemocons;
	        	$scope.pemopefi=row.pemopefi;
	        	$scope.pemomoro=row.pemomoro;
	        	
	        	FrmPerfilService.loadChildren();
	        }); 
        }
		
		$scope.deleteRecordChildren= function(){
			
			FrmPerfilService.deleteRecordChildren($scope.pemocons, FrmPerfilService.id, $scope.pemomoro).then(function(dataResponse) {        	            
				row=dataResponse.data;
				$scope.pemocons=row.pemocons;
	        	$scope.pemopefi=row.pemopefi;
	        	$scope.pemomoro=row.pemomoro;
	        	
	        	FrmPerfilService.loadChildren();				
	        }); 
        }
		
		//funcion del combo
		function getComboMoro() {		
			if($scope.optionsMoro == null){
				FrmPerfilService.getComboMoro().then(function(dataResponse) {  
					$scope.optionsMoro = dataResponse.data;
					
					$scope.pemomoro = $scope.optionsMoro[1];
		        }); 
				
			}
		}
				
    }            
    ])
    
    </script>       
  </head>
  <body>
	<div class="row">
      <div class="col-md-6" ng-controller="FrmPerfilController"><!-- Division grid maestro -->
        <div class="well well-sm">
			<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModalNew" ng-click="createRecordForm()" ng-show="rCreate"> Nuevo <span class="glyphicon glyphicon-file"> </span></button>
			<button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#myModalNew" ng-click="loadDatatoForm()" ng-show="rUpdate"> Editar <span class="glyphicon glyphicon-edit"> </span></button>
			<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#myModalNew" ng-click="deleteRecordForm()" ng-show="rDelete"> Borrar <span class="glyphicon glyphicon-trash"> </span></button>
			<a href="#"><span class="badge"><span class="glyphicon glyphicon-info-sign"> </span></span></a>			
		</div>
		<h3>{{ventanaTitulo}}</h3>
    	<div class="gridStyle" ng-grid="gridOptions"></div>
    	<!-- ventana modal -->
    	<!-- Modal New -->
		<div class="modal fade" id="myModalNew" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">{{ventanaTitulo}}</h4>
		      </div>
		      <div class="modal-body">
		        <form name="formInsert" class="form-horizontal" role="form">
		        	<div class="form-group">
					  <label for="peficons" class="col-sm-2 control-label">{{ whatClassIsIt("peficons") }}</label>
					  <div class="col-sm-10">
					  	<input type="number" name ="peficons" id="peficons" ng-model="peficons" readonly="readonly" value="{{peficons}}">
	  			  	  </div>
					</div>
	   				<div class="form-group">
					  <label for="pefinomb" class="col-sm-2 control-label">{{ whatClassIsIt("pefinomb") }}</label>
					  <div class="col-sm-10">
					  	<input type="text" name ="pefinomb" id="pefinomb" ng-model="pefinomb" min="1" max="99" required value="{{pefinomb}}">
					  </div>
					</div>							                 				
					<div class="form-group">
					  <label for="pefidesc" class="col-sm-2 control-label">{{ whatClassIsIt("pefidesc") }}</label>
					  <div class="col-sm-10">
					  	<textarea class="form-control" rows="3" name ="pefidesc" id="pefidesc" ng-model="pefidesc">{{pefidesc}}</textarea>
					  </div>
					</div>
					<div class="form-group">
					  <label for="pefifecr" class="col-sm-2 control-label">{{ whatClassIsIt("pefifecr") }}</label>
					  <div class="col-sm-10">
					  	<input type="text" name ="pefifecr" id="pefifecr" ng-model="pefifecr" min="1" max="99" readonly="readonly" value="{{pefifecr}}">
					  </div>
					</div>
					<div class="form-group">
					  <label for="pefiesta" class="col-sm-2 control-label">{{ whatClassIsIt("pefiesta") }}</label>
					  <div class="col-sm-10">
					  	<input type="text" name ="pefiesta" id="pefiesta" ng-model="pefiesta" readonly="readonly" value="{{pefiesta}}">
					  </div>
					</div>
	  			</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
		        <button type="button" class="btn btn-primary" ng-click="insertRecord()" ng-show="buttonNew">Registrar <span class="glyphicon glyphicon-floppy-disk"></span></button>
		        <button type="button" class="btn btn-success" ng-click="updateRecord()" ng-show="buttonEdit">Guardar Cambios <span class="glyphicon glyphicon-floppy-disk"></span></button>
		        <button type="button" class="btn btn-danger" ng-click="deleteRecord()" ng-show="buttonDelete">Borrar <span class="glyphicon glyphicon-trash"> </span></button>
		      </div>
		    </div>
		  </div>
		</div>						
      </div>
      <div class="col-md-6" ng-controller="FrmPerfmoduController"><!-- Division grid detalle -->
        <div class="well well-sm">
			<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModalChildren" ng-click="createRecordFormChildren()" ng-show="rCreate"> Nuevo <span class="glyphicon glyphicon-file"> </span></button>
			<button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#myModalChildren" ng-click="loadDatatoFormChildren()" ng-show="rUpdate"> Editar <span class="glyphicon glyphicon-edit"> </span></button>
			<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#myModalChildren" ng-click="deleteRecordFormChildren()" ng-show="rDelete"> Borrar <span class="glyphicon glyphicon-trash"> </span></button>
			<a href="#"><span class="badge"><span class="glyphicon glyphicon-info-sign"> </span></span></a>
		</div>
		<h3>{{ventanaTituloChildren}}</h3>
    	<div class="gridStyle" ng-grid="gridOptionsChildren"></div>
    	<!-- ventana modal -->
    	<!-- Modal New -->
		<div class="modal fade" id="myModalChildren" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">{{ventanaTituloChildren}}</h4>
		      </div>
		      <div class="modal-body">
		        <form name="formInsert" class="form-horizontal" role="form">
		        	<div class="form-group">
					  <label for="peficons" class="col-sm-2 control-label">{{ whatClassIsItChildren("pemopefi") }}</label>
					  <div class="col-sm-10">
					  	{{pefinomb}}
	  			  	  </div>					  
					</div>
		        	<div class="form-group">
					  <label for="peficons" class="col-sm-2 control-label">{{ whatClassIsItChildren("pemocons") }}</label>
					  <div class="col-sm-10">
					  	<input type="number" name ="pemocons" id="pemocons" ng-model="pemocons" readonly="readonly" value="{{pemocons}}">
	  			  	  </div>
					</div>
					<div class="form-group">
					  <label for="pemomoro" class="col-sm-2 control-label">{{ whatClassIsItChildren("pemomoro") }}</label>
					  <div class="col-sm-10">					  	
					  	<select class="form-control" id="pemomoro" ng-model="pemomoro" ng-options="opt.value as opt.label for opt in optionsMoro"></select>
	  			  	  </div>
					</div>					
	  			</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
		        <button type="button" class="btn btn-primary" ng-click="insertRecordChildren()" ng-show="buttonNewChildren">Registrar <span class="glyphicon glyphicon-floppy-disk"></span></button>
		        <button type="button" class="btn btn-success" ng-click="updateRecordChildren()" ng-show="buttonEditChildren">Guardar Cambios <span class="glyphicon glyphicon-floppy-disk"></span></button>
		        <button type="button" class="btn btn-danger" ng-click="deleteRecordChildren()" ng-show="buttonDeleteChildren">Borrar <span class="glyphicon glyphicon-trash"> </span></button>
		      </div>
		    </div>
		  </div>
		</div>    	
      </div>
    </div>		          
  </body>
</html>
</sec:authorize>