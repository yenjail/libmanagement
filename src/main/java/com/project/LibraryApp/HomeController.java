package com.project.LibraryApp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.LibraryApp.dao.ReaderDao;
//import com.project.LibraryApp.dao.ReaderDao;
import com.project.LibraryApp.dao.UserDao;
import com.project.LibraryApp.model.Reader;
import com.project.LibraryApp.model.ReaderLogs;
import com.project.LibraryApp.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ReaderDao readerDao;
	
	@Resource
	private SessionFactory sessionFactory;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatter, true));
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "login";
	}
	
	

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String librarianLoginCheck(@ModelAttribute User user, Model model, HttpSession session) {
		// vallidate user with datbase

		if (userDao.valliDateUser(user)) {
			// sucess: Save in session and show profile page.
			session.setAttribute("activeUser", user.getUsername());
			session.setMaxInactiveInterval(10 * 60); // 10 minute. 
			return "profile";
		} else {
			// Failed: Show error in login.jsp
			model.addAttribute("loginError", "Sorry User/Password invalid. Please re-login.");
			return "login";

		}

	}
	@RequestMapping(value = "/profile" ,method = RequestMethod.GET)
	public String sessionCheck(HttpSession session) {
		if(session.getAttribute("activeUser")==null) {
			
		return "login";	
		}
		else {
			return "profile";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	@RequestMapping(value= "/readerLogin", method = RequestMethod.POST)
	public String readerLoginCheck(@ModelAttribute Reader reader, Model model, HttpSession session) {
		
		if(userDao.valliDateReader(reader)) {
			session.setAttribute("activeReader", reader.getUsername());
			String username = reader.getUsername();
			
			
			readerDao.get2(username);
			ArrayList a = new ArrayList();
			a.add(readerDao.get2(username));
			System.out.println(" Hola " +a);
			String da= String.valueOf(a);
			byte[] b = da.getBytes();
//			System.out.println(b);
//			long id = Character.getNumericValue(b[10]);
//			// long id1 = Character.getNumericValue(49);
//			String getId2 = String.valueOf(b[10]);
//			System.out.println(getId2);
	//
//			String getId;
			// System.out.println("Str: "+getId);
			ArrayList ar = new ArrayList();

			for (int i = 8; i < b.length; i++) {
				String idget = String.valueOf(b[i]);

				if (!idget.equals("32")) {
					int id5 = Integer.parseInt(idget);
					long id4 = Character.getNumericValue(id5);
					
					ar.add(id4);
				} else {
					break;
				}
			}
			System.out.println(ar);
			
			StringBuffer idF = new StringBuffer();
			for (int i = 0; i < ar.size(); i++) {
				idF.append(ar.get(i));
			}
			System.out.println(idF);
			String val = String.valueOf(idF);
			long userid = Long.parseLong(val);
			System.out.println("Final Id: "+ userid);
		
			
			
			System.out.println(userid);
			
			
			session.setAttribute("activeReaderId", userid);
			
			session.setMaxInactiveInterval(10 * 60);
			
			//ReaderLogs readerLogs = readerDao.get(userid);
			
			
			Reader reader2 = readerDao.get(userid);
			reader2.getStatus();
			System.out.println("Status: "+reader2.getStatus());
			
			if(reader2.getStatus()!=false) {
				
				Session logsSession = sessionFactory.openSession();
				logsSession.beginTransaction();
				ReaderLogs logs = new ReaderLogs();
				logs.setReader_id(reader2);
				logs.setLogedInDate(new Date(System.currentTimeMillis()));
				logsSession.merge(logs);
				logsSession.getTransaction().commit();
				logsSession.close();
				
				
				return "readerProfile";
			}else {
				model.addAttribute("readerloginError", "Sorry User/Password invalid. Please re-login.");
				
				
				return "login";
			}
			
			
			
		
		}else {
			// Failed: Show error in login.jsp
			model.addAttribute("readerloginError", "Sorry User/Password invalid. Please re-login.");
			return "login";

		}
	}
	
	@RequestMapping("/signUp")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping(value = "/uploadCheck", method=RequestMethod.GET)
	public String uploadCheck() {
		
		return "uploadCheck";
	}
	
	

}
