package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DB.DBHelp;
import model.castle;
import model.chef;
import model.user;

public class castleDao {

	public boolean login(String acc, String pwd) {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			castle cas = new castle();
			conn = DBHelp.getconn();
			String sql = "select * from castle where acc=?;";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, acc);
			rs = pstm.executeQuery();
			while (rs.next()) {
				cas.setCid(rs.getInt(1));
				cas.setAcc(rs.getString("acc"));
				cas.setPwd(rs.getString("pwd"));
			}
			if (cas.getPwd().equals(pwd)) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			clos(pstm, conn, rs);
		}

		return false;
	}

	public static void clos(PreparedStatement pstm, Connection conn, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}


}
