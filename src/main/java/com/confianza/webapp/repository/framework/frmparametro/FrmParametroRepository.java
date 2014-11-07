package com.confianza.webapp.repository.framework.frmparametro;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;

public interface FrmParametroRepository {
	
	public FrmParametro list(Long id);
	
	public List<FrmParametro> listAll();	
	
	public FrmParametro update(Long id);
	
	public void delete(Long id);
	
	public FrmParametro insert(FrmParametro frmparametro);
}
