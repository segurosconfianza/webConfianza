package com.confianza.webapp.controller.framework.frmmenu;

import java.util.List;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.confianza.webapp.service.framework.frmmenu.FrmmenuService;

@Controller
@RequestMapping("/Frmmenu")
public class CFrmmenu {

	private FrmmenuService frmmenuService;
	
	@Autowired
	public CFrmmenu(FrmmenuService frmmenuService) {
		this.frmmenuService = frmmenuService;
	}

	@RequestMapping("/")
	public String index(Model model) {
		return "../../menu";
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Object[]> loadMenu(){
		
		return frmmenuService.loadMenu();
	}
		
}