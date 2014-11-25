<!doctype html>
<%@ page language="java" contentType="text/html; charset=iso-8859-1" %>
<html ng-app="plunker">
  <head>
  <%
  	ServletContext context = pageContext.getServletContext();
  	String WEB_SERVER = context.getInitParameter("WEB_SERVER");
  %>
            
	<script src="lib/Angular/1.3.2/AngularJS1216.jss"></script>            
   
    
    <script src="lib/bootstrap/3.1.1/js/jquery.min.js"></script>    
    <script src="lib/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script src="lib/bootstrap/3.1.1/js/ui-bootstrap-tpls-0.7.0.js"></script>
    <link  href="lib/bootstrap/3.1.1/css/uno.css" rel="stylesheet">	
	        
    <script>
    angular.module('plunker', ['ui.bootstrap']);
    var ModalDemoCtrl = function ($scope, $modal, $log) {

      $scope.open = function () {
      
        var modalInstance = $modal.open({
          templateUrl: 'myModalContent.html',
          controller: ModalInstanceCtrl
        });

        modalInstance.result.then(function (selected) {
          $scope.selected = selected;
        }, function () {
          $log.info('Modal dismissed at: ' + new Date());
        });
      };
    };

    var ModalInstanceCtrl = function ($scope, $modalInstance, $timeout) {

       $scope.dt = new Date();


      $scope.open = function() {
       
        $timeout(function() {
          $scope.opened = true;
        });
      };

      
      $scope.ok = function () {
        $modalInstance.close($scope.dt);
      };

      $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
      };
    };
	    	   
    </script>    
  </head>
  <body>
	   
    <div ng-controller="ModalDemoCtrl">
    <script type="text/ng-template" id="myModalContent.html">
        
        <div class="modal-header">
            <h3>I'm a modal!</h3>
        </div>
        <div class="modal-body" style="height:600px;">
          <pre>Selected date is: <em>{{dt | date:'fullDate' }}</em></pre>
          <div class="form-horizontal">
            <div class="input-group">
              <input type="text" class="form-control" datepicker-popup="dd.mm.yyyy" ng-model="dt" is-open="$parent.opened" ng-required="true" close-text="Close" />
              
              <span class="input-group-btn">
              <button style="height:34px;" class="btn btn-default" ng-click="open()">
              <i class="icon-calendar"></i></button> <b><- button not working</b>
              </span>
            </div>
          </div>
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" ng-click="ok()">OK</button>
            <button class="btn btn-warning" ng-click="cancel()">Cancel</button>
        </div>
    </script>

    <button class="btn" ng-click="open()">Open me!</button>
    <div ng-show="selected">Selection from a modal: {{ selected }}</div>
</div>
				
  </body>
</html>