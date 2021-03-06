package www.toursAdmin.com.dao;

import java.util.List;

import www.toursAdmin.com.model.EventDto;

public interface EventDao {

	List<EventDto> getAllEvent();

	EventDto getEventBySeq(int seq);

	void deleteEvent(int seq);

	int insertEvent(EventDto event);

	void updateStatus(EventDto event);

}
