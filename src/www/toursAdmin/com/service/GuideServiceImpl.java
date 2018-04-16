package www.toursAdmin.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.toursAdmin.com.dao.GuideDao;
import www.toursAdmin.com.dao.PlanerDao;
import www.toursAdmin.com.model.PlanerDto;
import www.toursAdmin.com.model.ToditorBBS;

@Service
public class GuideServiceImpl implements GuideService {
	@Autowired
	GuideDao guideDao;
	
	@Autowired
	PlanerDao planerDao;

	@Override
	public List<PlanerDto> getAllTodoongGuide() {
		// TODO Auto-generated method stub
		return guideDao.getAllTodoongGuide();
	}

	@Override
	public PlanerDto deleteTodoongGuide(int seq) {
		guideDao.deleteTodoongGuide(seq);
		return planerDao.getPlanerBySeq(seq);
	}

	@Override
	public List<ToditorBBS> getAllToditorGuide() {
		// TODO Auto-generated method stub
		return guideDao.getAllToditorGuide();
	}

	@Override
	public ToditorBBS toditorGuideDetail(int seq) {
		// TODO Auto-generated method stub
		return guideDao.toditorGuideDetail(seq);
	}

	@Override
	public ToditorBBS deleteToditorGuide(int seq) {
		guideDao.deleteToditorGuide(seq);
		return guideDao.toditorGuideDetail(seq);
	}
}
