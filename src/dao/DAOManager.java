package dao;

import java.util.ArrayList;

import obj.Meal;

//DAOが提供するサービス
public interface DAOManager {

	//一週間分の料理を返す。
	ArrayList<Meal> getWeeklyMeals();

}
