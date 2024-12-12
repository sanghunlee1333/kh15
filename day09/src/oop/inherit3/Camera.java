package oop.inherit3;

public class Camera {
	private String name;
	private int pixel;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPixel() {
		return pixel;
	}
	public void setPixel(int pixel) {
		this.pixel = pixel;
	}
	
	public void recording() {
		System.out.println("동영상 녹화 기능 실행");
	}
	

}
