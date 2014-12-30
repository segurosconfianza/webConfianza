package com.confianza.test;

import static org.junit.Assert.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.confianza.webapp.controller.framework.frmconsulta.CFrmConsulta;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  {"classpath:*testApplication-context.xml"})

public class test {
	private static Log logger = LogFactory.getLog("TestMago");
	
	private CFrmConsulta consulta=new CFrmConsulta();	

	@Test
	public void testMagoAdivinador() {
		
		System.out.println("Inicio de la adivinacion");
		assertEquals("loadRecord", consulta.loadRecord(null, "1", null));		
		System.out.println("Fin de Adivinacion");
	}
}