package www.toursAdmin.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.toursAdmin.com.dao.PlanerDao;
import www.toursAdmin.com.model.DayPlanerDto;
import www.toursAdmin.com.model.PlanerDto;
import www.toursAdmin.com.model.TimePlanerDto;

@Service
public class PlanerServiceImpl implements PlanerService{
	@Autowired
	PlanerDao planerDao;

	@Override
	public List<PlanerDto> getAllPlaner() {
		return planerDao.getAllPlaner();
	}

	@Override
	public PlanerDto getPlanerBySea(int seq) {
		return planerDao.getPlanerBySeq(seq);
	}

	@Override
	public PlanerDto deletePlaner(int seq) {
		planerDao.deletePlaner(seq);
		return planerDao.getPlanerBySeq(seq);
	}

	@Override
	public List<DayPlanerDto> getDayPlanerByTargetPlanerSeq(int seq) {
		return planerDao.getDayPlanerByTargetPlanerSeq(seq);
	}

	@Override
	public List<TimePlanerDto> getTimePlanerByDayPlanerSeqAndDay(DayPlanerDto dayPlaner) {
		return planerDao.getTimePlanerByDayPlanerSeqAndDay(dayPlaner);
	}
	
	

}
