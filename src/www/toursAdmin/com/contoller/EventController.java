package www.toursAdmin.com.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import www.toursAdmin.com.model.EventDto;
import www.toursAdmin.com.service.EventService;

@Controller
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@RequestMapping(value="eventManager.do", method=RequestMethod.GET)
	public String eventManager(Model model) {
		List<EventDto> eventList = eventService.getAllEvent();
		
		model.addAttribute("menu_id", "event");
		model.addAttribute("doc_title", "이벤트 관리");
		model.addAttribute("events", eventList);
		
		return "eventManager.tiles";
	}
	
	@RequestMapping(value="eventDetail.do", method=RequestMethod.GET)
	public String eventDetail(Model model, int seq) {
		EventDto event = eventService.getEventBySeq(seq);
		
		model.addAttribute("menu_id", "event");
		model.addAttribute("event", event);
		model.addAttribute("doc_title", "이벤트 상세보기");
		
		return "eventDetail.tiles";
	}

	@RequestMapping(value="eventInsert.do", method=RequestMethod.GET)
	public String eventInsert(Model model) {
		model.addAttribute("menu_id", "event");
		model.addAttribute("doc_title", "이벤트 작성하기");
		
		return "eventInsert.tiles";
	}
	
	@RequestMapping(value="eventInsert.do", method=RequestMethod.POST)
	public String eventInsertAf(RedirectAttributes redirectAttributes, EventDto event) {
		System.out.println("oh yeah");
		EventDto result = eventService.insertEvent(event);
		redirectAttributes.addAttribute("seq", result.getSeq());
		return "redirect:eventDetail.do";
	}

	@ResponseBody
	@RequestMapping(value="eventDelete.do", method=RequestMethod.GET)
	public EventDto eventDelete(int seq) {
		EventDto event = eventService.deleteEvent(seq);
		return event;
	}

	@ResponseBody
	@RequestMapping(value="changeEventStatus.do", method=RequestMethod.POST)
	public EventDto chaneEventStatus(int seq) {
		EventDto result = eventService.updateStatus(seq);
		return result;
	}
}
