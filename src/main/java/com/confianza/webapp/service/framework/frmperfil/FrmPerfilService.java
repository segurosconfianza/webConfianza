package com.confianza.webapp.service.framework.frmperfil;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;

import com.confianza.webapp.repository.framework.frmperfil.FrmPerfil;

public interface FrmPerfilService{
	
	public FrmPerfil list(Long id);
	
	public FrmPerfil update(Long id);
	
	public void delete(Long id);
	
	public FrmPerfil insert(FrmPerfil frmperfil);

	public List<FrmPerfil> listAll(int pageSize, int page);

	public int getCount();
	
}
