package oop.constructor3;

public class Lecture {
	//필드
	private String lecture;
	private String type;
	private int time;
	private int price;
	private String form;

	//메소드
	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		if (time < 0) return;
		if (time % 30 != 0)	return; //if(time < 0 && time % 30 != 0) return; 과 같은 의미.
		this.time = time;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price % 1000 != 0 && price < 0)	return;
		this.price = price;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		switch (form) {
		case "온라인", "오프라인", "혼합":
			this.form = form;
		}
	}
	
	public int getPricePertime() {
		return this.price / this.time;
	}
	
	public void show() {
		System.out.println("<강의 정보>");
		System.out.println("강좌명 : " + this.getLecture());
		System.out.println("구분 : " + this.getType());
		System.out.println("강의 시간 : " + this.getTime());
		System.out.print("수강료 : " + this.getPrice() + "원 ");
		System.out.println("(시간당 : " + this.getPricePertime() + "원)");
		System.out.println("수업 형태 : " + this.getForm());
		
	}
	
	//생성자(constructor)
	public Lecture (String lecture, String type, int time, int price) {
		this(lecture, type, time, price, "오프라인");
	}	
	
	public Lecture (String lecture, String type, int time, int price, String form) {
		this.setLecture(lecture);
		this.setType(type);
		this.setTime(time);
		this.setPrice(price);
		this.setForm(form);
	}

}
