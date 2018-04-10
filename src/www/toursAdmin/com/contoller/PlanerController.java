package www.toursAdmin.com.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import www.toursAdmin.com.model.TravelerDto;
import www.toursAdmin.com.service.PlanerService;
import www.toursAdmin.com.service.TravelerService;

@Controller
public class PlanerController {
	
	Logger logger = LoggerFactory.getLogger(PlanerController.class);
	
	@Autowired
	PlanerService planerService;
	
	@Autowired
	TravelerService travelerService;
	
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
		
		Map<DayPlanerDto, List<TimePlanerDto>> subPlaners = planerService.getSubPlaners(seq);
		
		TravelerDto traveler = travelerService.getTravelerBySeq(planer.getTarget_user_seq());
		
		model.addAttribute("doc_title", "플래너 상세보기");
		model.addAttribute("menu_id", "planer");
		model.addAttribute("planer", planer);
		model.addAttribute("dayPlaners", dayPlaners);
		model.addAttribute("subPlaners", subPlaners);
		model.addAttribute("traveler", traveler);
		return "planerDetail.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value="getTimePlaner.do", method=RequestMethod.GET)
	public List<TimePlanerDto> getTimePlaner(int seq) {
		List<TimePlanerDto> timePlaner = planerService.getTimePlanerByDayPlanerSeqAndDay(seq);
		return timePlaner;
	}
	
}
