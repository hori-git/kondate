package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import obj.DTOMeal;
import obj.DTOMenu;

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
			while (result_set.next()) {
				DTOMeal meal = new DTOMeal();
				meal.setId(result_set.getInt("id"));
				meal.setName(result_set.getString("name"));
				meal.setBreakfast(result_set.getBoolean("is_breakfast"));
				meal.setLunch(result_set.getBoolean("is_lunch"));
				meal.setDinner(result_set.getBoolean("is_dinner"));
				weeklyMenu.add(meal);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(conn);
		}

		return weeklyMenu;
	}

	@Override
	public void saveMenu(DTOMenu[] menu) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			pre_statement = conn.prepareStatement(SAVE_MENU);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//引数で受け取った献立情報をDBへ保存する
			//日付はDBへ「年月日」のみ保存する
			for (DTOMenu dtoMenu : menu) {
				pre_statement.setString(1, sdf.format(dtoMenu.getDate()));
				pre_statement.setString(2, dtoMenu.getMealTime());
				pre_statement.setInt(3, dtoMenu.getUserId());
				pre_statement.setInt(4, dtoMenu.getMealId());
				pre_statement.executeUpdate();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(conn);
		}

	}
}
