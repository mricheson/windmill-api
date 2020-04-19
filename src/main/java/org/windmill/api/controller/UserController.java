package org.windmill.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.windmill.api.data.model.User;
import org.windmill.api.data.repository.UserRepository;
import org.windmill.api.exception.ResourceNotFoundException;
import org.windmill.api.security.CurrentUser;
import org.windmill.api.security.UserPrincipal;

//TODO determine if this is necessary long term
@RestController
public class UserController {

	private UserRepository userRepository = new UserRepository() {
	};

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
		return userRepository.findById(userPrincipal.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
	}
}
