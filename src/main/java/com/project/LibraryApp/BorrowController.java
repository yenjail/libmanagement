package com.project.LibraryApp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.output.BrokenOutputStream;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpServerErrorException;

import com.project.LibraryApp.dao.BorrowDao;
import com.project.LibraryApp.dao.DocumentDao;
import com.project.LibraryApp.dao.ReaderDao;
import com.project.LibraryApp.model.Document;
import com.project.LibraryApp.model.Reader;
import com.project.LibraryApp.model.Transaction;

@Controller
@RequestMapping(value="/borrowDoc")
public class BorrowController {
	
	@Autowired
	private DocumentDao documentDao;
	
	@Autowired
	private ReaderDao readerDao;
	
	@Autowired
	private BorrowDao borrowDao;
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Resource
	private SessionFactory sessionFactory2;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatter, true));
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String borrowGet(Model model, HttpSession session ) {
		System.out.println("GET");
		model.addAttribute("documentBorrow", new Transaction());
		model.addAttribute("documentList", documentDao.borrowGet() );
		model.addAttribute("readerList", readerDao.getAll());
		model.addAttribute("transactionList", borrowDao.getAll());
		
		return "borrowDocument";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(method = RequestMethod.POST)
	public String borrowPost(Model model, HttpServletRequest request) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Transaction trans = new Transaction();
		System.out.println("POST");
		
		try {
		Long doc_id =Long.parseLong(request.getParameter("doc_code"));
		Long reader_id = Long.parseLong(request.getParameter("reader_id"));
		
		if(doc_id!=null || doc_id!=0) {
			model.addAttribute("borrowError","");
		
		Document doc = documentDao.get(doc_id);
		trans.setDoc_code(doc);
		Reader reader = readerDao.get(reader_id);
		trans.setReader_id(reader);
		trans.setReturnStatus(false);
		trans.setLoanedDate(new Date(System.currentTimeMillis()));
		
		doc.setAvailableStatus(true);
		System.out.println(doc.getAvailableStatus());
		documentDao.insertUpdate(doc);
		session.merge(trans);
		
		session.getTransaction().commit();
		session.close();
		model.addAttribute("documentBorrow", new Transaction());
		model.addAttribute("documentList", documentDao.borrowGet() );
		model.addAttribute("readerList", readerDao.getAll());
		model.addAttribute("transactionList", borrowDao.getAll());
		
		return "borrowDocument";
		}
		else{
			model.addAttribute("borrowError","Please fill the form correctly.");
			model.addAttribute("documentBorrow", new Transaction());
			model.addAttribute("documentList", documentDao.borrowGet() );
			model.addAttribute("readerList", readerDao.getAll());
			model.addAttribute("transactionList", borrowDao.getAll());
			return "borrowDocument";
		}
		}catch(Exception e) {
			e.getMessage();
			model.addAttribute("borrowError","Please fill the form correctly.");
			model.addAttribute("documentBorrow", new Transaction());
			model.addAttribute("documentList", documentDao.borrowGet() );
			model.addAttribute("readerList", readerDao.getAll());
			model.addAttribute("transactionList", borrowDao.getAll());
			return "borrowDocument";
			
		}
	}
	
	@RequestMapping(value="{transId}/{doc_code}/return",method=RequestMethod.GET)
	public String returnDoc(@PathVariable("transId") Long transId, @PathVariable("doc_code") Long doc_code) {
		Session session2 = sessionFactory2.openSession();
		System.out.println("error1");
		session2.beginTransaction();
		Document doc = documentDao.get(doc_code);
		Transaction trans = borrowDao.get(transId);
		System.out.println("error2");
		doc.setAvailableStatus(false);
		trans.setReturnStatus(true);
		
		System.out.println("error3");
		documentDao.insertUpdate(doc);
		System.out.println("error4");
		session2.merge(trans);
		System.out.println("error5");
		
		session2.getTransaction().commit();
		session2.close();
		System.out.println("error7");
		
		return "redirect:/borrowDoc" ;
	}
	
	
	
	
	
}
