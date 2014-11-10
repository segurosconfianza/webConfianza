package com.confianza.webapp.controller.framework.frmparametro;

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
 
import com.confianza.webapp.service.framework.frmparametro.FrmParametroService;
import com.confianza.webapp.repository.framework.frmparametro.FrmParametro;

@Controller
@RequestMapping("/FrmParametro")
public class CFrmParametro {

	private FrmParametroService frmParametroService;
	
	@Autowired
	public CFrmParametro(FrmParametroService frmparametroService) {
		this.frmParametroService = frmparametroService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public FrmParametro list(Long id){
		
		return this.frmParametroService.list(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<FrmParametro> listAll(){
	
		return this.frmParametroService.listAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public FrmParametro update(Long id){
		return this.frmParametroService.update(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public void delete(Long id){
		this.frmParametroService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public FrmParametro insert(@RequestBody FrmParametro frmparametro){
		return this.frmParametroService.insert(frmparametro);
	}
}
