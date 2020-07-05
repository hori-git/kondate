package businesslogic;

public class BussinessLogicFactory {

	BussinessLogic logic = null;

	public BussinessLogic getLogic(String appname) {

		if(appname.equals("kondateApp")) {
			logic = new DefaultBusinesslogic();
		}

		return logic;
	}
}
