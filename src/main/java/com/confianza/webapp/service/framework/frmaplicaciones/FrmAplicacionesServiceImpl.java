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
import org.springframework.stereotype.Service;

import com.confianza.webapp.repository.framework.frmaplicaciones.FrmAplicaciones;
import com.confianza.webapp.repository.framework.frmaplicaciones.FrmAplicacionesRepository;

@Service
public class FrmAplicacionesServiceImpl implements FrmAplicacionesService{
	
	@Autowired
	private FrmAplicacionesRepository frmAplicacionesRepository;
	
	/**
	 * @return the frmaplicacionesRepository
	 */
	public FrmAplicacionesRepository getFrmAplicacionesRepository() {
		return frmAplicacionesRepository;
	}

	/**
	 * @param frmaplicacionesRepository the frmaplicacionesRepository to set
	 */
	public void setFrmAplicacionesRepository(FrmAplicacionesRepository frmaplicacionesRepository) {
		this.frmAplicacionesRepository = frmaplicacionesRepository;
	}
	
	@Override
	public FrmAplicaciones list(Long id){
		return frmAplicacionesRepository.list(id);
	}
	
	@Override
	public List<FrmAplicaciones> listAll(){
		return frmAplicacionesRepository.listAll();
	}	
	
	@Override
	public FrmAplicaciones update(Long id){
		return frmAplicacionesRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmAplicacionesRepository.delete(id);
	}
	
	@Override
	public FrmAplicaciones insert(FrmAplicaciones frmaplicaciones){
		return frmAplicacionesRepository.insert(frmaplicaciones);
	}
	
}
