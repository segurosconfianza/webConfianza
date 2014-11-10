package com.confianza.webapp.repository.framework.frmmodurope;

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
public class FrmModuropeRepositoryImpl implements FrmModuropeRepository{
	
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
	 * Metodo de consulta para los registros de la tabla FrmModurope por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmModurope = objeto de la case FrmModurope que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmModurope list(Long id){
		try{
			String sql = "select morocons ,moromodu ,mororope "
					   + "from FrmModurope "
					   + "where morocons = :id ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmModurope.class)					
					     .setParameter("id", id);
			return (FrmModurope)query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo de consulta para los registros de la tabla FrmModurope
	 * @return FrmModurope = coleccion de objetos de la case FrmModurope que contiene los datos encontrados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<FrmModurope> listAll(){
		try{
			String sql = "select morocons ,moromodu ,mororope "
					   + "from FrmModurope ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmModurope.class);
					     
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * Metodo para actualizar los datos de un registro de la tabla FrmModurope por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmModurope = objeto de la case FrmModurope que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmModurope update(Long id){
		FrmModurope frmmodurope = this.list(id);
		getSession().update(frmmodurope);
		return frmmodurope;
	}
	
	/**
	 * Metodo para borrar un registro de la tabla FrmModurope por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmModurope = objeto de la case FrmModurope que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public void delete(Long id){
		FrmModurope frmmodurope = this.list(id);
		//FrmModurope.setEstado="B";
		getSession().update(frmmodurope);
	}
	
	/**
	 * Metodo para ingresar un registro de la tabla FrmModurope
	 * @value morocons
	 * @value moromodu
	 * @value mororope
	 * @return FrmModurope = objeto de la case FrmModurope que contiene los datos ingresados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmModurope insert(FrmModurope frmmodurope){
		//getSession().insert(frmmodurope);
		return frmmodurope;
	}
}
