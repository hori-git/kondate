package businesslogic;

import java.util.ArrayList;

import obj.DTOMeal;
import obj.JSONMeal;

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
			//別クラスか別メソッドへ移譲する必要あるかも？？？
			for (int i = 0; i < DTOMenu.size(); i++) {
				JSONMeal jsonMeal = new JSONMeal();
				jsonMeal.setId(DTOMenu.get(i).getId());
				jsonMeal.setName(DTOMenu.get(i).getName());
				if(DTOMenu.get(i).isBreakfast() && breakfastCounter<7) {
					jsonMeal.setMealType("morning");
					breakfastCounter++;
				}else if (DTOMenu.get(i).isLunch() && lunchCounter<7) {
					jsonMeal.setMealType("lunch");
					lunchCounter++;
				}else if (DTOMenu.get(i).isDinner()) {
					jsonMeal.setMealType("dinner");
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
	public void saveMenu(ArrayList<JSONMeal> JSONMeal) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
