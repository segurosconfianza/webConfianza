package com.confianza.webapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.confianza.webapp.repository.Pedido;
import com.confianza.webapp.repository.PedidoRepository;


@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public void setPedidoRepository(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	public PedidoRepository getPedidoRepository() {
		return this.pedidoRepository;
	}
	
	@Transactional
	public List<Pedido> listar() {
		return pedidoRepository.findAll();
	}

	@Transactional
	public Pedido recuperar(Pedido pedido) {
		return pedidoRepository.findById(pedido.getPedicons());
	}

	@Transactional
	public Long agregar(Pedido pedido) {
		return pedidoRepository.insert(pedido);
	}

	@Transactional
	public void modificar(Pedido pedido) {
		pedidoRepository.update(pedido);
	}

	@Transactional
	public void eliminar(Pedido pedido) {
		pedidoRepository.delete(pedido);
	}

	@Transactional
	public Long contar() {
		return pedidoRepository.count();
	}

	@Transactional
	public List<Pedido> buscarPorMotivo(String pedimoti) {
		return pedidoRepository.findByMotivo(pedimoti);
	}
	
	@Transactional
	public List<Object[]> contarPorSexo() {
		return pedidoRepository.countBySexo();
	}

	@Transactional
	public List<Object[]> contarPorMotivo() {
		return pedidoRepository.countByMotivo();
	}

	@Transactional
	public Map<String, Long> getTotales() {
		
		Map<String, Long> totales = new HashMap<String, Long>(); 
		
		List<Object[]> listSexo = pedidoRepository.countBySexo();
		Long totalSexo = new Long(0);
		for (Object[] reg : listSexo) {
			totales.put((String) reg[0], (reg[1]!=null) ? (Long) reg[1] : new Long(0));
			totalSexo += (Long) reg[1];
		}
		totales.put("Total", totalSexo);
		
		List<Object[]> listMotivo = pedidoRepository.countByMotivo();
		for (Object[] reg : listMotivo) {
			totales.put((String) reg[0], (reg[1]!=null) ? (Long) reg[1] : new Long(0));
		}
		
		return totales;
	}
}
