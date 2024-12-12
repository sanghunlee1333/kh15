package oop.constructor2;

public class Character {
	//필드
	private String id;
	private String job;
	private int level;
	private int money;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		switch(job) {
			//case "도둑", "성직자", "전사":
			case "도둑":
			case "성직자":
			case "전사":
				this.job = job;
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if (level < 1) return;
		this.level = level;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		if (money < 0) return;
		this.money = money;
	}
	
	//init 메소드 대신 생성자. 앞에 void 작성X -> init메소드와 구분하기 위해 안 적음
	//생성자 오버로딩
	public Character (String id, String job) {
		this(id, job, 1, 0); //생성자 몰아주기. this.init(,,,) (X)
//		this.setId(id);
//		this.setJob(job);
//		this.setLevel(1);
//		this.setMoney(0);
	}
	
	public Character (String id, String job, int level, int money) {
		this.setId(id);
		this.setJob(job);
		this.setLevel(level);
		this.setMoney(money);
	}
	
	public void show() { //다른 클래스에서도 show를 이용할 수 있도록 public으로 선언
		System.out.println("<캐릭터 정보>");
		System.out.println("아이디 : " + this.getId()); //this.id
		System.out.println("직업 : " + this.getJob()); //this.job
		System.out.println("레벨 : " + this.getLevel()); //this.level
		System.out.println("소지금 : " + this.getMoney() + "gold"); //this.money
		
	}
	
	
}
