package oop.inherit5;

public class DocumentFile extends File {

	// protected int pagesize; //ppt와 hwp의 페이지 최대 장수가 다르다. 잘 모르겠다 할 경우에 사용
	private int pagesize; // ppt, hwp의 페이지 장수가 0이하면 안된다.(절대 규칙)

	public int getPagesize() {
		return this.pagesize;
	}

	public void setPagesize(int pagesize) {
		if (pagesize <= 0)
			return;
		this.pagesize = pagesize;
	}

	//생성자
	public DocumentFile(String filename, long filesize, int pagesize) {
		super(filename, filesize);
		this.setPagesize(pagesize);
	}

	public DocumentFile(String filename, int pagesize) {
		super(filename);
		this.setPagesize(pagesize);
	}

}
