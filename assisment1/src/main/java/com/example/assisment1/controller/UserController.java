package com.example.assisment1.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.assisment1.model.User;
import com.example.assisment1.services.UserServices;

@Controller
public class UserController {

	@Autowired
	UserServices service;

	// employee details
	@GetMapping("/add")
	public String empUser(Model model) {
		model.addAttribute("obj", new User());
		return "employee";
	}

	@PostMapping("/add")
	public String addUser(@ModelAttribute User user) {
		this.service.create(user);
		return "redirect:/up";
	}

//upload
	
	@GetMapping("/login")
	public String loginuser() {
		return "login";
		}

	
	
	@GetMapping("/up")
	public String showUploadForm(Model model) {
		model.addAttribute("obj", new User());
		return "upload"; // Return the name of the upload form HTML file
	}

	@PostMapping("/up")
	public String handleFileUpload(@ModelAttribute User user, Model model) {
		MultipartFile file = user.getFile();
		if (file.isEmpty()) {
			model.addAttribute("Please select a file to upload.");
			return "employee";
		}

		try {
			String fileName = file.getOriginalFilename();
			String filePath = "/assisment1/src/main/resources/files" + fileName; // Define your file path
			File dest = new File(filePath);
			file.transferTo(dest);

			user.setFile(file);

			model.addAttribute("fileName", fileName);
			model.addAttribute("message", "File uploaded successfully.");
			return this.userList(model);
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("message", "Failed to upload file.");
			return "redirect:/home";
		}
	}

	// list employee
	@GetMapping("/home")
	public String userList(Model model) {
		model.addAttribute("users", this.service.getAll());
		return "home";

	}

	// edit
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable Integer id, Model model) {
		model.addAttribute("obj", this.service.getById(id));
		return "employee";

	}

	@PostMapping("/edit/{id}")
	public String editUser(@PathVariable Integer id, @ModelAttribute User user) {
		this.service.update(id, user);
		return "redirect:/home";
	}

	// delete
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Integer id) {
		this.service.delete(id);
		return "redirect:/home";
	}
}
