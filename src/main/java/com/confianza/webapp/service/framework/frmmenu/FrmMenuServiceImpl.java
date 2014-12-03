package com.confianza.webapp.service.framework.frmmenu;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.confianza.webapp.repository.framework.frmmenu.FrmMenu;
import com.confianza.webapp.repository.framework.frmmenu.FrmMenuRepository;

@Service
public class FrmMenuServiceImpl implements FrmMenuService{
	
	@Autowired
	private FrmMenuRepository frmMenuRepository;
	
	/**
	 * @return the frmmenuRepository
	 */
	public FrmMenuRepository getFrmMenuRepository() {
		return frmMenuRepository;
	}

	/**
	 * @param frmmenuRepository the frmmenuRepository to set
	 */
	public void setFrmMenuRepository(FrmMenuRepository frmmenuRepository) {
		this.frmMenuRepository = frmmenuRepository;
	}
	
	@Override
	public FrmMenu list(Long id){
		return frmMenuRepository.list(id);
	}
	
	@Override
	public List<FrmMenu> listAll(){		
		return frmMenuRepository.listAll();
	}	
	
	@Override
	public FrmMenu update(Long id){
		return frmMenuRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmMenuRepository.delete(id);
	}
	
	@Override
	public FrmMenu insert(FrmMenu frmmenu){
		return frmMenuRepository.insert(frmmenu);
	}
	
	@Override
	public List<Object[]> loadMenu(Long id) {

		List<String> roles = getRoles();
		if(roles.size()>0)
			return frmMenuRepository.loadMenu(roles, id);
		else
			return null;
	}
	
	@Override
	public FrmMenu loadMenuf() {

		FrmMenu FrmMenu=new FrmMenu();
		return FrmMenu;
	}
	
	private List<String> getRoles() {
		
		List<String> roles = new ArrayList<String>();
		List<GrantedAuthority> autorities = new ArrayList<GrantedAuthority>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			autorities=(List<GrantedAuthority>) auth.getAuthorities();
			for(GrantedAuthority obj:autorities){
				String[] auxRol= obj.toString().split("_");
				String rol="";
				for(int i=0;i<auxRol.length-1;i++){				
					if(rol.isEmpty())
						rol+=auxRol[i];
					else
						rol+="_"+auxRol[i];
				}
				roles.add(rol);	
			}
	    }
		
		return roles;
	}
}
