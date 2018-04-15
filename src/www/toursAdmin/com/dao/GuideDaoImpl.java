package www.toursAdmin.com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import www.toursAdmin.com.model.PlanerDto;
import www.toursAdmin.com.model.ToditorBBS;

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
	public void deleteTodoongGuide(int seq) {
		sqlSession.update(namespace+"deleteTodoongGuide", seq);
	}

	@Override
	public List<ToditorBBS> getAllToditorGuide() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+"getAllToditorGuide");
	}
}
