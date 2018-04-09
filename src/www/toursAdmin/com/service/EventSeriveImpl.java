package www.toursAdmin.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.toursAdmin.com.dao.EventDao;
import www.toursAdmin.com.model.EventDto;

@Service
public class EventSeriveImpl implements EventService {

	@Autowired
	EventDao eventDao;
	
	@Override
	public List<EventDto> getAllEvent() {
		return eventDao.getAllEvent();
	}

	@Override
	public EventDto getEventBySeq(int seq) {
		return eventDao.getEventBySeq(seq);
	}

	@Override
	public EventDto deleteEvent(int seq) {
		eventDao.deleteEvent(seq);
		return eventDao.getEventBySeq(seq);
	}

	@Override
	public EventDto insertEvent(EventDto event) {
		int seq = eventDao.insertEvent(event);
		return eventDao.getEventBySeq(seq);
	}

	@Override
	public EventDto updateStatus(int seq) {
		EventDto event = eventDao.getEventBySeq(seq);
		event.setStatus((event.getStatus()+1) % 2);
		eventDao.updateStatus(event);
		
		return eventDao.getEventBySeq(seq);
	}

}
