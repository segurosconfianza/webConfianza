package com.confianza.webapp.repository.pedido;

import java.util.List;

public interface PedidoRepository {

	public Long insert(Pedido pedido);
	public void update(Pedido pedido);
	public void delete(Pedido pedido);
	public Long count();
	public List<Pedido> findAll();
	public List<Pedido> find(Pedido pedido);
	public Pedido findById(Long pedicons);
	public List<Pedido> findByMotivo(String pedimoti);
	
	public List<Object[]> countBySexo();
	public List<Object[]> countByMotivo();
}
