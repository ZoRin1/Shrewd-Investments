package PO;

public class DistributePO {
	private String code;
	private String name;
	private int year;//分配年份
	private String report_date;//公布日期
	private double divi;//分红金额（每10股）
	private double shares;//转增和送股数（每10股）
	public DistributePO(String code, String name, int year, String report_date, double divi, double shares) {
		super();
		this.code = code;
		this.name = name;
		this.year = year;
		this.report_date = report_date;
		this.divi = divi;
		this.shares = shares;
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getReport_date() {
		return report_date;
	}
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	public double getDivi() {
		return divi;
	}
	public void setDivi(double divi) {
		this.divi = divi;
	}
	public double getShares() {
		return shares;
	}
	public void setShares(double shares) {
		this.shares = shares;
	}
	
}
