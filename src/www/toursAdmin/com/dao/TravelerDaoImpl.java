package www.toursAdmin.com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import www.toursAdmin.com.model.LevelDto;
import www.toursAdmin.com.model.LevelParam;
import www.toursAdmin.com.model.TravelerDto;

@Repository
public class TravelerDaoImpl implements TravelerDao{
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String namespace = "Traveler.";

	@Override
	public List<TravelerDto> getAllTraveler() {
		return sqlSession.selectList(namespace + "getAllTraveler");
	}

	@Override
	public TravelerDto getTravelerBySeq(int seq) {
		return sqlSession.selectOne(namespace + "getTravelerBySeq", seq);
	}

	@Override
	public List<LevelDto> getTopRankTraveler() {
		return sqlSession.selectList(namespace + "getTopRankTraveler");
	}

	@Override
	public boolean updateLevel(int seq, int status) {
		LevelParam param = new LevelParam(seq, status);
		
		int i = sqlSession.update(namespace + "updateLevel", param);
		return (i > 0)?true:false;
	}

	
}
