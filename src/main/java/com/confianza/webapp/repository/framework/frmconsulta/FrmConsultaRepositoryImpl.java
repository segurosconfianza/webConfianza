package com.confianza.webapp.repository.framework.frmconsulta;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public class FrmConsultaRepositoryImpl implements FrmConsultaRepository{
	
	@Autowired
	private SessionFactory sessionFactory;  	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Metodo de consulta para los registros de la tabla FrmConsulta por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmConsulta = objeto de la case FrmConsulta que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmConsulta list(Long id){
		try{
			String sql = "select conscons ,consmodu ,consnomb ,consdesc ,conscaco ,constipo ,conslsql ,conscolu ,constico "
					   + "from FrmConsulta "
					   + "where conscons = :id ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmConsulta.class)					
					     .setParameter("id", id);
			return (FrmConsulta)query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo de consulta para los registros de la tabla FrmConsulta
	 * @return FrmConsulta = coleccion de objetos de la case FrmConsulta que contiene los datos encontrados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<FrmConsulta> listAll(){
		try{
			String sql = "select conscons ,consmodu ,consnomb ,consdesc ,conscaco ,constipo ,conslsql ,conscolu ,constico "
					   + "from FrmConsulta ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmConsulta.class);
					     
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * Metodo para actualizar los datos de un registro de la tabla FrmConsulta por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmConsulta = objeto de la case FrmConsulta que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmConsulta update(Long id){
		FrmConsulta frmconsulta = this.list(id);
		getSession().update(frmconsulta);
		return frmconsulta;
	}
	
	/**
	 * Metodo para borrar un registro de la tabla FrmConsulta por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmConsulta = objeto de la case FrmConsulta que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public void delete(Long id){
		FrmConsulta frmconsulta = this.list(id);
		//FrmConsulta.setEstado="B";
		getSession().update(frmconsulta);
	}
	
	/**
	 * Metodo para ingresar un registro de la tabla FrmConsulta
	 * @value conscons
	 * @value consmodu
	 * @value consnomb
	 * @value consdesc
	 * @value conscaco
	 * @value constipo
	 * @value conslsql
	 * @value conscolu
	 * @value constico
	 * @return FrmConsulta = objeto de la case FrmConsulta que contiene los datos ingresados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmConsulta insert(FrmConsulta frmconsulta){
		//getSession().insert(frmconsulta);
		return frmconsulta;
	}
}
