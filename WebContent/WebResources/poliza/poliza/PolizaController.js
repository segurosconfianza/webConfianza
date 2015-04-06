var FrmMainApp=angular.module('FrmMainApp');

FrmMainApp.controller('PolizaController', ['$scope', 'PolizaService',function($scope, PolizaService) {
	
	$scope.Params = {};
	$scope.ParamsAmparo = {};
	$scope.Result = false;
	$scope.Boton = true;	
	$scope.BotonLoader = false;
	$scope.captcha = false;
	
	PolizaService.getContent(1).then(function(dataResponse) {  
		if(dataResponse.data.error!=undefined)
    		alert(dataResponse.data.tituloError+': '+dataResponse.data.error);
    	else{
    		$scope.contentTitle=dataResponse.data.titulo;
    		$scope.contentDescr=dataResponse.data.descri;
    		$scope.piepagina=dataResponse.data.piepagina;
    		$scope.avisolegal=dataResponse.data.avisolegal;
    		
			PolizaService.getParams().then(function(dataResponse) {  
		    	
		    	if(dataResponse.data.error!=undefined)
		    		alert(dataResponse.data.tituloError+': '+dataResponse.data.error);
		    	else{
		    		$scope.columns=dataResponse.data.data;
		    	}
		    	cargarRecaptcha();
		    });
			
			PolizaService.getParamsAmparo().then(function(dataResponse) {  
		    	
		    	if(dataResponse.data.error!=undefined)
		    		alert(dataResponse.data.tituloError+': '+dataResponse.data.error);
		    	else{
		    		$scope.columnsAmparo=dataResponse.data.data;
		    	}
		    	cargarRecaptcha();
		    });
			
			PolizaService.loadRecordFecha().then(function(dataResponse) {
				$scope.fechaActualziacion=dataResponse.data.data[0].FECEXP;
				cargarRecaptcha();
			});
    	}
		
		cargarRecaptcha();
    });
	
	$scope.optionsSucursales=[
	                   {"value": "128", "label": "ARMENIA"},
	                   {"value": "124", "label": "AVENIDA CHILE"},
	                   {"value": "106", "label": "BARRANQUILLA"},
	                   {"value": "118", "label": "BUCARAMANGA"},
	                   {"value": "104", "label": "BUENAVENTURA"},
	                   {"value": "103", "label": "CALI"},
	                   {"value": "102", "label": "CARTAGENA"},
	                   {"value": "101", "label": "CENTRO ANDINO"},
	                   {"value": "131", "label": "CENTRO INTERNACIONAL"},
	                   {"value": "133", "label": "CUCUTA"},
	                   {"value": "117", "label": "IBAGUE"},
	                   {"value": "116", "label": "MANIZALES"},
         			   {"value": "105", "label": "MEDELLIN"},
         			   {"value": "122", "label": "MOCOA"},
         			   {"value": "108", "label": "MONTERIA"},         			  
        			   {"value": "107", "label": "NEIVA"},
        			   {"value": "115", "label": "PASTO"},
        			   {"value": "123", "label": "PEREIRA"},
        			   {"value": "130", "label": "POPAYAN"},
        			   {"value": "109", "label": "RIOACHA"},
        			   {"value": "111", "label": "SANTA MARTA"},
        			   {"value": "136", "label": "SOGAMOSO"},
        			   {"value": "126", "label": "TUNJA"},
        			   {"value": "135", "label": "VALLEDUPAR"},
        			   {"value": "112", "label": "VILLAVICENCIO"},
         			   {"value": "127", "label": "YOPAL"}
					  ];
	
	$scope.loadRecord= function(){				
			
		$scope.BotonLoader=true;
		$scope.Boton=false;
		$scope.Result= false;		
		
		var verify=true;
		
		for(i=0; i<$scope.columns.length;i++){
			
			if(($scope.Params['TOMADOR']==undefined || $scope.Params['TOMADOR']=='' || $scope.Params['TOMADOR']==" ") &&
			   ($scope.Params['ASEGURADO']==undefined || $scope.Params['ASEGURADO']=='' || $scope.Params['ASEGURADO']==" ")){
				
				$scope.BotonLoader=false;
				$scope.Boton = true;
				verify=false;
				alert("Debe digitar el campo Nit del Tomador o Nit del Asegurado");				
				
				return;
			}
			
			if(!formData.$valid && $scope.columns[i].pararequ==1 && ($scope.Params[$scope.columns[i].paranomb]==undefined || $scope.Params[$scope.columns[i].paranomb]=='')){				
				verify=false;
				break;
			} 	
		}
		
		
		//sino se cargo el captcha
		if(document.getElementById('g-recaptcha-response')==null){
			alert('Error: No se ha cargado el captcha, intente de nuevo');
			grecaptcha.render("g-recaptcha", {"sitekey": SITEKEY, "theme": "light"});		
			$scope.Boton = true;
			$scope.BotonLoader=false;
			return;
		}
			
		captcha=document.getElementById('g-recaptcha-response').value;

		if(captcha==null || captcha==undefined || captcha==''){
			alert('Error: Verifica que no eres un robot');
			$scope.Boton = true;
			$scope.BotonLoader=false;
			return;
		}
		else{
			if(verify){									
		
					PolizaService.validateReCaptchaSpring(captcha).then(function(dataResponse) {
						//no eres un robot
						if(dataResponse.data.success==true){
								
								for(i=0; i<$scope.columns.length;i++){
									if($scope.Params[$scope.columns[i].paranomb]==undefined || $scope.Params[$scope.columns[i].paranomb]=='')
										$scope.Params[$scope.columns[i].paranomb]=" ";	
								}
								
								PolizaService.loadRecord($scope.Params, document.getElementById('g-recaptcha-response').value).then(function(dataResponse) {
															
									if(dataResponse.data.error!=undefined){
										$scope.Result=false;										
						    			alert(dataResponse.data.tituloError+': '+dataResponse.data.error); 
						    			$scope.BotonLoader=false;
						    			$scope.Boton = true;
									}
						        	else{
						        		if(dataResponse.data.data[0]){
							        		$scope.Result=true;						        		
							        		$scope.Data=dataResponse.data.data[0];
							        		$scope.Camp=dataResponse.data.camp;
							        		
							        		for(i=0; i<$scope.columnsAmparo.length;i++){        			
							        			$scope.ParamsAmparo[$scope.columnsAmparo[i].paranomb]=$scope.Params[$scope.columnsAmparo[i].paranomb];
							        		}        		
							        		
							        		PolizaService.loadRecordAmparo($scope.ParamsAmparo).then(function(dataResponse) {
												
							        			if(dataResponse.data.error!=undefined){
							        				$scope.ResultAmparo=false;
							            			alert(dataResponse.data.tituloError+': '+dataResponse.data.error);
							            			$scope.BotonLoader=false;
							            			$scope.Boton = true;
							        			}
							                	else{ 
							                		$scope.Result=true;
							                		$scope.DataAmparo=dataResponse.data.data;
							                		$scope.CampAmparo=dataResponse.data.camp;  
							                		$scope.Cafi=dataResponse.data.cafi;
							                		
							                		columns=[];
							                		for(i=0; i<$scope.CampAmparo.length;i++){
							                			columns.push({ field: $scope.CampAmparo[i], displayName: $scope.Cafi[i]});                        
							                		}
							                       $scope.columnDefs=columns;
							                       
							                       $scope.myData=$scope.DataAmparo;
							                       
							                       $scope.BotonLoader=false;
							                       $scope.Boton = true;
							                	}					        			
							                });	
						        		}
						        		else{
						        			alert('La p\u00f3liza no fue encontrada en nuestros registros. \nVerifique la p\u00f3liza llamando 7457777 en Bogot\u00e1, 6040465 en Medell\u00edn, 6972111 en Bucaramanga, 4894111 en Cali y 3851555 en Barranquilla');
						        			$scope.BotonLoader=false;
						        			$scope.Boton = true;
						        		}
						        	}
						        }); 						
						}else
							alert('Error: '+dataResponse.data.error-codes);
			        });
					grecaptcha.reset();				
				}else{
					alert("Datos vacios o incorrectos: Favor diligencie todos los campos");
					$scope.BotonLoader=false;
					$scope.Boton = true;
				}			
		}
		
    }
	
	$scope.filterOptions = {
            filterText: ""            
    };
	
    $scope.gridOptions = {
            data: 'myData',
            columnDefs:'columnDefs',
            selectedItems: [],                
            showColumnMenu: false,
            enableColumnResize: true,
            showFilter : false,
            filterOptions: $scope.filterOptions,
    };
    
    $scope.filterNephi = function() {
        var filterText = 'name:Nephi';
        if ($scope.filterOptions.filterText === '') {
          $scope.filterOptions.filterText = filterText;
        }
        else if ($scope.filterOptions.filterText === filterText) {
          $scope.filterOptions.filterText = '';
        }
      };
      
      function cargarRecaptcha(){
    	  if($scope.captcha==false){  			
  			grecaptcha.render("g-recaptcha", {"sitekey": SITEKEY, "theme": "light"});		  			
  			$scope.captcha = true;
  		}
      }
          
 }            
])