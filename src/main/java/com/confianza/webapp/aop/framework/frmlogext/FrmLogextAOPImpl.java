package com.confianza.webapp.aop.framework.frmlogext;

 /**                          
  *                           
  * @modifico	CONFIANZA
  * @version	1.0 
  * @Fecha		30/10/2014 
  * @since		1.0            
  * @app		framework  
  */                          

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.confianza.webapp.repository.framework.frmlogext.FrmLogextRepository;
import com.google.gson.Gson;

@Service
@Aspect
public class FrmLogextAOPImpl{
	@Autowired
	Gson gson;
	
	@Autowired
	private FrmLogextRepository frmlogextRepository;
	
	/**
	 * @return the frmlogextRepository
	 */
	public FrmLogextRepository getFrmLogextRepository() {
		return frmlogextRepository;
	}

	/**
	 * @param frmlogextRepository the frmlogextRepository to set
	 */
	public void setFrmLogextRepository(FrmLogextRepository frmlogextRepository) {
		this.frmlogextRepository = frmlogextRepository;
	}
	
					
	@Pointcut("execution(* com.confianza.webapp.controller.framework.frmconsulta.CFrmConsulta.loadRecord(..))")
	public void pointIntercepController(){		
	}	
	
	@Before("pointIntercepController()")
	public void interceptarLoadRecord(JoinPoint point) throws Throwable{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		
		String remoteAddress = request.getRemoteAddr();	
		InetAddress IP=InetAddress.getByName(remoteAddress);
		System.out.println("InetAddress.getHostAddress(): "+IP.getHostAddress());
		System.out.println("InetAddress.getHostName(): "+IP.getHostName());
		System.out.println("InetAddress.getLoopbackAddress(): "+IP.getLoopbackAddress());
		System.out.println("InetAddress.getCanonicalHostName(): "+IP.getCanonicalHostName());						
		System.out.println("InetAddress.toString(): "+IP.toString());
		System.out.println("InetAddress.getAddress(): "+IP.getAddress());		
		
		String[] HEADERS_TO_TRY = { 
		    "X-Forwarded-For",
		    "Proxy-Client-IP",
		    "WL-Proxy-Client-IP",
		    "HTTP_X_FORWARDED_FOR",
		    "HTTP_X_FORWARDED",
		    "HTTP_X_CLUSTER_CLIENT_IP",
		    "HTTP_CLIENT_IP",
		    "HTTP_FORWARDED_FOR",
		    "HTTP_FORWARDED",
		    "HTTP_VIA",
		    "REMOTE_ADDR" };
		
		String info="";
		for (String header : HEADERS_TO_TRY) {
	        info += header + ": " + request.getHeader(header) + ". ";	        
	    }	
	}
}
