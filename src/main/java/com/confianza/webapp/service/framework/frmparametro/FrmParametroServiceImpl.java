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
import org.springframework.stereotype.Service;

import com.confianza.webapp.repository.framework.frmparametro.FrmParametro;
import com.confianza.webapp.repository.framework.frmparametro.FrmParametroRepository;

@Service
public class FrmParametroServiceImpl implements FrmParametroService{
	
	@Autowired
	private FrmParametroRepository frmParametroRepository;
	
	/**
	 * @return the frmparametroRepository
	 */
	public FrmParametroRepository getFrmParametroRepository() {
		return frmParametroRepository;
	}

	/**
	 * @param frmparametroRepository the frmparametroRepository to set
	 */
	public void setFrmParametroRepository(FrmParametroRepository frmparametroRepository) {
		this.frmParametroRepository = frmparametroRepository;
	}
	
	@Override
	public FrmParametro list(Long id){
		return frmParametroRepository.list(id);
	}
	
	@Override
	public List<FrmParametro> listAll(){
		return frmParametroRepository.listAll();
	}	
	
	@Override
	public FrmParametro update(Long id){
		return frmParametroRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmParametroRepository.delete(id);
	}
	
	@Override
	public FrmParametro insert(FrmParametro frmparametro){
		return frmParametroRepository.insert(frmparametro);
	}
	
}
