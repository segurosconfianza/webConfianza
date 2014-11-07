package com.confianza.webapp.service.framework.frmtransaccion;

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

import com.confianza.webapp.repository.framework.frmtransaccion.FrmTransaccion;
import com.confianza.webapp.repository.framework.frmtransaccion.FrmTransaccionRepository;

public class FrmTransaccionServiceImpl implements FrmTransaccionService{
	
	@Autowired
	private FrmTransaccionRepository frmtransaccionRepository;
	
	/**
	 * @return the frmtransaccionRepository
	 */
	public FrmTransaccionRepository getFrmTransaccionRepository() {
		return frmtransaccionRepository;
	}

	/**
	 * @param frmtransaccionRepository the frmtransaccionRepository to set
	 */
	public void setFrmTransaccionRepository(FrmTransaccionRepository frmtransaccionRepository) {
		this.frmtransaccionRepository = frmtransaccionRepository;
	}
	
	@Override
	public FrmTransaccion list(Long id){
		return frmtransaccionRepository.list(id);
	}
	
	@Override
	public List<FrmTransaccion> listAll(){
		return frmtransaccionRepository.listAll();
	}	
	
	@Override
	public FrmTransaccion update(Long id){
		return frmtransaccionRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmtransaccionRepository.delete(id);
	}
	
	@Override
	public FrmTransaccion insert(FrmTransaccion frmtransaccion){
		return frmtransaccionRepository.insert(frmtransaccion);
	}
	
}
