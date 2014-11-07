package com.confianza.webapp.service.framework.frmaplicaciones;

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

import com.confianza.webapp.repository.framework.frmaplicaciones.FrmAplicaciones;
import com.confianza.webapp.repository.framework.frmaplicaciones.FrmAplicacionesRepository;

public class FrmAplicacionesServiceImpl implements FrmAplicacionesService{
	
	@Autowired
	private FrmAplicacionesRepository frmaplicacionesRepository;
	
	/**
	 * @return the frmaplicacionesRepository
	 */
	public FrmAplicacionesRepository getFrmAplicacionesRepository() {
		return frmaplicacionesRepository;
	}

	/**
	 * @param frmaplicacionesRepository the frmaplicacionesRepository to set
	 */
	public void setFrmAplicacionesRepository(FrmAplicacionesRepository frmaplicacionesRepository) {
		this.frmaplicacionesRepository = frmaplicacionesRepository;
	}
	
	@Override
	public FrmAplicaciones list(Long id){
		return frmaplicacionesRepository.list(id);
	}
	
	@Override
	public List<FrmAplicaciones> listAll(){
		return frmaplicacionesRepository.listAll();
	}	
	
	@Override
	public FrmAplicaciones update(Long id){
		return frmaplicacionesRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmaplicacionesRepository.delete(id);
	}
	
	@Override
	public FrmAplicaciones insert(FrmAplicaciones frmaplicaciones){
		return frmaplicacionesRepository.insert(frmaplicaciones);
	}
	
}
