package com.confianza.webapp.controller.framework.frmmenu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.confianza.webapp.service.framework.frmmenu.FrmmenuService;

@Controller
@RequestMapping("/Frmmenu")
public class CFrmmenu {

	private FrmmenuService frmMenuService;
	
	@Autowired
	public CFrmmenu(FrmmenuService frmmenuService) {
		this.frmMenuService = frmmenuService;
	}

	@RequestMapping("/")
	public String index(Model model) {
		return "../../menu";
	}

	@RequestMapping(method = RequestMethod.GET)	
	@ResponseBody
	public List<Object[]> loadMenu(){
		return frmMenuService.loadMenu();
	}
		
}