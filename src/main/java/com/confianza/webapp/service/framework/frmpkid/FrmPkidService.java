package com.confianza.webapp.service.framework.frmpkid;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;
import com.confianza.webapp.repository.framework.frmpkid.FrmPkid;

public interface FrmPkidService{
	
	public FrmPkid list(Long id);
	
	public List<FrmPkid> listAll();	
	
	public FrmPkid update(Long id);
	
	public void delete(Long id);
	
	public FrmPkid insert(FrmPkid frmpkid);
	
}
