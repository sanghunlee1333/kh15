package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PhoneDto;
import jdbc.mapper.PhoneMapper;
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
	
	public boolean update(PhoneDto phoneDto) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "update phone set phone_name = ?, phone_telecom = ?, phone_price = ?, phone_contract = ? where phone_no = ?";
		Object[] data = {
			phoneDto.getPhoneName(), phoneDto.getPhoneTelecom(), phoneDto.getPhonePrice(), phoneDto.getPhoneContract(), phoneDto.getPhoneNo()	
		};
		int rows = jdbcTemplate.update(sql, data);
		
		return rows > 0;
		
	}
	
	public boolean delete(int phoneNo) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "delete phone where phone_no = ?";
		Object[] data = {phoneNo};
		
		return jdbcTemplate.update(sql, data) > 0;		
		
	}
	
	private PhoneMapper phoneMapper = new PhoneMapper();
	
	public List<PhoneDto> selectList(){
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from phone";
		
		return jdbcTemplate.query(sql, phoneMapper);
		
	}

}
