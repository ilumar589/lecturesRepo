package org.eddInc.noname.lectures.backend.services.util;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;

public abstract class AbstractAuthenticationManager {
	
	@Resource(name = "authenticationManager")
	private AuthenticationManager authenticationManager;

	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	
	
	
}
