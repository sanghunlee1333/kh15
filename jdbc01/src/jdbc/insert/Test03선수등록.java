package jdbc.insert;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcFactory;

public class Test03선수등록 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("선수 이름 : ");
		String playerName = sc.next();
		
		System.out.print("종목 : ");
		String playerEvent = sc.next();
		
		System.out.print("구분 : ");
		String playerType = sc.next();
		
		System.out.print("금메달 개수 : ");
		int playerGoldMedal = sc.nextInt();
		
		System.out.print("은메달 개수 : ");
		int playerSilverMedal = sc.nextInt();
		
		System.out.print("동메달 개수 : ");
		int playerBronzeMedal = sc.nextInt();
		
		//데이터베이스처리
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		
		String sql = "insert into player(player_no, player_name, player_event, player_type, player_gold_medal, player_silver_medal, player_bronze_medal) "
				+ "values(player_seq.nextval, ?, ?, ?, ?, ?, ?)";
		Object[] data = {playerName, playerEvent, playerType, playerGoldMedal, playerSilverMedal, playerBronzeMedal}; 
		
		// 실행
		jdbcTemplate.update(sql, data); //data도 같이 넣어준다
		System.out.println("실행 완료");
		
	}

}
