package com.confianza.webapp.repository.framework.frmusuario;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name = "FRM_USUARIO")
public class FrmUsuario {
	@Id 
	// Habilite este codigo para generar automaticamente la llave primaria esta depende de una tabla
	@TableGenerator(name = "FRM_USUARIO_GEN", //<= nombre de la tabla con el cual se va a identificar la llave
	                 table = "FRM_PKID",              //<= Este string define la tabla dond se almacenan el consecutivo
	                 pkColumnName="PKIDNOMB",         //<= NOMBRE DE LA LLAVE PRIMARIA DE LA TABLA    
	                 valueColumnName="PKIDVALU",      //<= Valor del consecutivo en el que va la llave primaria
	                 pkColumnValue="FRM_USUARIO_PK", 
	                 initialValue = 1,                //<= Valor inicial de la llave primario
	                 allocationSize = 1)              //<= Valor a buscar por medio de la llave primaria
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "FRM_USUARIO_GEN")  
	@Column(name = "USUACONS")
	protected Long usuacons; 
	 
	@Column(name = "USUAUSUA")
	protected String usuausua; 
	 
	@Column(name = "USUANOMB")
	protected String usuanomb; 
	 
	@Column(name = "USUATIPO")
	protected String usuatipo; 
	 
	@Column(name = "USUAESTA")
	protected String usuaesta; 
	 
	@Column(name = "USUAFECR")
	protected Date usuafecr; 

	public FrmUsuario(){
	
	}

	public Long getUsuacons(){
		return usuacons;
	}
	
	public void setUsuacons(Long usuacons){
		this.usuacons = usuacons;
	}

	public String getUsuausua(){
		return usuausua;
	}
	
	public void setUsuausua(String usuausua){
		this.usuausua = usuausua;
	}

	public String getUsuanomb(){
		return usuanomb;
	}
	
	public void setUsuanomb(String usuanomb){
		this.usuanomb = usuanomb;
	}

	public String getUsuatipo(){
		return usuatipo;
	}
	
	public void setUsuatipo(String usuatipo){
		this.usuatipo = usuatipo;
	}

	public String getUsuaesta(){
		return usuaesta;
	}
	
	public void setUsuaesta(String usuaesta){
		this.usuaesta = usuaesta;
	}

	public Date getUsuafecr(){
		return usuafecr;
	}
	
	public void setUsuafecr(Date usuafecr){
		this.usuafecr = usuafecr;
	}


	static public String[] getNames(){
		return new String[]{ "USUACONS", "USUAUSUA", "USUANOMB", "USUATIPO", "USUAESTA", "USUAFECR" };
	}		
	
	public String toString(){
		return " USUACONS: "+ this.usuacons 
			+" USUAUSUA: "+ this.usuausua 
			+" USUANOMB: "+ this.usuanomb 
			+" USUATIPO: "+ this.usuatipo 
			+" USUAESTA: "+ this.usuaesta 
			+" USUAFECR: "+ this.usuafecr ;
	}
}
