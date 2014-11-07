package com.confianza.webapp.controller.framework.frmaplicaciones;

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
 
import com.confianza.webapp.service.framework.frmaplicaciones.FrmAplicacionesService;
import com.confianza.webapp.repository.framework.frmaplicaciones.FrmAplicaciones;

@Controller
@RequestMapping("/FrmAplicaciones")
public class CFrmAplicaciones {

	private FrmAplicacionesService frmaplicacionesService;
	
	@Autowired
	public CFrmAplicaciones(FrmAplicacionesService frmaplicacionesService) {
		this.frmaplicacionesService = frmaplicacionesService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public FrmAplicaciones list(Long id){
		
		return this.frmaplicacionesService.list(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<FrmAplicaciones> listAll(){
	
		return this.frmaplicacionesService.listAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public FrmAplicaciones update(Long id){
		return this.frmaplicacionesService.update(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public void delete(Long id){
		this.frmaplicacionesService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public FrmAplicaciones insert(@RequestBody FrmAplicaciones frmaplicaciones){
		return this.frmaplicacionesService.insert(frmaplicaciones);
	}
}
