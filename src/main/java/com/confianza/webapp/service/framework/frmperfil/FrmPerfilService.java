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
	
	public FrmPerfil list(Long id) throws Exception;	

	public FrmPerfil insert(FrmPerfil frmperfil) throws Exception;

	public List<FrmPerfil> listAll(int pageSize, int page) throws Exception;

	public int getCount() throws Exception;

	public FrmPerfil update(FrmPerfil frmperfil) throws Exception;

	public void delete(FrmPerfil frmperfil) throws Exception;
	
}
