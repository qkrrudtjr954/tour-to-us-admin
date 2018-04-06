package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.PlanerDto;

public interface UserGuideService {

	public List<PlanerDto> getUserPlanList();
	
	public List<PlanerDto> guideSearch(PlanerDto plan);
	
	public int guideCount(PlanerDto plan);
}
