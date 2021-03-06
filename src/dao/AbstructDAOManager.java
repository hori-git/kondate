package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstructDAOManager {

	//設定ファイルに出す
	//メンバ
	Connection conn = null;
	final String URL = "jdbc:mysql://localhost:3306/KondateApp";
	final String USER = "hori";
	final String PASSWORD = "password";

	//sql文
	//一週間の献立取得
	final String GET_WEEKLY_MEAL = "(SELECT * FROM meal WHERE is_breakfast = true ORDER BY RAND() LIMIT 7) UNION ALL (SELECT * FROM meal WHERE is_lunch = true ORDER BY RAND() LIMIT 7)"
			+
			"UNION ALL (SELECT * FROM meal WHERE is_dinner = true ORDER BY RAND() LIMIT 7)";

	final String SAVE_MENU = "INSERT INTO menu VALUES (?,?,?,?)";

	final String GET_MENU = "SELECT menu.date , menu.meal_time , meal.id , meal.name FROM menu INNER JOIN meal ON menu.meal_id = meal.id"
			+ " WHERE menu.user_id = ?  ORDER BY menu.date;";

	public AbstructDAOManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("DBとの接続に失敗しました");
			e.printStackTrace();
		}
	}

	public static void close(Connection connection) {
		if (connection != null) {
			try {
				//DB接続切断
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
