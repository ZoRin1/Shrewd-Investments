package dataService;

import java.util.ArrayList;

import PO.NewsPO;
import PO.SpecialNewsPO;

public interface NewsSer {
	//即时新闻
	public ArrayList<NewsPO> getNews();
	
	//信息地雷，code自然是股票编号
	public ArrayList<SpecialNewsPO> getSpecialNews();
}
