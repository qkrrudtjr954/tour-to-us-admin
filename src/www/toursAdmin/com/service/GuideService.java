package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.PlanerDto;

public interface GuideService {
	public List<PlanerDto> getAllTodoongGuide();
	public PlanerDto deleteGuide(int seq);
}
