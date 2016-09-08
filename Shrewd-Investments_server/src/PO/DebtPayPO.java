package PO;

public class DebtPayPO {
	private String code;//代码
	private String name;//名称
	private String currentratio;//流动比率
	private String quickratio;//速动比率
	private String cashratio;//现金比率
	private String icratio;//利息支付倍数
	private String sheqratio;//股东权益比率
	private String adratio;//股东权益增长率
	public DebtPayPO(String code, String name, String currentratio, String quickratio, String cashratio, String icratio,
			String sheqratio, String adratio) {
		super();
		this.code = code;
		this.name = name;
		this.currentratio = currentratio;
		this.quickratio = quickratio;
		this.cashratio = cashratio;
		this.icratio = icratio;
		this.sheqratio = sheqratio;
		this.adratio = adratio;
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
	public String getCurrentratio() {
		return currentratio;
	}
	public void setCurrentratio(String currentratio) {
		this.currentratio = currentratio;
	}
	public String getQuickratio() {
		return quickratio;
	}
	public void setQuickratio(String quickratio) {
		this.quickratio = quickratio;
	}
	public String getCashratio() {
		return cashratio;
	}
	public void setCashratio(String cashratio) {
		this.cashratio = cashratio;
	}
	public String getIcratio() {
		return icratio;
	}
	public void setIcratio(String icratio) {
		this.icratio = icratio;
	}
	public String getSheqratio() {
		return sheqratio;
	}
	public void setSheqratio(String sheqratio) {
		this.sheqratio = sheqratio;
	}
	public String getAdratio() {
		return adratio;
	}
	public void setAdratio(String adratio) {
		this.adratio = adratio;
	}
	
}
