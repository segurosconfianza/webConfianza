package com.confianza.webapp.controller.framework.frmconsulta;

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
import org.springframework.web.multipart.MultipartFile;

import com.confianza.webapp.service.framework.frmconsulta.FrmConsultaService;
import com.confianza.webapp.repository.framework.frmconsulta.FrmConsulta;

@Controller
@RequestMapping("/FrmConsulta")
public class CFrmConsulta {
	
	@Autowired
	private FrmConsultaService frmConsultaService;
		
	public CFrmConsulta() {
		super();
	}
	
	@RequestMapping("/")
	public String index() {
		return "framework/frmconsulta/FrmConsulta";
	}
	
	@RequestMapping("/PolizaConsulta/Poliza.html")
	public String polizaConsulta() {
		return "poliza/poliza/Poliza";
	}
	
	@RequestMapping("/Soporte/")
	public String soporteConsulta() {
		return "soporte/soporte/Soporte";
	}
	
	@RequestMapping(value = "/{conscons}.json", method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String list(@PathVariable("conscons") Long conscons){
		
		return this.frmConsultaService.list(conscons);
	}
	
	@RequestMapping(value = "/listAll.json", params = {"page","pageSize"},  method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String listAll(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page){
	
		return this.frmConsultaService.listAll(pageSize, page);
	}
	
	@RequestMapping(value = "/loadRecord.json", params = {"conscons","params"}, method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String loadRecord(HttpServletRequest request, @RequestParam("conscons") Long conscons, @RequestParam("params") String params) throws Throwable{
			
		return this.frmConsultaService.loadRecord(request, conscons, params);
	}
	
	@RequestMapping(value = "/updateRecord.json", params = {"conscons","params","paramsData", "files"}, method = RequestMethod.POST, produces={"application/json"})
	@ResponseBody
	public String updateRecord(@RequestParam("conscons") String conscons, @RequestParam("params") String params,  @RequestParam("paramsData") String paramsData, @RequestParam("files") MultipartFile file, HttpServletRequest request) throws Throwable{					
		 				   
		return this.frmConsultaService.updateRecord(conscons, params, paramsData);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces={"application/json"})
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public String update(@RequestBody FrmConsulta frmconsulta, HttpServletRequest request){
	
		return this.frmConsultaService.update(frmconsulta);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces={"application/json"})
	@ResponseStatus( HttpStatus.OK )
	@ResponseBody
	public String delete(@RequestBody FrmConsulta frmconsulta, HttpServletRequest request){
	
		//frmconsulta.setesta("B");
		return this.frmConsultaService.update(frmconsulta);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces={"application/json"})
	@ResponseStatus( HttpStatus.CREATED )
	@ResponseBody
	public String insert(@RequestBody FrmConsulta frmconsulta, HttpServletRequest request){
		
		return this.frmConsultaService.insert(frmconsulta);
	}
	
	@RequestMapping(value = "/listCombo.json", params = {"conscons"}, method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String listCombo(@RequestParam("conscons") String conscons) throws Exception{

		return this.frmConsultaService.listCombo(conscons);
	}
	
	@RequestMapping(value = "/listComboDynamic.json", params = {"conscons"}, method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String listComboDynamic(@RequestParam("conscons") String conscons) throws Exception{
		
		return this.frmConsultaService.listComboDynamic(conscons);
	}
	
	@RequestMapping(value = "/loadData.json", params = {"conscons"}, method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String loadData(@RequestParam("conscons") Long conscons) throws Throwable{
			
		return this.frmConsultaService.loadData(conscons);
	}
	
	@RequestMapping(value = "/loadConsChield.json", params = {"conscons"}, method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String loadConsChield(@RequestParam("conscons") String conscons) throws Throwable{
			
		return this.frmConsultaService.loadConsChield(conscons);
	}
	
	@RequestMapping(value = "/loadRecordFecha.json", params = {"conscons"}, method = RequestMethod.GET, produces={"application/json"})
	@ResponseBody
	public String loadRecordFecha(HttpServletRequest request, @RequestParam("conscons") Long conscons) throws Throwable{
			
		return this.frmConsultaService.loadRecord(request, conscons, null);
	}
}
