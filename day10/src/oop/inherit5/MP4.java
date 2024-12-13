package oop.inherit5;

public class MP4 extends MediaFile {
	
	private float speed; //1.2배속

	public float getSpeed() {
		return this.speed;
	}

	public void setSpeed(float speed) {
		if(speed >= 0.5f && speed <=2) this.speed = speed;
		//float는 switch구문 불가능!! 오차도 있고 switch구문 자체가 빨리 찾아야하는데 float는 어렵다. 
		//case 1.000001f: //안됨
		//case 1.000002f: //안됨
	}

	public MP4(String filename, long filesize, float speed) { //(중요!) 이 부분 강의 다시 듣고 정리
		super(filename, filesize); //상위 클래스꺼 쓰고
		this.setSpeed(speed); //추가한 내꺼 쓰고
	}

	public MP4(String filename, float speed) {
		super(filename);
		this.setSpeed(speed);
		
	}
	
	//information이 마음에 안드니까 재정의해서 재생시간을 추가하겠다
	//오버라이딩도 자동 완성 가능 Source - Override/Implement Method..
		@Override
		public void information() {
			super.information(); //기존의 information을 실행하고
			System.out.println("재생속도 : " + this.speed + "배속");
								
		}
	
	

	
}
