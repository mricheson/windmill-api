package org.windmill.api.data.model;

//TODO determine if this is necessary long term
public class User {
	private User() {

	}

	public final Long id = 1L;
	public final String email = "mricheson@gmail.com";
	public final String name = "Mitch";
	public final String imageUrl = "Richeson";
	public final Boolean emailVerified = true;
	public final String password = "don't show password";
	public final String provider = "google";

	public static User defaultUser = new User();
}
