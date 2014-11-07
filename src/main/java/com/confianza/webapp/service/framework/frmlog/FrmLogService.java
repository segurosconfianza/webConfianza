package com.confianza.webapp.service.framework.frmlog;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;
import com.confianza.webapp.repository.framework.frmlog.FrmLog;

public interface FrmLogService{
	
	public FrmLog list(Long id);
	
	public List<FrmLog> listAll();	
	
	public FrmLog update(Long id);
	
	public void delete(Long id);
	
	public FrmLog insert(FrmLog frmlog);
	
}
