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
import org.springframework.stereotype.Service;

import com.confianza.webapp.repository.framework.frmpkid.FrmPkid;
import com.confianza.webapp.repository.framework.frmpkid.FrmPkidRepository;

@Service
public class FrmPkidServiceImpl implements FrmPkidService{
	
	@Autowired
	private FrmPkidRepository frmPkidRepository;
	
	/**
	 * @return the frmpkidRepository
	 */
	public FrmPkidRepository getFrmPkidRepository() {
		return frmPkidRepository;
	}

	/**
	 * @param frmpkidRepository the frmpkidRepository to set
	 */
	public void setFrmPkidRepository(FrmPkidRepository frmpkidRepository) {
		this.frmPkidRepository = frmpkidRepository;
	}
	
	@Override
	public FrmPkid list(Long id){
		return frmPkidRepository.list(id);
	}
	
	@Override
	public List<FrmPkid> listAll(){
		return frmPkidRepository.listAll();
	}	
	
	@Override
	public FrmPkid update(Long id){
		return frmPkidRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmPkidRepository.delete(id);
	}
	
	@Override
	public FrmPkid insert(FrmPkid frmpkid){
		return frmPkidRepository.insert(frmpkid);
	}
	
}
