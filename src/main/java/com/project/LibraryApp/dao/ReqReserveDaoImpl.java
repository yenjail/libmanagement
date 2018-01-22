package com.project.LibraryApp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.LibraryApp.model.RequestReservation;
@Repository
public class ReqReserveDaoImpl implements ReqReserveDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void insertUpdate(RequestReservation reqReg) {
		Session session = sessionFactory.getCurrentSession();
		
		session.merge(reqReg);
		session.flush();
		
		
	}

	@Override
	public List<RequestReservation> getRequest() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(RequestReservation.class);
		criteria.add(Restrictions.eq("confirm", false));
		List<RequestReservation> reserveList = (List<RequestReservation>)criteria.list();
		return reserveList;
	}

	@Override
	@Transactional
	public void delete(Long doc_code) {
		Session session = sessionFactory.getCurrentSession();
		RequestReservation reqRes = (RequestReservation)session.get(RequestReservation.class,doc_code);
		session.delete(reqRes);
		session.flush();
		
		
	}

	@Override
	public RequestReservation get(Long reqId) {
		Session session = sessionFactory.openSession();
		RequestReservation reqRes =(RequestReservation) session.get(RequestReservation.class, reqId);
		
		return reqRes;
	}

	@Override
	public List<RequestReservation> getReserved() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(RequestReservation.class);
		criteria.add(Restrictions.eq("confirm", true));
		List<RequestReservation> reserveList = (List<RequestReservation>)criteria.list();
		
		return reserveList ;
	}

}
