package com.confianza.webapp.controller.framework.frmmenu;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.confianza.webapp.repository.pedido.Pedido;
import com.confianza.webapp.service.pedido.PedidoService;

@Controller
public class PedidoController {

	private PedidoService pedidoService;
	
	@Autowired
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@RequestMapping("/")
	public String index(Model model) {
		return "pedido";
	}

	
	@RequestMapping("/Pedido")
	public String pedirOracion(Model model, HttpServletRequest request) {
		
		Pedido pedido = new Pedido();
		pedido.setPedifech(new Date());
		pedido.setPedinomb(request.getParameter("persnomb"));
		pedido.setPeditext(request.getParameter("perstext"));
		pedido.setPedisexo(request.getParameter("perssexo"));
		pedido.setPedimoti( parseMotivos(request) );
		
		Long id = pedidoService.agregar(pedido);
		
		model.addAttribute("perscons", id);
		
		return "pedido";
	}	
	
	private String parseMotivos(HttpServletRequest request) {

		String [] motis = { request.getParameter("persmoti1"),
				request.getParameter("persmoti2"),
				request.getParameter("persmoti3"),
				request.getParameter("persmoti4"),
				request.getParameter("persmoti5")
			};
		
		StringBuilder sb = new StringBuilder();
		Boolean p = true;
		
		for (String moti : motis) {
			if (moti != null) {
				sb.append( p ? "" : ", " );
				sb.append(moti);
				p = false;
			}
		}
		return sb.toString();
	}

	@RequestMapping("/Resumen")
	public String resumen(Model model) {
		
		Map<String, Long> totales = pedidoService.getTotales();
		model.addAllAttributes(totales);
		/*
		List<Object[]> listSexo = pedidoService.contarPorSexo();
		for (Object[] reg : listSexo) {
			model.addAttribute((String) reg[0], (Long) reg[1]);
		}
		
		List<Object[]> listMotivo = pedidoService.contarPorMotivo();
		for (Object[] reg : listMotivo) {
			model.addAttribute((String) reg[0], (Long) reg[1]);
		}
		*/
		return "resumen";
	}
}