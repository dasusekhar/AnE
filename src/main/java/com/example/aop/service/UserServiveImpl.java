package com.example.aop.service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aop.entity.User;
import com.example.aop.repository.UserRepository;

@Service
public class UserServiveImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		
		User saveUs=userRepository.save(user);
		Set<User> addUnque=new HashSet<>();
		
		addUnque.add(saveUs);
	
		return saveUs;
	}

	@Override
	
	
	public List<User> getUsers() {
		List<User> set1=userRepository.findAll();
		//set1.stream().sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
	
		set1.stream().sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
	
		
		
		return set1;
	}

	@Override
	public List<User> getByEmail(String email) {

		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> deleteById(int id) {
	 userRepository.deleteById(id);
		return userRepository.findAll();
	}

	@Override
	public List<User> getByIds(int id) {
		
		
		return  userRepository.findById(id).get();
	}

	

	@Override
	public User updateUsers(int id, User user) {
		User users=userRepository.findById(id).get();
		users.setName(user.getName());
		users.setEmail(user.getEmail());
		users.setExperience(user.getExperience());
		users.setDomain(user.getDomain());
		
		return users ;
	}

	@Override
	public List<User> getAllList() {
		List<User> lists=userRepository.findAll();
		lists.stream().sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
		
		return  lists;
	}
	

	
	
	
	
	

}
