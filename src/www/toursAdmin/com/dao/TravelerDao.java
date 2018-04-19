package www.toursAdmin.com.dao;

import java.util.List;

import www.toursAdmin.com.model.LevelDto;
import www.toursAdmin.com.model.TravelerDto;

public interface TravelerDao {

	List<TravelerDto> getAllTraveler();

	TravelerDto getTravelerBySeq(int seq);

	List<LevelDto> getTopRankTraveler();

	boolean updateLevel(int i, int status);

}
