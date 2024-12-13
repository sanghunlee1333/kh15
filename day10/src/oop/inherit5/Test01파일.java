package oop.inherit5;

public class Test01파일 {

	public static void main(String[] args) {
		
		MP4 a = new MP4("동영상.mp4", 1.2f);
		MP3 b = new MP3("음악.mp3", 20000000, 194);
		HWP c = new HWP("강의노트.hwp", 10);
		PPT d = new PPT("강사 오리엔테이션.ppt", 20);
		
		System.out.println("<MP4 기능>");
		a.execute();
		a.forward();
		a.rewind();
		a.information();
		System.out.println();
		
		System.out.println("<MP3 기능>");
		b.execute();
		b.forward();
		b.rewind();
		b.information();
		System.out.println();
		
		System.out.println("<HWP 기능>");
		c.execute();
		c.preview();
		c.information();
		System.out.println();
		
		System.out.println("<PPT 기능>");
		d.execute();
		d.slideShow();
		d.information();		
		
	}

}
