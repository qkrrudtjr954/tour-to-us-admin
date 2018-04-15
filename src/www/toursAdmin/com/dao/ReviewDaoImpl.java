package www.toursAdmin.com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import www.toursAdmin.com.model.CommuAfterBbsDto;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String namespace = "Review.";

	@Override
	public List<CommuAfterBbsDto> getAllReview() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"getAllReview");
	}

	@Override
	public CommuAfterBbsDto getReviewDetail(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"getReviewDetail", seq);
	}

	@Override
	public void deleteReview(int seq) {
		sqlSession.update(namespace+"deleteReview", seq);
		
	}

	
}
