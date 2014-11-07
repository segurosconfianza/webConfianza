package com.confianza.webapp.controller.framework.frmauditoria;

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
 
import com.confianza.webapp.service.framework.frmauditoria.FrmAuditoriaService;
import com.confianza.webapp.repository.framework.frmauditoria.FrmAuditoria;

@Controller
@RequestMapping("/FrmAuditoria")
public class CFrmAuditoria {

	private FrmAuditoriaService frmauditoriaService;
	
	@Autowired
	public CFrmAuditoria(FrmAuditoriaService frmauditoriaService) {
		this.frmauditoriaService = frmauditoriaService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public FrmAuditoria list(Long id){
		
		return this.frmauditoriaService.list(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<FrmAuditoria> listAll(){
	
		return this.frmauditoriaService.listAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public FrmAuditoria update(Long id){
		return this.frmauditoriaService.update(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public void delete(Long id){
		this.frmauditoriaService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public FrmAuditoria insert(@RequestBody FrmAuditoria frmauditoria){
		return this.frmauditoriaService.insert(frmauditoria);
	}
}
