package www.toursAdmin.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.toursAdmin.com.dao.UploadDao;
import www.toursAdmin.com.model.TotoGuideDto;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	UploadDao uploadDao;

	@Override
	public List<TotoGuideDto> getTotoList() {
		// TODO Auto-generated method stub
		return uploadDao.getTotoList();
	}

	@Override
	public TotoGuideDto getUploadDetail(int seq) {
		// TODO Auto-generated method stub
		return uploadDao.getUploadDetail(seq);
	}

	@Override
	public TotoGuideDto deleteUpload(int seq) {
		// TODO Auto-generated method stub
		uploadDao.deleteUpload(seq);
		return uploadDao.getUploadDetail(seq);
	}

	@Override
	public void dataUpload(TotoGuideDto upload) {
		// TODO Auto-generated method stub
		uploadDao.dataUpload(upload);
	}

}
