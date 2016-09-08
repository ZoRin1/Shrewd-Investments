package PO;

public class OperationPO {
	private String code;//代码
	private String name;//名称
	private String arturnover;//应收账款周转率(次)
	private String arturndays;//应收账款周转天数(天)
	private String inventory_turnover;//存货周转率(次)
	private String inventory_days;//存货周转天数(天)
	private String currentasset_turnover;//流动资产周转率(次)
	private String currentasset_days;//流动资产周转天数(天)
	public OperationPO(String code, String name, String arturnover, String arturndays, String inventory_turnover,
			String inventory_days, String currentasset_turnover, String currentasset_days) {
		super();
		this.code = code;
		this.name = name;
		this.arturnover = arturnover;
		this.arturndays = arturndays;
		this.inventory_turnover = inventory_turnover;
		this.inventory_days = inventory_days;
		this.currentasset_turnover = currentasset_turnover;
		this.currentasset_days = currentasset_days;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArturnover() {
		return arturnover;
	}
	public void setArturnover(String arturnover) {
		this.arturnover = arturnover;
	}
	public String getArturndays() {
		return arturndays;
	}
	public void setArturndays(String arturndays) {
		this.arturndays = arturndays;
	}
	public String getInventory_turnover() {
		return inventory_turnover;
	}
	public void setInventory_turnover(String inventory_turnover) {
		this.inventory_turnover = inventory_turnover;
	}
	public String getInventory_days() {
		return inventory_days;
	}
	public void setInventory_days(String inventory_days) {
		this.inventory_days = inventory_days;
	}
	public String getCurrentasset_turnover() {
		return currentasset_turnover;
	}
	public void setCurrentasset_turnover(String currentasset_turnover) {
		this.currentasset_turnover = currentasset_turnover;
	}
	public String getCurrentasset_days() {
		return currentasset_days;
	}
	public void setCurrentasset_days(String currentasset_days) {
		this.currentasset_days = currentasset_days;
	}
	
}
