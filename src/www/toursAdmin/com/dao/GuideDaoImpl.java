package www.toursAdmin.com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import www.toursAdmin.com.model.PlanerDto;

@Repository
public class GuideDaoImpl implements GuideDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String namespace = "Guide.";

	@Override
	public List<PlanerDto> getAllTodoongGuide() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"getAllTodoongGuide");
	}

	@Override
	public void deleteGuide(int seq) {
		sqlSession.update(namespace+"deleteGuide", seq);
	}
}
