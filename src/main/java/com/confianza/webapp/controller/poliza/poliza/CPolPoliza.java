package com.confianza.webapp.controller.poliza.poliza;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@RequestMapping("/PolPoliza")
public class CPolPoliza {
	
	@Autowired
	Gson gson;
	
		public CPolPoliza() {
		super();
	}

	@RequestMapping("/")
	public String index(Model model) {
		return "poliza/poliza/Poliza";
	}
	
}
