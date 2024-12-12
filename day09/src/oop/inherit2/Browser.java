package oop.inherit2;

//공통 내용에 대한 클래스 (슈퍼 클래스, 상위 클래스, 부모 클래스)

//Chrome / Edge / Whale ---extends---> Browser. 크롬/엣지/웨일("this")이 브라우저를 선택해서 상속 받은 것!
public class Browser {
			
	//공통 필드
	private String url; //상속받은 클래스에서 private은 방어벽. 그 해결책으로 protected 사용
	
	//공통 메소드
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void refresh() {
		System.out.println("새로고침 기능 실행");
	}
	
	public void move() {
		System.out.println("페이지 이동 기능 실행");
	}
}
