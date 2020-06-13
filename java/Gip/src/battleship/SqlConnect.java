package battleship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * The class to connect my database, and manage the few functions it serves in
 * my project. the 3 methods serve to print out two kinds of score board, and to
 * save any player's attempt at playing the game.
 *
 */

public class SqlConnect {

	private static DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static Date date = new Date();
	public static Connection con;

	public SqlConnect() {
		try {
			con = DriverManager.getConnection("jdbc:sqlite:/Gip/src/battleship.db");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error connecting to database");
		}
	}

	public List<String> highScore() {
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM HighScores");
			ps.execute();
			ResultSet resultset = ps.getResultSet();
			List<String> resultlist = new ArrayList<String>();
			while (resultset.next()) {
				resultlist.add(resultset.getString("vraag"));
			}
			return resultlist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void saveScore(String player, int myScore, int enemyScore, String status) {
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"INSERT INTO HighScores (id, player, Achieved, shotsLanded, enemyShotsLanded, Status) VALUES "
							+ "('" + player + "," + dateformat.format(date) + "," + myScore + "," + enemyScore + ","
							+ status + "," + "')");

			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
