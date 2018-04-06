package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.CoTravelerDto;
import www.toursAdmin.com.model.TravelerDto;

public interface TravelerService {

	public boolean signup(TravelerDto dto) throws Exception;
	public TravelerDto getUserByEmail(String email) throws Exception;

	public TravelerDto signin(TravelerDto dto) throws Exception;
	public List<TravelerDto> getTravelersByNamdOrEmail(String name);

	TravelerDto getUserBySeq(int seq);
	int addCoTraveler(CoTravelerDto coTravelerDto);
	public boolean checkCoTraveler(CoTravelerDto coTraveler);
	public boolean deleteCoTraveler(CoTravelerDto coTraveler);
	public boolean myInfoUpd(TravelerDto dto);
	
	List<TravelerDto> getCoTravelers(int planer_seq);

}
