package www.toursAdmin.com.contoller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import www.toursAdmin.com.model.Korea;
import www.toursAdmin.com.model.TotoGuideDto;
import www.toursAdmin.com.service.PlanerService;
import www.toursAdmin.com.service.UploadService;



@Controller
public class UploadController {
	@Autowired
	UploadService uploadService;
	
	@Autowired
	PlanerService planerService;
	
	Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value="dataUploadList.do", method=RequestMethod.GET)
	public String toto_write(Model model)throws Exception {
		logger.info("UploadController >>>> dataUploadList");
		
		List<TotoGuideDto> list = uploadService.getTotoList();
		
		model.addAttribute("menu_id", "upload");
		model.addAttribute("doc_title", "자료 업로드 관리");
		model.addAttribute("uploadlist", list);
		
		return "uploadList.tiles";
	}
	
	@RequestMapping(value="uploadDetail.do", method=RequestMethod.GET)
	public String uploadDetail(Model model, int seq)throws Exception{
		logger.info("UploadController >>>> uploadDetail");
		
		TotoGuideDto upload = uploadService.getUploadDetail(seq);
		
		model.addAttribute("menu_id", "upload");
		model.addAttribute("doc_title", "자료 상세보기");
		model.addAttribute("upload", upload);
		
		return "uploadDetail.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value="uploadDelete.do", method=RequestMethod.GET)
	public TotoGuideDto uploadDelete(int seq)throws Exception {
		logger.info("UploadController >>>> uploadDelete");
		
		TotoGuideDto upload = uploadService.deleteUpload(seq);
		
		return upload;
	}
	
	@RequestMapping(value="uploadInsert.do", method=RequestMethod.GET)
	public String uploadInsert(Model model)throws Exception {
		logger.info("UploadController >>>> uploadInsert");
		List<Korea> korea = planerService.getKoreaList();
		
		model.addAttribute("menu_id", "upload");
		model.addAttribute("doc_title", "자료 업로드하기");		
		model.addAttribute("korea", korea);
		
		return "uploadInsert.tiles";
	}
	
	@RequestMapping(value="uploadInsertAf.do", method=RequestMethod.POST)
	public String uploadInsertAf(Model model, TotoGuideDto upload, HttpServletRequest req, @RequestParam(value="fileload")MultipartFile fileload) {
		logger.info("UploadController >>>> uploadInsertAf");
		
		// upload -MultipartResolver spring에 추가
		upload.setFilename(fileload.getOriginalFilename());
		// 폴더저장
		String fupload = "c:\\test";
		String f = upload.getFilename();
		
		// 이름변경
		//String newFile = FUpUtil.getNewFile(f);
		upload.setFilename(f);
		
		try {
			File file = new File(fupload+"/"+f);
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			
			// db insert
			uploadService.dataUpload(upload);
			
		} catch (IOException e) {
			System.out.println("upload fail");
		}
		
		return "redirect:/dataUploadList.do";
	}
}








