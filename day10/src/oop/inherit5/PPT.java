package oop.inherit5;

public class PPT extends DocumentFile {
	
	public PPT(String filename, int pagesize) {
		super(filename, pagesize);
	}

	public PPT(String filename, long filesize, int pagesize) {
		super(filename, filesize, pagesize);
	}

	public void slideShow() {
		
		System.out.println("슬라이드쇼 기능 실행");
		
	}

}
