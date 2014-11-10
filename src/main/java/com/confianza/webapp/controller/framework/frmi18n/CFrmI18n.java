package com.confianza.webapp.controller.framework.frmi18n;

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
 
import com.confianza.webapp.service.framework.frmi18n.FrmI18nService;
import com.confianza.webapp.repository.framework.frmi18n.FrmI18n;

@Controller
@RequestMapping("/FrmI18n")
public class CFrmI18n {

	private FrmI18nService frmI18nService;
	
	@Autowired
	public CFrmI18n(FrmI18nService frmi18nService) {
		this.frmI18nService = frmi18nService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public FrmI18n list(Long id){
		
		return this.frmI18nService.list(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<FrmI18n> listAll(){
	
		return this.frmI18nService.listAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public FrmI18n update(Long id){
		return this.frmI18nService.update(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public void delete(Long id){
		this.frmI18nService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public FrmI18n insert(@RequestBody FrmI18n frmi18n){
		return this.frmI18nService.insert(frmi18n);
	}
}
