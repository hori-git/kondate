package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOManager;
import factory.Factory;
import obj.JSONMenu;

/**
 * Servlet implementation class Test
 * 各種機能の動作確認用
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Factory factory = new Factory();
		DAOManager dao = factory.getDao("oracle", "kondateApp");
//		 BufferedReader br = new BufferedReader(request.getReader());
//		 String jsonText = br.readLine();
//		 ObjectMapper mapper = new ObjectMapper();
//
//		 //TODO 献立マスタの構成と紐付いたクラスを作成する。名前は、DTOMeal?
//		 DTOMenu[] menu = mapper.readValue(jsonText, DTOMenu[].class);
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null;
		try {
			date = formatter.parse("2001/12/21");
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		ArrayList<JSONMenu> menu = dao.getMenu(6);
		System.out.println(menu.get(1).getMealDate());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
