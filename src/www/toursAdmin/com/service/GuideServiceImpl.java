package www.toursAdmin.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.toursAdmin.com.dao.GuideDao;
import www.toursAdmin.com.dao.PlanerDao;
import www.toursAdmin.com.model.PlanerDto;

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
	public PlanerDto deleteGuide(int seq) {
		guideDao.deleteGuide(seq);
		return planerDao.getPlanerBySeq(seq);
	}
}
