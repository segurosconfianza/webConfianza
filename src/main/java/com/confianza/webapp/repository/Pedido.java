package com.confianza.webapp.repository;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="PEDIDO")
public class Pedido {
	
	@Id
	@TableGenerator(name = "PEDIDO_GEN", 
					table = "APP_TABLAS", 
    				pkColumnName="TABLNOMB", 
    				valueColumnName="TABLPKEY",
    				pkColumnValue="PEDIDO", 
    				initialValue = 1, 
    				allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PEDIDO_GEN")
	@Column(name="pedicons")
	private Long pedicons;

	@Column(name="pedifech")
	private Date pedifech;
	
	@Column(name="pedinomb")
	private String pedinomb;
	
	@Column(name="peditext")
	private String peditext;
	
	@Column(name="pedimoti")
	private String pedimoti;
	
	@Column(name="pedisexo")
	private String pedisexo;
	
	@Column(name="pediigle")
	private Integer pediigle;
	
	public Long getPedicons() {
		return pedicons;
	}
	public void setPedicons(Long pedicons) {
		this.pedicons = pedicons;
	}
	public Date getPedifech() {
		return pedifech;
	}
	public void setPedifech(Date pedifech) {
		this.pedifech = pedifech;
	}
	public String getPedinomb() {
		return pedinomb;
	}
	public void setPedinomb(String pedinomb) {
		this.pedinomb = pedinomb;
	}
	public String getPeditext() {
		return peditext;
	}
	public void setPeditext(String peditext) {
		this.peditext = peditext;
	}
	public String getPedimoti() {
		return pedimoti;
	}
	public void setPedimoti(String pedimoti) {
		this.pedimoti = pedimoti;
	}
	public String getPedisexo() {
		return pedisexo;
	}
	public void setPedisexo(String pedisexo) {
		this.pedisexo = pedisexo;
	}
	public Integer getPediigle() {
		return pediigle;
	}
	public void setPediigle(Integer pediigle) {
		this.pediigle = pediigle;
	}
	public String toString() {
		return String.format("Pedido [cons=%d fech=%s nomb=%s text=%s moti=%s sexo=%s]", pedicons, pedifech, pedinomb, peditext, pedimoti, pedisexo);		
	}
}
