package oop.keyword1;

//회원 클래스
public class Member {
	private final String id; // 이대로 두면 id가 null값임.. 이럴거면 만든 의미가 없으므로 생성자에서 생성과 동시에 값을 초기화해준다.
							 // 생성자에서 초기화 하지않고 여기에서 초기화하면 모든 인스턴스가 동일한 값을 지니게 된다..! 
							 // 따라서 생성자에서 초기화할 수 있도록 마련해두면, 각 인스턴스에서 변하지 않는 값을 갖을 수 있게 된다.
	private String password;
	private String email;
	
		
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	//필드가 final이면 모든 생성자에서 반드시 이 항목을 초기화해야 한다.
	//final이 붙은 필드는 setter메소드를 만들 수 없다! setter메소드가 값을 변경하려고 만든 것이기 때문!
	public Member(String id, String password) {
		this(id, password, null);
//		this.id = id; //setID(id) (X)
//		this.setPassword(password);
//		this.setEmail(null); // 이 구문은 안 적어도 된다!
		
	}	
	
	public Member(String id, String password, String email) {
		this.id = id;
		this.password = password;
		this.email = email;
	}
}
