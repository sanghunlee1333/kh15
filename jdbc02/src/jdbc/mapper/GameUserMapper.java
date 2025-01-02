package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.GameUserDto;

public class GameUserMapper implements RowMapper<GameUserDto>{

	@Override
	public GameUserDto mapRow(ResultSet rs, int arg1) throws SQLException {

		GameUserDto gameUserDto = new GameUserDto();
		gameUserDto.setGameUserNo(rs.getInt("game_user_no"));
		gameUserDto.setGameUserId(rs.getString("game_user_Id"));
		gameUserDto.setGameUserJob(rs.getString("game_user_job"));
		gameUserDto.setGameUserLevel(rs.getInt("game_user_level"));
		gameUserDto.setGameUserMoney(rs.getInt("game_user_money"));
		
		return gameUserDto;
	}
	
	

}
