package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.TravelerDto;

public interface TravelerService {

	List<TravelerDto> getAllTraveler();

	TravelerDto getTravelerBySeq(int seq);

	TravelerDto deleteTraveler(int seq);

}
