package com;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MovieMapper implements RowMapper<Movie> {

	
	@Override
	public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		Movie movie = new Movie();
		
		movie.setID(rs.getString(1));
		movie.setName(rs.getString(2));
		movie.setDescription(rs.getString(3));
		movie.setLanguage(rs.getString(4));
		movie.setType(rs.getString(5));
		movie.setExperience(rs.getString(6));
		movie.setImage(rs.getString(7));
		
		return movie;

	}

	

}
