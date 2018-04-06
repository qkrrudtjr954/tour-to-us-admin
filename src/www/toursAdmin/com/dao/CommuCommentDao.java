package www.toursAdmin.com.dao;

import java.util.List;

import www.toursAdmin.com.model.CommuAfterCommentDto;

public interface CommuCommentDao {
	
public List<CommuAfterCommentDto> getAllComments(int seq) throws Exception;	
public boolean addComment(CommuAfterCommentDto comment) throws Exception;
//public List<CommuAfterCommentDto> getComment(int seq) throws Exception;


}
