package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PhoneDto;
import jdbc.util.JdbcFactory;

public class PhoneDao {
	
	public void insert(PhoneDto phoneDto) {
		
		
		
	}
	
	public boolean update(PhoneDto phoneDto) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "update phone set phone_name = ?, phone_telecom = ?, phone_price = ?, phone_contract = ? where phone_no = ?";
		Object[] data = {
			phoneDto.getPhoneName(), phoneDto.getPhoneTelecom(), phoneDto.getPhonePrice(), phoneDto.getPhoneContract(), phoneDto.getPhoneNo()	
		};
		int rows = jdbcTemplate.update(sql, data);
		
		return rows > 0;
		
	}

}
