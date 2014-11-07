package com.confianza.webapp.repository.framework.frmaplicaciones;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;

public interface FrmAplicacionesRepository {
	
	public FrmAplicaciones list(Long id);
	
	public List<FrmAplicaciones> listAll();	
	
	public FrmAplicaciones update(Long id);
	
	public void delete(Long id);
	
	public FrmAplicaciones insert(FrmAplicaciones frmaplicaciones);
}
