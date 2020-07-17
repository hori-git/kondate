package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.BussinessLogic;
import factory.Factory;
import obj.JSONMeal;
import service.Converter;

public class KondateController {

	//ビジネスロジックを取得
	Factory logicFactory = new Factory();
	BussinessLogic logic = logicFactory.getLogic("kondateApp");


	//TODO ビジネスロジック層等にも記載
	//引数を確認
	public boolean checkUser(int userId,String accessKey) {
		//TODO ユーザーIDとアクセスキーの判定(別DBを参照？)
		return true;
	}

	public void startCreateMenuService(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Converter converter = new Converter();
		ArrayList<JSONMeal> menu = logic.createMenu();
		String respoceJson = converter.object2json(menu);
		//JSONの出力
		response.getWriter().write(respoceJson);
	}

	public void saveMenuService(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//TODO　リクエストボディからの取得　献立内のブックマークをもとに実装
		//リクエストの渡し方はJSONで良いか探る
		ArrayList<JSONMeal> JSONMeal = new ArrayList<JSONMeal>();
		logic.saveMenu(JSONMeal);
	}

}
