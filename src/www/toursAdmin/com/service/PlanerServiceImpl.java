package www.toursAdmin.com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.toursAdmin.com.dao.PlanerDao;
import www.toursAdmin.com.model.DayPlanerDto;
import www.toursAdmin.com.model.Korea;
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
	public List<TimePlanerDto> getTimePlanerByDayPlanerSeqAndDay(int seq) {
		return planerDao.getTimePlanerByDayPlanerSeqAndDay(seq);
	}

	@Override
	public Map<DayPlanerDto, List<TimePlanerDto>> getSubPlaners(int seq) {
		List<DayPlanerDto> dayPlaners = planerDao.getDayPlanerByTargetPlanerSeq(seq);
		
		Map<DayPlanerDto, List<TimePlanerDto>> subPlaners = new HashMap<>();
		dayPlaners.stream().forEach(dayPlaner -> {
			subPlaners.put(dayPlaner, planerDao.getTimePlanerByDayPlanerSeqAndDay(dayPlaner.getSeq()));
		});
		
		return subPlaners;
	}

	@Override
	public List<Korea> getKoreaList() {
		// TODO Auto-generated method stub
		return planerDao.getKoreaList();
	}

}
