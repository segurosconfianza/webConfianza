package com.confianza.webapp.controller.framework.frmperfil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.confianza.webapp.service.framework.frmperfil.FrmPerfilService;
import com.confianza.webapp.utils.JSONUtil;
import com.confianza.webapp.repository.framework.frmperfil.FrmPerfil;
import com.confianza.webapp.repository.framework.frmperfil.FrmPerfilSerializer;
import com.confianza.webapp.repository.framework.frmsesion.FrmSesion;

@Controller
@EnableWebMvc
@RequestMapping("/FrmPerfil")
public class CFrmPerfil {

	private FrmPerfilService frmPerfilService;
	
	@Autowired
	Gson gson;
	
	@Autowired
	public CFrmPerfil(FrmPerfilService frmperfilService) {
		this.frmPerfilService = frmperfilService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "framework/frmperfil/FrmPerfil";
	}
	
	@RequestMapping(value = "/{peficons}.json", method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String list(@PathVariable("peficons") Long peficons){
		
		return gson.toJson(this.frmPerfilService.list(peficons));
	}
	
	@RequestMapping(value = "/listAll.json", params = {"page","pageSize"}, method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String listAll(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page){
		
		List<FrmPerfil> listAll=this.frmPerfilService.listAll(pageSize, page);
		Type collectionType = new TypeToken<List<FrmPerfil>>(){}.getType();
		
		System.out.println("listAll: "+listAll.size());
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", listAll);
		result.put("count", this.frmPerfilService.getCount());
		
		return gson.toJson(result);
	}
	
	@RequestMapping(value = "/{peficons}", method = RequestMethod.PUT)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public FrmPerfil update(@PathVariable("peficons") Long peficons, HttpServletRequest request){
	
		HttpSession session = request.getSession();
		FrmSesion frmSesion = (FrmSesion) session.getAttribute("frmSesion");
		
		return this.frmPerfilService.update(peficons);
	}
	
	@RequestMapping(value = "/{peficons}.json", method = RequestMethod.DELETE)
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public void delete(@PathVariable("peficons") Long peficons, HttpServletRequest request){
	
		HttpSession session = request.getSession();
		FrmSesion frmSesion = (FrmSesion) session.getAttribute("frmSesion");
		
		this.frmPerfilService.delete(peficons);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces={"application/json"})
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public String insert(@RequestBody FrmPerfil frmperfil, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		FrmSesion frmSesion = (FrmSesion) session.getAttribute("frmSesion");
		
		return gson.toJson(this.frmPerfilService.insert(frmperfil));
	}
}
