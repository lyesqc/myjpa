package org.me.controler;

import org.me.models.Commite;
import org.me.services.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeControler {

	@Autowired
	ConferenceService conferenceSerive;
	@GetMapping(value="/home/{id}"/*,produces={MediaType.APPLICATION_JSON_VALUE}*/)
	@ResponseStatus(code=HttpStatus.OK)
	//@ResponseBody
	
	 String index(@PathVariable("id") String id) throws Exception{
		
		System.out.println("My Request Id is "+id);
		conferenceSerive.getCommiteOfConference(Long.valueOf(id));
		//return "You are Welcome"
		//throw new Exception();
		
		Commite cm = conferenceSerive.getCommiteByName("commite_1_name");
		System.out.println("My commite description is : "+cm.getDescription());
		Commite c1 = conferenceSerive.getCommiteById(Long.valueOf(id));
		System.out.println("selected Commite is "+c1.getDescription());
		Page<Commite> page = conferenceSerive.getCommitePage("commite_1", 0, 10);
		System.out.println("Page size is : "+page.getSize());
		return "welcome";
	}
	
	@GetMapping("/commite/{id}")
	String getCommiteOfID(@PathVariable("id") Commite u){
		
		System.out.println("Commite description : "+u.getDescription() +","+u.getName());
		return "welcome";
	}
	
}
