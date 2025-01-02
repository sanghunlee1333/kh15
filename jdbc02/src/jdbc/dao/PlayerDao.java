package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PlayerDto;
import jdbc.mapper.PlayerMapper;
import jdbc.util.JdbcFactory;

public class PlayerDao {

	public void insert(PlayerDto playerDto) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into player(player_no, player_name, player_event, player_type, player_gold_medal, player_silver_medal, player_bronze_medal) "
				+ "values(player_seq.nextval, ?, ?, ?, ?, ?, ?)";
		Object[] data = { playerDto.getPlayerName(), playerDto.getPlayerEvent(), playerDto.getPlayerType(),
				playerDto.getPlayerGoldMedal(), playerDto.getPlayerSilverMedal(), playerDto.getPlayerBronzeMedal() };
		
		jdbcTemplate.update(sql, data);
		
	}
	
	public boolean update(PlayerDto playerDto) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "update player set player_name = ?, player_event = ?, player_type = ?, "
					+ "player_gold_medal = ?, player_silver_medal = ?, player_bronze_medal = ? where player_no = ?";
		Object[] data = {
				playerDto.getPlayerName(), playerDto.getPlayerEvent(), playerDto.getPlayerType(), 
				playerDto.getPlayerGoldMedal(), playerDto.getPlayerSilverMedal(), playerDto.getPlayerBronzeMedal(), playerDto.getPlayerNo()
		};
//		int rows = jdbcTemplate.update(sql, data);
//		return rows > 0;
		
		return jdbcTemplate.update(sql, data) > 0;
		
	}
	
	public boolean delete(int playerNo) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "delete player where player_no = ?";
		Object[] data = {playerNo};
		
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	private PlayerMapper playerMapper = new PlayerMapper();
	
	public List<PlayerDto> selectList(){
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from player";
		return jdbcTemplate.query(sql, playerMapper);
		
	}

}
