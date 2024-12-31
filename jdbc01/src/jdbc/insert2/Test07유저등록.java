package jdbc.insert2;

public class Test07유저등록 {

	public static void main(String[] args) {
		
		GameUserDto gameUserDto = new GameUserDto();
		gameUserDto.setGameUserId("아스카주니어");
		gameUserDto.setGameUserJob("전사");
		gameUserDto.setGameUserLevel(30);
		gameUserDto.setGameUserMoney(10000);
		
		GameUserDao gameUserDao = new GameUserDao();
		gameUserDao.insert(gameUserDto);
		
		System.out.println("유저 등록 완료");
		
	}

}
