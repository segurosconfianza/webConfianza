package com.confianza.webapp.service;

import java.util.List;
import java.util.Map;

import com.confianza.webapp.repository.Pedido;


public interface PedidoService {
	
	public List<Pedido> listar();

	public Pedido recuperar(Pedido pedido);

	public Long agregar(Pedido pedido);

	public void modificar(Pedido pedido);

	public void eliminar(Pedido pedido);
	
	public Long contar();
	
	public List<Pedido> buscarPorMotivo(String pedimoti);
	
	public List<Object[]> contarPorSexo();
	
	public List<Object[]> contarPorMotivo();

	public Map<String, Long> getTotales();

}
