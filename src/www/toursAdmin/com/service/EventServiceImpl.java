package www.toursAdmin.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.toursAdmin.com.dao.EventDao;
import www.toursAdmin.com.model.EventDto;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventDao eventDao;

	@Override
	public List<EventDto> getEventList() {
		// TODO Auto-generated method stub
		return eventDao.getEventList();
	}

	@Override
	public EventDto getEventDetail(int seq) {
		// TODO Auto-generated method stub
		return eventDao.getEventDetail(seq);
	}
}
