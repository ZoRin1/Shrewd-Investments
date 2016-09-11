package dataSerImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataService.LoginDataSer;

public class LoginDataSerImp implements LoginDataSer{
	private static String URL="jdbc:mysql://127.0.0.1:3306/investment";
	private static String DRIVER="com.mysql.jdbc.Driver";
	private static String USER="root";
	private static  String PASSWORD="123456";
	private String sql;
	@Override
	public boolean signup(String cid, String password) {
		// TODO 自动生成的方法存根
		if (password.length()>12||cid.length()>12) {
			System.out.println("geshi");
			return false;
		}
		sql="select cid from customers where cid='"+cid+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				preparedStatement.close();
				connection.close();
				System.out.println("cunzai");
				return false;
			}
			preparedStatement.close();
			sql="insert into customers(cid,password) values('"+cid+"','"+password+"')";
			preparedStatement=connection.prepareStatement(sql);
			if (!preparedStatement.execute()) {
				preparedStatement.close();
				connection.close();
				System.out.println("zhengchang");
				return true;
			}else {
				preparedStatement.close();
				connection.close();
				System.out.println("gengxinshibai");
				return false;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean login(String cid, String password) {
		// TODO 自动生成的方法存根
		sql="select cid from customers where cid='"+cid+"' and password='"+password+"'" ;
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				preparedStatement.close();
				connection.close();
				return true;
			}
			else {
				preparedStatement.close();
				connection.close();
				return false;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<String> getOwnStock(String cid) {
		// TODO 自动生成的方法存根
		sql="select sid from customersown where cid='"+cid+"'" ;
		List<String> strings=new ArrayList<>();
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();			
			while (resultSet.next()) {
				strings.add(resultSet.getString(1));				
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
		
		return strings;
	}

	@Override
	public String[] getOwnSet(String cid, String sid) {
		// TODO 自动生成的方法存根
		sql="select date,money,price from customersown where cid='"+cid+"' and sid='"+sid+"'";
		String[] strings=new String[3];
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();		
			resultSet.next();
			strings[0]=resultSet.getString(1);
			strings[1]=Double.toString(resultSet.getDouble(2));
			strings[2]=Double.toString(resultSet.getDouble(3));
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strings;
	}

	@Override
	public void raise(String cid, String sid, String date, double money, double price) {
		// TODO 自动生成的方法存根
		sql="select cid from customersown where cid='"+cid+"' and sid='"+sid+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				sql="update customersown set date='"+date+"',money="+money+",price="+price+" where cid='"+cid+"' and sid='"+sid+"'";
			}
			else {
				sql="insert into customersown (cid,sid,date,money,price) values ('"+cid+"','"+sid+"','"+date+"',"+money+","+price+")";
			}
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.execute();
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

	@Override
	public void changePass(String cid, String password) {
		// TODO 自动生成的方法存根
		sql="update customers set password='"+password+"' where cid='"+cid+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.execute();
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

	@Override
	public void delete(String cid, String sid) {
		// TODO 自动生成的方法存根
		sql="delete from customersown where cid='"+cid+"' and sid='"+sid+"'";
		try {
			Class.forName(DRIVER);
			Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.execute();
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

}
