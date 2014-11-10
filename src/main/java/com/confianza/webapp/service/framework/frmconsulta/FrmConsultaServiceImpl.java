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
import org.springframework.stereotype.Service;

import com.confianza.webapp.repository.framework.frmconsulta.FrmConsulta;
import com.confianza.webapp.repository.framework.frmconsulta.FrmConsultaRepository;

@Service
public class FrmConsultaServiceImpl implements FrmConsultaService{
	
	@Autowired
	private FrmConsultaRepository frmConsultaRepository;
	
	/**
	 * @return the frmconsultaRepository
	 */
	public FrmConsultaRepository getFrmConsultaRepository() {
		return frmConsultaRepository;
	}

	/**
	 * @param frmconsultaRepository the frmconsultaRepository to set
	 */
	public void setFrmConsultaRepository(FrmConsultaRepository frmconsultaRepository) {
		this.frmConsultaRepository = frmconsultaRepository;
	}
	
	@Override
	public FrmConsulta list(Long id){
		return frmConsultaRepository.list(id);
	}
	
	@Override
	public List<FrmConsulta> listAll(){
		return frmConsultaRepository.listAll();
	}	
	
	@Override
	public FrmConsulta update(Long id){
		return frmConsultaRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmConsultaRepository.delete(id);
	}
	
	@Override
	public FrmConsulta insert(FrmConsulta frmconsulta){
		return frmConsultaRepository.insert(frmconsulta);
	}
	
}
