package jdbc.insert2;

public class PhoneDto {
	
	private int phoneNo;
	private String phoneName;
	private String phoneTelecom;
	private int phonePrice;
	private Integer phoneContract;
	
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPhoneName() {
		return phoneName;
	}
	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}
	public String getPhoneTelecom() {
		return phoneTelecom;
	}
	public void setPhoneTelecom(String phoneTelecom) {
		this.phoneTelecom = phoneTelecom;
	}
	public int getPhonePrice() {
		return phonePrice;
	}
	public void setPhonePrice(int phonePrice) {
		this.phonePrice = phonePrice;
	}
	public Integer getPhoneContract() {
		return phoneContract;
	}
	public void setPhoneContract(Integer phoneContract) {
		this.phoneContract = phoneContract;
	}
	
	@Override
	public String toString() {
		return "PhoneDto [phoneNo=" + phoneNo + ", phoneName=" + phoneName + ", phoneTelecom=" + phoneTelecom
				+ ", phonePrice=" + phonePrice + ", phoneContract=" + phoneContract + "]";
	}
	
	public PhoneDto() {
		super();
	}
	
}
