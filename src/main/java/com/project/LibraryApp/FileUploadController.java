package com.project.LibraryApp;

import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	private static final String FILE_PATH="C:\\Users\\anjil\\Documents\\temp\\";

	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String uploadPost(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		if(!file.isEmpty()) {
			FileOutputStream out = new FileOutputStream(FILE_PATH + file.getOriginalFilename());
			out.write(file.getBytes());
			out.close();
			
			model.addAttribute("sucessMsg", "File upload success: "+file.getOriginalFilename());
			model.addAttribute("fileName",file.getOriginalFilename());
			System.out.println(model.addAttribute("fileName",file.getOriginalFilename()));
			
		}
		
		
		return "redirect:/readerReg";
	}
}
