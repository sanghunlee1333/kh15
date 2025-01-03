package jdbc.select3;

import jdbc.dao.PlayerDao;
import jdbc.dto.PlayerDto;

public class Test03선수상세 {

	public static void main(String[] args) {
		
		int playerNo = 2;
		
		PlayerDao playerDao = new PlayerDao();
		PlayerDto playerDto = playerDao.selectOne(playerNo);
		
		if(playerDto == null) {
			System.out.println("존재하지 않은 선수 번호");
		}
		else {
			System.out.println(playerDto);
		}

	}

}
