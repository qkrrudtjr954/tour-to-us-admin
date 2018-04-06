package www.toursAdmin.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.toursAdmin.com.dao.UserGuideDao;
import www.toursAdmin.com.model.PlanerDto;

@Service
public class UserGuideServiceImpl implements UserGuideService {

	@Autowired
	UserGuideDao userGuideDao;

	@Override
	public List<PlanerDto> getUserPlanList() {
		// TODO Auto-generated method stub
		return userGuideDao.getUserPlanList();
	}

	@Override
	public List<PlanerDto> guideSearch(PlanerDto plan) {
		// TODO Auto-generated method stub
		return userGuideDao.guideSearch(plan);
	}

	@Override
	public int guideCount(PlanerDto plan) {
		// TODO Auto-generated method stub
		return userGuideDao.guideCount(plan);
	}
}
