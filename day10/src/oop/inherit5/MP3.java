package oop.inherit5;

public class MP3 extends MediaFile {

	private int duration; //ex) 3분 14초 -> 194초 -> int

	//생성자
	public MP3(String filename, long filesize, int duration) {
		super(filename, filesize); //원래 있던 것은 상위로 보내준다. 무조건 먼저 적어야 함! 처리 순서1
		this.setDuration(duration); //내가 가지고 있는 것. 처리 순서2
	}

	public MP3(String filename, int duration) {
		super(filename);
		this.setDuration(duration);
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		if(duration <= 0) return;
		this.duration = duration;
	}

	//information이 마음에 안드니까 재정의해서 재생시간을 추가하겠다
	@Override
	public void information() {
		super.information(); //기존의 information을 실행하고
		System.out.println("재생시간 : " + this.duration / 60 + "분" + this.duration % 60 + "초");
				
	}
	
}
