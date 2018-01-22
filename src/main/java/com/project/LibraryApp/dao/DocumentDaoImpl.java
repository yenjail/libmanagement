package com.project.LibraryApp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.LibraryApp.model.ArchiveDocument;
import com.project.LibraryApp.model.Document;
@Repository
public class DocumentDaoImpl implements DocumentDao{
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private SessionFactory sessionFactory2;
	
	
	
	@Override
	@Transactional
	public void insertUpdate(Document document) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(document);
		session.flush();
		
		
	}
	
	//archive
	@Override
	@Transactional
	public void insertUpdate2(ArchiveDocument arc) {
		Session session = sessionFactory2.getCurrentSession();
		session.merge(arc);
		session.flush();
	}
	

	@Override
	@Transactional
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Document document = (Document)session.get(Document.class, id);
		session.delete(document);
		session.flush();
		
	}
	
	@Override
	public Document get(Long id) {
		Session session = sessionFactory.openSession();
		Document document = (Document)session.get(Document.class, id);
		
		return document;
	}
	

	@Override
	public List<Document> getAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Document.class);
		criteria.add(Restrictions.eq("status", true));
		List<Document> documentList = (List<Document>)criteria.list();
		
		return documentList;
	}
	
	@Override
	public List<Document> archive(){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Document.class);
		criteria.add(Restrictions.eq("status", false));
		List<Document> archivedList = (List<Document>)criteria.list();
		
		return archivedList;
		
	}

	@Override
	public List<Document> reserveGet() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Document.class);
		criteria.add(Restrictions.eq("status", true));
		List<Document> availableLDocList = (List<Document>)criteria.list();
		return availableLDocList;
	}

	@Override
	public List<Document> borrowGet() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Document.class);
		criteria.add(Restrictions.eq("status", true));
		criteria.add(Restrictions.eq("availableStatus", false));
		List<Document> documentList = (List<Document>)criteria.list();
		
		return documentList;
	}

	

	

}
