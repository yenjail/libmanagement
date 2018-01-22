package com.project.LibraryApp.dao;

import com.project.LibraryApp.model.Reader;
import com.project.LibraryApp.model.User;

public interface UserDao {
	boolean valliDateUser(User user);
	
	boolean valliDateReader(Reader reader);
	
	boolean checkUniqueUser(Reader reader2);

}
