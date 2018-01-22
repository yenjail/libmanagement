package com.project.LibraryApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.LibraryApp.dao.ReqReserveDao;


@Controller
@RequestMapping(value = "/reservedList")
public class ReservedDocController {
	
	@Autowired
	private ReqReserveDao reqDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String reserveReq(Model model) {
		model.addAttribute("reservedList" ,reqDao.getReserved());
		return "reservedList";
	}
	
	
	
}
