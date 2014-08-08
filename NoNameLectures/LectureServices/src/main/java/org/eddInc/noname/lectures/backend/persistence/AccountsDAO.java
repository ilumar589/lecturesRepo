package org.eddInc.noname.lectures.backend.persistence;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.eddInc.noname.lectures.backend.model.Accounts;

@Repository
public class AccountsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveOrUpdateAccount(Accounts account){
		
		sessionFactory.getCurrentSession().saveOrUpdate(account);
		
	}
	
	
	public void deleteAccount(Accounts account){
		
		sessionFactory.getCurrentSession().delete(account);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Accounts> getAllAccounts(){
		
		return (List<Accounts>) sessionFactory.getCurrentSession().createQuery("from Accounts").list();
		
	}
	
	
	public Accounts getAccountById(int accountId){
		
		return (Accounts) sessionFactory.getCurrentSession().createQuery("from Accounts where accountId = :param").
				setParameter("param",accountId).uniqueResult();
	}
	
	
	public Accounts getAccountByName(String accountName){
		
		return (Accounts) sessionFactory.getCurrentSession().createQuery("from Accounts where accountName = :param").
				setParameter("param",accountName).uniqueResult();
	}
	
	

}
