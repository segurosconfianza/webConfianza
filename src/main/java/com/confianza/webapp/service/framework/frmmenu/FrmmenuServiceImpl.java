package com.confianza.webapp.service.framework.frmmenu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.confianza.webapp.repository.framework.frmmenu.FrmMenuRepository;

@Service
public class FrmmenuServiceImpl implements FrmmenuService{

	@Autowired
	private FrmMenuRepository frmMenuRepository;
		
	@Override
	public List<Object[]> loadMenu() {

		List<String> roles = getRoles();
		return frmMenuRepository.loadMenu(roles);
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

	/**
	 * @return the frmMenuRepository
	 */
	public FrmMenuRepository getFrmMenuRepository() {
		return frmMenuRepository;
	}

	/**
	 * @param frmMenuRepository the frmMenuRepository to set
	 */
	public void setFrmMenuRepository(FrmMenuRepository frmMenuRepository) {
		this.frmMenuRepository = frmMenuRepository;
	}
		
}
