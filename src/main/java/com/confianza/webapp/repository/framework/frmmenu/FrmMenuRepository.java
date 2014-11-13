package com.confianza.webapp.repository.framework.frmmenu;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;

public interface FrmMenuRepository {
	
	public FrmMenu list(Long id);
	
	public List<FrmMenu> listAll();	
	
	public FrmMenu update(Long id);
	
	public void delete(Long id);
	
	public FrmMenu insert(FrmMenu frmmenu);

	List<Object[]> loadMenu(List<String> roles, Long id);
}
