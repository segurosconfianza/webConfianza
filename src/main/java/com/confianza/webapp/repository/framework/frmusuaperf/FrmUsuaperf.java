package com.confianza.webapp.repository.framework.frmusuaperf;

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
@Table(name = "FRM_USUAPERF")
public class FrmUsuaperf {
	@Id 
	@Column(name = "USPEUSUA")
	protected Long uspeusua; 
	
	@Column(name = "USPEPEFI")
	protected Long uspepefi; 

	public FrmUsuaperf(){
	
	}

	public Long getUspeusua(){
		return uspeusua;
	}
	
	public void setUspeusua(Long uspeusua){
		this.uspeusua = uspeusua;
	}

	public Long getUspepefi(){
		return uspepefi;
	}
	
	public void setUspepefi(Long uspepefi){
		this.uspepefi = uspepefi;
	}


	static public String[] getNames(){
		return new String[]{ "USPEUSUA", "USPEPEFI" };
	}		
	
	public String toString(){
		return " USPEUSUA: "+ this.uspeusua 
			+" USPEPEFI: "+ this.uspepefi ;
	}
}
