package com.confianza.webapp.controller.framework.frmperfil;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
 
import com.confianza.webapp.service.framework.frmperfil.FrmPerfilService;
import com.confianza.webapp.repository.framework.frmperfil.FrmPerfil;

@Controller
@RequestMapping("/FrmPerfil")
public class CFrmPerfil {

	private FrmPerfilService frmPerfilService;
	
	@Autowired
	public CFrmPerfil(FrmPerfilService frmperfilService) {
		this.frmPerfilService = frmperfilService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public FrmPerfil list(Long id){
		
		return this.frmPerfilService.list(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<FrmPerfil> listAll(){
	
		return this.frmPerfilService.listAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public FrmPerfil update(Long id){
		return this.frmPerfilService.update(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public void delete(Long id){
		this.frmPerfilService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public FrmPerfil insert(@RequestBody FrmPerfil frmperfil){
		return this.frmPerfilService.insert(frmperfil);
	}
}
