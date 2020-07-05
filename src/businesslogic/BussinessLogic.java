package businesslogic;

import java.util.ArrayList;

import obj.Meal;

public interface BussinessLogic {

	//一週間の献立を作成するロジック
	ArrayList<Meal> createMenu();

}
