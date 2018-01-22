package com.project.LibraryApp;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.LibraryApp.dao.ArchiveDao;
import com.project.LibraryApp.dao.DocumentDao;
import com.project.LibraryApp.model.ArchiveDocument;
import com.project.LibraryApp.model.Document;

@Controller
@RequestMapping(value = "/documentReg")
public class DocumentRegController {

	@Autowired
	private DocumentDao documentDao;
	
	@Autowired
	private ArchiveDao archiveDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatter, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public String documentGEt(Model model, HttpSession session) {
		if(session.getAttribute("activeUser")!=null) {
		model.addAttribute("document", new Document());
		model.addAttribute("documentList", documentDao.getAll());

		return "documentRegister";
		}
		else {
			return "login";
		}
	}
	
	

	@RequestMapping(method = RequestMethod.POST)
	public String documentPost(Model model, @ModelAttribute Document doc, HttpServletRequest request) {
		
		String docName = request.getParameter("doc_name");
		if(!docName.isEmpty()) {
			model.addAttribute("docError","");
		String name = request.getParameter("doc_name");
		System.out.println("post CHeck"+name);
		documentDao.insertUpdate(doc);
		model.addAttribute("document", new Document());
		model.addAttribute("documentList", documentDao.getAll());
		return "documentRegister";
		}
		else {
			System.out.println("Error");
			model.addAttribute("docError","Please correctly fill the form.");
			model.addAttribute("document", new Document());
			model.addAttribute("documentList", documentDao.getAll());
			return "documentRegister";
		}
	}

	// @InitBinder
	// public void initBinder(WebDataBinder binder) {
	// SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	// sdf.setLenient(true);
	// binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	// }

	@RequestMapping(value = "{doc_code}/edit", method = RequestMethod.GET)
	public String editDocumentGet(@PathVariable("doc_code") Long doc_code, Model model) {
		Document doc = documentDao.get(doc_code);
		model.addAttribute("document", doc);
		model.addAttribute("documentList", documentDao.getAll());
		return "documentRegister";
	}

	@RequestMapping(value = "{doc_code}/edit", method = RequestMethod.POST)
	public String editDocumentPost(Model model, @ModelAttribute Document doc) {
		documentDao.insertUpdate(doc);
		return "redirect:/documentReg";

	}
	
	@RequestMapping(value="{doc_code}/delete", method=RequestMethod.GET)
	public String deletDocument(@PathVariable("doc_code") Long doc_code, Model model) {
		documentDao.delete(doc_code);
		return "redirect:/documentReg";
	}
	
	@RequestMapping(value="{doc_code}/archive", method=RequestMethod.GET)
	public String arcGet(@PathVariable("doc_code") Long doc_code, Model model, HttpSession session) {
		Document doc = documentDao.get(doc_code);
		doc.setStatus(false);
		documentDao.insertUpdate(doc);
		
		
		return "redirect:/documentReg";
	}
	
	
	
	
	
	
//	
//	
//	@RequestMapping(value="{doc_code}/archive", method=RequestMethod.POST)
//	public String archiveDocument(@PathVariable("doc_code") Long doc_code, Model model, ArchiveDocument doc) {
//		
//		documentDao.insertUpdate2(doc);
//		
//		
//		
//		return "redirect:/documentReg";
//	}
	
	
	

}
