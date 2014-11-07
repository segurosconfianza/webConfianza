package com.confianza.webapp.repository.framework.frmconsulta;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;

public interface FrmConsultaRepository {
	
	public FrmConsulta list(Long id);
	
	public List<FrmConsulta> listAll();	
	
	public FrmConsulta update(Long id);
	
	public void delete(Long id);
	
	public FrmConsulta insert(FrmConsulta frmconsulta);
}
