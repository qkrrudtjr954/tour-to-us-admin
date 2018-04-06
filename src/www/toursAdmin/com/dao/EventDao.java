package www.toursAdmin.com.dao;

import java.util.List;

import www.toursAdmin.com.model.EventDto;


public interface EventDao {
	List<EventDto> getEventList();
	EventDto getEventDetail(int seq);
}
