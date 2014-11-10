package com.confianza.webapp.repository.framework.frmpkid;

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
public class FrmPkidRepositoryImpl implements FrmPkidRepository{
	
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
	 * Metodo de consulta para los registros de la tabla FrmPkid por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmPkid = objeto de la case FrmPkid que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmPkid list(Long id){
		try{
			String sql = "select pkidcons ,pkidnomb ,pkidvalu "
					   + "from FrmPkid "
					   + "where pkidcons = :id ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmPkid.class)					
					     .setParameter("id", id);
			return (FrmPkid)query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo de consulta para los registros de la tabla FrmPkid
	 * @return FrmPkid = coleccion de objetos de la case FrmPkid que contiene los datos encontrados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<FrmPkid> listAll(){
		try{
			String sql = "select pkidcons ,pkidnomb ,pkidvalu "
					   + "from FrmPkid ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmPkid.class);
					     
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * Metodo para actualizar los datos de un registro de la tabla FrmPkid por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmPkid = objeto de la case FrmPkid que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmPkid update(Long id){
		FrmPkid frmpkid = this.list(id);
		getSession().update(frmpkid);
		return frmpkid;
	}
	
	/**
	 * Metodo para borrar un registro de la tabla FrmPkid por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmPkid = objeto de la case FrmPkid que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public void delete(Long id){
		FrmPkid frmpkid = this.list(id);
		//FrmPkid.setEstado="B";
		getSession().update(frmpkid);
	}
	
	/**
	 * Metodo para ingresar un registro de la tabla FrmPkid
	 * @value pkidcons
	 * @value pkidnomb
	 * @value pkidvalu
	 * @return FrmPkid = objeto de la case FrmPkid que contiene los datos ingresados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmPkid insert(FrmPkid frmpkid){
		//getSession().insert(frmpkid);
		return frmpkid;
	}
}
