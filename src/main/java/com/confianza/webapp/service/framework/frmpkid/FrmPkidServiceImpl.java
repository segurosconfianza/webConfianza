package com.confianza.webapp.service.framework.frmpkid;

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

import com.confianza.webapp.repository.framework.frmpkid.FrmPkid;
import com.confianza.webapp.repository.framework.frmpkid.FrmPkidRepository;

public class FrmPkidServiceImpl implements FrmPkidService{
	
	@Autowired
	private FrmPkidRepository frmpkidRepository;
	
	/**
	 * @return the frmpkidRepository
	 */
	public FrmPkidRepository getFrmPkidRepository() {
		return frmpkidRepository;
	}

	/**
	 * @param frmpkidRepository the frmpkidRepository to set
	 */
	public void setFrmPkidRepository(FrmPkidRepository frmpkidRepository) {
		this.frmpkidRepository = frmpkidRepository;
	}
	
	@Override
	public FrmPkid list(Long id){
		return frmpkidRepository.list(id);
	}
	
	@Override
	public List<FrmPkid> listAll(){
		return frmpkidRepository.listAll();
	}	
	
	@Override
	public FrmPkid update(Long id){
		return frmpkidRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmpkidRepository.delete(id);
	}
	
	@Override
	public FrmPkid insert(FrmPkid frmpkid){
		return frmpkidRepository.insert(frmpkid);
	}
	
}
