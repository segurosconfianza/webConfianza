package com.confianza.webapp.service.framework.frmperfmodu;

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

import com.confianza.webapp.repository.framework.frmperfmodu.FrmPerfmodu;
import com.confianza.webapp.repository.framework.frmperfmodu.FrmPerfmoduRepository;

@Service
public class FrmPerfmoduServiceImpl implements FrmPerfmoduService{
	
	@Autowired
	private FrmPerfmoduRepository frmperfmoduRepository;
	
	/**
	 * @return the frmperfmoduRepository
	 */
	public FrmPerfmoduRepository getFrmPerfmoduRepository() {
		return frmperfmoduRepository;
	}

	/**
	 * @param frmperfmoduRepository the frmperfmoduRepository to set
	 */
	public void setFrmPerfmoduRepository(FrmPerfmoduRepository frmperfmoduRepository) {
		this.frmperfmoduRepository = frmperfmoduRepository;
	}
	
	@Override
	public FrmPerfmodu list(Long id){
		return frmperfmoduRepository.list(id);
	}
	
	@Override
	public List<FrmPerfmodu> listAll(){
		return frmperfmoduRepository.listAll();
	}	
	
	@Override
	public FrmPerfmodu update(Long id){
		return frmperfmoduRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmperfmoduRepository.delete(id);
	}
	
	@Override
	public FrmPerfmodu insert(FrmPerfmodu frmperfmodu){
		return frmperfmoduRepository.insert(frmperfmodu);
	}
	
}
