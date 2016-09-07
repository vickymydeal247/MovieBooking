package com;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TheaterMapper implements RowMapper<Theaters> {

	@Override
	public Theaters mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Theaters theaters = new Theaters();
		
		Address  address  = new Address();
		
		theaters.setID(rs.getString(1));
		theaters.setName(rs.getString(2));
		theaters.setCity(rs.getString(3));
		address.setLocation(rs.getString(4));
		address.setPincode(Integer.parseInt(rs.getString(5)));
		theaters.setAddress(address);
		theaters.setNumberOfScreen(Integer.parseInt(rs.getString(6)));
		theaters.setSeats(Integer.parseInt(rs.getString(7)));
		theaters.setPrice(Integer.parseInt(rs.getString(8)));
		
		return theaters;
		
	}

}
