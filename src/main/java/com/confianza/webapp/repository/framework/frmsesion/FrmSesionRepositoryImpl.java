package com.confianza.webapp.repository.framework.frmsesion;

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
public class FrmSesionRepositoryImpl implements FrmSesionRepository{
	
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
	 * Metodo de consulta para los registros de la tabla FrmSesion por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmSesion = objeto de la case FrmSesion que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmSesion list(Long id){
		try{
			String sql = "select sesicons ,sesiusua ,sesifecr ,sesiterm "
					   + "from FrmSesion "
					   + "where sesicons = :id ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmSesion.class)					
					     .setParameter("id", id);
			return (FrmSesion)query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo de consulta para los registros de la tabla FrmSesion
	 * @return FrmSesion = coleccion de objetos de la case FrmSesion que contiene los datos encontrados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<FrmSesion> listAll(){
		try{
			String sql = "select sesicons ,sesiusua ,sesifecr ,sesiterm "
					   + "from FrmSesion ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmSesion.class);
					     
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * Metodo para actualizar los datos de un registro de la tabla FrmSesion por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmSesion = objeto de la case FrmSesion que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmSesion update(Long id){
		FrmSesion frmsesion = this.list(id);
		getSession().update(frmsesion);
		return frmsesion;
	}
	
	/**
	 * Metodo para borrar un registro de la tabla FrmSesion por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmSesion = objeto de la case FrmSesion que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public void delete(Long id){
		FrmSesion frmsesion = this.list(id);
		//FrmSesion.setEstado="B";
		getSession().update(frmsesion);
	}
	
	/**
	 * Metodo para ingresar un registro de la tabla FrmSesion
	 * @value sesicons
	 * @value sesiusua
	 * @value sesifecr
	 * @value sesiterm
	 * @return FrmSesion = objeto de la case FrmSesion que contiene los datos ingresados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public void insert(FrmSesion frmsesion){
		getSession().save(frmsesion);
	}
}
