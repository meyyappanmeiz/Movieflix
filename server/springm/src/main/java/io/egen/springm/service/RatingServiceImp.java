package io.egen.springm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.springm.entity.Movies;
import io.egen.springm.entity.Ratings;
import io.egen.springm.entity.Users;
import io.egen.springm.exception.MovieNotFoundException;
import io.egen.springm.exception.UserNotFoundException;
import io.egen.springm.repository.MoviesRepository;
import io.egen.springm.repository.RatingRepository;
import io.egen.springm.repository.UserRepository;

@Service
public class RatingServiceImp implements RatingService {

	@Autowired
	RatingRepository repository;

	@Autowired
	MoviesRepository mRepo;

	@Autowired
	UserRepository uRepo;

	@Override
	@Transactional
	public Ratings add(String movieId, Ratings rating) {
		Users user = uRepo.findById(rating.getUsers().getUserId());
		
		if (user == null) {
			throw new UserNotFoundException("User not found");
		}
		rating.setUsers(user);
		return repository.add(rating);
	}

	@Override
	@Transactional
	public Ratings update(String movieId, Ratings rating) {
		Users user = uRepo.findById(rating.getUsers().getUserId());
		
		if (user == null) {
			throw new UserNotFoundException("User not found");
		}
		rating.setUsers(user);
		return repository.update(rating);
	}

	@Override
	public List<Ratings> findByMovie(String movieId) {
		return repository.findByMovie(movieId);
	}

}
