package jdbc.insert2;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcFactory;

public class GameUserDao {
	
	public void insert(GameUserDto gameUserDto) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into game_user(game_user_no, game_user_id, game_user_job, game_user_level, game_user_money) "
				+ "values(game_user_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {
			
			gameUserDto.getGameUserId(), gameUserDto.getGameUserJob(), gameUserDto.getGameUserLevel(), gameUserDto.getGameUserMoney()				
				
		};
		jdbcTemplate.update(sql, data);
		
	}

}
