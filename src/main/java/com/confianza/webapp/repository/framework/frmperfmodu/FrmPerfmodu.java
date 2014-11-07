package com.confianza.webapp.repository.framework.frmperfmodu;

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
@Table(name = "FRM_PERFMODU")
public class FrmPerfmodu {
	 
	@Column(name = "PEMOPEFI")
	protected Long pemopefi; 
	 
	@Column(name = "PEMOMORO")
	protected Long pemomoro; 

	public FrmPerfmodu(){
	
	}

	public Long getPemopefi(){
		return pemopefi;
	}
	
	public void setPemopefi(Long pemopefi){
		this.pemopefi = pemopefi;
	}

	public Long getPemomoro(){
		return pemomoro;
	}
	
	public void setPemomoro(Long pemomoro){
		this.pemomoro = pemomoro;
	}


	static public String[] getNames(){
		return new String[]{ "PEMOPEFI", "PEMOMORO" };
	}		
	
	public String toString(){
		return " PEMOPEFI: "+ this.pemopefi 
			+" PEMOMORO: "+ this.pemomoro ;
	}
}
