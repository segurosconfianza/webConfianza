package com.confianza.webapp.repository.framework.frmtransaccion;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;

public interface FrmTransaccionRepository {
	
	public FrmTransaccion list(Long id);
	
	public List<FrmTransaccion> listAll();	
	
	public FrmTransaccion update(Long id);
	
	public void delete(Long id);
	
	public FrmTransaccion insert(FrmTransaccion frmtransaccion);
}
