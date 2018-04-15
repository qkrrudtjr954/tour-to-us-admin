package www.toursAdmin.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.toursAdmin.com.dao.ReviewDao;
import www.toursAdmin.com.model.CommuAfterBbsDto;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	ReviewDao reviewDao;

	@Override
	public List<CommuAfterBbsDto> getAllReview() {
		// TODO Auto-generated method stub
		return reviewDao.getAllReview();
	}

}
