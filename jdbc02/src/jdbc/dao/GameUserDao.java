package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.GameUserDto;
import jdbc.mapper.GameUserMapper;
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
	
	public boolean delete(int gameUserNo) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "delete game_user where game_user_no = ?";
		Object[] data = {gameUserNo};
		return jdbcTemplate.update(sql, data) > 0;
		
	}
	
	private GameUserMapper gameUserMapper = new GameUserMapper();
	
	public List<GameUserDto> selectList(){
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from game_user";
		
		return jdbcTemplate.query(sql, gameUserMapper);
		
	}

}
