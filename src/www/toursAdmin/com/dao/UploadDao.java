package www.toursAdmin.com.dao;

import java.util.List;

import www.toursAdmin.com.model.TotoGuideDto;

public interface UploadDao {

	List<TotoGuideDto> getTotoList();
	TotoGuideDto getUploadDetail(int seq);
	void deleteUpload(int seq);
	void dataUpload(TotoGuideDto upload);
}
