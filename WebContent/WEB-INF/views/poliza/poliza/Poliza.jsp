<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

	<div class="row">
      <div ng-controller="PolizaController"><!-- Division grid maestro -->      	
        
        <!-- Nested list template -->
	    <script type="text/ng-template" id="form_renderer.jsp">
			  			
			  <label for="{{column.paranomb}}" class="col-sm-3 control-label">{{column.paranomb}}</label>
			  <div class="col-sm-3" ng-if="column.paratida == 'S'">			
				<input ng-pattern="/^[a-zA-Z0-9]*$/" style="width:100%;" type="text"   name ="{{column.paracons}}" id="{{column.paracons}}" ng-model="Params[column.paranomb]" required>
			  </div>
              <div class="col-sm-3" ng-if="column.paratida == 'N'">				
				<input ng-pattern="/^[0-9]*$/" style="width:100%;" type="number"   name ="{{column.paracons}}" id="{{column.paracons}}" ng-model="Params[column.paranomb]" required>
			  </div>
              <div class="col-sm-3" ng-if="column.paratida == 'C'">
				<select class="form-control" id="{{column.paracons}}" ng-model="Params[column.paranomb]" ng-options="opt.value as opt.label for opt in optionsSucursales"></select>
	  	      </div>			
        </script>
        
        <script type="text/ng-template" id="data_renderer.jsp">
		  	<td><b>{{column}}:</b></td><td>{{Data[column]}}</td>
        </script>
	    	    
	    <div align="left">
		    <h2>Datos de la Poliza</h2><br/>		    
		    <form name="formData" class="form-horizontal" role="form">
			   <div class="form-group" ng-repeat="column in columns" ng-include="'form_renderer.jsp'">		   		   
			   </div>
			   <div class="form-group">
			   		<label class="col-sm-3 control-label"></label>
			   		<div class="col-sm-3">
						<div id="g-recaptcha" name="g-recaptcha" class="g-recaptcha" data-sitekey="6Ld7av4SAAAAAINAmuKYWEBsNV_LQxiiEkm3F6_S" ></div>				
	  	      		</div>
			   </div>			   			   
			  
			   <div class="modal-footer">
		        <button type="reset" class="btn btn-default">Limpiar Datos</button>
		        <button type="button" class="btn btn-primary" ng-click="loadRecord()" ng-show="Boton">Consultar Datos <span class="glyphicon glyphicon-search"></span></button>
		      </div>
			</form>				
		</div>			
		
		<div class="panel" align="left" ng-if="Result">
			<table class="table table-condensed" border=0 width="80%">			   
				<tr ng-repeat="column in Camp" ng-include="'data_renderer.jsp'">			   			   		 
			   	</tr>
			</table>			   		
		</div>
		 
		<div class="gridStyle" ng-grid="gridOptions" ng-if="Result"></div>
		
      </div>
    </div>	    	       