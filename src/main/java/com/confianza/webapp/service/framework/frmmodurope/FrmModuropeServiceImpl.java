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
import org.springframework.stereotype.Service;

import com.confianza.webapp.repository.framework.frmmodurope.FrmModurope;
import com.confianza.webapp.repository.framework.frmmodurope.FrmModuropeRepository;

@Service
public class FrmModuropeServiceImpl implements FrmModuropeService{
	
	@Autowired
	private FrmModuropeRepository frmModuropeRepository;
	
	/**
	 * @return the frmmoduropeRepository
	 */
	public FrmModuropeRepository getFrmModuropeRepository() {
		return frmModuropeRepository;
	}

	/**
	 * @param frmmoduropeRepository the frmmoduropeRepository to set
	 */
	public void setFrmModuropeRepository(FrmModuropeRepository frmmoduropeRepository) {
		this.frmModuropeRepository = frmmoduropeRepository;
	}
	
	@Override
	public FrmModurope list(Long id){
		return frmModuropeRepository.list(id);
	}
	
	@Override
	public List<FrmModurope> listAll(){
		return frmModuropeRepository.listAll();
	}	
	
	@Override
	public FrmModurope update(Long id){
		return frmModuropeRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmModuropeRepository.delete(id);
	}
	
	@Override
	public FrmModurope insert(FrmModurope frmmodurope){
		return frmModuropeRepository.insert(frmmodurope);
	}
	
}
