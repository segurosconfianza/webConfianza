package com.confianza.webapp.repository.framework.frmmenu;

import java.util.List;

public interface FrmMenuRepository {
	
	public List<Object[]> loadMenu(List<String> roles);
}
