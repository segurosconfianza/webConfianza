package com.confianza.webapp.repository.framework.frmperfmodu;

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

public class FrmPerfmoduRepositoryImpl implements FrmPerfmoduRepository{
	
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
	 * Metodo de consulta para los registros de la tabla FrmPerfmodu por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmPerfmodu = objeto de la case FrmPerfmodu que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmPerfmodu list(Long id){
		try{
			String sql = "select pemopefi ,pemomoro "
					   + "from FrmPerfmodu "
					   + "where  = :id ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmPerfmodu.class)					
					     .setParameter("id", id);
			return (FrmPerfmodu)query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo de consulta para los registros de la tabla FrmPerfmodu
	 * @return FrmPerfmodu = coleccion de objetos de la case FrmPerfmodu que contiene los datos encontrados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<FrmPerfmodu> listAll(){
		try{
			String sql = "select pemopefi ,pemomoro "
					   + "from FrmPerfmodu ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmPerfmodu.class);
					     
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * Metodo para actualizar los datos de un registro de la tabla FrmPerfmodu por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmPerfmodu = objeto de la case FrmPerfmodu que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmPerfmodu update(Long id){
		FrmPerfmodu frmperfmodu = this.list(id);
		getSession().update(frmperfmodu);
		return frmperfmodu;
	}
	
	/**
	 * Metodo para borrar un registro de la tabla FrmPerfmodu por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmPerfmodu = objeto de la case FrmPerfmodu que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public void delete(Long id){
		FrmPerfmodu frmperfmodu = this.list(id);
		//FrmPerfmodu.setEstado="B";
		getSession().update(frmperfmodu);
	}
	
	/**
	 * Metodo para ingresar un registro de la tabla FrmPerfmodu
	 * @value pemopefi
	 * @value pemomoro
	 * @return FrmPerfmodu = objeto de la case FrmPerfmodu que contiene los datos ingresados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmPerfmodu insert(FrmPerfmodu frmperfmodu){
		//getSession().insert(frmperfmodu);
		return frmperfmodu;
	}
}
