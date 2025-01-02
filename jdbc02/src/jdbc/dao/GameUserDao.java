package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.GameUserDto;
import jdbc.util.JdbcFactory;

public class GameUserDao {
	
	public void insert(GameUserDto gameUserDto) {
		
		
		
	}
	
	public boolean update(GameUserDto gameUserDto) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "update game_user set game_user_id = ?, game_user_job = ?, game_user_level = ?, game_user_money = ? where game_user_no = ?";
		Object[] data = {
			
			gameUserDto.getGameUserId(), gameUserDto.getGameUserJob(), gameUserDto.getGameUserLevel(), 
			gameUserDto.getGameUserMoney(), gameUserDto.getGameUserNo()			
				
		};
		int rows = jdbcTemplate.update(sql, data);
		
		return rows > 0;
		
	}

}
