package controller;

import java.util.ArrayList;

import businesslogic.BussinessLogic;
import businesslogic.BussinessLogicFactory;
import obj.Meal;

public class KondateController {

	//ビジネスロジックを取得
	BussinessLogicFactory logicFactory = new BussinessLogicFactory();
	BussinessLogic logic = logicFactory.getLogic("kondateApp");

	//TODO ビジネスロジック層等にも記載
	//引数を確認
	public boolean checkUser(int userId,String accessKey) {
		//TODO ユーザーIDとアクセスキーの判定(別DBを参照？)
		return true;
	}

	public ArrayList<Meal> createMenuService() {

		ArrayList<Meal> menu = logic.createMenu();

		return menu;
	}


}
