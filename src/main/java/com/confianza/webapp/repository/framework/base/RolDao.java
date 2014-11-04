package com.confianza.webapp.repository.framework.base;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Resource
public class RolDao {
	
	@Autowired
	private DataSource dataSource;
	
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
	
	public List<Object[]> findRoles(List<String> perfiles)
	{
		System.out.println("loadRoles");		
		try{
			String sql = "select frm_modurope.* "
					   + "from frm_perfil "
					   + "join frm_perfmodu on (pemopefi=peficons) "
					   + "join frm_modurope on (morocons=pemomoro) "
					   + "where pefinomb in (:perfiles)";
			
			/*Query query = dataSource.getSession().createSQLQuery(sql)						 
					         .addScalar("moromodu", StringType.INSTANCE)
					         .addScalar("mororope", StringType.INSTANCE)
					         .setParameterList("perfiles", perfiles);
			*/
			Query query = getSession().createSQLQuery(sql)					
					     .setParameterList("perfiles", perfiles);
			
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}
