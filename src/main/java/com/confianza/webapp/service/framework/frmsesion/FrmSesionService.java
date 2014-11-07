package com.confianza.webapp.service.framework.frmsesion;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;
import com.confianza.webapp.repository.framework.frmsesion.FrmSesion;

public interface FrmSesionService{
	
	public FrmSesion list(Long id);
	
	public List<FrmSesion> listAll();	
	
	public FrmSesion update(Long id);
	
	public void delete(Long id);
	
	public FrmSesion insert(FrmSesion frmsesion);
	
}
