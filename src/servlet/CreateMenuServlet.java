package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.KondateController;
import obj.Meal;

/**
 * Servlet implementation class CreateMenuServlet
 */
@WebServlet("/CreateMenuServlet")
public class CreateMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateMenuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		KondateController controller = new KondateController();
		//TODO ユーザーIDとアクセスキーをiPhoneから受け取る。
		int userId = 0;
		String accessKey = "";
		//TODO　リクエストで受け取ったユーザーIDとアクセスキーをもとに、当サーブレットを実行するか判定。
		if(!controller.checkUser(userId, accessKey)){
			//TODO サーブレットの動作を中止
			//エラーである旨をiPhoneへ渡す。
		}
		//TODO 一週間分の献立をJSON形式で返す。
		ArrayList<Meal> menu = controller.createMenuService();
		//確認用
		for(Meal m: menu) {
			System.out.println(m.getId() + m.getName());
		}
		//テスト
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
