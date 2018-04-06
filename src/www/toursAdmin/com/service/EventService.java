package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.EventDto;

public interface EventService {
	public List<EventDto> getEventList();
	public EventDto getEventDetail(int seq);
}
