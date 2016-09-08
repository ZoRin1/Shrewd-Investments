package PO;

public class SpecialNewsPO {
	private String type;//信息类型
	private String title;//新闻标题
	private String date;//发布日期
	private String url;//新闻链接
	public SpecialNewsPO(String type, String title, String date, String url) {
		super();
		this.type = type;
		this.title = title;
		this.date = date;
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
