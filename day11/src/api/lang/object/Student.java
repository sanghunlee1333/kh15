package api.lang.object;

import java.util.Objects;

//내가 만든 클래스는 상속을 적어야 이루어지는데.. Object를 상속받을 수 있을까?
public class Student /* extends Object */ { //Object 슈퍼클래스는 기본 탑재되어 있음
	private String name;
	
	//Source - Generate hashcode and equals -> 수동으로 치지말자
	//일련번호를 보고 싶은게 아니기 때문에 메소드를 개조해야한다.
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	private int score;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
