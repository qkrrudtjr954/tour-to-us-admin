package www.toursAdmin.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.toursAdmin.com.dao.LikeDao;
import www.toursAdmin.com.model.LikeDto;

@Service
public class LikeService {

	@Autowired
	LikeDao likedao;

	
	public int prevent_duplication(LikeDto dto) throws Exception{
		return likedao.prevent_duplication(dto);
	}
	
	public void insert_like(LikeDto dto) throws Exception{
		likedao.insert_like(dto);
	}
	
	public void delete_like(LikeDto dto) throws Exception{
		likedao.delete_like(dto);
	}
	
	public int getLikeCount(LikeDto dto) {
		return likedao.getLikeCount(dto);
	}
}
