package blService;
//各个板块自身及对应股票实时数据获取，（实时有点水分）

import java.util.ArrayList;

import PO.BigChangePO;
import PO.NowStockPO;
import PO.StockBasicPO;
import PO.StockPO;

public interface GetStockBlSer {
	//code为sha,shb,sza,szb分别对应上证，深证A，B股，
	//small,gem,risk分别对应中小板，创业板和风险警示板
	//显示的是里面的数据，后面三个会麻烦一点，辛苦了
	public ArrayList<NowStockPO> getNowStock(String code);
	
	//code即是股票编号,那就按半年的历史数据来，也就是拉180个出来
	public ArrayList<StockPO> getHistoryStock(String code);
	
	//code即是股票编号，获取股票实时数据
	public NowStockPO getNowStockPO(String code);
	
	//code即是股票编号,大单交易数据
	public ArrayList<BigChangePO> getStockBigChange(String code);
	
	//股票对应公司基本面数据，如公积金这些
	public StockBasicPO getStockBasic(String code);
}
