package com.confianza.webapp.service.framework.frmperfil;

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

import com.confianza.webapp.repository.framework.frmperfil.FrmPerfil;
import com.confianza.webapp.repository.framework.frmperfil.FrmPerfilRepository;

public class FrmPerfilServiceImpl implements FrmPerfilService{
	
	@Autowired
	private FrmPerfilRepository frmperfilRepository;
	
	/**
	 * @return the frmperfilRepository
	 */
	public FrmPerfilRepository getFrmPerfilRepository() {
		return frmperfilRepository;
	}

	/**
	 * @param frmperfilRepository the frmperfilRepository to set
	 */
	public void setFrmPerfilRepository(FrmPerfilRepository frmperfilRepository) {
		this.frmperfilRepository = frmperfilRepository;
	}
	
	@Override
	public FrmPerfil list(Long id){
		return frmperfilRepository.list(id);
	}
	
	@Override
	public List<FrmPerfil> listAll(){
		return frmperfilRepository.listAll();
	}	
	
	@Override
	public FrmPerfil update(Long id){
		return frmperfilRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmperfilRepository.delete(id);
	}
	
	@Override
	public FrmPerfil insert(FrmPerfil frmperfil){
		return frmperfilRepository.insert(frmperfil);
	}
	
}
