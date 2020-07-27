package dao;

import java.util.ArrayList;

import obj.DTOMeal;
import obj.DTOMenu;

//DAOが提供するサービス
public interface DAOManager {

	//一週間分の料理を返す。
	ArrayList<DTOMeal> getWeeklyMeals();

	//献立マスタへ保存する
	void saveMenu(DTOMenu[] menu);
}
