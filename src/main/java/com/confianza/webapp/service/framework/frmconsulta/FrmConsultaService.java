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
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.confianza.webapp.repository.framework.frmconsulta.FrmConsulta;
import com.confianza.webapp.repository.framework.frmparametro.FrmParametro;

public interface FrmConsultaService{
	
	public String list(Long id);
	
	public String listAll(int pageSize, int page);	
	
	public String insert(FrmConsulta frmconsulta);
	
	public String update(FrmConsulta frmconsulta);
	
	public void delete(FrmConsulta frmconsulta);	
	
	public int getCount();

	public FrmConsulta listName(String conscons);

	public List<Object[]> loadData(FrmConsulta frmConsulta, Map<String, Object> parameters);

	public FrmConsulta listProcedureChild(String id);

	public Map<String, Object> loadProcedure(FrmConsulta frmConsulta,	List<FrmParametro> parametros, Map<String, Object> parameters, Map<String, Object> parametersData);

	public String updateRecord(String conscons, String params, String paramsData);

	public String listCombo(String conscons);

	public String listComboDynamic(String conscons);

	public FrmConsulta listChild(String id);

	public String loadConsChield(String conscons);

	public String loadRecord(HttpServletRequest request, Long conscons, String params);

	public FrmConsulta listEntity(Long id);

	public String loadData(Long conscons);
	
}
