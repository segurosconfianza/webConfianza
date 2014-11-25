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
	public List<Object[]> listAll(int pageSize, int page, Long pemopefi){
		
		int limit=pageSize*page;
		int init=limit-pageSize;
		
		return frmperfmoduRepository.listAll(init, limit, pemopefi);
	}	
	
	@Override
	public FrmPerfmodu update(FrmPerfmodu frmperfmodu){
		return frmperfmoduRepository.update(frmperfmodu);
	}
	
	@Override
	public void delete(FrmPerfmodu frmperfmodu){
		frmperfmoduRepository.delete(frmperfmodu);
	}
	
	@Override
	public FrmPerfmodu insert(FrmPerfmodu frmperfmodu){
		return frmperfmoduRepository.insert(frmperfmodu);
	}

	@Override
	public int getCount() {
		return frmperfmoduRepository.getCount();
	}
	
	@Override
	public List<Object[]> listComboMoro(){
				
		return frmperfmoduRepository.listComboMoro();
	}
	
}
