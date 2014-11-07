package com.confianza.webapp.service.framework.frmtablas;

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

import com.confianza.webapp.repository.framework.frmtablas.FrmTablas;
import com.confianza.webapp.repository.framework.frmtablas.FrmTablasRepository;

public class FrmTablasServiceImpl implements FrmTablasService{
	
	@Autowired
	private FrmTablasRepository frmtablasRepository;
	
	/**
	 * @return the frmtablasRepository
	 */
	public FrmTablasRepository getFrmTablasRepository() {
		return frmtablasRepository;
	}

	/**
	 * @param frmtablasRepository the frmtablasRepository to set
	 */
	public void setFrmTablasRepository(FrmTablasRepository frmtablasRepository) {
		this.frmtablasRepository = frmtablasRepository;
	}
	
	@Override
	public FrmTablas list(Long id){
		return frmtablasRepository.list(id);
	}
	
	@Override
	public List<FrmTablas> listAll(){
		return frmtablasRepository.listAll();
	}	
	
	@Override
	public FrmTablas update(Long id){
		return frmtablasRepository.update(id);
	}
	
	@Override
	public void delete(Long id){
		frmtablasRepository.delete(id);
	}
	
	@Override
	public FrmTablas insert(FrmTablas frmtablas){
		return frmtablasRepository.insert(frmtablas);
	}
	
}
