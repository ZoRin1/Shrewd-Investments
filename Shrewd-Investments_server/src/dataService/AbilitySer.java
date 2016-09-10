package dataService;

import PO.CashflowPO;

import PO.DebtPayPO;
import PO.GrowthPO;
import PO.OperationPO;
import PO.ReportPO;
/**
 * 股票季度各种能力报表，按每个公司每个季度来，
 * 存有2014年第一季度至2016第1季度
 * 2014第一季度表示为“2014-1”
 * @author 熊凯奇xiong kaiqi
 *
 */
public interface AbilitySer {
	/**
	 * 业绩报告，每股每季度
	 * @param code为股票代码
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public ReportPO getReport(String code,String season);
	/**
	 * 营运能力，每股每季度
	 * @param code为股票代码
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public OperationPO getOperation(String code,String season);
	/**
	 * 成长能力，每股每季度
	 * @param code为股票代码
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public GrowthPO getGrowth(String code,String season);
	/**
	 * 偿债能力，每股每季度
	 * @param code为股票代码
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public DebtPayPO getDebtPay(String code,String season);
	/**
	 * 现金流量，每股每季度
	 * @param code为股票代码
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public CashflowPO getCashFlow(String code,String season);
}
