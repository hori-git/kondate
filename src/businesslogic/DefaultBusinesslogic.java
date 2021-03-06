package businesslogic;

import java.util.ArrayList;

import obj.DTOMeal;
import obj.DTOMenu;
import obj.JSONMeal;
import obj.JSONMenu;

public class DefaultBusinesslogic extends AbstructBusinessLogic implements BussinessLogic{

	@Override
	public ArrayList<JSONMeal> createMenu() {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<JSONMeal> menu = new ArrayList<JSONMeal>();
		int breakfastCounter = 0;
		int lunchCounter = 0;
		try {
			ArrayList<DTOMeal> DTOMenu = dao.getWeeklyMeals();
			//DB取得したDTOMenuをJSONMealへ変換
			//変換処理は、別クラスか別メソッドへ移譲する必要あるかも？？？
			for (int i = 0; i < DTOMenu.size(); i++) {
				JSONMeal jsonMeal = new JSONMeal();
				jsonMeal.setId(DTOMenu.get(i).getId());
				jsonMeal.setName(DTOMenu.get(i).getName());
				if(DTOMenu.get(i).isBreakfast() && breakfastCounter<7) {
					jsonMeal.setMealTime("morning");
					breakfastCounter++;
				}else if (DTOMenu.get(i).isLunch() && lunchCounter<7) {
					jsonMeal.setMealTime("lunch");
					lunchCounter++;
				}else if (DTOMenu.get(i).isDinner()) {
					jsonMeal.setMealTime("dinner");
				}
				menu.add(jsonMeal);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public void saveMenu(DTOMenu[] menu) {
			dao.saveMenu(menu);
	}

	@Override
	public ArrayList<JSONMenu> getMenu(int userId) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<JSONMenu> menu = dao.getMenu(userId);
		return menu;
	}
}
