package com.confianza.webapp.repository.framework.frmestaproc;

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
public class FrmEstaprocRepositoryImpl implements FrmEstaprocRepository{
	
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
	 * Metodo de consulta para los registros de la tabla FrmEstaproc por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmEstaproc = objeto de la case FrmEstaproc que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmEstaproc list(Long id){
		try{
			String sql = "select esprcons ,esprproc ,esprporc ,esprdesc ,esprerro ,espruser ,esprfecr ,espresta "
					   + "from FrmEstaproc "
					   + "where esprcons = :id ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmEstaproc.class)					
					     .setParameter("id", id);
			return (FrmEstaproc)query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo de consulta para los registros de la tabla FrmEstaproc
	 * @return FrmEstaproc = coleccion de objetos de la case FrmEstaproc que contiene los datos encontrados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<FrmEstaproc> listAll(){
		try{
			String sql = "select esprcons ,esprproc ,esprporc ,esprdesc ,esprerro ,espruser ,esprfecr ,espresta "
					   + "from FrmEstaproc ";
						
			Query query = getSession().createSQLQuery(sql)
						 .addEntity(FrmEstaproc.class);
					     
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
	
	/**
	 * Metodo para actualizar los datos de un registro de la tabla FrmEstaproc por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmEstaproc = objeto de la case FrmEstaproc que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmEstaproc update(Long id){
		FrmEstaproc frmestaproc = this.list(id);
		getSession().update(frmestaproc);
		return frmestaproc;
	}
	
	/**
	 * Metodo para borrar un registro de la tabla FrmEstaproc por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmEstaproc = objeto de la case FrmEstaproc que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public void delete(Long id){
		FrmEstaproc frmestaproc = this.list(id);
		//FrmEstaproc.setEstado="B";
		getSession().update(frmestaproc);
	}
	
	/**
	 * Metodo para ingresar un registro de la tabla FrmEstaproc
	 * @value esprcons
	 * @value esprproc
	 * @value esprporc
	 * @value esprdesc
	 * @value esprerro
	 * @value espruser
	 * @value esprfecr
	 * @value espresta
	 * @return FrmEstaproc = objeto de la case FrmEstaproc que contiene los datos ingresados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmEstaproc insert(FrmEstaproc frmestaproc){
		//getSession().insert(frmestaproc);
		return frmestaproc;
	}
}
