package dataSerImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import PO.CashflowPO;
import PO.DebtPayPO;
import PO.GrowthPO;
import PO.OperationPO;
import PO.ReportPO;
import dataService.AbilitySer;

public class AbilitySerImp implements AbilitySer {
	private static String URL="jdbc:mysql://127.0.0.1:3306/investment";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	@Override
	public ReportPO getReport(String code, String season) {
		// TODO 自动生成的方法存根
		sql="select * from report"+season+" where code="+code;
		ReportPO reportPO=null;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				reportPO=new ReportPO(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3), 
						resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getDouble(8), 
						resultSet.getDouble(9), resultSet.getString(10));
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
		return reportPO;
	}

	@Override
	public OperationPO getOperation(String code, String season) {
		// TODO 自动生成的方法存根
		sql="select * from operation"+season+" where code="+code;
		OperationPO operationPO=null;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				operationPO=new OperationPO(resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getDouble(4), 
						resultSet.getDouble(5), resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getDouble(8));
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
		return operationPO;
	}

	@Override
	public GrowthPO getGrowth(String code, String season) {
		// TODO 自动生成的方法存根
		sql="select * from growth"+season+" where code="+code;
		GrowthPO growthPO=null;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				growthPO=new GrowthPO(resultSet.getString(1), resultSet.getString(2), Double.toString(resultSet.getDouble(3)),
						Double.toString(resultSet.getDouble(4)), Double.toString(resultSet.getDouble(5)), 
						Double.toString(resultSet.getDouble(6)), Double.toString(resultSet.getDouble(7)), Double.toString(resultSet.getDouble(8)));
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
		return growthPO;
	}

	@Override
	public DebtPayPO getDebtPay(String code, String season) {
		// TODO 自动生成的方法存根
		sql="select * from debtpay"+season+" where code="+code;
		DebtPayPO debtPayPO=null;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				debtPayPO=new DebtPayPO(resultSet.getString(1), resultSet.getString(2), Double.toString(resultSet.getDouble(3)),
						Double.toString(resultSet.getDouble(4)), Double.toString(resultSet.getDouble(5)), 
						Double.toString(resultSet.getDouble(6)), Double.toString(resultSet.getDouble(7)), Double.toString(resultSet.getDouble(8)));
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
		return debtPayPO;
	}

	@Override
	public CashflowPO getCashFlow(String code, String season) {
		// TODO 自动生成的方法存根
		sql="select * from cashflow"+season+" where code="+code;
		CashflowPO cashflowPO=null;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				cashflowPO=new CashflowPO(resultSet.getString(1), resultSet.getString(2), Double.toString(resultSet.getDouble(3)),
						Double.toString(resultSet.getDouble(4)), Double.toString(resultSet.getDouble(5)), 
						Double.toString(resultSet.getDouble(6)), Double.toString(resultSet.getDouble(7)));
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
		return cashflowPO;
	}

}
