package com.confianza.webapp.service.framework.frmestaproc;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;
import com.confianza.webapp.repository.framework.frmestaproc.FrmEstaproc;

public interface FrmEstaprocService{
	
	public FrmEstaproc list(Long id);
	
	public List<FrmEstaproc> listAll();	
	
	public FrmEstaproc update(Long id);
	
	public void delete(Long id);
	
	public FrmEstaproc insert(FrmEstaproc frmestaproc);
	
}
