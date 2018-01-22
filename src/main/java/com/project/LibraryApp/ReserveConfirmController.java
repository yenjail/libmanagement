package com.project.LibraryApp;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.LibraryApp.dao.DocumentDao;
import com.project.LibraryApp.dao.ReaderDao;
import com.project.LibraryApp.dao.ReqReserveDao;
import com.project.LibraryApp.model.Document;
import com.project.LibraryApp.model.Reader;
import com.project.LibraryApp.model.RequestReservation;
import com.project.LibraryApp.model.Reservation;

@Controller
@RequestMapping(value = "/reserveReq")
public class ReserveConfirmController {
	
	
	@Autowired
	private ReqReserveDao reserveDao;
	
	@Autowired
	private DocumentDao documentDao;
	
	@Autowired
	private ReaderDao readerDao;
	
	@Resource
	private SessionFactory sessionFactory;
	
	@RequestMapping(method = RequestMethod.GET)
	public String reqGet(Model model) {
		
		model.addAttribute("requestList", reserveDao.getRequest());
		
		return "reserveRequest";
	}
	
	@RequestMapping(value="{reqId}/confirmReservation", method = RequestMethod.GET)
	public String confirReq(@PathVariable("reqId") Long reqId,Model model) throws UnsupportedEncodingException {
		System.out.println("Request: "+reqId);
		RequestReservation reqRes = reserveDao.get(reqId);
		reqRes.setConfirm(true);
		reqRes.getDoc_code();
		
		//----
		System.out.println("Here");
		System.out.println("Doc Code:  "+reqRes.getDoc_code());
		ArrayList docInf= new ArrayList();
		docInf.add(reqRes.getDoc_code());
		System.out.println("Doc: "+docInf);
		String docId = String.valueOf(docInf);
		byte [] b = docId.getBytes();
		System.out.println("Bytes Val: "+b);
		
		long id = Character.getNumericValue(b[9]);
		System.out.println("Id "+id);
		Document doc = documentDao.get(id);
		doc.setAvailableStatus(true); //reservedStatus
		
		documentDao.insertUpdate(doc);
		reserveDao.insertUpdate(reqRes);
		
		
		return "redirect:/reserveReq";
	}
	
	


}
