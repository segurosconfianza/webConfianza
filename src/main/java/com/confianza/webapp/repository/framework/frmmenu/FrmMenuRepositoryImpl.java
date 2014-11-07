package com.confianza.webapp.repository.framework.frmmenu;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hgonzalez
 *
 */
@Repository
public class FrmMenuRepositoryImpl implements FrmMenuRepository{
	
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
		
	@Override
	@Transactional
	public List<Object[]> loadMenu(List<String> roles) {
		try{
			String sql = "select menucons,menupadr,menumodu,menuicon,menutitu,menuorde,menuesta,moducons,moduapli,modunomb,modunemo,modudurl "
					   + "from frm_modulo "
					   + "join frm_menu  on (menumodu=moducons) "
					   + "where modunomb in (:roles) and menuesta='A' and menupadr is null "
					   + "order by menuorde ";
						
			Query query = getSession().createSQLQuery(sql)					
					     .setParameterList("roles", roles);
					
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
