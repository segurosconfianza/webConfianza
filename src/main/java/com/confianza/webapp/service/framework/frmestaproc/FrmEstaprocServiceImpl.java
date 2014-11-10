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
import org.springframework.stereotype.Service;

import com.confianza.webapp.repository.framework.frmestaproc.FrmEstaproc;
import com.confianza.webapp.repository.framework.frmestaproc.FrmEstaprocRepository;

@Service
public class FrmEstaprocServiceImpl implements FrmEstaprocService{
	
	@Autowired
	private FrmEstaprocRepository frmEstaprocRepository;
	
	/**
	 * @return the frmestaprocRepository
	 */
	public FrmEstaprocRepository getFrmEstaprocRepository() {
		return frmEstaprocRepository;
	}

	/**
	 * @param frmestaprocRepository the frmestaprocRepository to set
	 */
	public void setFrmEstaprocRepository(FrmEstaprocRepository frmestaprocRepository) {
		this.frmEstaprocRepository = frmestaprocRepository;
	}
	
	@Override
	public FrmEstaproc list(Long id){
		return frmEstaprocRepository.list(id);
	}
	
	@Override
	public List<FrmEstaproc> listAll(){
		return frmEstaprocRepository.listAll();
	}	
	
	@Override
	public FrmEstaproc update(Long id){
		return frmEstaprocRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmEstaprocRepository.delete(id);
	}
	
	@Override
	public FrmEstaproc insert(FrmEstaproc frmestaproc){
		return frmEstaprocRepository.insert(frmestaproc);
	}
	
}
