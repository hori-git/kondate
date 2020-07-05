package dao;

public class DAOFactory {

	DAOManager dao = null;

	public DAOManager getDao(String dbname, String appname) {
		if(dbname.equals("oracle")) {
			if(appname.contentEquals("kondateApp")) {
				//タスクアプリ用のDAOを生成
				dao = new DefaultDAOManager();
			}
		}
		return dao;
	}

}
