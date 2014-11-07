package com.confianza.webapp.service.framework.frmsesion;

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

import com.confianza.webapp.repository.framework.frmsesion.FrmSesion;
import com.confianza.webapp.repository.framework.frmsesion.FrmSesionRepository;

public class FrmSesionServiceImpl implements FrmSesionService{
	
	@Autowired
	private FrmSesionRepository frmsesionRepository;
	
	/**
	 * @return the frmsesionRepository
	 */
	public FrmSesionRepository getFrmSesionRepository() {
		return frmsesionRepository;
	}

	/**
	 * @param frmsesionRepository the frmsesionRepository to set
	 */
	public void setFrmSesionRepository(FrmSesionRepository frmsesionRepository) {
		this.frmsesionRepository = frmsesionRepository;
	}
	
	@Override
	public FrmSesion list(Long id){
		return frmsesionRepository.list(id);
	}
	
	@Override
	public List<FrmSesion> listAll(){
		return frmsesionRepository.listAll();
	}	
	
	@Override
	public FrmSesion update(Long id){
		return frmsesionRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmsesionRepository.delete(id);
	}
	
	@Override
	public FrmSesion insert(FrmSesion frmsesion){
		return frmsesionRepository.insert(frmsesion);
	}
	
}
