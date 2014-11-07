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

	private FrmParametroService frmparametroService;
	
	@Autowired
	public CFrmParametro(FrmParametroService frmparametroService) {
		this.frmparametroService = frmparametroService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public FrmParametro list(Long id){
		
		return this.frmparametroService.list(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<FrmParametro> listAll(){
	
		return this.frmparametroService.listAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public FrmParametro update(Long id){
		return this.frmparametroService.update(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public void delete(Long id){
		this.frmparametroService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public FrmParametro insert(@RequestBody FrmParametro frmparametro){
		return this.frmparametroService.insert(frmparametro);
	}
}
