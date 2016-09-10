package dataService;

import java.util.ArrayList;

import PO.NowStockPO;
import PO.ShortPO;
import PO.StockPO;

public interface GetMarketSer {
	//行情页面中显示6个指数实时大小时用的
	public ArrayList<ShortPO> getShort();
	
	//显示6个指数中单个详细实时数据所用,code为000001：上证指数，399001:深证指数
	//399300：沪深300,000016：上证50,399005：中小板指，399006：创业板指
	public NowStockPO getNowMarket(String code);
	
	
	//显示指数历史数据所用，code同上,180个
	public ArrayList<StockPO> getHistoryMarket(String code);
}
