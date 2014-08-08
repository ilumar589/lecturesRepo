package org.eddInc.noname.lectures.backend.services.util;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import org.eddInc.noname.lectures.backend.model.Accounts;



@Service
public class CustomUserDetails implements UserDetails,Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7124103710830678686L;

	private Accounts account;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	private String password;
	
	private String username;
	
	private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;
    
    
    
    
    public CustomUserDetails(){};
    
    public CustomUserDetails(Accounts account,
    						 String username,
    						 String password,
    						 boolean accountNonExpired,
    						 boolean accountNonLocked,
    						 boolean credentialsNonExpired,
    						 boolean enabled,
    						 Collection<? extends GrantedAuthority> authorities){
    	
    	this.account = account;
    	this.username = username;
    	this.password = password;
    	this.accountNonExpired = accountNonExpired;
    	this.accountNonLocked = accountNonLocked;
    	this.credentialsNonExpired = credentialsNonExpired;
    	this.enabled = enabled;
    	this.authorities = authorities;
    	
    	
    }
	
	
	
	public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return this.authorities;
	}

	@Override
	public String getPassword() {

		return this.password;
	}

	@Override
	public String getUsername() {

		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {

		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {


		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {

		return this.enabled;
	}
	
	

}
