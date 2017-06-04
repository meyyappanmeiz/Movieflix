package io.egen.springm.service;

import io.egen.springm.entity.Stars;

public interface StarsService {

	public Stars create(Stars star);

	public Stars update(String movieId, Stars star);

	public void delete(String id);

	public Stars findFullCast(String movieId);

}
