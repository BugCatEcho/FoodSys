package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBHelp;
import model.food;
import model.user;

public class foodDao {

	public List<food> queryAll() {
		// 查询所有菜单

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<food> list = new ArrayList<food>();
		try {
			conn = DBHelp.getconn();
			String sql = "select * from food;";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				food food = new food();
				food.setFid(rs.getInt("fid"));
				food.setCid(rs.getInt("cid"));
				food.setName(rs.getString("name"));
				food.setTypeid(rs.getInt("typeid"));
				food.setMoney(rs.getInt("money"));
				food.setJieshao(rs.getString("jieshao"));
				list.add(food);
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

	public List<food> queryType(int typeid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<food> list = new ArrayList<food>();
		try {
			conn = DBHelp.getconn();
			String sql = "select * from food where typeid=?;";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, typeid);
			rs = pstm.executeQuery();
			while (rs.next()) {
				food food = new food();
				food.setFid(rs.getInt("fid"));
				food.setCid(rs.getInt("cid"));
				food.setName(rs.getString("name"));
				food.setTypeid(rs.getInt("typeid"));
				food.setMoney(rs.getInt("money"));
				food.setJieshao(rs.getString("jieshao"));
				list.add(food);
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

	public food queryOne(int fid) {
		// 根据fid查一条记录
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		food foodone = new food();
		try {
			conn = DBHelp.getconn();
			String sql = "select * from food where fid=?;";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, fid);
			rs = pstm.executeQuery();
			while (rs.next()) {
				foodone.setFid(fid);
				foodone.setCid(rs.getInt("cid"));
				foodone.setName(rs.getString("name"));
				foodone.setTypeid(rs.getInt("typeid"));
				foodone.setMoney(rs.getInt("money"));
				foodone.setJieshao(rs.getString("jieshao"));
			}

			return foodone;

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

	public List<food> search(String flag) {
		// select * from systables where tabname like 'saa%'
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<food> list = new ArrayList<food>();
		try {
			conn = DBHelp.getconn();
			String sql = "select * from food where name like '%" + flag + "%' or jieshao like '%" + flag + "%';";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				food food = new food();
				food.setFid(rs.getInt("fid"));
				food.setCid(rs.getInt("cid"));
				food.setName(rs.getString("name"));
				food.setTypeid(rs.getInt("typeid"));
				food.setMoney(rs.getInt("money"));
				food.setJieshao(rs.getString("jieshao"));
				list.add(food);
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

}
