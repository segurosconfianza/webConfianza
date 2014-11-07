package com.confianza.webapp.repository.framework.frmparametro;

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

public class FrmParametroRepositoryImpl implements FrmParametroRepository{
	
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
	 * Metodo de consulta para los registros de la tabla FrmParametro por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmParametro = objeto de la case FrmParametro que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmParametro list(Long id){
		try{
			String sql = "select paracons ,paracosu ,paranomb ,paratipo ,paratida ,paracomb "
					   + "from FrmParametro "
					   + "where paracons = :id ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmParametro.class)					
					     .setParameter("id", id);
			return (FrmParametro)query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo de consulta para los registros de la tabla FrmParametro
	 * @return FrmParametro = coleccion de objetos de la case FrmParametro que contiene los datos encontrados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<FrmParametro> listAll(){
		try{
			String sql = "select paracons ,paracosu ,paranomb ,paratipo ,paratida ,paracomb "
					   + "from FrmParametro ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmParametro.class);
					     
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * Metodo para actualizar los datos de un registro de la tabla FrmParametro por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmParametro = objeto de la case FrmParametro que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmParametro update(Long id){
		FrmParametro frmparametro = this.list(id);
		getSession().update(frmparametro);
		return frmparametro;
	}
	
	/**
	 * Metodo para borrar un registro de la tabla FrmParametro por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmParametro = objeto de la case FrmParametro que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public void delete(Long id){
		FrmParametro frmparametro = this.list(id);
		//FrmParametro.setEstado="B";
		getSession().update(frmparametro);
	}
	
	/**
	 * Metodo para ingresar un registro de la tabla FrmParametro
	 * @value paracons
	 * @value paracosu
	 * @value paranomb
	 * @value paratipo
	 * @value paratida
	 * @value paracomb
	 * @return FrmParametro = objeto de la case FrmParametro que contiene los datos ingresados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmParametro insert(FrmParametro frmparametro){
		//getSession().insert(frmparametro);
		return frmparametro;
	}
}
