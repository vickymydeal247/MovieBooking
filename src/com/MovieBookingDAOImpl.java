package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class MovieBookingDAOImpl implements MovieBookingDAO
{

	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		
		jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public List<Movie> showMovie() {
		// TODO Auto-generated method stub
		
		String query = "select * from movies";
        
		List<Movie> movie = new ArrayList<Movie>();
		
		             movie = jdbcTemplateObject.query(query, new MovieMapper());
		
		return movie;
		
	}

	@Override
	public int login(String loginas, String userName, String password) {
		// TODO Auto-generated method stub
		
		int v;
		    v = 0;
		
		if(loginas.equalsIgnoreCase("Admin"))
		{
			String query = "SELECT COUNT(*) FROM admin WHERE username = '" + userName + "' AND password = '" + password + "'";
			
			           v = jdbcTemplateObject.query(query, new ResultSetExtractor<Integer>() {
				 
			        public Integer extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			            if (rs.next()) {
			                int c = rs.getInt(1);
			                return c;
			            } 
			            return 0;
			        } 
			    });
		}
		
		if(loginas.equalsIgnoreCase("Theater Admin"))
		{
			String query = "SELECT COUNT(*) FROM theateradmin WHERE username = '" + userName + "' AND password = '" + password + "'";
			
			           v = jdbcTemplateObject.query(query, new ResultSetExtractor<Integer>() {
				 
			        public Integer extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			            if (rs.next()) {
			                int c = rs.getInt(1);
			                return c;
			            } 
			            return 0;
			        } 
			    });
		}
		
		if(loginas.equalsIgnoreCase("User"));
		{
			String query = "SELECT COUNT(*) FROM users WHERE username = '" + userName + "' AND password = '" + password + "'";
			
			           v = jdbcTemplateObject.query(query, new ResultSetExtractor<Integer>() {
				 
			        public Integer extractData(ResultSet rs) throws SQLException,
			                DataAccessException {
			            if (rs.next()) {
			                int c = rs.getInt(1);
			                return c;
			            } 
			            return 0;
			        } 
			    });
		}
		
		return v;
		
	}

	@Override
	public List<Theaters> showTheaters(String theaterAdminID) {
		// TODO Auto-generated method stub
		 
        String query = "select theaterId, name, city, location, pincode, noOfScreens from theateradmin, "
        		+ "theaters, address where theateradmin.theaterId = theaters.theaterId and "
        		+ "theaters.address = address.addressId theateradmin.usernamse = " + theaterAdminID;
        
		List<Theaters> theaters = new ArrayList<Theaters>();
		
		             theaters = jdbcTemplateObject.query(query, new TheaterMapper());
		
		return theaters;
	    
		
	}

	@Override
	public void registerUser(String name, String userName, String password, long phoneNumber) {
		// TODO Auto-generated method stub
		
       String query = "INSERT INTO user (name, username, password, phoneno)" + " VALUES (?, ?, ?, ?)";
		
		jdbcTemplateObject.update(query, name, userName, password, phoneNumber);
	}

	// show movie for asynchronous call
	@Override
	public List<Movie> showMovie(String city, String language) {
		// TODO Auto-generated method stub

		String query = "select movies.ID, movies.name, description, language, type, experience, Image  from movies, theaters where city = '" + city + "' and language = '" + language + "'"; 
        
		List<Movie> movieList = new ArrayList<Movie>();
		
		             movieList = jdbcTemplateObject.query(query, new MovieMapper());
		             
		             return movieList;
		
	}

	@Override
	public Movie movieDetails(String movieId) {
		// TODO Auto-generated method stub
		
		String query = "select * from movies where ID = " + movieId;
		
		ResultSetExtractor<Movie> rse = new ResultSetExtractor<Movie>() {
			
			@Override
			public Movie extractData(ResultSet rse) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				Movie m = new Movie();
				
				if(rse.next())
				{	
				  m.setID(movieId);
				  m.setName(rse.getString(2));
				  m.setDescription(rse.getString(3));
				  m.setLanguage(rse.getString(4));
				  m.setType(rse.getString(5));
				  m.setExperience(rse.getString(6));
				  m.setImage(rse.getString(7));
				  return m;
				}
				return m;
			}
		};
		
		Movie movie  = jdbcTemplateObject.query(query, rse);
		
		return movie;
		
	}

	@Override
	public List<City> getCity(String movieId) {
		// TODO Auto-generated method stub
		
		System.out.println("movieId" + movieId);
		
		String query = "select city from theaters t, theatermovie tm where t.theaterId = tm.theaterId and seats > 1 and StartDate < ? and EndDate > ? and movieId = ?";
		
        List<City> cityList = new ArrayList<City>();  
        
        Date d = new Date();
        
             cityList  = jdbcTemplateObject.query(query, new Object[]{d, d, movieId}, new CityMapper());
          
        return cityList;
		
	}

	@Override
	public List<TheaterMovie> getTheaters(String movieId, String city, String date) {
		// TODO Auto-generated method stub
		
		String query = "select t.theaterId, movieId, showTime, screenNo, seats, price, address from theaters t, theatermovie tm where t.theaterId = tm.theaterId and seats > 1 and StartDate < ? and EndDate > ? and movieId = ? and city = ?";
		
		List<TheaterMovie> theatersList = new ArrayList<TheaterMovie>();
		
		     theatersList = jdbcTemplateObject.query(query, new Object[]{date, date, movieId, city}, new TheaterMovieMapper());
		     
		return theatersList;     
		
	}

	@Override
	public UserMovieTheaterShowTiming bookTickets(String userId, TheaterMovie theaterMovie, long mobile, String date) {
		// TODO Auto-generated method stub
		
		String movieId = theaterMovie.getMovieID();
		
		String theaterId = theaterMovie.getTheaterID();
		
		int showTime = theaterMovie.getShowTime();
		
		System.out.println("mobile" + mobile);
		
		/*@SuppressWarnings("deprecation")
		long d         = Date.parse(date);*/
		
		String query = "insert into usermovietheater (userId, movieId, theaterId, showTime, date, mobile) values(?, ?, ?, ?, ?, ?)";
		
		int result = jdbcTemplateObject.update(query, new Object[]{userId, movieId, theaterId, showTime, date, mobile});
		
		UserMovieTheaterShowTiming userMovieTheaterShowTiming = new UserMovieTheaterShowTiming();
		
		if(result>0)
		{
			userMovieTheaterShowTiming.setUserID(userId);
			userMovieTheaterShowTiming.setMovieID(movieId);
			userMovieTheaterShowTiming.setTheaterID(theaterId);
			userMovieTheaterShowTiming.setShowTime(showTime);
			userMovieTheaterShowTiming.setDate(date);
			userMovieTheaterShowTiming.setMobile(mobile);
		}
		return userMovieTheaterShowTiming;
	}

	@Override
	public String getMovieName(String movieId) {
		// TODO Auto-generated method stub
		
        String query = "select name from movies where ID = " + movieId;
        
        ResultSetExtractor<String> rse = new ResultSetExtractor<String>() {
			
			@Override
			public String extractData(ResultSet rse) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				String movieName = new String();
				
				if(rse.next())
				{	
					movieName = rse.getString(1);
				}
				return movieName;
			}
		};
		
		String movieName = jdbcTemplateObject.query(query, rse);
		
		return movieName;
		
	}

	@Override
	public String getTheaterAddress(String theaterId) {
		// TODO Auto-generated method stub
		
        String query = "select address from theaters where theaterId = " + theaterId;
        
        ResultSetExtractor<String> rse = new ResultSetExtractor<String>() {
			
			@Override
			public String extractData(ResultSet rse) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				String address = new String();
				
				if(rse.next())
				{	
					address = rse.getString(1);
				}
				return address;
			}
		};
		
		String address = jdbcTemplateObject.query(query, rse);
		
		return address;
		
	}

	@Override
	public long mobile(String userId) {
		// TODO Auto-generated method stub
		
        String query = "select mobile from users where userName = '" + userId +"'";
        
        ResultSetExtractor<Long> rse = new ResultSetExtractor<Long>() {
			
			@Override
			public Long extractData(ResultSet rse) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				Long mobile = null;
				
				if(rse.next())
				{	
					mobile = Long.parseLong(rse.getString(1));
				}
				return mobile;
			}
		};
		
		Long address = jdbcTemplateObject.query(query, rse);
		
		return address;
		
	}
	
}
