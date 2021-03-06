package io.egen.springm.service;

import java.util.List;

import io.egen.springm.entity.Users;

public interface UserService {

	public Users create(Users user);

	public List<Users> findAll();

	public Users findById(String id);

	public Users update(String id, Users user);

	public void delete(String id);

	public Users login(String username, String password);

}