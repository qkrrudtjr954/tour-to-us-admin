package www.toursAdmin.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.toursAdmin.com.dao.TravelerDao;
import www.toursAdmin.com.model.TravelerDto;

@Service
public class TravelerServiceImpl implements TravelerService{
	@Autowired
	TravelerDao travelerDao;

	@Override
	public List<TravelerDto> getAllTraveler() {
		return travelerDao.getAllTraveler();
	}

	@Override
	public TravelerDto getTravelerBySeq(int seq) {
		return travelerDao.getTravelerBySeq(seq);
	}

	@Override
	public TravelerDto deleteTraveler(int seq) {
		travelerDao.deleteTraveler(seq);
		return travelerDao.getTravelerBySeq(seq);
	}
}
