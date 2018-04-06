package www.toursAdmin.com.dao;

import java.util.List;

import www.toursAdmin.com.model.DayPlanerDto;
import www.toursAdmin.com.model.Korea;
import www.toursAdmin.com.model.PlanerDto;
import www.toursAdmin.com.model.TimePlanerDto;

public interface PlanerDao {

	int addPlaner(PlanerDto planer);

	PlanerDto getPlaner(int seq);

	List<PlanerDto> getplanList(int seq);

	List<DayPlanerDto> getDayplanList(int seq);

	DayPlanerDto getDayPlanerByTargetPlanerSeqAndDayCount(DayPlanerDto dayPlaner);

	int addDayPlaner(DayPlanerDto dayPlaner);

	DayPlanerDto getDayPlanerBySeq(int seq);

	int addTimePlaner(TimePlanerDto timePlaner);

	TimePlanerDto getTimePlanerBySeq(int seq);

	List<TimePlanerDto> getAllTimePlanersByTargetDayPlanerSeq(int seq);

	boolean changeTitle(PlanerDto planer);
	
	boolean planDelete(int seq);

	void updateCompletePlaner(PlanerDto planer);

	List<Korea> getKoreaList();
}
