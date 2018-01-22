package com.project.LibraryApp.dao;

import java.util.List;

import com.project.LibraryApp.model.ArchiveDocument;

public interface ArchiveDao {
	
	void insertUpdate(ArchiveDocument archiveDocument );
	
	void delete(Long id);
	
	ArchiveDocument get(Long id);
	
	List<ArchiveDocument> getAll();

}
