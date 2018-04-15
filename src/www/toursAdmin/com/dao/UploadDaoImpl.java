package www.toursAdmin.com.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import www.toursAdmin.com.model.TotoGuideDto;

@Repository
public class UploadDaoImpl implements UploadDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String namespace = "Upload.";

	@Override
	public List<TotoGuideDto> getTotoList() {
		return sqlSession.selectList(namespace+"getTotoList");
	}

	@Override
	public TotoGuideDto getUploadDetail(int seq) {
		return sqlSession.selectOne(namespace+"getUploadDetail", seq);
	}

	@Override
	public void deleteUpload(int seq) {
		sqlSession.update(namespace+"deleteUpload", seq);		
	}

	@Override
	public void dataUpload(TotoGuideDto upload) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+"dataUpload", upload);
	}
}
