package PO;

public class ReportPO {
	private String code;//代码
	private String name;//名称
	private double eps;//每股收益
	private double eps_yoy;//每股收益同比(%)
	private double bvps;//每股净资产
	private double roe;//净资产收益率(%)
	private double epcf;//每股现金流量(元)
	private double net_profits;//净利润(万元)
	private double profits_yoy;//净利润同比(%)
	private String distrib;//分配方案
	private String report_date;//发布日期
	public ReportPO(String code, String name, double eps, double eps_yoy, double bvps, double roe, double epcf,
			double net_profits, double profits_yoy, String distrib, String report_date) {
		super();
		this.code = code;
		this.name = name;
		this.eps = eps;
		this.eps_yoy = eps_yoy;
		this.bvps = bvps;
		this.roe = roe;
		this.epcf = epcf;
		this.net_profits = net_profits;
		this.profits_yoy = profits_yoy;
		this.distrib = distrib;
		this.report_date = report_date;
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
	public double getEps() {
		return eps;
	}
	public void setEps(double eps) {
		this.eps = eps;
	}
	public double getEps_yoy() {
		return eps_yoy;
	}
	public void setEps_yoy(double eps_yoy) {
		this.eps_yoy = eps_yoy;
	}
	public double getBvps() {
		return bvps;
	}
	public void setBvps(double bvps) {
		this.bvps = bvps;
	}
	public double getRoe() {
		return roe;
	}
	public void setRoe(double roe) {
		this.roe = roe;
	}
	public double getEpcf() {
		return epcf;
	}
	public void setEpcf(double epcf) {
		this.epcf = epcf;
	}
	public double getNet_profits() {
		return net_profits;
	}
	public void setNet_profits(double net_profits) {
		this.net_profits = net_profits;
	}
	public double getProfits_yoy() {
		return profits_yoy;
	}
	public void setProfits_yoy(double profits_yoy) {
		this.profits_yoy = profits_yoy;
	}
	public String getDistrib() {
		return distrib;
	}
	public void setDistrib(String distrib) {
		this.distrib = distrib;
	}
	public String getReport_date() {
		return report_date;
	}
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	
}
