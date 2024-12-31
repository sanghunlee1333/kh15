package jdbc.insert2;

public class PlayerDto {
	private int playerNo;
	private String playerName;
	private String playerEvent;
	private String playerType;
	private int playerGoldMedal;
	private int playerSilverMedal;
	private int playerBronzeMedal;
	public int getPlayerNo() {
		return playerNo;
	}
	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerEvent() {
		return playerEvent;
	}
	public void setPlayerEvent(String playerEvent) {
		this.playerEvent = playerEvent;
	}
	public String getPlayerType() {
		return playerType;
	}
	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}
	public int getPlayerGoldMedal() {
		return playerGoldMedal;
	}
	public void setPlayerGoldMedal(int playerGoldMedal) {
		this.playerGoldMedal = playerGoldMedal;
	}
	public int getPlayerSilverMedal() {
		return playerSilverMedal;
	}
	public void setPlayerSilverMedal(int playerSilverMedal) {
		this.playerSilverMedal = playerSilverMedal;
	}
	public int getPlayerBronzeMedal() {
		return playerBronzeMedal;
	}
	public void setPlayerBronzeMedal(int playerBronzeMedal) {
		this.playerBronzeMedal = playerBronzeMedal;
	}
	@Override
	public String toString() {
		return "PlayerDto [playerNo=" + playerNo + ", playerName=" + playerName + ", playerEvent=" + playerEvent
				+ ", playerType=" + playerType + ", playerGoldMedal=" + playerGoldMedal + ", playerSilverMedal="
				+ playerSilverMedal + ", playerBronzeMedal=" + playerBronzeMedal + "]";
	}
	public PlayerDto() {
		super();
	}
	
	
}
