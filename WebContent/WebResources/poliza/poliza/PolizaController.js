var FrmMainApp=angular.module('FrmMainApp');

FrmMainApp.controller('PolizaController', ['$scope', 'PolizaService',function($scope, PolizaService) {
	
	$scope.Params = {};
	
	PolizaService.getParams().then(function(dataResponse) {  
    	
    	if(dataResponse.data.error!=undefined)
    		alert(dataResponse.data.tituloError+': '+dataResponse.data.error);
    	else{
    		$scope.columns=dataResponse.data.data;
    		$scope.params =dataResponse.data.params;
    	}
    });
		
	$scope.getName = function(param){
				
    	return 'p'+param;
    }
	
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
 }            
])