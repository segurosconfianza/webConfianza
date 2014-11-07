package com.confianza.webapp.service.framework.frmmodulo;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;
import com.confianza.webapp.repository.framework.frmmodulo.FrmModulo;

public interface FrmModuloService{
	
	public FrmModulo list(Long id);
	
	public List<FrmModulo> listAll();	
	
	public FrmModulo update(Long id);
	
	public void delete(Long id);
	
	public FrmModulo insert(FrmModulo frmmodulo);
	
}
