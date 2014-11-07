package com.confianza.webapp.service.framework.frmestaproc;

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

import com.confianza.webapp.repository.framework.frmestaproc.FrmEstaproc;
import com.confianza.webapp.repository.framework.frmestaproc.FrmEstaprocRepository;

public class FrmEstaprocServiceImpl implements FrmEstaprocService{
	
	@Autowired
	private FrmEstaprocRepository frmestaprocRepository;
	
	/**
	 * @return the frmestaprocRepository
	 */
	public FrmEstaprocRepository getFrmEstaprocRepository() {
		return frmestaprocRepository;
	}

	/**
	 * @param frmestaprocRepository the frmestaprocRepository to set
	 */
	public void setFrmEstaprocRepository(FrmEstaprocRepository frmestaprocRepository) {
		this.frmestaprocRepository = frmestaprocRepository;
	}
	
	@Override
	public FrmEstaproc list(Long id){
		return frmestaprocRepository.list(id);
	}
	
	@Override
	public List<FrmEstaproc> listAll(){
		return frmestaprocRepository.listAll();
	}	
	
	@Override
	public FrmEstaproc update(Long id){
		return frmestaprocRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmestaprocRepository.delete(id);
	}
	
	@Override
	public FrmEstaproc insert(FrmEstaproc frmestaproc){
		return frmestaprocRepository.insert(frmestaproc);
	}
	
}
