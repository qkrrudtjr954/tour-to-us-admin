package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.DayPlanerDto;
import www.toursAdmin.com.model.PlanerDto;
import www.toursAdmin.com.model.TimePlanerDto;

public interface PlanerService {

	List<PlanerDto> getAllPlaner();

	PlanerDto getPlanerBySea(int seq);

	PlanerDto deletePlaner(int seq);

	List<DayPlanerDto> getDayPlanerByTargetPlanerSeq(int seq);

	List<TimePlanerDto> getTimePlanerByDayPlanerSeqAndDay(DayPlanerDto dayPlaner);

}
