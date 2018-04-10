package www.toursAdmin.com.dao;

import java.util.List;

import www.toursAdmin.com.model.DayPlanerDto;
import www.toursAdmin.com.model.PlanerDto;
import www.toursAdmin.com.model.TimePlanerDto;

public interface PlanerDao {

	List<PlanerDto> getAllPlaner();

	PlanerDto getPlanerBySeq(int seq);

	void deletePlaner(int seq);

	List<DayPlanerDto> getDayPlanerByTargetPlanerSeq(int seq);

	List<TimePlanerDto> getTimePlanerByDayPlanerSeqAndDay(int seq);

}
