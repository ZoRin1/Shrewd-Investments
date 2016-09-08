package dataService;

import PO.CashflowPO;
import PO.DebtPayPO;
import PO.GrowthPO;
import PO.OperationPO;
import PO.ReportPO;
/*
 * 股票季度各种能力报表，按每个公司每个季度来，
 * 存有2014年第一季度至2016第1季度
 * 2014第一季度表示为“2014-1”
 */
public interface AbilitySer {
	//业绩报告，每股每季度
	public ReportPO getReport(String code,String season);
	
	//营运能力，每股每季度
	public OperationPO getOperation(String code,String season);
	
	//成长能力，每股每季度
	public GrowthPO getGrowth(String code,String season);
	
	//偿债能力，每股每季度
	public DebtPayPO getDebtPay(String code,String season);
	
	//现金流量，每股每季度
	public CashflowPO getCashFlow(String code,String season);
}
