package PO;
//作为主页面上的大盘短消息显示
public class ShortPO {
	private String code;
	private String name;
	private double price;//大盘点数
	public ShortPO(String code, String name, double price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
