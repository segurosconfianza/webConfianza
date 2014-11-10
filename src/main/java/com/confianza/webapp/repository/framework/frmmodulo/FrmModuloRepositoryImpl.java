package com.confianza.webapp.repository.framework.frmmodulo;

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
public class FrmModuloRepositoryImpl implements FrmModuloRepository{
	
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
	 * Metodo de consulta para los registros de la tabla FrmModulo por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmModulo = objeto de la case FrmModulo que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmModulo list(Long id){
		try{
			String sql = "select moducons ,moduapli ,modunomb ,modunemo ,modudurl "
					   + "from FrmModulo "
					   + "where moducons = :id ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmModulo.class)					
					     .setParameter("id", id);
			return (FrmModulo)query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo de consulta para los registros de la tabla FrmModulo
	 * @return FrmModulo = coleccion de objetos de la case FrmModulo que contiene los datos encontrados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<FrmModulo> listAll(){
		try{
			String sql = "select moducons ,moduapli ,modunomb ,modunemo ,modudurl "
					   + "from FrmModulo ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmModulo.class);
					     
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * Metodo para actualizar los datos de un registro de la tabla FrmModulo por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmModulo = objeto de la case FrmModulo que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmModulo update(Long id){
		FrmModulo frmmodulo = this.list(id);
		getSession().update(frmmodulo);
		return frmmodulo;
	}
	
	/**
	 * Metodo para borrar un registro de la tabla FrmModulo por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmModulo = objeto de la case FrmModulo que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public void delete(Long id){
		FrmModulo frmmodulo = this.list(id);
		//FrmModulo.setEstado="B";
		getSession().update(frmmodulo);
	}
	
	/**
	 * Metodo para ingresar un registro de la tabla FrmModulo
	 * @value moducons
	 * @value moduapli
	 * @value modunomb
	 * @value modunemo
	 * @value modudurl
	 * @return FrmModulo = objeto de la case FrmModulo que contiene los datos ingresados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmModulo insert(FrmModulo frmmodulo){
		//getSession().insert(frmmodulo);
		return frmmodulo;
	}
}
