package com;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TheaterMovieMapper implements RowMapper<TheaterMovie>{

	@Override
	public TheaterMovie mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		TheaterMovie theaterMovie = new TheaterMovie();
		
		             theaterMovie.setTheaterID(rs.getString(1));
		             theaterMovie.setMovieID(rs.getString(2));
		             theaterMovie.setShowTime(Integer.parseInt(rs.getString(3)));
		             theaterMovie.setScreenNumber(Integer.parseInt(rs.getString(4)));
		             theaterMovie.setSeats(Integer.parseInt(rs.getString(5)));
		             theaterMovie.setPrice(Integer.parseInt(rs.getString(6)));
		             theaterMovie.setAddress(rs.getString(7));
		             
		             return theaterMovie;
			
	}

}
