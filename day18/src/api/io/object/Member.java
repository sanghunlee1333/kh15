package api.io.object;

import java.io.Serializable;

public class Member implements Serializable {
	private String id;
	private String password;
	private String nickname;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Member(String id, String password, String nickname) {
		super();
		this.id = id;
		this.password = password;
		this.nickname = nickname;
	}
	
	
}
