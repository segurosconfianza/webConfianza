package com.confianza.webapp.repository.framework.frmaplicaciones;

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

@Repository
public class FrmAplicacionesRepositoryImpl implements FrmAplicacionesRepository{
	
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
	 * Metodo de consulta para los registros de la tabla FrmAplicaciones por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmAplicaciones = objeto de la case FrmAplicaciones que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmAplicaciones list(Long id){
		try{
			String sql = "select aplicons ,aplinomb ,aplidesc ,apliesta ,aplifecr "
					   + "from FrmAplicaciones "
					   + "where aplicons = :id ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmAplicaciones.class)					
					     .setParameter("id", id);
			return (FrmAplicaciones)query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo de consulta para los registros de la tabla FrmAplicaciones
	 * @return FrmAplicaciones = coleccion de objetos de la case FrmAplicaciones que contiene los datos encontrados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<FrmAplicaciones> listAll(){
		try{
			String sql = "select aplicons ,aplinomb ,aplidesc ,apliesta ,aplifecr "
					   + "from FrmAplicaciones ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmAplicaciones.class);
					     
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * Metodo para actualizar los datos de un registro de la tabla FrmAplicaciones por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmAplicaciones = objeto de la case FrmAplicaciones que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmAplicaciones update(Long id){
		FrmAplicaciones frmaplicaciones = this.list(id);
		getSession().update(frmaplicaciones);
		return frmaplicaciones;
	}
	
	/**
	 * Metodo para borrar un registro de la tabla FrmAplicaciones por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmAplicaciones = objeto de la case FrmAplicaciones que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public void delete(Long id){
		FrmAplicaciones frmaplicaciones = this.list(id);
		//FrmAplicaciones.setEstado="B";
		getSession().update(frmaplicaciones);
	}
	
	/**
	 * Metodo para ingresar un registro de la tabla FrmAplicaciones
	 * @value aplicons
	 * @value aplinomb
	 * @value aplidesc
	 * @value apliesta
	 * @value aplifecr
	 * @return FrmAplicaciones = objeto de la case FrmAplicaciones que contiene los datos ingresados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmAplicaciones insert(FrmAplicaciones frmaplicaciones){
		//getSession().insert(frmaplicaciones);
		return frmaplicaciones;
	}
}
