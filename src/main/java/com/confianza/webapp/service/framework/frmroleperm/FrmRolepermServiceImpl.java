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

import com.confianza.webapp.repository.framework.frmroleperm.FrmRoleperm;
import com.confianza.webapp.repository.framework.frmroleperm.FrmRolepermRepository;

public class FrmRolepermServiceImpl implements FrmRolepermService{
	
	@Autowired
	private FrmRolepermRepository frmrolepermRepository;
	
	/**
	 * @return the frmrolepermRepository
	 */
	public FrmRolepermRepository getFrmRolepermRepository() {
		return frmrolepermRepository;
	}

	/**
	 * @param frmrolepermRepository the frmrolepermRepository to set
	 */
	public void setFrmRolepermRepository(FrmRolepermRepository frmrolepermRepository) {
		this.frmrolepermRepository = frmrolepermRepository;
	}
	
	@Override
	public FrmRoleperm list(Long id){
		return frmrolepermRepository.list(id);
	}
	
	@Override
	public List<FrmRoleperm> listAll(){
		return frmrolepermRepository.listAll();
	}	
	
	@Override
	public FrmRoleperm update(Long id){
		return frmrolepermRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmrolepermRepository.delete(id);
	}
	
	@Override
	public FrmRoleperm insert(FrmRoleperm frmroleperm){
		return frmrolepermRepository.insert(frmroleperm);
	}
	
}
