package PO;

public class BigChangePO {
	private String code;
	private String time;
	private double price;//当前价格
	private double volume;//成交手
	private double preprice;//上一笔价格
	private String type;//买卖类型【买盘、卖盘、中性盘】
	public BigChangePO(String code, String time, double price, double volume, double preprice, String type) {
		super();
		this.code = code;
		this.time = time;
		this.price = price;
		this.volume = volume;
		this.preprice = preprice;
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getPreprice() {
		return preprice;
	}
	public void setPreprice(double preprice) {
		this.preprice = preprice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
