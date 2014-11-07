package com.confianza.webapp.service.framework.frmmodurope;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;
import com.confianza.webapp.repository.framework.frmmodurope.FrmModurope;

public interface FrmModuropeService{
	
	public FrmModurope list(Long id);
	
	public List<FrmModurope> listAll();	
	
	public FrmModurope update(Long id);
	
	public void delete(Long id);
	
	public FrmModurope insert(FrmModurope frmmodurope);
	
}
