package oop.inherit5;

public class MediaFile extends File {

	//추가 메소드 작성
	public void forward() {
		System.out.println(super.getFilename() + "빨리감기 기능 실행"); // this.filename도 가능. 상위의 있는 기능을 상속 받았으니 나에게도 있는 것!
	}
	
	public void rewind() {
		System.out.println(this.filename + "되감기 기능 실행");
	}

	//생성자를 상위 클래스에 맞춰 생성
	public MediaFile(String filename, long filesize) {
		super(filename, filesize);
	}

	//생성자 오버로딩
	public MediaFile(String filename) {
		super(filename);
	}
	
	
}
