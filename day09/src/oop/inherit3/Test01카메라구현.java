package oop.inherit3;

public class Test01카메라구현 {

	public static void main(String[] args) {
		
		WebCam w1 = new WebCam();
		ActionCam a1 = new ActionCam();
		DigitalCam d1 = new DigitalCam();
		
		//w1.setName("웹캠");
		//w1.setPixel(1000000);
		w1.record();
		w1.decorate();
		
		//a1.setName("액션캠");
		//a1.setPixel(5000000);
		a1.record();
		a1.slowMotion();
		a1.reduce();
		
		//d1.setName("디지털캠");
		//d1.setPixel(10000000);
		d1.record();
		d1.slowMotion();
		d1.wideRecord();
		
	}

}
