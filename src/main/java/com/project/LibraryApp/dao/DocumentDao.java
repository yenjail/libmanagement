package com.project.LibraryApp.dao;

import java.util.List;

import com.project.LibraryApp.model.ArchiveDocument;
import com.project.LibraryApp.model.Document;

public interface DocumentDao {
	
	void insertUpdate(Document document );
	
	void insertUpdate2(ArchiveDocument arc);
	
	void delete(Long id);
	
	Document get(Long id);
	
	
	
	List<Document> getAll();
	
	List<Document> archive();
	
	List<Document> reserveGet();
	
	List<Document> borrowGet();
	

	

}
