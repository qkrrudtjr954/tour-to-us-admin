package www.toursAdmin.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.toursAdmin.com.dao.FreeDao;
import www.toursAdmin.com.model.CommuFreeBbsDto;

@Service
public class FreeServiceImpl implements FreeService {

	@Autowired
	FreeDao freeDao;

	@Override
	public List<CommuFreeBbsDto> getAllFree() {
		// TODO Auto-generated method stub
		return freeDao.getAllFree();
	}

	@Override
	public CommuFreeBbsDto getFreeDetail(int seq) {
		// TODO Auto-generated method stub
		return freeDao.getFreeDetail(seq);
	}

	@Override
	public CommuFreeBbsDto deleteFree(int seq) {
		freeDao.deleteFree(seq);
		return freeDao.getFreeDetail(seq);
	}
}
