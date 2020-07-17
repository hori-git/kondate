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
	final String GET_WEEKLY_MENU = "(SELECT * FROM meal WHERE is_breakfast = true ORDER BY RAND() LIMIT 7) UNION ALL (SELECT * FROM meal WHERE is_lunch = true ORDER BY RAND() LIMIT 7)" +
			"UNION ALL (SELECT * FROM meal WHERE is_dinner = true ORDER BY RAND() LIMIT 7)";

	public AbstructDAOManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("DBとの接続に失敗しました");
			e.printStackTrace();
		}
	}

}
