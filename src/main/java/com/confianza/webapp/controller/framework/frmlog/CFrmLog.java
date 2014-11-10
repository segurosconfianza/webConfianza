package com.confianza.webapp.controller.framework.frmlog;

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
 
import com.confianza.webapp.service.framework.frmlog.FrmLogService;
import com.confianza.webapp.repository.framework.frmlog.FrmLog;

@Controller
@RequestMapping("/FrmLog")
public class CFrmLog {

	private FrmLogService frmLogService;
	
	@Autowired
	public CFrmLog(FrmLogService frmlogService) {
		this.frmLogService = frmlogService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public FrmLog list(Long id){
		
		return this.frmLogService.list(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<FrmLog> listAll(){
	
		return this.frmLogService.listAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public FrmLog update(Long id){
		return this.frmLogService.update(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public void delete(Long id){
		this.frmLogService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public FrmLog insert(@RequestBody FrmLog frmlog){
		return this.frmLogService.insert(frmlog);
	}
}
