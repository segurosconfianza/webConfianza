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

import com.confianza.webapp.repository.framework.frmlogext.FrmLogext;
import com.confianza.webapp.repository.framework.frmlogext.FrmLogextRepository;
import com.confianza.webapp.service.framework.frmlogext.FrmLogextService;
import com.google.gson.Gson;

@Service
@Aspect
public class FrmLogextAOPImpl{
	@Autowired
	Gson gson;
	
	@Autowired
	private FrmLogextService frmlogextService;
					
	@Pointcut("execution(* com.confianza.webapp.controller.framework.frmconsulta.CFrmConsulta.loadRecord(..))")
	public void pointIntercepController(){		
	}	
	
	@Around("pointIntercepController()")
	public String interceptarLoadRecord(ProceedingJoinPoint point) throws Throwable{
		
		String data=(String) point.proceed();
		
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
		for (String header : HEADERS_TO_TRY) 
	        info += header + ": " + request.getHeader(header) + ". ";	        
	    
		FrmLogext frmLogext=new FrmLogext();
		frmLogext.setLoexacci("1");
		frmLogext.setLoexdaco("InetAddress.getHostAddress(): "+IP.getHostAddress()+" InetAddress.getHostName(): "+IP.getHostName()+" InetAddress.getLoopbackAddress(): "+IP.getLoopbackAddress()+" InetAddress.getCanonicalHostName(): "+IP.getCanonicalHostName()+" InetAddress.toString(): "+IP.toString()+" InetAddress.getAddress(): "+IP.getAddress()+info);
		frmLogext.setLoexdata("Argumentos: "+point.getArgs()[2]+" Datos Cargados: "+data);
		frmLogext.setLoexfecr(new Date());
		frmLogext.setLoextabl("consulta: "+point.getArgs()[1]);
		frmlogextService.insert(frmLogext);
		
		return data;
	}
}
