package com.confianza.webapp.service.framework.frmmodulo;

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

import com.confianza.webapp.repository.framework.frmmodulo.FrmModulo;
import com.confianza.webapp.repository.framework.frmmodulo.FrmModuloRepository;

public class FrmModuloServiceImpl implements FrmModuloService{
	
	@Autowired
	private FrmModuloRepository frmmoduloRepository;
	
	/**
	 * @return the frmmoduloRepository
	 */
	public FrmModuloRepository getFrmModuloRepository() {
		return frmmoduloRepository;
	}

	/**
	 * @param frmmoduloRepository the frmmoduloRepository to set
	 */
	public void setFrmModuloRepository(FrmModuloRepository frmmoduloRepository) {
		this.frmmoduloRepository = frmmoduloRepository;
	}
	
	@Override
	public FrmModulo list(Long id){
		return frmmoduloRepository.list(id);
	}
	
	@Override
	public List<FrmModulo> listAll(){
		return frmmoduloRepository.listAll();
	}	
	
	@Override
	public FrmModulo update(Long id){
		return frmmoduloRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmmoduloRepository.delete(id);
	}
	
	@Override
	public FrmModulo insert(FrmModulo frmmodulo){
		return frmmoduloRepository.insert(frmmodulo);
	}
	
}
