package www.toursAdmin.com.dao;


import java.util.List;

import www.toursAdmin.com.model.CoTravelerDto;
import www.toursAdmin.com.model.TravelerDto;

public interface TravelerDao {

	TravelerDto signin(TravelerDto dto)throws Exception;
	boolean signup(TravelerDto dto) throws Exception;
	TravelerDto getUserByEmail(String email);
	List<TravelerDto> getTravelersByNamdOrEmail(String name);
	List<TravelerDto> getCoTravelers(int planer_seq);
	TravelerDto getUserBySeq(int seq);
	int addCoTraveler(CoTravelerDto coTravelerDto);
	CoTravelerDto getCoTraveler(CoTravelerDto coTraveler);
	boolean deleteCoTraveler(CoTravelerDto coTraveler);
	boolean myInfoUpd(TravelerDto dto);
	
	

}
