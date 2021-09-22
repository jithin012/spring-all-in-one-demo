package com.demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.model.GithubUser;
import com.demo.spring.service.UserService;


@RestController
@BasePathAwareController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/search/{userName}")
	public ResponseEntity<GithubUser> searchUser(@PathVariable(required = true) String userName) {
		GithubUser userResult = userService.searchUserByGithubUserName(userName);
		return new ResponseEntity<GithubUser>(userResult, HttpStatus.OK);
	}

	@PostMapping("/{userName}")
	public ResponseEntity<GithubUser> saveUser(@PathVariable(required = true) String userName) {
		GithubUser user = userService.saveData(userName);
		return new ResponseEntity<GithubUser>(user, HttpStatus.OK);
	}

}
