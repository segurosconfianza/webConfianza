<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

	<div class="row">
      <div class="col-md-6" ng-controller="PolizaController"><!-- Division grid maestro -->      	
        
        <!-- Nested list template -->
	    <script type="text/ng-template" id="form_renderer.jsp">
			  			
			  <label for="{{column.paranomb}}" class="col-sm-3 control-label">{{column.paranomb}}</label>
			  <div class="col-sm-9" ng-if="column.paratida == 'S'">			
				<input type="text"   name ="{{column.paracons}}" id="{{column.paracons}}" ng-model="Params[column.paracons]">
			  </div>
              <div class="col-sm-9" ng-if="column.paratida == 'N'">				
				<input type="number"   name ="{{column.paracons}}" id="{{column.paracons}}" ng-model="Params[column.paracons]">
			  </div>
              <div class="col-sm-9" ng-if="column.paratida == 'C'">
				<select class="form-control" id="{{column.paracons}}" ng-model="Params[column.paracons]" ng-options="opt.value as opt.label for opt in optionsSucursales"></select>
	  	      </div>			
        </script>
	    
	    <div align="center">
		    <h2>Datos de la Poliza</h2><br/>		    
		    <form name="formInsert" class="form-horizontal" role="form">
			   <div class="form-group" ng-repeat="column in columns" ng-include="'form_renderer.jsp'">		   		   
			   </div>
			   <div class="modal-footer">
		        <button type="reset" class="btn btn-default">Limpiar Datos</button>
		        <button type="button" class="btn btn-primary" ng-click="loadRecord()">Consultar Datos <span class="glyphicon glyphicon-search"></span></button>
		      </div>
			</form>				
		</div>	
								
      </div>
    </div>	    	       