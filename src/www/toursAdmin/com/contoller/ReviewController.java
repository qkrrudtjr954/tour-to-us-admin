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

import www.toursAdmin.com.model.CommuAfterBbsDto;
import www.toursAdmin.com.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;

	Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value="reviewManager.do", method=RequestMethod.GET)
	public String reviewManager(Model model)throws Exception {
		List<CommuAfterBbsDto> list = reviewService.getAllReview();
		
		model.addAttribute("menu_id", "review");
		model.addAttribute("doc_title", "여행 후기 관리");
		model.addAttribute("reviewlist", list);
		return "reviewManager.tiles";
	}
	
	@RequestMapping(value="reviewDetail.do", method=RequestMethod.GET)
	public String reviewDetail(Model model, int seq)throws Exception {
		CommuAfterBbsDto review = reviewService.getReviewDetail(seq);
		
		model.addAttribute("menu_id", "review");
		model.addAttribute("doc_title", "여행 후기 상세보기");
		model.addAttribute("review", review);
		
		return "reviewDetail.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value="reviewDelete.do", method=RequestMethod.GET)
	public CommuAfterBbsDto reviewDelete(int seq)throws Exception{
		CommuAfterBbsDto review = reviewService.deleteReview(seq);
		return review;
	}
}
