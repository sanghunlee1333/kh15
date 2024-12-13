package oop.inherit5;

public class File {
	protected String filename; // 파일이름이 어떻게 될지 모르니(향후 변경될 가능성 농후) -> protected
								// 하위 클래스의 setter에서 작성한 규칙 수정 가능
	private long filesize; // 파일 크기는 어떤 확장자는 음수만 아니면 되는 고정 규칙을 가지고 있음(절대불변의 규칙) -> private
								// 하위 클래스의 setter에서 규칙 수정 불가
							//int로는 최대 2GB 미만까지 밖에 표현을 못함 -> long으로 선언
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		if (filesize < 0L) return;
		this.filesize = filesize;
	}
	
	//생성자
	//생성자 오버로딩
	public File(String filename) { //filesize가 0일 것을 대비해서 오버로딩
		this(filename, 0L); //몰아주기 표현
	}
	public File(String filename, long filesize) {
		this.setFilename(filename);
		this.setFilesize(0L);
	}

	public void execute() {
		System.out.println("실행");
	}
	
	public /*final*/ void information() {
		System.out.println("<파일 정보>");
		System.out.println("파일명 : " + this.filename);
		System.out.println("파일크기 : " + this.filesize + "bytes");
	}
}
