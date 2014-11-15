<!doctype html>
<%@ page language="java" contentType="text/html; charset=iso-8859-1" %>
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
    <link  href="../../lib/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">	
	        
    <script>
    var FrmPerfilApp = angular.module('FrmPerfil', ['ngGrid']);
    
    FrmPerfilApp.service('FrmPerfilService', function($http) {	    	
    	
    	this.getData = function(pageSize, page) {    		    		
    		return $http({
    	        method: 'GET',
    	        url: '<%out.print(WEB_SERVER);%>Confianza/confianza/FrmPerfil/listAll.json',
    	        params: {page: page, pageSize: pageSize }
    	     });
    	 }
    });
    
    FrmPerfilApp.controller('FrmPerfilController', ['$scope', 'FrmPerfilService', function($scope, FrmPerfilService) {
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
    	
        $scope.gridOptions = {
            data: 'myData',
            enablePaging: true,
            showFooter: true,
            totalServerItems:'totalServerItems',
            pagingOptions: $scope.pagingOptions,
            filterOptions: $scope.filterOptions
        };
    }]);
	    	   
    </script>    
  </head>
  <body ng-controller="FrmPerfilController">
	</p>
	<div class="well well-sm">
		<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModalNew"> Nuevo <span class="glyphicon glyphicon-file"> </span></button>
		<button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#myModalEdit"> Editar <span class="glyphicon glyphicon-edit"> </span></button>
		<button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#myModalDelete"> Borrar <span class="glyphicon glyphicon-trash"> </span></button>
		<div align="right"><span class="badge"><span class="glyphicon glyphicon-info-sign"></span></span></div>
	</div>
	</p>
    <div class="gridStyle" ng-grid="gridOptions"></div>
       
    <!-- Modal New -->
	<div class="modal fade" id="myModalNew" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
	      </div>
	      <div class="modal-body">
	        ...
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
	        <button type="button" class="btn btn-primary">Registrar <span class="glyphicon glyphicon-floppy-disk"></span></button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- Modal Edit -->
	<div class="modal fade" id="myModalEdit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
	      </div>
	      <div class="modal-body">
	        ...
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
	        <button type="button" class="btn btn-success">Guardar Cambios <span class="glyphicon glyphicon-floppy-disk"></span></button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- Modal Delete -->
	<div class="modal fade" id="myModalDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
	      </div>
	      <div class="modal-body">
	        Esta seguro que desea eliminar este registro?
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
	        <button type="button" class="btn btn-danger">Borrar <span class="glyphicon glyphicon-trash"> </span></button>
	      </div>
	    </div>
	  </div>
	</div>
	
  </body>
</html>