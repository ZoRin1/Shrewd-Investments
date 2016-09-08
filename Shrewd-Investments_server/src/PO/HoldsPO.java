package PO;

public class HoldsPO {
	private String code;
	private String name;
	private String date;//报告日期
	private double nums;//基金家数
	private double nlast;//与上期相比（增加或减少了）
	private double count;//基金持股数（万股）
	private double clast;//与上期相比
	private double amount;//基金持股市值
	public HoldsPO(String code, String name, String date, double nums, double nlast, double count, double clast,
			double amount) {
		super();
		this.code = code;
		this.name = name;
		this.date = date;
		this.nums = nums;
		this.nlast = nlast;
		this.count = count;
		this.clast = clast;
		this.amount = amount;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getNums() {
		return nums;
	}
	public void setNums(double nums) {
		this.nums = nums;
	}
	public double getNlast() {
		return nlast;
	}
	public void setNlast(double nlast) {
		this.nlast = nlast;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	public double getClast() {
		return clast;
	}
	public void setClast(double clast) {
		this.clast = clast;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
