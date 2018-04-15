package www.toursAdmin.com.dao;

import java.util.List;

import www.toursAdmin.com.model.PlanerDto;
import www.toursAdmin.com.model.ToditorBBS;

public interface GuideDao {
	List<PlanerDto> getAllTodoongGuide();
	void deleteTodoongGuide(int seq);
	List<ToditorBBS> getAllToditorGuide();
	ToditorBBS toditorGuideDetail(int seq);
}
