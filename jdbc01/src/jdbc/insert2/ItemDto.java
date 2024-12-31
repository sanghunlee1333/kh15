package jdbc.insert2;

public class ItemDto {
	
	private int itemNo;
	private String itemName;
	private String itemType;
	private int itemPrice;
	private Float itemDiscountRate;
	private int itmQty;
	private String itemEarly;
	
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public Float getItemDiscountRate() {
		return itemDiscountRate;
	}
	public void setItemDiscountRate(Float itemDiscountRate) {
		this.itemDiscountRate = itemDiscountRate;
	}
	public int getItmQty() {
		return itmQty;
	}
	public void setItmQty(int itmQty) {
		this.itmQty = itmQty;
	}
	public String getItemEarly() {
		return itemEarly;
	}
	public void setItemEarly(String itemEarly) {
		this.itemEarly = itemEarly;
	}
	
	@Override
	public String toString() {
		return "ItemDto [itemNo=" + itemNo + ", itemName=" + itemName + ", itemType=" + itemType + ", itemPrice="
				+ itemPrice + ", itemDiscountRate=" + itemDiscountRate + ", itmQty=" + itmQty + ", itemEarly="
				+ itemEarly + "]";
	}
	
	public ItemDto() {
		super();
	}
	
}
