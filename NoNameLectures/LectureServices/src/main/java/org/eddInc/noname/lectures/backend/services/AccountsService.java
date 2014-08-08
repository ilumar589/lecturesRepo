package org.eddInc.noname.lectures.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.eddInc.noname.lectures.backend.model.Accounts;
import org.eddInc.noname.lectures.backend.persistence.AccountsDAO;
import org.eddInc.noname.lectures.backend.services.util.AbstractAuthenticationManager;

@Service
@Transactional(readOnly = true)
public class AccountsService extends AbstractAuthenticationManager {
	
	@Autowired
	private AccountsDAO accountsDao;
	
	
	
	public Authentication login(String accountName,String password){
		
		try{
			
			Authentication authObj = getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(accountName,password));
			if(authObj.isAuthenticated()){
				
				 SecurityContextHolder.getContext().setAuthentication(authObj);
	             return authObj;
			}else{
				
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}
	
	
	@Transactional(readOnly = false)
	public void saveOrUpdateAccount(Accounts account){
		
		accountsDao.saveOrUpdateAccount(account);
		
		
	}
	
	public void deleteAccount(Accounts account){
		
		accountsDao.deleteAccount(account);
	}
	
	
	public List<Accounts> getAllAccounts(){
		
		return accountsDao.getAllAccounts();
	}
	
	
	public Accounts getAccountById(Accounts account){
		
		return accountsDao.getAccountById(account.getAccountId());
	}
	
	public Accounts getAccountByName(String accountName){
		
		return accountsDao.getAccountByName(accountName);
	}

}
