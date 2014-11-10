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
import org.springframework.stereotype.Service;

import com.confianza.webapp.repository.framework.frmmodulo.FrmModulo;
import com.confianza.webapp.repository.framework.frmmodulo.FrmModuloRepository;

@Service
public class FrmModuloServiceImpl implements FrmModuloService{
	
	@Autowired
	private FrmModuloRepository frmModuloRepository;
	
	/**
	 * @return the frmmoduloRepository
	 */
	public FrmModuloRepository getFrmModuloRepository() {
		return frmModuloRepository;
	}

	/**
	 * @param frmmoduloRepository the frmmoduloRepository to set
	 */
	public void setFrmModuloRepository(FrmModuloRepository frmmoduloRepository) {
		this.frmModuloRepository = frmmoduloRepository;
	}
	
	@Override
	public FrmModulo list(Long id){
		return frmModuloRepository.list(id);
	}
	
	@Override
	public List<FrmModulo> listAll(){
		return frmModuloRepository.listAll();
	}	
	
	@Override
	public FrmModulo update(Long id){
		return frmModuloRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmModuloRepository.delete(id);
	}
	
	@Override
	public FrmModulo insert(FrmModulo frmmodulo){
		return frmModuloRepository.insert(frmmodulo);
	}
	
}
