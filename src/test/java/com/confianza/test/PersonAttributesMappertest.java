/**
 * 
 */
package com.confianza.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.confianza.webapp.repository.framework.security.PersonAttributesMapper;

/**
 * @author hgonzalez
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  {"classpath:*testApplication-context.xml"})
public class PersonAttributesMappertest {
	@Autowired
	protected PersonAttributesMapper personAttributesMapper;

	/**
	 * Test method for {@link com.confianza.webapp.service.security.UserServiceImpl#loadUserByUsername(java.lang.String)}.
	 */
	@Test
	public void testPersonAttributesMapper() {
		try{
		List<String> rolesHave = new ArrayList();
		rolesHave.add("DESARROLLO");
		personAttributesMapper.loadRoles(rolesHave);		
		}catch(Exception e){
			e.printStackTrace();
			fail("Error !!! "+e.getMessage());
		}
	}

}
