package www.toursAdmin.com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.toursAdmin.com.dao.PlanerDao;
import www.toursAdmin.com.dao.TravelerDao;
import www.toursAdmin.com.model.CoTravelerDto;
import www.toursAdmin.com.model.DayPlanerDto;
import www.toursAdmin.com.model.Korea;
import www.toursAdmin.com.model.PlanerDto;
import www.toursAdmin.com.model.TimePlanerDto;
import www.toursAdmin.com.model.TravelerDto;

@Service
public class PlanerServiceImpl implements PlanerService{

	Logger logger = LoggerFactory.getLogger(PlanerServiceImpl.class);

	@Autowired
	PlanerDao planerDao;

	@Autowired
	TravelerDao travelDao;


	@Override
	public PlanerDto addPlaner(PlanerDto planer) {
		//	저장한 후 , Dto 세팅
		int planer_seq = planerDao.addPlaner(planer);

		TravelerDto traveler = travelDao.getUserBySeq(planer.getTarget_user_seq());
		CoTravelerDto coTravelerDto = new CoTravelerDto(traveler.getSeq(), planer_seq, traveler.getName());
		travelDao.addCoTraveler(coTravelerDto);

		return planerDao.getPlaner(planer_seq);
	}


	@Override
	public PlanerDto getPlaner(int seq) {
		return planerDao.getPlaner(seq);
	}


	public List<PlanerDto> getplanList(int seq) {
		// TODO Auto-generated method stub
		return planerDao.getplanList(seq);
	}

	@Override
	public List<DayPlanerDto> getDayplanList(int seq) {
		// TODO Auto-generated method stub
		return planerDao.getDayplanList(seq);
	}

	@Override
	public DayPlanerDto getDayPlanerByTargetPlanerSeqAndDayCount(DayPlanerDto dayPlaner) {
		return planerDao.getDayPlanerByTargetPlanerSeqAndDayCount(dayPlaner);
	}


	@Override
	public DayPlanerDto addDayPlaner(DayPlanerDto dayPlaner) {
		int seq = planerDao.addDayPlaner(dayPlaner);
		return planerDao.getDayPlanerBySeq(seq);
	}


	@Override
	public TimePlanerDto addTimePlaner(TimePlanerDto timePlaner) {
		int seq = planerDao.addTimePlaner(timePlaner);
		return planerDao.getTimePlanerBySeq(seq);
	}


	@Override
	public List<TimePlanerDto> getAllTimePlanersByTargetDayPlanerSeq(int seq) {
		return planerDao.getAllTimePlanersByTargetDayPlanerSeq(seq);
	}


	@Override
	public boolean changeTitle(PlanerDto planer) {

		return planerDao.changeTitle(planer);
	}
	
	@Override
	public boolean planDelete(int seq) {
		// TODO Auto-generated method stub
		return planerDao.planDelete(seq);
	}

	public void updateCompletePlaner(PlanerDto planer) {
		planerDao.updateCompletePlaner(planer);
	}


	@Override
	public List<Korea> getKoreaList() {
		return planerDao.getKoreaList();
	}






}
