package io.egen.springm.service;

import java.util.List;

import io.egen.springm.entity.Ratings;

public interface RatingService {
	
	public Ratings add(String movieId, Ratings rating);
	
	public Ratings update(String movieId, Ratings rating);
	
	public List<Ratings> findByMovie(String movieId);

}