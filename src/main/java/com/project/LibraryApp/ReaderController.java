package com.project.LibraryApp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.LibraryApp.dao.ReaderDao;
import com.project.LibraryApp.dao.UserDao;
import com.project.LibraryApp.model.Reader;

@Controller
@RequestMapping(value="/readerReg")
public class ReaderController {
	
	public static final String FILE_PATH="C:\\Users\\anjil\\Documents\\temp\\";
	
	
	@Autowired
	private ReaderDao readerDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String readerGet(Model model) {
		
		model.addAttribute("reader", new Reader());
		model.addAttribute("readerList", readerDao.getAll());
		
		
		return "readerRegister";
		
	}
	
	@RequestMapping(method=RequestMethod.POST) 
	public String readerPost(Model model,@ModelAttribute Reader read, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException, ScriptException, NoSuchMethodException{
		//save student record in db
		
		//if(!file.isEmpty()) {
			//readerDao.insertUpdate(read);
			
			String reader_name = request.getParameter("first_name");
			//if(!userDao.checkUniqueUser(read)) {
			try {
				
			if(!file.isEmpty() && !reader_name.isEmpty()) {
				model.addAttribute("readerError","");
				FileOutputStream out = new FileOutputStream(FILE_PATH + file.getOriginalFilename());
				out.write(file.getBytes());
				out.close();
				
				model.addAttribute("sucessMsg", "File upload success: "+file.getOriginalFilename());
				model.addAttribute("fileName",file.getOriginalFilename());
				 String photoName = file.getOriginalFilename();
				
				read.setPhotoName(photoName);
				read.setStatus(true);
				read.setRegisterDate(new Date(System.currentTimeMillis()));
				readerDao.insertUpdate(read);
				System.out.println(model.addAttribute("fileName",file.getOriginalFilename()));
				model.addAttribute("reader", new Reader());
				model.addAttribute("readerList", readerDao.getAll());
				
			//}
			
		
		//}
		
		return "redirect:/readerReg";
			}
			else {
				model.addAttribute("readerError","Please fill the form correctly.");
				model.addAttribute("reader", new Reader());
				model.addAttribute("readerList", readerDao.getAll());
				return "redirect:/readerReg";
			}
			}catch(Exception e) {
				model.addAttribute("readerError","Please fill the form correctly.!");
				model.addAttribute("reader", new Reader());
				model.addAttribute("readerList", readerDao.getAll());
				return "redirect:/readerReg";
			}
	}
	
	@RequestMapping(value="{id}/edit", method=RequestMethod.GET)
	public String editReader(@PathVariable("id") Long id, Model model) {
		Reader read = readerDao.get(id);
		model.addAttribute("reader", read);
		model.addAttribute("readerList", readerDao.getAll());
		return "readerRegister";
	}
	
	@RequestMapping(value="{id}/edit", method=RequestMethod.POST)
	public String editReaderPost(Model model,@ModelAttribute Reader read,@RequestParam("file") MultipartFile file) throws IOException {
		
		
		if(!file.isEmpty()) {
			FileOutputStream out = new FileOutputStream(FILE_PATH + file.getOriginalFilename());
			out.write(file.getBytes());
			out.close();
			
			model.addAttribute("sucessMsg", "File upload success: "+file.getOriginalFilename());
			model.addAttribute("fileName",file.getOriginalFilename());
			 String photoName = file.getOriginalFilename();
		
			 
		read.setPhotoName(photoName);
		
		read.setStatus(true);
		read.setRegisterDate(new Date(System.currentTimeMillis()));
		readerDao.insertUpdate(read);
		}
		return "redirect:/readerReg";
		
		}

	
	
	@RequestMapping(value="{id}/delete", method=RequestMethod.GET)
	public String deleteReader(@PathVariable("id") Long id, Model model) {
		
		readerDao.delete(id);
		
		return "redirect:/readerReg";
	}
	
	//<form:input path="username" />
	
	
	

}
