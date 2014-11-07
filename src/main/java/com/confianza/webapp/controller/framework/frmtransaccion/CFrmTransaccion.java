package com.confianza.webapp.controller.framework.frmtransaccion;

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
 
import com.confianza.webapp.service.framework.frmtransaccion.FrmTransaccionService;
import com.confianza.webapp.repository.framework.frmtransaccion.FrmTransaccion;

@Controller
@RequestMapping("/FrmTransaccion")
public class CFrmTransaccion {

	private FrmTransaccionService frmtransaccionService;
	
	@Autowired
	public CFrmTransaccion(FrmTransaccionService frmtransaccionService) {
		this.frmtransaccionService = frmtransaccionService;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public FrmTransaccion list(Long id){
		
		return this.frmtransaccionService.list(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<FrmTransaccion> listAll(){
	
		return this.frmtransaccionService.listAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public FrmTransaccion update(Long id){
		return this.frmtransaccionService.update(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public void delete(Long id){
		this.frmtransaccionService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public FrmTransaccion insert(@RequestBody FrmTransaccion frmtransaccion){
		return this.frmtransaccionService.insert(frmtransaccion);
	}
}
