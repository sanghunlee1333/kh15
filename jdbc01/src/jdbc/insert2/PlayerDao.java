package jdbc.insert2;

import org.springframework.jdbc.core.JdbcTemplate;

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

}
