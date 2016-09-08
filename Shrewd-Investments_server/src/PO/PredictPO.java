package PO;

public class PredictPO {
	private String code;
	private String name;
	private String type;//业绩变动类型【预增、预亏等】
	private String report_date;//发布日期
	private double pre_eps;
	private String range;
	public PredictPO(String code, String name, String type, String report_date, double pre_eps, String range) {
		super();
		this.code = code;
		this.name = name;
		this.type = type;
		this.report_date = report_date;
		this.pre_eps = pre_eps;
		this.range = range;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReport_date() {
		return report_date;
	}
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	public double getPre_eps() {
		return pre_eps;
	}
	public void setPre_eps(double pre_eps) {
		this.pre_eps = pre_eps;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	
}
