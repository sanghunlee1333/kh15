package oop.inherit5;

public class HWP extends DocumentFile {
	
		
	public HWP(String filename, int pagesize) {
		super(filename, pagesize);
	}

	public HWP(String filename, long filesize, int pagesize) {
		super(filename, filesize, pagesize);
	}

	public void preview() {
		
		System.out.println("미리보기 기능 실행");
		
	}
}
