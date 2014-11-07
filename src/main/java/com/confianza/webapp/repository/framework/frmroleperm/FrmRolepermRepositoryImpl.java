package com.confianza.webapp.repository.framework.frmroleperm;

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

public class FrmRolepermRepositoryImpl implements FrmRolepermRepository{
	
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
	 * Metodo de consulta para los registros de la tabla FrmRoleperm por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmRoleperm = objeto de la case FrmRoleperm que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmRoleperm list(Long id){
		try{
			String sql = "select ropecons ,ropenomb ,ropedesc ,ropetipo "
					   + "from FrmRoleperm "
					   + "where ropecons = :id ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmRoleperm.class)					
					     .setParameter("id", id);
			return (FrmRoleperm)query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo de consulta para los registros de la tabla FrmRoleperm
	 * @return FrmRoleperm = coleccion de objetos de la case FrmRoleperm que contiene los datos encontrados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<FrmRoleperm> listAll(){
		try{
			String sql = "select ropecons ,ropenomb ,ropedesc ,ropetipo "
					   + "from FrmRoleperm ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmRoleperm.class);
					     
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * Metodo para actualizar los datos de un registro de la tabla FrmRoleperm por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmRoleperm = objeto de la case FrmRoleperm que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmRoleperm update(Long id){
		FrmRoleperm frmroleperm = this.list(id);
		getSession().update(frmroleperm);
		return frmroleperm;
	}
	
	/**
	 * Metodo para borrar un registro de la tabla FrmRoleperm por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmRoleperm = objeto de la case FrmRoleperm que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public void delete(Long id){
		FrmRoleperm frmroleperm = this.list(id);
		//FrmRoleperm.setEstado="B";
		getSession().update(frmroleperm);
	}
	
	/**
	 * Metodo para ingresar un registro de la tabla FrmRoleperm
	 * @value ropecons
	 * @value ropenomb
	 * @value ropedesc
	 * @value ropetipo
	 * @return FrmRoleperm = objeto de la case FrmRoleperm que contiene los datos ingresados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmRoleperm insert(FrmRoleperm frmroleperm){
		//getSession().insert(frmroleperm);
		return frmroleperm;
	}
}
