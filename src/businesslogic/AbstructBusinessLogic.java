package businesslogic;

import dao.DAOFactory;
import dao.DAOManager;

public abstract class AbstructBusinessLogic {

	//daofactoryクラスを取得
	DAOFactory factory = new DAOFactory();

	//DAOManagerのインスタンスを取得する
	DAOManager dao = factory.getDao("oracle", "kondateApp");
}
