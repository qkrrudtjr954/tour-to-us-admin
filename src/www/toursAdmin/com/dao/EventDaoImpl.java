package www.toursAdmin.com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import www.toursAdmin.com.model.EventDto;

@Repository
public class EventDaoImpl implements EventDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	private String namespace = "Event.";
	
	@Override
	public List<EventDto> getAllEvent() {
		return sqlSession.selectList(namespace + "getAllEvent");
	}

	@Override
	public EventDto getEventBySeq(int seq) {
		return sqlSession.selectOne(namespace + "getEventBySeq", seq);
	}

	@Override
	public void deleteEvent(int seq) {
		sqlSession.update(namespace + "deleteEvent", seq);
	}

	@Override
	public int insertEvent(EventDto event) {
		sqlSession.insert(namespace + "insertEvent", event);
		return event.getSeq();
	}

	@Override
	public void updateStatus(EventDto event) {
		sqlSession.update(namespace + "updateStatus", event);
	}
	

}
