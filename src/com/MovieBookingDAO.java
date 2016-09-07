package com;

import java.util.List;

public interface MovieBookingDAO {

	// for showing all the movie in drop down 
		public List<Movie> showMovie();
		
    // for login
		public int login(String loginas, String userName, String password);
		
	// for mobile using user Id
		public long mobile(String userId);
		
	// fetch movie name by movie Id
		public String getMovieName(String movieId);
		
	// fetch address of theater by theater Id
		public String getTheaterAddress(String theaterId);
		
    // for showing theater for respective theater admin home
		public List<Theaters> showTheaters(String theaterAdminID);
		
    // for registering user
		public void registerUser(String name, String userName, String password, long phoneNumber);
		
    // for theaters list
		public List<Movie> showMovie(String city, String language);
		
	// for getting details of movie on thye basis of movie id
		public Movie movieDetails(String movieId);
	
	// for getting city for movie
		public List<City> getCity(String movieId);
		
	// for getting theaters for a movie in a city
		public List<TheaterMovie> getTheaters(String movieId, String city, String date);
		
	// for booking movie non login users
		public UserMovieTheaterShowTiming bookTickets(String userId, TheaterMovie theaterMovie, long mobile, String date);
		
}
