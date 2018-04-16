package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.PlanerDto;
import www.toursAdmin.com.model.ToditorBBS;

public interface GuideService {
	public List<PlanerDto> getAllTodoongGuide();
	public PlanerDto deleteTodoongGuide(int seq);
	public List<ToditorBBS> getAllToditorGuide();
	public ToditorBBS toditorGuideDetail(int seq);
	public ToditorBBS deleteToditorGuide(int seq);
}
