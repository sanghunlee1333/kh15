package jdbc.insert2;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcFactory;

public class PhoneDao {
	
	public void insert(PhoneDto phoneDto) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into phone(phone_no, phone_name, phone_telecom, phone_price, phone_contract) "
				+ "values(phone_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {
			phoneDto.getPhoneName(), phoneDto.getPhoneTelecom(), phoneDto.getPhonePrice(), phoneDto.getPhoneContract()	
		};
		jdbcTemplate.update(sql, data);
		
	}

}
