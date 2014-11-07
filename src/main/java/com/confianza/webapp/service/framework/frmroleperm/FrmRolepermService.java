package com.confianza.webapp.service.framework.frmroleperm;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;
import com.confianza.webapp.repository.framework.frmroleperm.FrmRoleperm;

public interface FrmRolepermService{
	
	public FrmRoleperm list(Long id);
	
	public List<FrmRoleperm> listAll();	
	
	public FrmRoleperm update(Long id);
	
	public void delete(Long id);
	
	public FrmRoleperm insert(FrmRoleperm frmroleperm);
	
}
