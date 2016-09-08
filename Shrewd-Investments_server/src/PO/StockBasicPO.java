package PO;

public class StockBasicPO {
	private String code;//代码
	private String name;//名称
	private String industry;//所属行业
	private String area;//地区
	private double p;//市盈率
	private double outstanding;//流通股本
	private double totals;//总股本(万)
	private double totalAssets;//总资产(万)
	private double liquidAssets;//流动资产
	private double fixedAssets;//固定资产
	private double reserved;//公积金
	private double reservedPerShare;//每股公积金
	private double eps;//每股收益
	private double bvps;//每股净资
	private double pb;//市净率
	private String timeToMarket;//上市日期
	public StockBasicPO(String code, String name, String industry, String area, double p, double outstanding,
			double totals, double totalAssets, double liquidAssets, double fixedAssets, double reserved,
			double reservedPerShare, double eps, double bvps, double pb, String timeToMarket) {
		super();
		this.code = code;
		this.name = name;
		this.industry = industry;
		this.area = area;
		this.p = p;
		this.outstanding = outstanding;
		this.totals = totals;
		this.totalAssets = totalAssets;
		this.liquidAssets = liquidAssets;
		this.fixedAssets = fixedAssets;
		this.reserved = reserved;
		this.reservedPerShare = reservedPerShare;
		this.eps = eps;
		this.bvps = bvps;
		this.pb = pb;
		this.timeToMarket = timeToMarket;
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
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public double getP() {
		return p;
	}
	public void setP(double p) {
		this.p = p;
	}
	public double getOutstanding() {
		return outstanding;
	}
	public void setOutstanding(double outstanding) {
		this.outstanding = outstanding;
	}
	public double getTotals() {
		return totals;
	}
	public void setTotals(double totals) {
		this.totals = totals;
	}
	public double getTotalAssets() {
		return totalAssets;
	}
	public void setTotalAssets(double totalAssets) {
		this.totalAssets = totalAssets;
	}
	public double getLiquidAssets() {
		return liquidAssets;
	}
	public void setLiquidAssets(double liquidAssets) {
		this.liquidAssets = liquidAssets;
	}
	public double getFixedAssets() {
		return fixedAssets;
	}
	public void setFixedAssets(double fixedAssets) {
		this.fixedAssets = fixedAssets;
	}
	public double getReserved() {
		return reserved;
	}
	public void setReserved(double reserved) {
		this.reserved = reserved;
	}
	public double getReservedPerShare() {
		return reservedPerShare;
	}
	public void setReservedPerShare(double reservedPerShare) {
		this.reservedPerShare = reservedPerShare;
	}
	public double getEps() {
		return eps;
	}
	public void setEps(double eps) {
		this.eps = eps;
	}
	public double getBvps() {
		return bvps;
	}
	public void setBvps(double bvps) {
		this.bvps = bvps;
	}
	public double getPb() {
		return pb;
	}
	public void setPb(double pb) {
		this.pb = pb;
	}
	public String getTimeToMarket() {
		return timeToMarket;
	}
	public void setTimeToMarket(String timeToMarket) {
		this.timeToMarket = timeToMarket;
	}
	
}
