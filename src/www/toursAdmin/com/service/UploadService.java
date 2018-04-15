package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.TotoGuideDto;

public interface UploadService {
	public List<TotoGuideDto> getTotoList();
	public TotoGuideDto getUploadDetail(int seq);
	public TotoGuideDto deleteUpload(int seq);
	public void dataUpload(TotoGuideDto upload);
}
