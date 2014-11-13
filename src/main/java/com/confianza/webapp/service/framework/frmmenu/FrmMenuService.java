package com.confianza.webapp.service.framework.frmmenu;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;

import com.confianza.webapp.repository.framework.frmmenu.FrmMenu;

public interface FrmMenuService{
	
	public FrmMenu list(Long id);
	
	public List<FrmMenu> listAll();	
	
	public FrmMenu update(Long id);
	
	public void delete(Long id);
	
	public FrmMenu insert(FrmMenu frmmenu);

	public FrmMenu loadMenuf();

	public List<Object[]> loadMenu(Long id);
	
}
