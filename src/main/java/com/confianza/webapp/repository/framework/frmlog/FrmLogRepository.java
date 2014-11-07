package com.confianza.webapp.repository.framework.frmlog;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;

public interface FrmLogRepository {
	
	public FrmLog list(Long id);
	
	public List<FrmLog> listAll();	
	
	public FrmLog update(Long id);
	
	public void delete(Long id);
	
	public FrmLog insert(FrmLog frmlog);
}
