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
		// // ����һ������
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
		// ɾ��һ�����
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
		// ����һ�����
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
		// ����ID��ѯһ��User
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
		// ��ѯ����
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
		// �����û�ID��Ҫ���ٵ�Ǯ�������û���Ǯ
		double moneyflag = getMoney(uid);// ����û����

		System.out.println("�û���" + moneyflag);
		System.out.println("�û�Ҫ����Ǯ��" + payflag);
		if (moneyflag > payflag) {// ����û�������Ӧ������ٲ���

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
			System.out.println("--errormsg--�û�������֧��");
			return false;

		}

		return false;
	}

	private double getMoney(int uid) {
		// ����û����

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
		// ����id�ж��û��Ƿ����
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
		// ����name�ж��û��Ƿ����
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
