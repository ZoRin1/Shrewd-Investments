package blService;

import java.util.ArrayList;

import PO.DistributePO;
import PO.HoldsPO;
import PO.PredictPO;
/*
 * 几个不大弄得清楚的数据块的接口，含分配预案，业绩报告，基金持股
 */
public interface InvestBlSer {
	/*
	 * 分配预案年度，直接把一个公司所有预案传过去，大多数没有，直接一个null
	 */
	public ArrayList<DistributePO> getdistribute(String code);
	
	/*
	 * 业绩报告季度，按每个公司每个季度来，存有2014年第一季度至2016第1季度
	 * 2014第一季度表示为“2014-1”
	 * 
	 */
	public ArrayList<PredictPO> getPredict(String code,String season);
	
	/*
	 * 基金持股季度，按每个公司每个季度来，存有2014年第一季度至2016第1季度
	 * 2014第一季度表示为“2014-1”
	 * 
	 */
	public ArrayList<HoldsPO> getHolds(String code,String season);
}
