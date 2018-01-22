package com.project.LibraryApp;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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

@Controller
@RequestMapping(value = "/docCheck")
public class ReaderReservationController {
	
	@Autowired
	private DocumentDao documentDao;
	
	@Autowired
	private ReaderDao readerDao;
	
	@Resource
	private SessionFactory sessionFactory;
	
//	@Autowired
//	private ReqReserveDao reqDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public String documentGet(Model model) {
		model.addAttribute("document", new Document());
		model.addAttribute("documentList", documentDao.reserveGet());
		return "displayDocuments";
	}
	
	@RequestMapping(value="{doc_code}/{reader_id}/reserve", method=RequestMethod.GET)
	public String reserveReq(@PathVariable("doc_code") Long doc_code, @PathVariable("reader_id") long reader_id ) {
	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Document doc = documentDao.get(doc_code);
		
		Reader read = readerDao.get(reader_id);
		
		RequestReservation reqRes = new RequestReservation();
		reqRes.setDoc_code(doc);
		reqRes.setReader_id(read);
		reqRes.setReserveDate(new Date(System.currentTimeMillis()) );
		reqRes.setConfirm(false);
		
		session.merge(reqRes);
		session.getTransaction().commit();
		session.close();
		
		return "redirect:/docCheck";
	}
	
	
	
}
