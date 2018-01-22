package com.project.LibraryApp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.LibraryApp.model.Reader;
@Repository
public class ReaderDaoImpl implements ReaderDao {
	
	@Resource
	private SessionFactory sessionFactory;
	

	@Override
	@Transactional
	public void insertUpdate(Reader read) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(read); //save or update
		
	
		session.flush();
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Reader read = (Reader)session.get(Reader.class, id);
		read.setStatus(false);
		session.flush();
		
	}

	@Override
	public Reader get(Long id) {
		Session session = sessionFactory.openSession();
		Reader read =(Reader) session.get(Reader.class, id);
		return read;
	}

	@Override
	public List<Reader> getAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Reader.class); //select * from student
		criteria.add(Restrictions.eq("status", true));
		
//		criteria.add(Restrictions.eq("username", "yenjail"));
//		criteria.add(Restrictions.isNotNull("email"));
		
		List<Reader> readerList = (List<Reader>)criteria.list();
		
		//List<Reader> readerList = (List<Reader>)criteria.uniqueResult();
		return readerList;
	}

	@Override
	public List<Reader> get2(String username) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Reader.class);
		criteria.add(Restrictions.eq("username", username));
		List<Reader> readerId = (List<Reader>)criteria.list();
		return readerId;
	}

	
}
