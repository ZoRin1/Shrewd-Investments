package dataSerImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import PO.NowStockPO;
import PO.ShortPO;
import PO.StockPO;
import dataService.GetMarketSer;

public class GetMarketSerImp implements GetMarketSer {
	private static String URL="jdbc:mysql://127.0.0.1:3306/investment";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	@Override
	public ArrayList<ShortPO> getShort() {
		// TODO 自动生成的方法存根
		ArrayList<ShortPO> shortPOs=new ArrayList<>();
		sql="select code,name,price from marketlist";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				shortPOs.add(new ShortPO(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3)));
				
			}
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shortPOs;
	}

	@Override
	public NowStockPO getNowMarket(String code) {
		// TODO 自动生成的方法存根
		sql="select * from marketlist where code ="+code;
		NowStockPO nowStockPO=null;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				double open=resultSet.getDouble(5);
				double close=resultSet.getDouble(4);
				nowStockPO=new NowStockPO(resultSet.getString(1), resultSet.getString(2),open-close,(open-close)/close, resultSet.getDouble(3), resultSet.getDouble(4), resultSet.getDouble(5),
						resultSet.getDouble(6), resultSet.getDouble(7),resultSet.getDouble(8),resultSet.getDouble(9), resultSet.getString(10), resultSet.getString(11));
			}
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nowStockPO;
	}

	@Override
	public ArrayList<StockPO> getHistoryMarket(String code) {
		// TODO 自动生成的方法存根
		ArrayList<StockPO> stockPOs=new ArrayList<>();
		String market="";
		switch(code){
		case "000001":
			market="sh";
			break;
		case "399001":
			market="sz";
			break;
		case "399300":
			market="hs300";
			break;
		case "000016":
			market="sz50";
			break;
		case "399005":
			market="zxb";
			break;
		case "399006":
			market="cyb";
			break;
		}
		Calendar calendar=Calendar.getInstance();   
		calendar.setTime(new Date());
		String now=new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)-180);
		String last=new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
		
		sql="select * from market_"+market +" where date <='"+now+"' and date>='"+last+"' order by date";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				stockPOs.add(new StockPO(code,resultSet.getString(1), resultSet.getDouble(2), resultSet.getDouble(4), resultSet.getDouble(3),
						resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getDouble(8),
						resultSet.getDouble(9), resultSet.getDouble(10), resultSet.getDouble(11), resultSet.getDouble(12),
						resultSet.getDouble(13), resultSet.getDouble(14), 0));
			}
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stockPOs;
	}

}
