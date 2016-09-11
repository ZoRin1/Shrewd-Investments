package dataSerImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import PO.NewsPO;
import PO.SpecialNewsPO;
import dataService.NewsSer;

public class NewsSerImp implements NewsSer {
	private static String URL="jdbc:mysql://127.0.0.1:3306/investment";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	@Override
	public ArrayList<NewsPO> getNews() {
		// TODO 自动生成的方法存根
		sql="select * from news";
		ArrayList<NewsPO> newsPOs=new ArrayList<>();
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				newsPOs.add(new NewsPO(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
				
			}
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return newsPOs;
	}

	@Override
	public ArrayList<SpecialNewsPO> getSpecialNews(String code) {
		// TODO 自动生成的方法存根
		sql="select * from specialnews_"+code;
		ArrayList<SpecialNewsPO> specialNewsPOs=new ArrayList<>();
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				specialNewsPOs.add(new SpecialNewsPO(resultSet.getString(2), resultSet.getString(1), resultSet.getString(3), resultSet.getString(4)));
				
			}
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return specialNewsPOs;
	}

}
