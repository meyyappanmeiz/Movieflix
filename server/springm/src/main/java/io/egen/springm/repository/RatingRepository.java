package io.egen.springm.repository;

import java.util.List;

import io.egen.springm.entity.Ratings;

public interface RatingRepository {
	
	public Ratings add(Ratings rating);
	
public Ratings update(Ratings rating);
	
	public List<Ratings> findByMovie(String movieId);

}