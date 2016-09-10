package dataSerImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import PO.DistributePO;
import PO.HoldsPO;
import PO.PredictPO;
import PO.ReportPO;
import dataService.InvestSer;

public class InvestSerImp implements InvestSer {
	private static String URL="jdbc:mysql://127.0.0.1:3306/investment";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	@Override
	public ArrayList<DistributePO> getdistribute(String code) {
		// TODO 自动生成的方法存根
		ArrayList<DistributePO> distributePOs=new ArrayList<>();
		sql="select * from distribute where code ="+code;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				distributePOs.add(new DistributePO(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4),
						resultSet.getDouble(5), resultSet.getDouble(6)));
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return distributePOs;
	}

	@Override
	public PredictPO getPredict(String code, String season) {
		// TODO 自动生成的方法存根
		sql="select * from predict"+season+" where code="+code;
		PredictPO predictPO=null;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				predictPO=new PredictPO(code, resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDouble(5), resultSet.getString(6));
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
		return predictPO;
	}

	@Override
	public HoldsPO getHolds(String code, String season) {
		// TODO 自动生成的方法存根
		sql="select * from holds"+season+" where code="+code;
		HoldsPO holdsPO=null;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				holdsPO=new HoldsPO(code, resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getDouble(5),
						resultSet.getDouble(6), resultSet.getDouble(7), resultSet.getDouble(8),resultSet.getDouble(9));
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
		return holdsPO;
	}

}
