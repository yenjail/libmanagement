package com.project.LibraryApp.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.project.LibraryApp.model.Document;
import com.project.LibraryApp.model.Transaction;

@Repository
public class BorrowDaoImpl implements BorrowDao{
	
	@Resource
	private SessionFactory sessionFactory;

	
	@Override
	public void insertupdate(Transaction trans) {
		Session session = sessionFactory.getCurrentSession();
		
		
		session.merge(trans);
		
		
		session.flush();
	}

	@Override
	public void returnBorrow(Long id) {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public List<Transaction> getAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Transaction.class);
		criteria.add(Restrictions.eq("returnStatus", false));
		List<Transaction> transList = (List<Transaction>) criteria.list(); 
		return transList;
	}

	@Override
	public Transaction get(Long id) {
		Session session = sessionFactory.openSession();
		Transaction trans = (Transaction)session.get(Transaction.class, id);
		
		return trans;
	}

}
