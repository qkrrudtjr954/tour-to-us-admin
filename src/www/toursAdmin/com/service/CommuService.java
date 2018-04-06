package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.CommuAfterBbsDto;

public interface CommuService {
	
	List<CommuAfterBbsDto> getAfterBbslist()throws Exception;
	
	boolean afterwriteBbs(CommuAfterBbsDto bbs)throws Exception;
	
	public CommuAfterBbsDto getAfterBbs(int seq) throws Exception;
	
	boolean AfterUpdate(CommuAfterBbsDto bbs) throws Exception;
	
	boolean Afterdelete(int seq) throws Exception;
	
	public List<CommuAfterBbsDto> AftergetBbsPagingList(CommuAfterBbsDto afterparam) throws Exception;
	
	public int AfterGetBbsCount(CommuAfterBbsDto aftercontparam) throws Exception;
	

}
