package com.project.LibraryApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.LibraryApp.dao.DocumentDao;
import com.project.LibraryApp.model.Document;

@Controller
@RequestMapping(value="/archivedDoc")
public class ArchiveController {
	
	@Autowired
	private DocumentDao documentDao;
	
	@RequestMapping(method= RequestMethod.GET)
	public String documentGet(Model model) {
		//model.addAttribute("document", new Document());
		model.addAttribute("documentList",documentDao.archive());
		
		return "archiveDocuments";
	}
	
//	@RequestMapping(method=RequestMethod.POST)
//	public String documentPost(Model model, @ModelAttribute Document doc) {
//		documentDao.insertUpdate(doc);
//		//model.addAttribute("document", new Document());
//		model.addAttribute("documentList",documentDao.archive());
//		return null;
//	}
	@RequestMapping(value = "{doc_code}/delete", method=RequestMethod.GET)
	public String deleteDoc(@PathVariable("doc_code")Long doc_code,Model model) {
		documentDao.delete(doc_code);
		
		return "redirect:/archivedDoc";
	}
	
	@RequestMapping(value="{doc_code}/restore",method=RequestMethod.GET)
	public String docRestore(@PathVariable("doc_code")Long doc_code, Model model) {
		Document doc = documentDao.get(doc_code);
		doc.setStatus(true);
		documentDao.insertUpdate(doc);
		return "redirect:/archivedDoc";
	}
	
	

}
