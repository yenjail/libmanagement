package com.project.LibraryApp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.LibraryApp.model.ArchiveDocument;

@Repository
public class ArchiveDaoImpl implements ArchiveDao{
	
	@Resource
	private SessionFactory sessionFactory;
	
	

	@Override
	@Transactional
	public void insertUpdate(ArchiveDocument archiveDocument) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(archiveDocument);
		session.flush();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		ArchiveDocument archiveDocument = (ArchiveDocument)session.get(ArchiveDocument.class, id);
		session.delete(archiveDocument);
		session.flush();
	}

	@Override
	public ArchiveDocument get(Long id) {
		Session session = sessionFactory.openSession();
		ArchiveDocument archiveDocument = (ArchiveDocument)session.get(ArchiveDocument.class, id);
		
		
		return archiveDocument;
	}

	@Override
	public List<ArchiveDocument> getAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ArchiveDocument.class);
		List<ArchiveDocument> documentList =(List<ArchiveDocument>) criteria.list();
		
		
		return documentList;
	}
	
	

}
