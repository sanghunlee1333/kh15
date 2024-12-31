package jdbc.insert2;

public class Test03선수등록 {

	public static void main(String[] args) {
		
		PlayerDto playerDto = new PlayerDto();
		playerDto.setPlayerName("전이경");
		playerDto.setPlayerEvent("쇼트트랙");
		playerDto.setPlayerType("동계");
		playerDto.setPlayerGoldMedal(4);
		playerDto.setPlayerSilverMedal(2);
		playerDto.setPlayerBronzeMedal(3);
		
		PlayerDao playerDao = new PlayerDao();
		playerDao.insert(playerDto);
		
		System.out.println("선수 등록 완료");
	}

}
