package com.confianza.webapp.service.framework.frmmodurope;

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

import com.confianza.webapp.repository.framework.frmmodurope.FrmModurope;
import com.confianza.webapp.repository.framework.frmmodurope.FrmModuropeRepository;

public class FrmModuropeServiceImpl implements FrmModuropeService{
	
	@Autowired
	private FrmModuropeRepository frmmoduropeRepository;
	
	/**
	 * @return the frmmoduropeRepository
	 */
	public FrmModuropeRepository getFrmModuropeRepository() {
		return frmmoduropeRepository;
	}

	/**
	 * @param frmmoduropeRepository the frmmoduropeRepository to set
	 */
	public void setFrmModuropeRepository(FrmModuropeRepository frmmoduropeRepository) {
		this.frmmoduropeRepository = frmmoduropeRepository;
	}
	
	@Override
	public FrmModurope list(Long id){
		return frmmoduropeRepository.list(id);
	}
	
	@Override
	public List<FrmModurope> listAll(){
		return frmmoduropeRepository.listAll();
	}	
	
	@Override
	public FrmModurope update(Long id){
		return frmmoduropeRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmmoduropeRepository.delete(id);
	}
	
	@Override
	public FrmModurope insert(FrmModurope frmmodurope){
		return frmmoduropeRepository.insert(frmmodurope);
	}
	
}
