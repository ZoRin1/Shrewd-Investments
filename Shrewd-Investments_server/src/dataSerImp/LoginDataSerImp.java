package dataSerImp;

import java.util.List;

import dataService.LoginDataSer;

public class LoginDataSerImp implements LoginDataSer{

	@Override
	public boolean signup(String cid, String password) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean login(String cid, String password) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public List<String> getOwnStock(String cid) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String[] getOwnSet(String cid, String sid) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void raise(String cid, String sid, String date, double money, double price) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void changePass(String cid, String password) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void delete(String cid, String sid) {
		// TODO 自动生成的方法存根
		
	}

}
