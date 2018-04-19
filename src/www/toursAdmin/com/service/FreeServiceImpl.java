package www.toursAdmin.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.toursAdmin.com.dao.FreeDao;
import www.toursAdmin.com.model.CommuFreeBbsDto;
import www.toursAdmin.com.model.CommuFreeCategoryDto;

@Service
public class FreeServiceImpl implements FreeService {

	@Autowired
	FreeDao freeDao;

	@Override
	public List<CommuFreeBbsDto> getAllFree() {
		// TODO Auto-generated method stub
		return freeDao.getAllFree();
	}

	@Override
	public CommuFreeBbsDto getFreeDetail(int seq) {
		// TODO Auto-generated method stub
		return freeDao.getFreeDetail(seq);
	}

	@Override
	public CommuFreeBbsDto deleteFree(int seq) {
		freeDao.deleteFree(seq);
		return freeDao.getFreeDetail(seq);
	}

	@Override
	public List<CommuFreeCategoryDto> getCategory() {
		// TODO Auto-generated method stub
		return freeDao.getCategory();
	}

	@Override
	public void categoryInsert(CommuFreeCategoryDto categoryDto) {
		// TODO Auto-generated method stub
		freeDao.categoryInsert(categoryDto);
	}

	@Override
	public CommuFreeCategoryDto updateStatus(int seq) {
		CommuFreeCategoryDto categoryDto = freeDao.getCategoryBySeq(seq);
		categoryDto.setStatus((categoryDto.getStatus()+1) % 2);
		freeDao.updateStatus(categoryDto);
		System.out.println("ser"+categoryDto.toString());
		
		return freeDao.getCategoryBySeq(seq);
	}

	@Override
	public CommuFreeCategoryDto getCategoryBySeq(int seq) {
		// TODO Auto-generated method stub
		return freeDao.getCategoryBySeq(seq);
	}
}
