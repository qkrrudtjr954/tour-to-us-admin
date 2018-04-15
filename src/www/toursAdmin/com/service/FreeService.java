package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.CommuFreeBbsDto;

public interface FreeService {
	public List<CommuFreeBbsDto> getAllFree();
	public CommuFreeBbsDto getFreeDetail(int seq);
	public CommuFreeBbsDto deleteFree(int seq);
}
