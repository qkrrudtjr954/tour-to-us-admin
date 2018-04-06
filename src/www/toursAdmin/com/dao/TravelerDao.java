package www.toursAdmin.com.dao;

import java.util.List;

import www.toursAdmin.com.model.TravelerDto;

public interface TravelerDao {

	List<TravelerDto> getAllTraveler();

	TravelerDto getTravelerBySeq(int seq);

	void deleteTraveler(int seq);

}
