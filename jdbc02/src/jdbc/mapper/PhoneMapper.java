package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.PhoneDto;

public class PhoneMapper implements RowMapper<PhoneDto>{
	
	@Override
	public PhoneDto mapRow(ResultSet rs, int arg1) throws SQLException {
		
		PhoneDto phoneDto = new PhoneDto();
		phoneDto.setPhoneNo(rs.getInt("phone_no"));
		phoneDto.setPhoneName(rs.getString("phone_name"));
		phoneDto.setPhoneTelecom(rs.getString("phone_telecom"));
		//phoneDto.setPhonePrice(rs.getInt("phone_price")); //비추천
		//phoneDto.setPhoneContract((Integer)rs.getObject("phone_contract")); //비추천
		phoneDto.setPhoneContract(rs.getObject("phone_contract", Integer.class)); //추천
		
		return phoneDto;
		
	}
	

}
