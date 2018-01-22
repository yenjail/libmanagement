package com.project.LibraryApp.dao;

import java.util.List;

import com.project.LibraryApp.model.Reader;

public interface ReaderDao {
	void insertUpdate(Reader read);
	
	void delete(Long id);
	
	Reader get(Long id);
	
	List<Reader> getAll();
	

	List<Reader> get2(String username);
	

	
	

}
