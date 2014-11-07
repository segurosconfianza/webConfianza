package com.confianza.webapp.repository.framework.frmestaproc;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;

public interface FrmEstaprocRepository {
	
	public FrmEstaproc list(Long id);
	
	public List<FrmEstaproc> listAll();	
	
	public FrmEstaproc update(Long id);
	
	public void delete(Long id);
	
	public FrmEstaproc insert(FrmEstaproc frmestaproc);
}
