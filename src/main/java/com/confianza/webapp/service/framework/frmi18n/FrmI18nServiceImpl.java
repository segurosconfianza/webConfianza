package com.confianza.webapp.service.framework.frmi18n;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.confianza.webapp.repository.framework.frmi18n.FrmI18n;
import com.confianza.webapp.repository.framework.frmi18n.FrmI18nRepository;

public class FrmI18nServiceImpl implements FrmI18nService{
	
	@Autowired
	private FrmI18nRepository frmi18nRepository;
	
	/**
	 * @return the frmi18nRepository
	 */
	public FrmI18nRepository getFrmI18nRepository() {
		return frmi18nRepository;
	}

	/**
	 * @param frmi18nRepository the frmi18nRepository to set
	 */
	public void setFrmI18nRepository(FrmI18nRepository frmi18nRepository) {
		this.frmi18nRepository = frmi18nRepository;
	}
	
	@Override
	public FrmI18n list(Long id){
		return frmi18nRepository.list(id);
	}
	
	@Override
	public List<FrmI18n> listAll(){
		return frmi18nRepository.listAll();
	}	
	
	@Override
	public FrmI18n update(Long id){
		return frmi18nRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmi18nRepository.delete(id);
	}
	
	@Override
	public FrmI18n insert(FrmI18n frmi18n){
		return frmi18nRepository.insert(frmi18n);
	}
	
}
