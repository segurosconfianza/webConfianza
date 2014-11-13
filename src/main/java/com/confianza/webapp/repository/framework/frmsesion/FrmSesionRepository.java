package com.confianza.webapp.repository.framework.frmsesion;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;

public interface FrmSesionRepository {
	
	public FrmSesion list(Long id);
	
	public List<FrmSesion> listAll();	
	
	public FrmSesion update(Long id);
	
	public void delete(Long id);
	
	public void insert(FrmSesion frmsesion);
}
