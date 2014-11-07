package com.confianza.webapp.service.framework.frmaplicaciones;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;
import com.confianza.webapp.repository.framework.frmaplicaciones.FrmAplicaciones;

public interface FrmAplicacionesService{
	
	public FrmAplicaciones list(Long id);
	
	public List<FrmAplicaciones> listAll();	
	
	public FrmAplicaciones update(Long id);
	
	public void delete(Long id);
	
	public FrmAplicaciones insert(FrmAplicaciones frmaplicaciones);
	
}
