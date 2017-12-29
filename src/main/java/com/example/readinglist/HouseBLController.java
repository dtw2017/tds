package com.example.readinglist;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.readinglist.HouseBL;
import com.example.readinglist.HouseBLRepository;

@Controller

public class HouseBLController {
	

	private HouseBLRepository houseblRepository;
	
	public HouseBLController(HouseBLRepository houseblrepository) {
		this.houseblRepository = houseblrepository;
	}
	@Autowired
	
	@GetMapping(path = "/housebl")
	public String newHouseBL() {
		return "housebl";
	}
	
	//Save House BL to DB
	@RequestMapping(value = "/housebl",params= {"save"})
	public @ResponseBody HouseBL saveHouseBL(@RequestBody HouseBL hbl) {
		//houseblrepository.save(hbl);
		System.out.println(hbl.getBookingno());
		System.out.println(hbl.getHblno());
		System.out.println(hbl.getVvd());
		houseblRepository.save(hbl);
		return hbl;
	}
	
	//Retrieve House BL from DB
	@RequestMapping(value = "/housebl",params= {"retrieve"})
	public @ResponseBody HouseBL retrieveHouseBL(@RequestBody String hblno) {
		HouseBL houseblinfo = houseblRepository.findByhblno(hblno);
		System.out.println(houseblinfo.getVvd());
		return houseblinfo;
	}
	
	//Delete House BL from DB
	@RequestMapping(value = "/housebl",params= {"delete"})
	public @ResponseBody HouseBL deleteHouseBL(@RequestBody String hblno) {
		HouseBL houseblinfo = houseblRepository.findByhblno(hblno);
		System.out.println(houseblinfo.getVvd());
		houseblRepository.delete(houseblinfo);
		return houseblinfo;
	}
	
	@RequestMapping(value = "/housebl",params= {"print"})
	public String printHouseBL(final HouseBL hbl, Model model) {
		
		return "redirect:/{housebl}";
	}
}
