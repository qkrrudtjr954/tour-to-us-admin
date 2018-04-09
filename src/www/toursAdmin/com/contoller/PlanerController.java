package www.toursAdmin.com.contoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import www.toursAdmin.com.model.DayPlanerDto;
import www.toursAdmin.com.model.PlanerDto;
import www.toursAdmin.com.model.TimePlanerDto;
import www.toursAdmin.com.service.PlanerService;

@Controller
public class PlanerController {
	
	Logger logger = LoggerFactory.getLogger(PlanerController.class);
	
	@Autowired
	PlanerService planerService;
	
	@RequestMapping(value="planerManager.do", method=RequestMethod.GET)
	public String planerManager(Model model) {
		List<PlanerDto> planerList = planerService.getAllPlaner(); 
		model.addAttribute("doc_title", "플래너 관리");
		model.addAttribute("menu_id", "planer");
		model.addAttribute("planers", planerList);
		return "planerManager.tiles";
	}
	
	
	@ResponseBody
	@RequestMapping(value="planerDelete.do", method=RequestMethod.GET)
	public PlanerDto planerDelete(Model model, int seq) {
		logger.info("deletePlaner seq : {} ", seq);
		PlanerDto planer = planerService.deletePlaner(seq);
		return planer;
	}

	@RequestMapping(value="planerDetail.do", method=RequestMethod.GET)
	public String planerDetail(Model model, int seq) {
		
		PlanerDto planer = planerService.getPlanerBySea(seq);
		List<DayPlanerDto> dayPlaners = planerService.getDayPlanerByTargetPlanerSeq(seq);
		
		model.addAttribute("doc_title", "플래너 상세보기");
		model.addAttribute("menu_id", "planer");
		model.addAttribute("planer", planer);
		model.addAttribute("dayPlaners", dayPlaners);
		return "planerDetail.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value="getTimePlaner.do", method=RequestMethod.GET)
	public List<TimePlanerDto> getTimePlaner(DayPlanerDto dayPlaner) {
		List<TimePlanerDto> timePlaner = planerService.getTimePlanerByDayPlanerSeqAndDay(dayPlaner);
		return timePlaner;
	}
	
}
