package dataSerImp;

import java.util.ArrayList;

import PO.BigChangePO;
import PO.NowStockPO;
import PO.StockBasicPO;
import PO.StockPO;
import dataService.GetStockSer;

public class GetStockSerImp implements GetStockSer {
	private static String URL="jdbc:mysql://127.0.0.1:3306/investment";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	@Override
	public ArrayList<NowStockPO> getNowStock(String code) {
		// TODO 自动生成的方法存根
		
		return null;
	}

	@Override
	public ArrayList<StockPO> getHistoryStock(String code) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public NowStockPO getNowStockPO(String code) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<BigChangePO> getStockBigChange(String code) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public StockBasicPO getStockBasic(String code) {
		// TODO 自动生成的方法存根
		return null;
	}

}
