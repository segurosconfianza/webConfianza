package com.confianza.webapp.service.security;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.confianza.webapp.repository.framework.security.Person;
import com.confianza.webapp.repository.framework.security.PersonAttributesMapperImpl;

public class AutenticateImpl implements AuthenticationProvider {

	@Autowired
	private LdapTemplate ldapTemplate;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException  {
		
		String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        
		boolean authenticated = this.authenticate(username, password);
		
		List<GrantedAuthority> autorities = new ArrayList<GrantedAuthority>();
			
		if(authenticated)
		{
			List<Person> lista = null;
			lista =  ldapTemplate.search(query().	  
	        		 filter("(&(objectClass=person)(sAMAccountName="+username+"))"),
	        		 new PersonAttributesMapperImpl());
			
			return new UsernamePasswordAuthenticationToken(username, password, autorities);
		}
		else
			return null;
	}
	
	public boolean authenticate(String username, String credentials) {
		return ldapTemplate.authenticate("", "(&(objectClass=person)(sAMAccountName="+username+"))", credentials);		
	}

	/**
	 * @return the ldapTemplate
	 */
	public LdapTemplate getLdapTemplate() {
		return ldapTemplate;
	}

	/**
	 * @param ldapTemplate the ldapTemplate to set
	 */
	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
