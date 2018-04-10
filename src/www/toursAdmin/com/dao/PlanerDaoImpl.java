package www.toursAdmin.com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import www.toursAdmin.com.model.DayPlanerDto;
import www.toursAdmin.com.model.PlanerDto;
import www.toursAdmin.com.model.TimePlanerDto;

@Repository
public class PlanerDaoImpl implements PlanerDao{
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String namespace = "Planer.";

	@Override
	public List<PlanerDto> getAllPlaner() {
		return sqlSession.selectList(namespace + "getAllPlaner");
	}

	@Override
	public PlanerDto getPlanerBySeq(int seq) {
		return sqlSession.selectOne(namespace + "getPlanerBySeq", seq);
	}

	@Override
	public void deletePlaner(int seq) {
		sqlSession.update(namespace + "deletePlaner", seq);
	}

	@Override
	public List<DayPlanerDto> getDayPlanerByTargetPlanerSeq(int seq) {
		return sqlSession.selectList(namespace + "getDayPlanerByTargetPlanerSeq", seq);
	}

	@Override
	public List<TimePlanerDto> getTimePlanerByDayPlanerSeqAndDay(int seq) {
		return sqlSession.selectList(namespace + "getTimePlanerByDayPlanerSeqAndDay", seq);
	}
	
}
