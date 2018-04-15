package www.toursAdmin.com.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import www.toursAdmin.com.model.CommuFreeBbsDto;
import www.toursAdmin.com.service.FreeService;

@Controller
public class FreeController {
	
	@Autowired
	FreeService freeService;

	@RequestMapping(value="freeManager.do", method=RequestMethod.GET)
	public String freeManager(Model model)throws Exception{
		List<CommuFreeBbsDto> list = freeService.getAllFree();
		
		model.addAttribute("menu_id", "free");
		model.addAttribute("doc_title", "자유 게시판 관리");
		model.addAttribute("freelist", list);
		return "freeManager.tiles";
	}
	
	@RequestMapping(value="freeDetail.do", method=RequestMethod.GET)
	public String freeDetail(Model model, int seq)throws Exception{
		CommuFreeBbsDto free = freeService.getFreeDetail(seq);
		
		model.addAttribute("menu_id", "free");
		model.addAttribute("doc_title", "자유 게시판 관리");
		model.addAttribute("free", free);
		return "freeDetail.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value="freeDelete.do", method=RequestMethod.GET)
	public CommuFreeBbsDto freeDelete(Model model, int seq)throws Exception{
		CommuFreeBbsDto free = freeService.deleteFree(seq);
		return free;
	}
}
