package com.example.assisment1.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.assisment1.model.User;

@Service
public class UserServices {

	HashMap<Integer, User> data = new HashMap<>();
	AtomicInteger atomicInteger = new AtomicInteger();

	public User create(User user) {
		user.setId(atomicInteger.incrementAndGet());
		this.data.put(user.getId(), user);
		return user;
	}

	public Collection<User> getAll() {
		return this.data.values();

	}



	public User getById(Integer id) {
		return this.data.get(id);

	}

	   public void update(Integer id ,User user) {
	     user.setId(id);
	     this.data.put(user.getId(), user);
	    }

	    public void delete(Integer id) {
	        this.data.remove(id);
	    }

}
