package www.toursAdmin.com.dao;

import java.util.List;

import www.toursAdmin.com.model.PlanerDto;

public interface UserGuideDao {

	List<PlanerDto> getUserPlanList(); 
	
	List<PlanerDto> guideSearch(PlanerDto plan);

	int guideCount(PlanerDto plan);
}
