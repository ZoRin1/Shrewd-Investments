package PO;

public class CashflowPO {
	private String code;//代码
	private String name;//名称
	private String cf_sales;//经营现金净流量对销售收入比率
	private String rateofreturn;//资产的经营现金流量回报率
	private String cf_nm;//经营现金净流量与净利润的比率
	private String cf_liabilities;//经营现金净流量对负债比率
	private String cashflowratio;//现金流量比率
	public CashflowPO(String code, String name, String cf_sales, String rateofreturn, String cf_nm,
			String cf_liabilities, String cashflowratio) {
		super();
		this.code = code;
		this.name = name;
		this.cf_sales = cf_sales;
		this.rateofreturn = rateofreturn;
		this.cf_nm = cf_nm;
		this.cf_liabilities = cf_liabilities;
		this.cashflowratio = cashflowratio;
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
	public String getCf_sales() {
		return cf_sales;
	}
	public void setCf_sales(String cf_sales) {
		this.cf_sales = cf_sales;
	}
	public String getRateofreturn() {
		return rateofreturn;
	}
	public void setRateofreturn(String rateofreturn) {
		this.rateofreturn = rateofreturn;
	}
	public String getCf_nm() {
		return cf_nm;
	}
	public void setCf_nm(String cf_nm) {
		this.cf_nm = cf_nm;
	}
	public String getCf_liabilities() {
		return cf_liabilities;
	}
	public void setCf_liabilities(String cf_liabilities) {
		this.cf_liabilities = cf_liabilities;
	}
	public String getCashflowratio() {
		return cashflowratio;
	}
	public void setCashflowratio(String cashflowratio) {
		this.cashflowratio = cashflowratio;
	}
	
}
