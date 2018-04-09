package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.EventDto;

public interface EventService {

	List<EventDto> getAllEvent();

	EventDto getEventBySeq(int seq);

	EventDto deleteEvent(int seq);

	EventDto insertEvent(EventDto event);

	EventDto updateStatus(int seq);

}
