package www.toursAdmin.com.dao;

import java.util.List;

import www.toursAdmin.com.model.CommuFreeBbsDto;

public interface FreeDao {
	List<CommuFreeBbsDto> getAllFree();
	CommuFreeBbsDto getFreeDetail(int seq);
	void deleteFree(int seq);
}
