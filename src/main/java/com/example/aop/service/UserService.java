package com.example.aop.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.aop.entity.User;

public interface UserService {

	User saveUser(User user);

	List<User> getUsers();

	

	List<User> getByEmail(String email);

	List<User> deleteById(int id);

	List<User> getByIds(int id);

	

	List<User> getAllList();

	User updateUsers(int id, User user);

	

	

}
