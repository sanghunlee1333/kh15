package jdbc.select;

import java.util.List;

import jdbc.dao.PlayerDao;
import jdbc.dto.PlayerDto;

public class Test03선수조회 {

	public static void main(String[] args) {
		
		PlayerDao playerDao = new PlayerDao();
		List<PlayerDto> list = playerDao.selectList();
		
		for(PlayerDto playerDto : list) {
			System.out.println(playerDto);
		}
		
	}

}
