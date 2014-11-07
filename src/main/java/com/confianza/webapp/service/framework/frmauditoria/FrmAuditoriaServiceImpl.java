package com.confianza.webapp.service.framework.frmauditoria;

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

import com.confianza.webapp.repository.framework.frmauditoria.FrmAuditoria;
import com.confianza.webapp.repository.framework.frmauditoria.FrmAuditoriaRepository;

public class FrmAuditoriaServiceImpl implements FrmAuditoriaService{
	
	@Autowired
	private FrmAuditoriaRepository frmauditoriaRepository;
	
	/**
	 * @return the frmauditoriaRepository
	 */
	public FrmAuditoriaRepository getFrmAuditoriaRepository() {
		return frmauditoriaRepository;
	}

	/**
	 * @param frmauditoriaRepository the frmauditoriaRepository to set
	 */
	public void setFrmAuditoriaRepository(FrmAuditoriaRepository frmauditoriaRepository) {
		this.frmauditoriaRepository = frmauditoriaRepository;
	}
	
	@Override
	public FrmAuditoria list(Long id){
		return frmauditoriaRepository.list(id);
	}
	
	@Override
	public List<FrmAuditoria> listAll(){
		return frmauditoriaRepository.listAll();
	}	
	
	@Override
	public FrmAuditoria update(Long id){
		return frmauditoriaRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmauditoriaRepository.delete(id);
	}
	
	@Override
	public FrmAuditoria insert(FrmAuditoria frmauditoria){
		return frmauditoriaRepository.insert(frmauditoria);
	}
	
}
