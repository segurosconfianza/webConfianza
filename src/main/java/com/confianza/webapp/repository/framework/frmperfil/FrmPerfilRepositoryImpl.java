package com.confianza.webapp.repository.framework.frmperfil;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FrmPerfilRepositoryImpl implements FrmPerfilRepository{
	
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
	 * Metodo de consulta para los registros de la tabla FrmPerfil por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmPerfil = objeto de la case FrmPerfil que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmPerfil list(Long id){
		try{
			String sql = "select peficons ,pefinomb ,pefidesc ,pefifecr, pefiesta "
					   + "from FrmPerfil "
					   + "where peficons = :id ";
						
			Query query = getSession().createQuery(sql)				
					     .setParameter("id", id);
			return (FrmPerfil)query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo de consulta para los registros de la tabla FrmPerfil
	 * @return FrmPerfil = coleccion de objetos de la case FrmPerfil que contiene los datos encontrados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public List<FrmPerfil> listAll(int init, int limit){
		try{
			String sql = "select peficons ,pefinomb ,pefidesc ,pefifecr, pefiesta "
					   + "from Frm_Perfil order by peficons";
						
			Query query = getSession().createSQLQuery(sql).addEntity(FrmPerfil.class);
			if(init==0 && limit!=0){
				query.setFirstResult(init);			
				query.setMaxResults(limit);
			}
	        
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo de consulta para el conteo de los registros de la tabla FrmPerfil
	 * @return int = cantidad de registros encontrados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public int getCount(){
		try{
			String sql = "select count(*) "
					   + "from FrmPerfil ";
						
			Query query = getSession().createQuery(sql);
	        
			Iterator it = query.list().iterator();
	        Long ret = new Long(0);
	        
	        if (it != null)
		        if (it.hasNext()){
		        	ret = (Long) it.next();
		        }
	        
			return ret.intValue();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Metodo para actualizar los datos de un registro de la tabla FrmPerfil por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmPerfil = objeto de la case FrmPerfil que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmPerfil update(FrmPerfil frmPerfil){
		getSession().update(frmPerfil);
		return frmPerfil;
	}
	
	/**
	 * Metodo para borrar un registro de la tabla FrmPerfil por id
	 * @value id = id de la llave primaria a consultar el registro
	 * @return FrmPerfil = objeto de la case FrmPerfil que contiene los datos encontrados dado el id
	 * @throws Exception
	 */
	@Override
	@Transactional
	public void delete(Long id){
		FrmPerfil frmperfil = this.list(id);
		//FrmPerfil.setEstado="B";
		getSession().update(frmperfil);
	}
	
	/**
	 * Metodo para ingresar un registro de la tabla FrmPerfil
	 * @value peficons
	 * @value pefinomb
	 * @value pefidesc
	 * @value pefifecr
	 * @return FrmPerfil = objeto de la case FrmPerfil que contiene los datos ingresados
	 * @throws Exception
	 */
	@Override
	@Transactional
	public FrmPerfil insert(FrmPerfil frmperfil){
		getSession().save(frmperfil);
		return frmperfil;
	}

	@Override
	public void delete(FrmPerfil frmperfil) {
		// TODO Auto-generated method stub
		
	}
}
