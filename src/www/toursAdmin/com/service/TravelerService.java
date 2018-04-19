package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.LevelDto;
import www.toursAdmin.com.model.TravelerDto;

public interface TravelerService {

	List<TravelerDto> getAllTraveler();

	TravelerDto getTravelerBySeq(int seq);

	List<LevelDto> getTopRankTraveler();

	boolean updateLevel(int[] users, int status);

}
