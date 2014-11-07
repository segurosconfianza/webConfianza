package com.confianza.webapp.service.framework.frmparametro;

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

import com.confianza.webapp.repository.framework.frmparametro.FrmParametro;
import com.confianza.webapp.repository.framework.frmparametro.FrmParametroRepository;

public class FrmParametroServiceImpl implements FrmParametroService{
	
	@Autowired
	private FrmParametroRepository frmparametroRepository;
	
	/**
	 * @return the frmparametroRepository
	 */
	public FrmParametroRepository getFrmParametroRepository() {
		return frmparametroRepository;
	}

	/**
	 * @param frmparametroRepository the frmparametroRepository to set
	 */
	public void setFrmParametroRepository(FrmParametroRepository frmparametroRepository) {
		this.frmparametroRepository = frmparametroRepository;
	}
	
	@Override
	public FrmParametro list(Long id){
		return frmparametroRepository.list(id);
	}
	
	@Override
	public List<FrmParametro> listAll(){
		return frmparametroRepository.listAll();
	}	
	
	@Override
	public FrmParametro update(Long id){
		return frmparametroRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmparametroRepository.delete(id);
	}
	
	@Override
	public FrmParametro insert(FrmParametro frmparametro){
		return frmparametroRepository.insert(frmparametro);
	}
	
}
