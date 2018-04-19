package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.CommuFreeBbsDto;
import www.toursAdmin.com.model.CommuFreeCategoryDto;

public interface FreeService {
	public List<CommuFreeBbsDto> getAllFree();
	public CommuFreeBbsDto getFreeDetail(int seq);
	public CommuFreeBbsDto deleteFree(int seq);
	public List<CommuFreeCategoryDto> getCategory();
	public void categoryInsert(CommuFreeCategoryDto categoryDto);
	public CommuFreeCategoryDto updateStatus(int seq);
	public CommuFreeCategoryDto getCategoryBySeq(int seq);
}
