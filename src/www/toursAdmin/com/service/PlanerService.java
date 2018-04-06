package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.DayPlanerDto;
import www.toursAdmin.com.model.Korea;
import www.toursAdmin.com.model.PlanerDto;
import www.toursAdmin.com.model.TimePlanerDto;

public interface PlanerService {

	PlanerDto addPlaner(PlanerDto planer);

	public List<PlanerDto> getplanList(int seq);

	public List<DayPlanerDto> getDayplanList(int seq);

	PlanerDto getPlaner(int seq);

	DayPlanerDto getDayPlanerByTargetPlanerSeqAndDayCount(DayPlanerDto dayPlaner);

	DayPlanerDto addDayPlaner(DayPlanerDto dayPlaner);

	TimePlanerDto addTimePlaner(TimePlanerDto timePlaner);

	List<TimePlanerDto> getAllTimePlanersByTargetDayPlanerSeq(int seq);

	public boolean changeTitle(PlanerDto planer);
	
	public boolean planDelete(int seq);

	void updateCompletePlaner(PlanerDto planer);

	List<Korea> getKoreaList();
}
