package com.demo.spring.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.exception.DataExistException;
import com.demo.spring.exception.UserNotFoundException;
import com.demo.spring.model.GithubUser;
import com.demo.spring.repository.UserRepository;

@Service
public class UserService {
	public static final String githubBaseUrl = "https://api.github.com/users/";
	public static final String indianPostalBaseUrl = "";
	RestTemplate restTemplate;

	@Autowired
	UserRepository userRepository;

	public UserService() {
		this.restTemplate = new RestTemplate();
	}

	public GithubUser searchUserByGithubUserName(String userName) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Object> entity = new HttpEntity<Object>(headers);

		try {
			ResponseEntity<GithubUser> response = restTemplate.exchange(githubBaseUrl + userName, HttpMethod.GET,
					entity, GithubUser.class);
			return response.getBody();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new UserNotFoundException(userName);
		}
	}

	public GithubUser saveData(String userName) {
		GithubUser userResult = searchUserByGithubUserName(userName);
		
		if (userResult != null) {
			if(userRepository.existsById(userResult.getId())) {
				throw new DataExistException("user " + userName + " is exist!!!");
			} else {
				return userRepository.insert(userResult);	
			}
		} else {
			throw new UserNotFoundException(userName);
		}
	}
}
