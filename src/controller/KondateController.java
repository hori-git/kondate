package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import businesslogic.BussinessLogic;
import factory.Factory;
import obj.DTOMenu;
import obj.JSONMeal;
import obj.JSONMenu;
import service.Converter;

public class KondateController {

	//ビジネスロジックを取得
	Factory logicFactory = new Factory();
	BussinessLogic logic = logicFactory.getLogic("kondateApp");

	//TODO ビジネスロジック層等にも記載
	//引数を確認
	public boolean checkUser(int userId, String accessKey) {
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
		BufferedReader br = new BufferedReader(request.getReader());
		String jsonText = br.readLine();
		ObjectMapper mapper = new ObjectMapper();
		DTOMenu[] menu = mapper.readValue(jsonText, DTOMenu[].class);

		logic.saveMenu(menu);
	}

	public void getMenuService(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Converter converter = new Converter();
		String str = request.getParameter("user_id");
        int userId = Integer.parseInt(str);
		ArrayList<JSONMenu> menu = logic.getMenu(userId);
		String respoceJson = converter.object2json(menu);
		//JSONの出力
		response.getWriter().write(respoceJson);
	}
}
