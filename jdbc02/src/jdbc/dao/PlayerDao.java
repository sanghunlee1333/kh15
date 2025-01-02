package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PlayerDto;
import jdbc.util.JdbcFactory;

public class PlayerDao {

	public void insert(PlayerDto playerDto) {
		
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

}
