package businesslogic;

import java.util.ArrayList;

import obj.Meal;

public class DefaultBusinesslogic extends AbstructBusinessLogic implements BussinessLogic{

	@Override
	public ArrayList<Meal> createMenu() {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList<Meal> menu = null;
		try {
			menu = dao.getWeeklyMeals();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


		return menu;
	}

}
