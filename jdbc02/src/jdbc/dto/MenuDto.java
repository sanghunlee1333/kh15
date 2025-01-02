package jdbc.dto;

public class MenuDto {
	
	private int menuNo;
	private String menuName;
	private String menuType;
	private int menuPrice;
	private String menuEvent;
	
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getMenuEvent() {
		return menuEvent;
	}
	public void setMenuEvent(String menuEvent) {
		this.menuEvent = menuEvent;
	}
	
	@Override
	public String toString() {
		return "MenuDto [menuNo=" + menuNo + ", menuName=" + menuName + ", menuType=" + menuType + ", menuPrice="
				+ menuPrice + ", menuEvent=" + menuEvent + "]";
	}
	
	public MenuDto() {
		super();
	}
	
}
