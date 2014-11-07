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

	private FrmPerfilService frmperfilService;
	
	@Autowired
	public CFrmPerfil(FrmPerfilService frmperfilService) {
		this.frmperfilService = frmperfilService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public FrmPerfil list(Long id){
		
		return this.frmperfilService.list(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<FrmPerfil> listAll(){
	
		return this.frmperfilService.listAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public FrmPerfil update(Long id){
		return this.frmperfilService.update(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public void delete(Long id){
		this.frmperfilService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public FrmPerfil insert(@RequestBody FrmPerfil frmperfil){
		return this.frmperfilService.insert(frmperfil);
	}
}
