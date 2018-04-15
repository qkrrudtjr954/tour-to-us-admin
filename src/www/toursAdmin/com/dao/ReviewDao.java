package www.toursAdmin.com.dao;

import java.util.List;

import www.toursAdmin.com.model.CommuAfterBbsDto;

public interface ReviewDao {
	List<CommuAfterBbsDto> getAllReview();
	CommuAfterBbsDto getReviewDetail(int seq);
	void deleteReview(int seq);
}
