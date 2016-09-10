package dataService;

import java.util.ArrayList;

import PO.NewsPO;
import PO.SpecialNewsPO;

public interface NewsSer {
	/**
	 * 即时新闻
	 * @param code为股票代码
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public ArrayList<NewsPO> getNews();
	
	/**
	 * 信息地雷
	 * @param code为股票代码
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public ArrayList<SpecialNewsPO> getSpecialNews(String code);
}
