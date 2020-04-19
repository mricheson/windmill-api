package org.windmill.api.data.repository;

import java.util.Optional;

import org.windmill.api.data.model.User;

//TODO determine if this is necessary long term
public interface UserRepository {

	default Optional<User> findByEmail(String email) {
		if (User.defaultUser.email.equals(email)) {
			return Optional.of(User.defaultUser);
		}
		return Optional.empty();
	}

	default Boolean existsByEmail(String email) {
		return findByEmail(email).isPresent();
	}

	default Optional<User> findById(Long id) {
		if (User.defaultUser.id.equals(id)) {
			return Optional.of(User.defaultUser);
		}
		return Optional.empty();
	}
}
