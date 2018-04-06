package www.toursAdmin.com.service;

import java.util.List;

import www.toursAdmin.com.model.CommuAfterCommentDto;

public interface CommuCommentService {
		
public List<CommuAfterCommentDto> addComment(CommuAfterCommentDto comment) throws Exception;
public List<CommuAfterCommentDto> getAllComments(int seq) throws Exception;




}
