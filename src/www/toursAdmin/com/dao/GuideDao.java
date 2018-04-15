package www.toursAdmin.com.dao;

import java.util.List;

import www.toursAdmin.com.model.PlanerDto;

public interface GuideDao {
	List<PlanerDto> getAllTodoongGuide();
	void deleteGuide(int seq);
}
