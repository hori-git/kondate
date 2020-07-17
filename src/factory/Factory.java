package factory;

import businesslogic.BussinessLogic;
import businesslogic.DefaultBusinesslogic;
import dao.DAOManager;
import dao.DefaultDAOManager;

public class Factory {

	//メンバ
	private DAOManager dao = null;
	private BussinessLogic logic = null;

	public DAOManager getDao(String dbname, String appname) {
		if(dbname.equals("oracle")) {
			if(appname.contentEquals("kondateApp")) {
				//タスクアプリ用のDAOを生成
				dao = new DefaultDAOManager();
			}
		}
		return dao;
	}

	public BussinessLogic getLogic(String appname) {

		if(appname.equals("kondateApp")) {
			logic = new DefaultBusinesslogic();
		}

		return logic;
	}
}
