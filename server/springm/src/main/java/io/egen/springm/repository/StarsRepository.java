package io.egen.springm.repository;

import io.egen.springm.entity.Stars;

public interface StarsRepository {
	
	public Stars create(Stars star);

	public Stars update(Stars star);

	public void delete(Stars star);

	public Stars findFullCast(String movieId);
	
	public Stars findById(String id);

}
