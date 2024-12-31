package jdbc.insert2;

public class GameUserDto {
	
	private int gameUserNo;
	private String gameUserId;
	private String gameUserJob;
	private int gameUserLevel;
	private int gameUserMoney;
	
	public int getGameUserNo() {
		return gameUserNo;
	}
	public void setGameUserNo(int gameUserNo) {
		this.gameUserNo = gameUserNo;
	}
	public String getGameUserId() {
		return gameUserId;
	}
	public void setGameUserId(String gameUserId) {
		this.gameUserId = gameUserId;
	}
	public String getGameUserJob() {
		return gameUserJob;
	}
	public void setGameUserJob(String gameUserJob) {
		this.gameUserJob = gameUserJob;
	}
	public int getGameUserLevel() {
		return gameUserLevel;
	}
	public void setGameUserLevel(int gameUserLevel) {
		this.gameUserLevel = gameUserLevel;
	}
	public int getGameUserMoney() {
		return gameUserMoney;
	}
	public void setGameUserMoney(int gameUserMoney) {
		this.gameUserMoney = gameUserMoney;
	}
	
	@Override
	public String toString() {
		return "GameUserDto [gameUserNo=" + gameUserNo + ", gameUserId=" + gameUserId + ", gameUserJob=" + gameUserJob
				+ ", gameUserLevel=" + gameUserLevel + ", gameUserMoney=" + gameUserMoney + "]";
	}
	
	public GameUserDto() {
		super();
	}

}
