package dataService;

import java.util.ArrayList;

import PO.DistributePO;
import PO.HoldsPO;
import PO.PredictPO;
/**
 * 几个不大弄得清楚的数据块的接口，含分配预案，业绩报告，基金持股
 * @author 熊凯奇xiong kaiqi
 *
 */
public interface InvestSer {
	/**
	 * 分配预案年度，直接把一个公司所有预案传过去，大多数没有，直接一个null
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public ArrayList<DistributePO> getdistribute(String code);
	/**
	 * 业绩报告季度，按每个公司每个季度来，存有2014年第一季度至2016第1季度
	 * 2014第一季度表示为“20141”
	 * @param code为股票代码，season为季度“20141”这类
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public PredictPO getPredict(String code,String season);
	/**
	 * 基金持股季度，按每个公司每个季度来，存有2014年第一季度至2016第1季度
	 * 2014第一季度表示为“20141”
	 * @param code为股票代码，season为季度“20141”这类
	 * @author 熊凯奇xiong kaiqi
	 *
	 */
	public HoldsPO getHolds(String code,String season);
}
