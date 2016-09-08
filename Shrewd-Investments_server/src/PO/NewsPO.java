package PO;

public class NewsPO {
	private String classify;//新闻类别
	private String title;//新闻标题
	private String time;//发布时间
	private String url;//新闻链接
	public NewsPO(String classify, String title, String time, String url) {
		super();
		this.classify = classify;
		this.title = title;
		this.time = time;
		this.url = url;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
