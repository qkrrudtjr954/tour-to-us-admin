package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.CommuAfterBbsDto;

public interface ReviewService {
	public List<CommuAfterBbsDto> getAllReview();
	public CommuAfterBbsDto getReviewDetail(int seq);
	public CommuAfterBbsDto deleteReview(int seq);
}
