package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBHelp;
import model.bill;
import model.food;
import model.user;

public class billDao {
	public boolean insert(int fid, int uid) {

		Connection conn = null;
		PreparedStatement pstm = null;
		// ����һ������
		try {
			conn = DBHelp.getconn();
			// insert into bill values(null,uid,fid,date,[1,2])(1����;2δ��)
			String sql = "insert into bill values(null,?,?,?,?);";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, uid);
			pstm.setInt(2, fid);
			pstm.setString(3, new timerDao().gettime());
			pstm.setInt(4, 2);

			return pstm.executeUpdate() < 2;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			clos(pstm, conn, null);
		}
		return false;
	}

	public List<bill> getNoPay(int uid) {
		// ����uid ��ѯ SettlementΪ2��(δ�����)
		// �˵�list
		// bid int primary key auto_increment,
		// uid int,
		// fid int,
		// addtime varchar(20),
		// Settlement int
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<bill> list = new ArrayList<bill>();
		try {
			conn = DBHelp.getconn();
			String sql = "select * from bill where uid=? and Settlement=2;";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, uid);
			rs = pstm.executeQuery();
			while (rs.next()) {
				bill billone = new bill();
				billone.setBid(rs.getInt("bid"));
				billone.setUid(rs.getInt("uid"));
				billone.setFid(rs.getInt("fid"));
				billone.setFood(new foodDao().queryOne(rs.getInt("fid")));
				billone.setAddtime(rs.getString("addtime"));
				billone.setSettlement(rs.getInt("Settlement"));

				list.add(billone);
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

	public boolean removeOne(int bid) {
		// �Ƴ�һ������
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = DBHelp.getconn();
			// insert into bill values(null,uid,fid,date,[1,2])(1����;2δ��)
			String sql = "delete from bill where bid=?;";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, bid);

			return pstm.executeUpdate() < 2;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			clos(pstm, conn, null);
		}
		return false;
	}

	public boolean pay(int uid) {
		userDao ud = new userDao();
		double payflag = needPayMoney(uid);
		if (ud.deMoney(uid, payflag)) {// �ȿ�Ǯ ����ɹ��˵Ļ�
			// ���ĸ��û����е��˵�Ϊ�ѽ���

			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = DBHelp.getconn();
				String sql = "update bill set settlement=1 where uid=?;";
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, uid);
				return pstm.executeUpdate() > 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} finally {

				clos(pstm, conn, null);
			}

		} else {
			System.out.println("--syserror--�ۿ�ʧ��");

			return false;

		}
		return false;
	}

	private double needPayMoney(int uid) {
		// ����Ӧ����
		List<bill> list = getNoPay(uid);
		double flag = 0;
		for (int i = 0; i < list.size(); i++) {
			flag += list.get(i).getFood().getMoney();
		}
		return flag;
	}
}
