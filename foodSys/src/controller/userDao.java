package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBHelp;
import model.user;

public class userDao {

	public boolean insertone(user user) {
		// Connection conn = null;
		// PreparedStatement pstm = null;
		// // 增加一条数据
		// try {
		// conn = DBHelp.getconn();
		// String sql = "insert into user values(null,?,?,?);";
		// pstm = conn.prepareStatement(sql);
		// pstm.setString(1, user.getUname());
		// pstm.setInt(2, user.getAge());
		// pstm.setString(3, user.getSex());
		// return pstm.executeUpdate() < 2;
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }finally {
		//
		// clos(pstm, conn, null);
		// }
		return false;
	}

	public boolean delete(int id) {
		// 删除一条语句
		// Connection conn = null;
		// PreparedStatement pstm = null;
		// try {
		// conn = db.getconn();
		// String sql = "delete from user where uid=?;";
		// pstm = conn.prepareStatement(sql);
		// pstm.setInt(1, id);
		// return pstm.executeUpdate() < 2;
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		//
		// }finally {
		//
		// clos(pstm, conn, null);
		// }
		return false;

	}

	public boolean updata(user user) {
		// 更改一条语句
		// Connection conn = null;
		// PreparedStatement pstm = null;
		// try {
		// conn = db.getconn();
		// String sql = "update user set name=?,age=?,sex=? where uid=?;";
		// pstm = conn.prepareStatement(sql);
		//
		// pstm.setString(1, user.getUname());
		// pstm.setInt(2, user.getAge());
		// pstm.setString(3, user.getSex());
		// pstm.setInt(4, user.getUid());
		// return pstm.executeUpdate() < 2;
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		//
		// }finally {
		//
		// clos(pstm, conn, null);
		// }

		return false;

	}

	public user queryone(int id) {
		// 根据ID查询一个User
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		user user = new user();
		try {
			conn = DBHelp.getconn();
			String sql = "select * from user where uid=?;";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				user.setUid(id);
				user.setName(rs.getString("name"));
				user.setMoney(rs.getDouble("money"));
			}

			return user;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			clos(pstm, conn, rs);
		}
		return null;

	}

	public List<user> queryAll() {
		// 查询所有
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		List<user> list = new ArrayList<user>();
		try {
			conn = DBHelp.getconn();
			String sql = "select * from user;";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				user user = new user();
				user.setUid(rs.getInt("uid"));
				user.setName(rs.getString("name"));
				user.setMoney(rs.getDouble("money"));
				list.add(user);
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

	public boolean deMoney(int uid, double payflag) {
		// 根据用户ID和要减少的钱来操作用户的钱
		double moneyflag = getMoney(uid);// 获得用户余额

		System.out.println("用户余额：" + moneyflag);
		System.out.println("用户要付的钱：" + payflag);
		if (moneyflag > payflag) {// 如果用户余额大于应付金额再操作

			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = DBHelp.getconn();
				String sql = "update user set money=? where uid=?;";
				pstm = conn.prepareStatement(sql);
				pstm.setDouble(1, moneyflag - payflag);
				pstm.setDouble(2, uid);
				return pstm.executeUpdate() > 0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} finally {

				clos(pstm, conn, null);
			}

		} else {
			System.out.println("--errormsg--用户余额不足以支付");
			return false;

		}

		return false;
	}

	private double getMoney(int uid) {
		// 获得用户余额

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		double moneyflag = 0;
		try {
			conn = DBHelp.getconn();
			String sql = "select money from user where uid=?;";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, uid);
			rs = pstm.executeQuery();
			while (rs.next()) {
				moneyflag = rs.getDouble("Money");
			}

			return moneyflag;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			clos(pstm, conn, rs);
		}
		return 0;

	}

	public boolean exist(int uid) {
		// 根据id判断用户是否存在
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		user user = new user();
		try {
			conn = DBHelp.getconn();
			String sql = "select * from user where uid=?;";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, uid);
			rs = pstm.executeQuery();
			while (rs.next()) {
				user.setUid(rs.getInt("uid"));
				user.setName(rs.getString("name"));
				user.setMoney(rs.getDouble("money"));
			}
			return user.getUid() != null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			clos(pstm, conn, rs);
		}
		return false;
	}

	public boolean exist(String name) {
		// 根据name判断用户是否存在
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		user user = new user();
		try {
			conn = DBHelp.getconn();
			String sql = "select * from user where name=?;";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			while (rs.next()) {
				user.setUid(rs.getInt("uid"));
				user.setName(rs.getString("name"));
				user.setMoney(rs.getDouble("money"));
			}
			return user.getUid() != null;

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
