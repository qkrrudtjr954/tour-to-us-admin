package www.toursAdmin.com.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value="main.do", method=RequestMethod.GET)
	public String main(Model model) {
		logger.info("AdminController >>> main");
		model.addAttribute("doc_title", "Tours To us");
		model.addAttribute("menu_id", "home");
		return "main.tiles";
	}
}
