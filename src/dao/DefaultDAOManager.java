package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import obj.DTOMeal;

public class DefaultDAOManager extends AbstructDAOManager implements DAOManager {

	//メンバ
	private PreparedStatement pre_statement;

	public DefaultDAOManager() {
		super();
	}

	@Override
	public ArrayList<DTOMeal> getWeeklyMeals() {
		//メンバ
		ResultSet result_set = null;
		ArrayList<DTOMeal> weeklyMenu = new ArrayList<DTOMeal>();

		try {
			//TODO Taskの方で引数に使用しているのはなにか聞く
			pre_statement = conn.prepareStatement(GET_WEEKLY_MENU);
			result_set = pre_statement.executeQuery();

			//取得したResultSetからMeal配列オブジェクトを生成する
			while(result_set.next()) {
				DTOMeal meal = new DTOMeal();
					meal.setId(result_set.getInt("id"));
					meal.setName(result_set.getString("name"));
					meal.setBreakfast(result_set.getBoolean("is_breakfast"));
					meal.setLunch(result_set.getBoolean("is_lunch"));
					meal.setDinner(result_set.getBoolean("is_dinner"));
				weeklyMenu.add(meal);
			}
			//コンソールに全件表示
//			for(Meal m: weeklyMenu) {
//				System.out.println(m.getId() + m.getName());
//			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return weeklyMenu;
	}
}
