package www.toursAdmin.com.dao;

import java.util.List;

import www.toursAdmin.com.model.CommuFreeBbsDto;
import www.toursAdmin.com.model.CommuFreeCategoryDto;

public interface FreeDao {
	List<CommuFreeBbsDto> getAllFree();
	CommuFreeBbsDto getFreeDetail(int seq);
	void deleteFree(int seq);
	List<CommuFreeCategoryDto> getCategory();
	void categoryInsert(CommuFreeCategoryDto categoryDto);
	void updateStatus(CommuFreeCategoryDto categoryDto);
	CommuFreeCategoryDto getCategoryBySeq(int seq);
}
