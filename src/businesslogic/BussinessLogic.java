package businesslogic;

import java.util.ArrayList;

import obj.DTOMenu;
import obj.JSONMeal;
import obj.JSONMenu;

public interface BussinessLogic {

	//一週間の献立を作成するロジック
	ArrayList<JSONMeal> createMenu();

	//一週間の献立をDBへ保存するロジック
	void saveMenu(DTOMenu[]  DTOMenus);

	//過去作成分の献立を取得するロジック
	ArrayList<JSONMenu> getMenu(int userId);
}
