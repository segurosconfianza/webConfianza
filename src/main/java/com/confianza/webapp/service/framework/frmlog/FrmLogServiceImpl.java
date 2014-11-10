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
import org.springframework.stereotype.Service;

import com.confianza.webapp.repository.framework.frmlog.FrmLog;
import com.confianza.webapp.repository.framework.frmlog.FrmLogRepository;

@Service
public class FrmLogServiceImpl implements FrmLogService{
	
	@Autowired
	private FrmLogRepository frmLogRepository;
	
	/**
	 * @return the frmlogRepository
	 */
	public FrmLogRepository getFrmLogRepository() {
		return frmLogRepository;
	}

	/**
	 * @param frmlogRepository the frmlogRepository to set
	 */
	public void setFrmLogRepository(FrmLogRepository frmlogRepository) {
		this.frmLogRepository = frmlogRepository;
	}
	
	@Override
	public FrmLog list(Long id){
		return frmLogRepository.list(id);
	}
	
	@Override
	public List<FrmLog> listAll(){
		return frmLogRepository.listAll();
	}	
	
	@Override
	public FrmLog update(Long id){
		return frmLogRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmLogRepository.delete(id);
	}
	
	@Override
	public FrmLog insert(FrmLog frmlog){
		return frmLogRepository.insert(frmlog);
	}
	
}
