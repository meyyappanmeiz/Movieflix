package io.egen.springm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.springm.entity.Comments;
import io.egen.springm.entity.Movies;
import io.egen.springm.entity.Users;
import io.egen.springm.exception.MovieNotFoundException;
import io.egen.springm.repository.CommentRepository;
import io.egen.springm.repository.MoviesRepository;
import io.egen.springm.repository.UserRepository;

@Service
public class CommentServiceImp implements CommentService{
	
	@Autowired
	CommentRepository repository;
	@Autowired
	MoviesRepository mRepo;
	@Autowired
	UserRepository uRepo;

	@Override
	@Transactional
	public Comments add(String movieId, Comments comments) {
		Movies movie = mRepo.findOne(comments.getMovies().getMovieId());
		Users user = uRepo.findById(comments.getUsers().getUserId());
		comments.setMovies(movie);
		comments.setUsers(user);
		return repository.add(comments);
	}

	@Override
	public List<Comments> findByMovie(String movieId) {
		return (List<Comments>) repository.findByMovie(movieId);
	}
	
	@Override
	public Comments findById(String id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Comments update(String movieId, Comments comment) {
		Movies movie = mRepo.findOne(movieId);
		Users user = uRepo.findById(comment.getUsers().getUserId());
		if(movie == null){
			throw new MovieNotFoundException("Movie not found");
		}
		comment.setMovies(movie);
		comment.setUsers(user);
		return repository.update(comment);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Comments comment = repository.findById(id);
		repository.delete(comment);
		
	}

}