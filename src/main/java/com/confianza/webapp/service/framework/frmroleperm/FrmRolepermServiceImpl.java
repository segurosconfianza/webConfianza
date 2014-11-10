package com.confianza.webapp.service.framework.frmroleperm;

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

import com.confianza.webapp.repository.framework.frmroleperm.FrmRoleperm;
import com.confianza.webapp.repository.framework.frmroleperm.FrmRolepermRepository;

@Service
public class FrmRolepermServiceImpl implements FrmRolepermService{
	
	@Autowired
	private FrmRolepermRepository frmRolepermRepository;
	
	/**
	 * @return the frmrolepermRepository
	 */
	public FrmRolepermRepository getFrmRolepermRepository() {
		return frmRolepermRepository;
	}

	/**
	 * @param frmrolepermRepository the frmrolepermRepository to set
	 */
	public void setFrmRolepermRepository(FrmRolepermRepository frmrolepermRepository) {
		this.frmRolepermRepository = frmrolepermRepository;
	}
	
	@Override
	public FrmRoleperm list(Long id){
		return frmRolepermRepository.list(id);
	}
	
	@Override
	public List<FrmRoleperm> listAll(){
		return frmRolepermRepository.listAll();
	}	
	
	@Override
	public FrmRoleperm update(Long id){
		return frmRolepermRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmRolepermRepository.delete(id);
	}
	
	@Override
	public FrmRoleperm insert(FrmRoleperm frmroleperm){
		return frmRolepermRepository.insert(frmroleperm);
	}
	
}
