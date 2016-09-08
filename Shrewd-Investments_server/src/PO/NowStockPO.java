package PO;

public class NowStockPO {
	private String code;//股票代码(大盘代码）
	private String name;//股票名（大盘名）
	private double price_change;//价格变动,这个需要自己算，now-close
	private double p_change;//涨跌幅,(now-close)/close
	private double open;//今开
	private double close;//昨收
	private double now;//当前价格
	private double high;//今日最高价
	private double low;//今日最低价
	private double volume;//成交量
	private double account;//成交金额
	private String time;//时间
	private String date;//日期
	public NowStockPO(String code, String name, double price_change, double p_change, double open, double close,
			double now, double high, double low, double volume, double account, String time, String date) {
		super();
		this.code = code;
		this.name = name;
		this.price_change = price_change;
		this.p_change = p_change;
		this.open = open;
		this.close = close;
		this.now = now;
		this.high = high;
		this.low = low;
		this.volume = volume;
		this.account = account;
		this.time = time;
		this.date = date;
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
	public double getPrice_change() {
		return price_change;
	}
	public void setPrice_change(double price_change) {
		this.price_change = price_change;
	}
	public double getP_change() {
		return p_change;
	}
	public void setP_change(double p_change) {
		this.p_change = p_change;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getNow() {
		return now;
	}
	public void setNow(double now) {
		this.now = now;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
