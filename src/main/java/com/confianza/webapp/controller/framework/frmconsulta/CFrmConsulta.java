package com.confianza.webapp.controller.framework.frmconsulta;

import java.util.Map;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import com.google.gson.Gson;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.confianza.webapp.utils.JSONUtil;

import com.confianza.webapp.service.framework.frmconsulta.FrmConsultaService;
import com.confianza.webapp.repository.framework.frmconsulta.FrmConsulta;

@Controller
@RequestMapping("/FrmConsulta")
public class CFrmConsulta {

	private FrmConsultaService frmConsultaService;
	
	@Autowired
	Gson gson;
	
	public CFrmConsulta() {
		super();
	}
	
	@Autowired
	public CFrmConsulta(FrmConsultaService frmconsultaService) {
		this.frmConsultaService = frmconsultaService;
	}
		
	@RequestMapping("/")
	public String index() {
		return "framework/frmconsulta/FrmConsulta";
	}
	
	@RequestMapping(value = "/{conscons}.json", method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String list(@PathVariable("conscons") Long conscons){
		
		try{
			return gson.toJson(this.frmConsultaService.list(conscons));
		}catch(AccessDeniedException e){
			return "Acceso denegado";
		}
	}
	
	@RequestMapping(value = "/listAll.json", params = {"page","pageSize"},  method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String listAll(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page){
	
		try{
			List<FrmConsulta> listAll=this.frmConsultaService.listAll(pageSize, page);
			
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("data", listAll);
			result.put("count", this.frmConsultaService.getCount());
			
			return gson.toJson(result);
		}catch(AccessDeniedException e){
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("tituloError", "Acceso denegado");
			result.put("error", "No posee los permisos para esta accion");
			return gson.toJson(result);
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces={"application/json"})
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public String update(@RequestBody FrmConsulta frmconsulta, HttpServletRequest request){
	
		try{		
			return gson.toJson(this.frmConsultaService.update(frmconsulta) );
		}catch(AccessDeniedException e){
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("tituloError", "Acceso denegado");
			result.put("error", "No posee los permisos para esta accion");
			return gson.toJson(result);
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces={"application/json"})
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public String delete(@RequestBody FrmConsulta frmconsulta, HttpServletRequest request){
	
		try{
			//frmconsulta.setesta("B");
			return gson.toJson(this.frmConsultaService.update(frmconsulta));
		}catch(AccessDeniedException e){
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("tituloError", "Acceso denegado");
			result.put("error", "No posee los permisos para esta accion");
			return gson.toJson(result);
		}
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces={"application/json"})
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public String insert(@RequestBody FrmConsulta frmconsulta, HttpServletRequest request){
		
		try{
			//frmconsulta.setesta("A");
			//frmconsulta.setfecr(new Date());
			
			return gson.toJson(this.frmConsultaService.insert(frmconsulta));
		}catch(AccessDeniedException e){
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("tituloError", "Acceso denegado");
			result.put("error", "No posee los permisos para esta accion");
			return gson.toJson(result);
		}
	}
}
