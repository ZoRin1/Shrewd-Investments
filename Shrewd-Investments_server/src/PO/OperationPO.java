package PO;

public class OperationPO {
	private String code;//代码
	private String name;//名称
	private double arturnover;//应收账款周转率(次)
	private double arturndays;//应收账款周转天数(天)
	private double inventory_turnover;//存货周转率(次)
	private double inventory_days;//存货周转天数(天)
	private double currentasset_turnover;//流动资产周转率(次)
	private double currentasset_days;//流动资产周转天数(天)
	public OperationPO(String code, String name, double arturnover, double arturndays, double inventory_turnover,
			double inventory_days, double currentasset_turnover, double currentasset_days) {
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
	public double getArturnover() {
		return arturnover;
	}
	public void setArturnover(double arturnover) {
		this.arturnover = arturnover;
	}
	public double getArturndays() {
		return arturndays;
	}
	public void setArturndays(double arturndays) {
		this.arturndays = arturndays;
	}
	public double getInventory_turnover() {
		return inventory_turnover;
	}
	public void setInventory_turnover(double inventory_turnover) {
		this.inventory_turnover = inventory_turnover;
	}
	public double getInventory_days() {
		return inventory_days;
	}
	public void setInventory_days(double inventory_days) {
		this.inventory_days = inventory_days;
	}
	public double getCurrentasset_turnover() {
		return currentasset_turnover;
	}
	public void setCurrentasset_turnover(double currentasset_turnover) {
		this.currentasset_turnover = currentasset_turnover;
	}
	public double getCurrentasset_days() {
		return currentasset_days;
	}
	public void setCurrentasset_days(double currentasset_days) {
		this.currentasset_days = currentasset_days;
	}
	
}
