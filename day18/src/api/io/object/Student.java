package api.io.object;

import java.io.Serializable;

//이 클래스의 인스턴스가 파일에 저장될 수 있다면 java.io.Serializable을 상속
//(+추가) 출력에서 특정 필드를 제외할 수 있다(transient 키워드)
//(+추가) 클래스의 내용이 변할 수 있으므로 버전 설정이 가능 (serialVersionUID)

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //버전1
	private String name;
	private transient int score; //입출력 제외 항목
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

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

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	
	

}
