package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBHelp;
import model.chef;
import model.food;

public class chefDao {

	public List<chef> queryAll() {
		// 查询所有厨師
		// 主键 cid int
		// 名字 name String
		// 密码 pwd String
		// 手机号 phone String
		// 邮箱 mail String
		// 个人介绍 vita String
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<chef> list = new ArrayList<chef>();
		try {
			conn = DBHelp.getconn();
			String sql = "select * from chef;";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				chef chef = new chef();
				chef.setCid(rs.getInt("cid"));
				chef.setName(rs.getString("name"));
				chef.setPwd(rs.getString("pwd"));
				chef.setPhone(rs.getString("phone"));
				chef.setMail(rs.getString("mail"));
				chef.setVita(rs.getString("vita"));
				list.add(chef);
			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			clos(pstm, conn, rs);
		}
		return null;
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
