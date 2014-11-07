package com.confianza.webapp.service.framework.frmlog;

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

import com.confianza.webapp.repository.framework.frmlog.FrmLog;
import com.confianza.webapp.repository.framework.frmlog.FrmLogRepository;

public class FrmLogServiceImpl implements FrmLogService{
	
	@Autowired
	private FrmLogRepository frmlogRepository;
	
	/**
	 * @return the frmlogRepository
	 */
	public FrmLogRepository getFrmLogRepository() {
		return frmlogRepository;
	}

	/**
	 * @param frmlogRepository the frmlogRepository to set
	 */
	public void setFrmLogRepository(FrmLogRepository frmlogRepository) {
		this.frmlogRepository = frmlogRepository;
	}
	
	@Override
	public FrmLog list(Long id){
		return frmlogRepository.list(id);
	}
	
	@Override
	public List<FrmLog> listAll(){
		return frmlogRepository.listAll();
	}	
	
	@Override
	public FrmLog update(Long id){
		return frmlogRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmlogRepository.delete(id);
	}
	
	@Override
	public FrmLog insert(FrmLog frmlog){
		return frmlogRepository.insert(frmlog);
	}
	
}
