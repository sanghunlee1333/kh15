package jdbc.dto;

public class LectureDto {
	
	private int lectureNo;
	private String lectureName;
	private String lectureCategory;
	private int lecturePeriod;
	private int lecturePrice;
	private String lectureType;
	
	public int getLectureNo() {
		return lectureNo;
	}
	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}
	public String getLectureName() {
		return lectureName;
	}
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	public String getLectureCategory() {
		return lectureCategory;
	}
	public void setLectureCategory(String lectureCategory) {
		this.lectureCategory = lectureCategory;
	}
	public int getLecturePeriod() {
		return lecturePeriod;
	}
	public void setLecturePeriod(int lecturePeriod) {
		this.lecturePeriod = lecturePeriod;
	}
	public int getLecturePrice() {
		return lecturePrice;
	}
	public void setLecturePrice(int lecturePrice) {
		this.lecturePrice = lecturePrice;
	}
	public String getLectureType() {
		return lectureType;
	}
	public void setLectureType(String lectureType) {
		this.lectureType = lectureType;
	}
	
	@Override
	public String toString() {
		return "LectureDto [lectureNo=" + lectureNo + ", lectureName=" + lectureName + ", lectureCategory="
				+ lectureCategory + ", lecturePeriod=" + lecturePeriod + ", lecturePrice=" + lecturePrice
				+ ", lectureType=" + lectureType + "]";
	}
	
	public LectureDto() {
		super();
	}
		
}
