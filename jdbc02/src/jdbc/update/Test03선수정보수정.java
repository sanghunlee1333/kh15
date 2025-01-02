package jdbc.update;

import jdbc.dao.PlayerDao;
import jdbc.dto.PlayerDto;

public class Test03선수정보수정 {

	public static void main(String[] args) {
		
		PlayerDto playerDto = new PlayerDto();
		playerDto.setPlayerNo(2);
		playerDto.setPlayerName("김수녕");
		playerDto.setPlayerEvent("양궁");
		playerDto.setPlayerType("하계");
		playerDto.setPlayerGoldMedal(3);
		playerDto.setPlayerSilverMedal(2);
		playerDto.setPlayerBronzeMedal(1);
		
		PlayerDao playerDao = new PlayerDao();
		
		boolean success = playerDao.update(playerDto);
		if(success) System.out.println("선수 정보 수정 완료");
		else System.out.println("대상이 아닙니다");
		
	}

}
