package www.toursAdmin.com.contoller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import www.toursAdmin.com.model.DayPlanerDto;
import www.toursAdmin.com.model.PlanerDto;
import www.toursAdmin.com.model.TimePlanerDto;
import www.toursAdmin.com.model.ToditorBBS;
import www.toursAdmin.com.model.TravelerDto;
import www.toursAdmin.com.service.GuideService;
import www.toursAdmin.com.service.PlanerService;
import www.toursAdmin.com.service.TravelerService;

@Controller
public class GuideController {
	@Autowired
	GuideService guideService;
	
	@Autowired
	PlanerService planerService;
	
	@Autowired
	TravelerService travelerService;
	
	@RequestMapping(value="todoongManager.do", method=RequestMethod.GET)
	public String todoongManager(Model model)throws Exception{
		List<PlanerDto> list = guideService.getAllTodoongGuide();
				
		model.addAttribute("menu_id", "guide");
		model.addAttribute("doc_title", "가이드 관리");
		model.addAttribute("todoonglist", list);
		return "todoongManager.tiles";
	}
	
	@RequestMapping(value="todoongGuideDetail.do", method=RequestMethod.GET)
	public String guideDetail(Model model, int seq)throws Exception{
		PlanerDto planer = planerService.getPlanerBySea(seq);
		List<DayPlanerDto> dayPlaners = planerService.getDayPlanerByTargetPlanerSeq(seq);
		
		Map<DayPlanerDto, List<TimePlanerDto>> subPlaners = planerService.getSubPlaners(seq);
		
		TravelerDto traveler = travelerService.getTravelerBySeq(planer.getTarget_user_seq());
		
		model.addAttribute("doc_title", "투둥이 상세보기");
		model.addAttribute("menu_id", "guide");
		model.addAttribute("guide", planer);
		model.addAttribute("dayPlaners", dayPlaners);
		model.addAttribute("subPlaners", subPlaners);
		model.addAttribute("traveler", traveler);
		
		return "todoongGuideDetail.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value="todoongGuideDelete.do", method=RequestMethod.GET)
	public PlanerDto guideDelete(Model model, int seq)throws Exception{
		PlanerDto planer = guideService.deleteTodoongGuide(seq);		
		return planer;
	}
	
	@RequestMapping(value="toditorManager.do", method=RequestMethod.GET)
	public String toditorManager(Model model)throws Exception{
		List<ToditorBBS> list = guideService.getAllToditorGuide();
		
		model.addAttribute("menu_id", "guide");
		model.addAttribute("doc_title", "가이드 관리");
		model.addAttribute("toditorlist", list);
		
		return "toditorManager.tiles";
	}
	
	@RequestMapping(value="toditorGuideDetail.do", method=RequestMethod.GET)
	public String toditorGuideDetail(Model model, int seq)throws Exception{
		ToditorBBS toditor = guideService.toditorGuideDetail(seq);
		
		model.addAttribute("menu_id", "guide");
		model.addAttribute("doc_title", "가이드 관리");
		model.addAttribute("toditor", toditor);
		return "toditorGuideDetail.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value="toditorGuideDelete.do", method=RequestMethod.GET)
	public ToditorBBS toditorGuideDelete(Model model, int seq)throws Exception{
		ToditorBBS toditor = guideService.deleteToditorGuide(seq);
		
		return toditor;
	}
	
}
