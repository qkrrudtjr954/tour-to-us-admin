package www.toursAdmin.com.contoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UploadController {
	
	Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value="dataUpload.do", method=RequestMethod.GET)
	public String toto_write(Model model)throws Exception {
		logger.info("TotoGuideController >>>> toto_write");
		
		/*List<Korea> korea = planerService.getKoreaList();
		model.addAttribute("korea", korea);
		*/
		return "toto_write.tiles";
	}
}
