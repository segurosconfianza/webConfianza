var FrmMainApp=angular.module('FrmMainApp');

FrmMainApp.controller('PolizaController', ['$scope', 'PolizaService',function($scope, PolizaService) {
	
	$scope.Params = {};
	$scope.ParamsAmparo = {};
	$scope.Result = false;
	$scope.Boton = true;	
	  
	PolizaService.getParams().then(function(dataResponse) {  
    	
    	if(dataResponse.data.error!=undefined)
    		alert(dataResponse.data.tituloError+': '+dataResponse.data.error);
    	else{
    		$scope.columns=dataResponse.data.data;
    	}
    });
	
	PolizaService.getParamsAmparo().then(function(dataResponse) {  
    	
    	if(dataResponse.data.error!=undefined)
    		alert(dataResponse.data.tituloError+': '+dataResponse.data.error);
    	else{
    		$scope.columnsAmparo=dataResponse.data.data;
    	}
    });
	
	$scope.optionsSucursales=[{"value": "101",
        				"label": "Centro Andino"},
        			   {"value": "102",
            			"label": "Cartagena"},
         			   {"value": "103",
            			"label": "Cali"},
         			   {"value": "104",
                		"label": "Buenaventura"},
         			   {"value": "105",
                		"label": "Medellin"},
         			   {"value": "106",
               			"label": "Barranquilla"},
        			   {"value": "107",
               			"label": "Neiva"},
        			   {"value": "108",
               			"label": "Monteria"},
        			   {"value": "109",
               			"label": "Riohacha"},
        			   {"value": "111",
               			"label": "Santa Marta"},
        			   {"value": "112",
               			"label": "Villavicencio"},
        			   {"value": "115",
               			"label": "Pasto"},
         			   {"value": "116",
               			"label": "Manizales"},
        			   {"value": "117",
                  		"label": "Ibague"},
        			   {"value": "118",
                  		"label": "Bucaramanga"},
         			   {"value": "122",
                 		"label": "Mocoa"},
         			   {"value": "123",
                 		"label": "Pereira"},
        			   {"value": "124",
                  		"label": "Avenida Chile"},
         			   {"value": "126",
                  		"label": "Tunja"},
         			   {"value": "127",
                  		"label": "Yopal"},
         			   {"value": "128",
                   		"label": "Armenia"},
         			   {"value": "130",
                  		"label": "Popayan"},
         			   {"value": "131",
                  		"label": "Centro Internacional"},
         			   {"value": "133",
                   		"label": "Cucuta"},
         			   {"value": "135",
                  		"label": "Valledupar"},
        			   {"value": "136",
                  		"label": "Sogamoso"}
					  ];
	
	$scope.loadRecord= function(){				
			
		$scope.Boton=false;
		$scope.Result= false;
		
		var verify=true;
		
		for(i=0; i<$scope.columns.length;i++){
			if(!formData.$valid && $scope.Params[$scope.columns[i].paranomb]==undefined || $scope.Params[$scope.columns[i].paranomb]==''){
				verify=false;
				break;
			}
		}
		
		//sino se cargo el captcha
		if(document.getElementById('g-recaptcha-response')==null){
			alert('Error: No se ha cargado el captcha, intente de nuevo');
			grecaptcha.render("g-recaptcha", {"sitekey": "6Ld7av4SAAAAAINAmuKYWEBsNV_LQxiiEkm3F6_S", "theme": "light"});		
			$scope.Boton = true;
			return;
		}
			
		captcha=document.getElementById('g-recaptcha-response').value;

		if(captcha==null || captcha==undefined || captcha==''){
			alert('Error: Verifica que no eres un robot');
			$scope.Boton = true;
			return;
		}
		else{
			if(verify){									
		
					PolizaService.validateReCaptchaSpring(captcha).then(function(dataResponse) {
						//no eres un robot
						if(dataResponse.data.success==true){						
								PolizaService.loadRecord($scope.Params, document.getElementById('g-recaptcha-response').value).then(function(dataResponse) {
															
									if(dataResponse.data.error!=undefined){
										$scope.Result=false;
						    			alert(dataResponse.data.tituloError+': '+dataResponse.data.error);    			
									}
						        	else{ 
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
						        			}
						                	else{ 
						                		$scope.Result=true;
						                		$scope.DataAmparo=dataResponse.data.data;
						                		$scope.CampAmparo=dataResponse.data.camp;  
						                		                		
						                		columns=[];
						                		for(i=0; i<$scope.CampAmparo.length;i++){
						                			columns.push({ field: $scope.CampAmparo[i], displayName: $scope.CampAmparo[i]});                        
						                		}
						                       $scope.columnDefs=columns;
						                       
						                       $scope.myData=$scope.DataAmparo;
						                	}					        			
						                });						        								        		
						        	}
						        }); 						
						}else
							alert('Error: '+dataResponse.data.error-codes);
			        });
					grecaptcha.reset();				
				}else
					alert("Datos vacios o incorrectos: Favor diligencie todos los campos");   
			
			$scope.Boton = true;
		}
		
    }
	
	$scope.filterOptions = {
            filterText: ""            
    };
	
    $scope.gridOptions = {
            data: 'myData',
            columnDefs:'columnDefs',
            selectedItems: [],                
            showColumnMenu: true,
            enableColumnResize: true,
            showFilter : true,
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
          
 }            
])