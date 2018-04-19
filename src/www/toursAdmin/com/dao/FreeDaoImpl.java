package www.toursAdmin.com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import www.toursAdmin.com.model.CommuFreeBbsDto;
import www.toursAdmin.com.model.CommuFreeCategoryDto;

@Repository
public class FreeDaoImpl implements FreeDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String namespace = "Free.";

	@Override
	public List<CommuFreeBbsDto> getAllFree() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"getAllFree");
	}

	@Override
	public CommuFreeBbsDto getFreeDetail(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"getFreeDetail", seq);
	}

	@Override
	public void deleteFree(int seq) {
		sqlSession.update(namespace+"deleteFree", seq);
		
	}

	@Override
	public List<CommuFreeCategoryDto> getCategory() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"getCategory");
	}

	@Override
	public void categoryInsert(CommuFreeCategoryDto categoryDto) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+"categoryInsert", categoryDto);
	}

	@Override
	public void updateStatus(CommuFreeCategoryDto categoryDto) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+"updateStatus", categoryDto);
		
	}

	@Override
	public CommuFreeCategoryDto getCategoryBySeq(int seq) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"getCategoryBySeq", seq);
	}
}
