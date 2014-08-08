package org.eddInc.noname.lectures.backend.services.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.eddInc.noname.lectures.backend.model.Accounts;
import org.eddInc.noname.lectures.backend.services.AccountsService;

@Service("customUserDetailsService")
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private AccountsService accountService;
	
	public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException{

		Accounts retAccount = accountService.getAccountByName(accountName);	
		if(retAccount==null){
			
			throw new BadCredentialsException("This account does not exist!");
		}
		
		 boolean enabled = true;
         boolean accountNonExpired = true;
         boolean credentialsNonExpired = true;
         boolean accountNonLocked = true;
         
         return new CustomUserDetails(retAccount,
        		                      retAccount.getAccountName(),
        		                      retAccount.getPassword(),
        		                      accountNonExpired,
        		                      accountNonLocked,
        		                      credentialsNonExpired,
        		                      enabled,
        		                      getAuthorities(retAccount.getRole().getRoleId()));
		
	}
	
	
	
	public Collection<? extends GrantedAuthority> getAuthorities(int role){
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }
	
	public List<String> getRoles(int roleId){
		List<String> roles = new ArrayList<String>();
		if(roleId==1){
			
			roles.add(Constants.ADMIN);
		}
		if(roleId==2){
			roles.add(Constants.NORMAL_USER);
		}
		
		return roles;
		
	}
	
	  public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles){
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        for (String role : roles){
	            authorities.add(new SimpleGrantedAuthority(role));
	        }
	        return authorities;
	    }
	

}
