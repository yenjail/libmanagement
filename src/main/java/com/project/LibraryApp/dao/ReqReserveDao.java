package com.project.LibraryApp.dao;

import java.util.List;

import com.project.LibraryApp.model.RequestReservation;

public interface ReqReserveDao {
	
	void insertUpdate(RequestReservation reqReg);
	
	List<RequestReservation> getRequest();
	
	void delete(Long doc_code);
	
	RequestReservation get(Long reqId);
	
	List<RequestReservation> getReserved();

}
