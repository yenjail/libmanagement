package com.project.LibraryApp.dao;

import java.util.List;

import com.project.LibraryApp.model.Transaction;

public interface BorrowDao {
	void insertupdate(Transaction trans);
	void returnBorrow(Long id);
	
	Transaction get(Long id);
	
	List<Transaction> getAll();

}
