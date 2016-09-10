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

import PO.BidPO;
import PO.BigChangePO;
import PO.NowStockPO;
import PO.ShortPO;
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
		ArrayList<NowStockPO> nowStockPOs=new ArrayList<>();
		if (code.equals("cyb")||code.equals("sh")||code.equals("sz")) {
			sql="select code, name, open, pre_close, price, high, low, volume, amount, time, date from stocklist_"+code;
			try {
				Class.forName(DRIVER);
				Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				ResultSet resultSet=preparedStatement.executeQuery();
				while (resultSet.next()) {
					double price_change=resultSet.getDouble(5)-resultSet.getDouble(4);
					double p_change=price_change/resultSet.getDouble(4);
					nowStockPOs.add(new NowStockPO(resultSet.getString(1), resultSet.getString(2), price_change, p_change, resultSet.getDouble(3),
							resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getDouble(8),
							resultSet.getDouble(9), resultSet.getString(10), resultSet.getString(11)));
					
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
		}else if (code.equals("small")) {
			sql="select code, name, open, pre_close, price, high, low, volume, amount, time, date from stocklist_sz where code like '002%'";
			try {
				Class.forName(DRIVER);
				Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				ResultSet resultSet=preparedStatement.executeQuery();
				while (resultSet.next()) {
					double price_change=resultSet.getDouble(5)-resultSet.getDouble(4);
					double p_change=price_change/resultSet.getDouble(4);
					nowStockPOs.add(new NowStockPO(resultSet.getString(1), resultSet.getString(2), price_change, p_change, resultSet.getDouble(3),
							resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getDouble(8),
							resultSet.getDouble(9), resultSet.getString(10), resultSet.getString(11)));
					
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
		}
		else {
			try {
				Class.forName(DRIVER);
				Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
				sql="select code, name, open, pre_close, price, high, low, volume, amount, time, date from stocklist_sz where name like '%ST%'";
				PreparedStatement preparedStatement=connection.prepareStatement(sql);
				ResultSet resultSet=preparedStatement.executeQuery();
				while (resultSet.next()) {
					double price_change=resultSet.getDouble(5)-resultSet.getDouble(4);
					double p_change=price_change/resultSet.getDouble(4);
					nowStockPOs.add(new NowStockPO(resultSet.getString(1), resultSet.getString(2), price_change, p_change, resultSet.getDouble(3),
							resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getDouble(8),
							resultSet.getDouble(9), resultSet.getString(10), resultSet.getString(11)));
					
				}
				preparedStatement.close();
				sql="select code, name, open, pre_close, price, high, low, volume, amount, time, date from stocklist_sh where name like '%ST%'";
				preparedStatement=connection.prepareStatement(sql);
				resultSet=preparedStatement.executeQuery();
				while (resultSet.next()) {
					double price_change=resultSet.getDouble(5)-resultSet.getDouble(4);
					double p_change=price_change/resultSet.getDouble(4);
					nowStockPOs.add(new NowStockPO(resultSet.getString(1), resultSet.getString(2), price_change, p_change, resultSet.getDouble(3),
							resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getDouble(8),
							resultSet.getDouble(9), resultSet.getString(10), resultSet.getString(11)));
					
				}
				preparedStatement.close();
				sql="select code, name, open, pre_close, price, high, low, volume, amount, time, date from stocklist_cyb where name like '%ST%'";
				preparedStatement=connection.prepareStatement(sql);
				resultSet=preparedStatement.executeQuery();
				while (resultSet.next()) {
					double price_change=resultSet.getDouble(5)-resultSet.getDouble(4);
					double p_change=price_change/resultSet.getDouble(4);
					nowStockPOs.add(new NowStockPO(resultSet.getString(1), resultSet.getString(2), price_change, p_change, resultSet.getDouble(3),
							resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getDouble(8),
							resultSet.getDouble(9), resultSet.getString(10), resultSet.getString(11)));
					
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
		}
		return nowStockPOs;

	}

	@Override
	public ArrayList<StockPO> getHistoryStock(String code) {
		// TODO 自动生成的方法存根
		ArrayList<StockPO> stockPOs=new ArrayList<>();
		Calendar calendar=Calendar.getInstance();   
		calendar.setTime(new Date());
		String now=new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
		calendar.set(Calendar.DAY_OF_MONTH,calendar.get(Calendar.DAY_OF_MONTH)-180);
		String last=new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
		
		sql="select * from stock_"+code +" where date <='"+now+"' and date>='"+last+"' order by date";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				stockPOs.add(new StockPO(code,resultSet.getString(1), resultSet.getDouble(2), resultSet.getDouble(4), resultSet.getDouble(3),
						resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getDouble(8),
						resultSet.getDouble(9), resultSet.getDouble(10), resultSet.getDouble(11), resultSet.getDouble(12),
						resultSet.getDouble(13), resultSet.getDouble(14), resultSet.getDouble(15)));
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

	@Override
	public NowStockPO getNowStockPO(String code) {
		// TODO 自动生成的方法存根
		switch(code.charAt(0)){
		case '0':
			sql="select code, name, open, pre_close, price, high, low, volume, amount, time, date from stocklist_sz where code ="+code;
			break;
		case '3':
			sql="select code, name, open, pre_close, price, high, low, volume, amount, time, date from stocklist_cyb where code ="+code;
			break;
		case '6':
			sql="select code, name, open, pre_close, price, high, low, volume, amount, time, date from stocklist_sh where code ="+code;
			break;
		}
		
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
	public ArrayList<BigChangePO> getStockBigChange(String code) {
		// TODO 自动生成的方法存根
		ArrayList<BigChangePO> bigChangePOs=new ArrayList<>();
		sql="select * from stockbigchange_"+code;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				bigChangePOs.add(new BigChangePO(code,resultSet.getString(1), resultSet.getDouble(2), resultSet.getDouble(3), resultSet.getDouble(4), resultSet.getString(5)));
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
		return bigChangePOs;
	}

	@Override
	public StockBasicPO getStockBasic(String code) {
		// TODO 自动生成的方法存根
		StockBasicPO stockBasicPO = null;
		sql="select * from mainlist where code ="+code;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				stockBasicPO=new StockBasicPO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
						resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getDouble(8), resultSet.getDouble(9), 
						resultSet.getDouble(10), resultSet.getDouble(11), resultSet.getDouble(12), resultSet.getDouble(13), resultSet.getDouble(14),
						resultSet.getDouble(15), resultSet.getString(16));
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
		return stockBasicPO;
	}
	

	@Override
	public BidPO getBid(String code) {
		// TODO 自动生成的方法存根
		BidPO bidPO = null;
		switch(code.charAt(0)){
		case '0':
			sql="select b1_v, b1_p, b2_v, b2_p, b3_v, b3_p, b4_v, b4_p, b5_v, b5_p, a1_v, a1_p, a2_v, a2_p, a3_v, a3_p, a4_v, a4_p, a5_v, a5_p from stocklist_sz where code ="+code;
			break;
		case '3':
			sql="select b1_v, b1_p, b2_v, b2_p, b3_v, b3_p, b4_v, b4_p, b5_v, b5_p, a1_v, a1_p, a2_v, a2_p, a3_v, a3_p, a4_v, a4_p, a5_v, a5_p from stocklist_cyb where code ="+code;
			break;
		case '6':
			sql="select b1_v, b1_p, b2_v, b2_p, b3_v, b3_p, b4_v, b4_p, b5_v, b5_p, a1_v, a1_p, a2_v, a2_p, a3_v, a3_p, a4_v, a4_p, a5_v, a5_p from stocklist_sh where code ="+code;
			break;
		}
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				bidPO=new BidPO(code, resultSet.getDouble(1), resultSet.getDouble(2), resultSet.getDouble(3), resultSet.getDouble(4), resultSet.getDouble(5),
						resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getDouble(8), resultSet.getDouble(9), resultSet.getDouble(10),
						resultSet.getDouble(11), resultSet.getDouble(12), resultSet.getDouble(13), resultSet.getDouble(14), resultSet.getDouble(15),
						resultSet.getDouble(16), resultSet.getDouble(17), resultSet.getDouble(18), resultSet.getDouble(19), resultSet.getDouble(20));
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
		return bidPO;
	}

}
