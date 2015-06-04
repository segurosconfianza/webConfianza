<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

	<div class="row">
      <div ng-controller="PolizaController" ng-init="init()"><!-- Division grid maestro -->      	
        
        <!-- Nested list template -->
	    <script type="text/ng-template" id="form_renderer.jsp">
			  			  		
			  <label for="{{column.paralabe}}" class="col-sm-3 control-label"><label ng-if="column.pararequ == 1"><font color="red">*</font></label><label ng-bind-html="column.paralabe | to_trusted"></label></label>
			  <div class="col-sm-3" ng-if="column.paratida == 'S'">			
				<input ng-pattern="/^[a-zA-Z0-9]*$/" style="width:100%;" type="text"   name ="{{column.paracons}}" id="{{column.paracons}}" ng-model="Params[column.paranomb]" ng-required="column.pararequ">
			  </div>
              <div class="col-sm-3" ng-if="column.paratida == 'N'">				
				<input ng-pattern="/^[0-9]*$/" style="width:100%;" type="number"   name ="{{column.paracons}}" id="{{column.paracons}}" ng-model="Params[column.paranomb]" ng-required="column.pararequ">
			  </div>
              <div class="col-sm-3" ng-if="column.paratida == 'C'">
				<select class="form-control" id="{{column.paracons}}" ng-model="Params[column.paranomb]" ng-options="opt.value as opt.label for opt in optionsSucursales" ng-required="column.pararequ"></select>
	  	      </div>			
        </script>
        
        <script type="text/ng-template" id="data_renderer.jsp">
		  	<td><b ng-bind-html="column | to_trusted">:</b></td><td>{{Data[column]}}</td>
        </script>
	    	    
	    <div align="left">
		    <h2><label ng-bind-html="contentTitle | to_trusted"></label></h2><br/>
		    
		    <h4 ng-bind-html="contentDescr | to_trusted"></h4><br/>
		    		    
		    <form name="formData" class="form-horizontal" role="form">
			   <div class="form-group" ng-repeat="column in columns" ng-include="'form_renderer.jsp'"></div>
			   <div class="form-group">			   		
	  	      		<label class="col-sm-3 control-label"></font></label>
			   		<div class="col-sm-3">
						<a data-toggle="modal" href="remote.html" data-target="#myModalNew">Consulte aqu&iacute; d&oacute;nde encontrar los datos solicitados. </a>										
	  	      		</div>	  	      		
			   </div>
			   <div class="form-group">
			   		<label class="col-sm-3 control-label"><font color="red">*</font></label>
			   		<div class="col-sm-3">
						<div id="g-recaptcha" name="g-recaptcha" class="g-recaptcha" data-sitekey=SITEKEY ></div>				
	  	      		</div>
			   </div>			   			   
			   <div class="form-group">
			   		<label class="col-sm-3 control-label"></label>
			   		<div class="col-sm-3">
						(<font color="red">*</font>) Campos obligatorios.				
	  	      		</div>	  	      		
			   </div>
			   <div><label ng-bind-html="avisolegal | to_trusted"></label></div>
			   <div class="modal-footer">
		        <button type="reset" class="btn btn-default">Limpiar Datos</button>
		        <button type="button" class="btn btn-primary" ng-click="loadRecord()" ng-show="Boton">Consultar Datos <span class="glyphicon glyphicon-search"></span></button>
		      </div>
		      <div>La informaci&#243;n para esta consulta fue actualizada por &#250;ltima vez en:<b>{{fechaActualziacion}}</b> Si requiere validar una p&#243;liza con expedici&#243;n posterior, por favor p&#243;ngase en contacto con nosotros.<p/></div>
			</form>				
		</div>							
		
		<div class="panel" align="center" ng-if="BotonLoader">
			<button class="btn btn-lg btn-warning"><span class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span> Cargando...</button>
		</div>
		
		<div class="panel" align="left" ng-if="Result">			
			<table class="table table-condensed" border=0 width="80%">						  
				<tr ng-repeat="column in Camp" ng-include="'data_renderer.jsp'">			   			   		 
			   	</tr>
			</table>			   		
		</div>
		 
		<div class="gridStyle" ng-grid="gridOptions" ng-if="Result"></div>
		
		<div><label ng-bind-html="piepagina | to_trusted"></label></div>
		
		<!-- ventana modal -->
    	<!-- Modal New -->
		<div class="modal fade bs-example-modal-lg" id="myModalNew" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>		        
		      </div>
		      <div class="modal-body">
		        <img alt="Poliza" src="Imagenes/Iconos/Poliza.png" height="50%" width="100%">
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>		        
		      </div>
		    </div>
		  </div>
		</div>
		
      </div>
    </div>	    	       