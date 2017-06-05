package io.egen.springm.repository;

import java.util.List;

import io.egen.springm.entity.Comments;

public interface CommentRepository {
	
	public Comments add(Comments comments);
	
	public List<Comments> findByMovie(String movieId);
	
	public Comments findById(String id);
	
	public Comments update(Comments comment);
	
	public void delete(Comments comment);
	

}
