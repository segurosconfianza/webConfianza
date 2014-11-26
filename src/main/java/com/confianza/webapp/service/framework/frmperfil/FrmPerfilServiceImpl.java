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

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.confianza.webapp.repository.framework.frmperfil.FrmPerfil;
import com.confianza.webapp.repository.framework.frmperfil.FrmPerfilRepository;

@Service
public class FrmPerfilServiceImpl implements FrmPerfilService{
	
	@Autowired
	private FrmPerfilRepository frmPerfilRepository;
	
	/**
	 * @return the frmperfilRepository
	 */
	public FrmPerfilRepository getFrmPerfilRepository() {
		return frmPerfilRepository;
	}

	/**
	 * @param frmperfilRepository the frmperfilRepository to set
	 */
	public void setFrmPerfilRepository(FrmPerfilRepository frmperfilRepository) {
		this.frmPerfilRepository = frmperfilRepository;
	}
	
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "FRM_PERFIL_ALL", "FRM_PERFIL_READ"})
	public FrmPerfil list(Long id) throws Exception{
		return frmPerfilRepository.list(id);
	}
		
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "FRM_PERFIL_ALL", "FRM_PERFIL_READ"})
	public List<FrmPerfil> listAll(int pageSize, int page) throws Exception{
		
		int limit=pageSize*page;
		int init=limit-pageSize;
		
		return frmPerfilRepository.listAll(init, limit);
	}
	
	@Override
	public int getCount(){
				
		return frmPerfilRepository.getCount();
	}
	
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "FRM_PERFIL_ALL", "FRM_PERFIL_UPDATE"})
	public FrmPerfil update(FrmPerfil frmPerfil) throws Exception{
		return frmPerfilRepository.update(frmPerfil);
	}
	
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "FRM_PERFIL_ALL", "FRM_PERFIL_DELETE"})
	public void delete(FrmPerfil frmperfil) throws Exception{
		frmPerfilRepository.delete(frmperfil);
	}
	
	@Override
	@RolesAllowed({"ADMINISTRATOR_ADMINISTRATOR", "FRM_PERFIL_ALL", "FRM_PERFIL_CREATE"})
	public FrmPerfil insert(FrmPerfil frmperfil) throws Exception{
		return frmPerfilRepository.insert(frmperfil);
	}
	
}
