package com.project.LibraryApp.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.LibraryApp.model.Reader;
import com.project.LibraryApp.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private DataSource dataSource2;
	
	

	@Override
	public boolean valliDateUser(User user) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		try {
		
		String sql = "SELECT username FROM USER WHERE username = '" +user.getUsername()
					+"' AND PASSWORD = '" + user.getPassword() + "'";
		String dbUserName = jdbcTemplate.queryForObject(sql, String.class);
		if(dbUserName != null && dbUserName.equals(user.getUsername())) {
			return true;
		} else {
			return false;
		}
			
		
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean valliDateReader(Reader reader) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource2);
		try {
			//"Reader"+ id+" "+username+" "+firstName+" "+lastName+" "+contactNo+" "+email+""+password+""+photoName;
			String sql = "SELECT username FROM reader WHERE username='"+reader.getUsername()
			+"' AND password = '"+reader.getPassword()+"'";
			String dbCheck = jdbcTemplate.queryForObject(sql, String.class);
			if(dbCheck != null && dbCheck.equals(reader.getUsername())) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
		e.printStackTrace();	
		return false;
		}
		
	}

	@Override
	public boolean checkUniqueUser(Reader reader2) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		try {
		
		String sql = "SELECT username FROM reader WHERE username='"+reader2.getUsername()+"'";
		String dbCheck = jdbcTemplate.queryForObject(sql, String.class);
		
		if(dbCheck !=null &&dbCheck.equals(reader2.getUsername())) {
			return true;
		}
		else {
			return false;
		}
		
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
