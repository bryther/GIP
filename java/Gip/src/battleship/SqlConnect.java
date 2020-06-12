package battleship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The class to connect my database, and manage the few functions it serves in
 * my project. the 3 methods serve to print out two kinds of score board, and to
 * save any player's attempt at playing the game.
 *
 */

public class SqlConnect {

	public Connection con;

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
			ps = con.prepareStatement("SELECT player,Achieved,shotsLanded, MIN(enemyShotsLanded), Status");
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

	public boolean retrieveFromDB(String antwoordGebruiker) {
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("SELECT * FROM oplossingen WHERE lower(oplossing) LIKE lower(?)");
			ps.setString(1, antwoordGebruiker);
			ps.execute();
			ResultSet resultset = ps.getResultSet();
			return resultset.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	List<String> retrieveLettersFromDB(int idvraag) {
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(
					"SELECT DISTINCT substr(oplossing, 1, 1) as oplossingen FROM oplossingen WHERE FK = '1'");
			ps.execute();
			ResultSet resultset = ps.getResultSet();
			List<String> resultlist = new ArrayList<String>();
			while (resultset.next()) {
				resultlist.add(resultset.getString("oplossingen"));
			}
			return resultlist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}