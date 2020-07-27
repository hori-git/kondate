package businesslogic;

import java.util.ArrayList;

import obj.DTOMenu;
import obj.JSONMeal;

public interface BussinessLogic {

	//一週間の献立を作成するロジック
	ArrayList<JSONMeal> createMenu();

	//一週間の献立をDBへ保存するロジック
	void saveMenu(DTOMenu[]  DTOMenus);
}
