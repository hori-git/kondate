package businesslogic;

import dao.DAOManager;
import factory.Factory;

public abstract class AbstructBusinessLogic {

	//daofactoryクラスを取得
	Factory factory = new Factory();

	//DAOManagerのインスタンスを取得する
	DAOManager dao = factory.getDao("oracle", "kondateApp");
}
