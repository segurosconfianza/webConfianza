package com.confianza.webapp.repository.framework.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.poi.hssf.record.formula.functions.T;

public class BaseDAO {

	protected String tableName;
	protected String objectName;        
	@Autowired
	private SessionFactory sessionFactory;			
	
	public BaseDAO(String tableName, String objectName) {
		super();
		this.tableName = tableName;
		this.objectName = objectName;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<T> findAll(String orderBy, int init, int max){
		String where="";
		
		String sql=String.format("from " + this.objectName + " %2$s ", orderBy );
		
		Query query = getSession().createQuery(sql);
        query.setFirstResult(init);
        if(max!=-1)
        	query.setMaxResults(max);
        
        List<T> list = query.list();
        
        return list;
	}
	
	public List<T> findBy(List<String[]> filter, String orderBy, int init, int max){
		String where="";
		
		if(filter!=null || !filter.isEmpty()){
			for(String[] obj:filter){
				if(where.isEmpty())
					where+=String.format("\"obj[1]\"= %1$s", obj[2]);
				else
					where+=String.format(" AND \"obj[1]\"= %1$s", obj[2]);
			}
		}
		
		String sql=String.format("from " + this.objectName + " %1$s %2$s ", filter, orderBy );
		
		Query query = getSession().createQuery(sql);
        query.setFirstResult(init);
        if(max!=-1)
        	query.setMaxResults(max);
        
        List<T> list = query.list();
        
        return list;
	}
		
}
