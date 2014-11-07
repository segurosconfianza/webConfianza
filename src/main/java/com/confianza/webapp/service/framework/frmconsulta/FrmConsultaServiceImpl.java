package com.confianza.webapp.service.framework.frmconsulta;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.confianza.webapp.repository.framework.frmconsulta.FrmConsulta;
import com.confianza.webapp.repository.framework.frmconsulta.FrmConsultaRepository;

public class FrmConsultaServiceImpl implements FrmConsultaService{
	
	@Autowired
	private FrmConsultaRepository frmconsultaRepository;
	
	/**
	 * @return the frmconsultaRepository
	 */
	public FrmConsultaRepository getFrmConsultaRepository() {
		return frmconsultaRepository;
	}

	/**
	 * @param frmconsultaRepository the frmconsultaRepository to set
	 */
	public void setFrmConsultaRepository(FrmConsultaRepository frmconsultaRepository) {
		this.frmconsultaRepository = frmconsultaRepository;
	}
	
	@Override
	public FrmConsulta list(Long id){
		return frmconsultaRepository.list(id);
	}
	
	@Override
	public List<FrmConsulta> listAll(){
		return frmconsultaRepository.listAll();
	}	
	
	@Override
	public FrmConsulta update(Long id){
		return frmconsultaRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmconsultaRepository.delete(id);
	}
	
	@Override
	public FrmConsulta insert(FrmConsulta frmconsulta){
		return frmconsultaRepository.insert(frmconsulta);
	}
	
}
