package dataService;
//各个板块自身及对应股票实时数据获取，（实时有点水分）

import java.util.ArrayList;

import PO.BidPO;
import PO.BigChangePO;
import PO.NowStockPO;
import PO.StockBasicPO;
import PO.StockPO;

public interface GetStockSer {
	/**
	 * code为sh,sz,cyb，
	 * small,risk分别对应中小板,风险警示板
	 * 显示的是里面的数据，后面三个会麻烦一点，辛苦了
	 * @param code为股票代码
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public ArrayList<NowStockPO> getNowStock(String code);
	/**
	 * code即是股票编号,那就按半年的历史数据来，也就是拉180个出来
	 * @param code为股票代码
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public ArrayList<StockPO> getHistoryStock(String code);
	/**
	 * 获取股票实时数据
	 * @param code为股票代码
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public NowStockPO getNowStockPO(String code);
	/**
	 * 大单交易数据
	 * @param code为股票代码
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public ArrayList<BigChangePO> getStockBigChange(String code);
	/**
	 * 股票对应公司基本面数据，如公积金这些
	 * @param code为股票代码
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public StockBasicPO getStockBasic(String code);
	/**
	 * 获得五档盘口
	 * @param code为股票代码
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public BidPO getBid(String code);
}
