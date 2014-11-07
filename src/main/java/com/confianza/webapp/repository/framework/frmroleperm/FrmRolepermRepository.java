package com.confianza.webapp.repository.framework.frmroleperm;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;

public interface FrmRolepermRepository {
	
	public FrmRoleperm list(Long id);
	
	public List<FrmRoleperm> listAll();	
	
	public FrmRoleperm update(Long id);
	
	public void delete(Long id);
	
	public FrmRoleperm insert(FrmRoleperm frmroleperm);
}
