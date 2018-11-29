package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.foodDao;
import model.chef;
import model.food;
import model.user;
import service.billService;
import service.castleService;
import service.chefService;
import service.foodService;
import service.userService;

public class motion extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String str = req.getParameter("motion");
		userService us = new userService();
		foodService fs = new foodService();
		billService bs = new billService();
		chefService cs=new chefService();
		castleService as=new castleService();
		foodDao fd = new foodDao();
		// int uid=Integer.valueOf(req.getParameter("uid")).intValue();
		// int fid=Integer.valueOf(req.getParameter("fid")).intValue();
		// int typeid=Integer.valueOf(req.getParameter("tp")).intValue();
		if (str != null) {
			System.out.println("--sysmsg--�յ�����" + str + ",������Ӧ");
			switch (str) {
			// qa ��ѯ���в�
			// qt ��ѯtype�ض��Ĳ� ������tp
			case "qa": {
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();
				System.out.println("�û�" + us.getName(uid) + "�����ѯ���в˵�");
				req.setCharacterEncoding("utf-8");
				List<food> list = fs.getAll();
				if (list != null) {
					System.out.println("--sysmsg--��" + list.size() + "�����ݴ���ǰ̨");
					req.setAttribute("list", list);

				} else {
					System.out.println("--errormsg--��ѯ����ʧ��");
				}
				req.setAttribute("user", us.getUser(uid));
				// ��ǰ̨�����в�Ʒ��list��uid
				req.getRequestDispatcher("show.jsp").forward(req, resp);

				// ת����ǰ̨��ʾҳ��
				break;
			}
			case "qt": {
				int typeid = Integer.valueOf(req.getParameter("tp")).intValue();
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();
				List<food> typelist = fs.queryType(typeid);

				if (typelist != null) {
					System.out.println("--sysmsg--��ǰ̨���ض�����Ĳ�list");
					req.setAttribute("list", typelist);
				} else {
					System.out.println("--errormsg--��ѯ�ض�ʧ��");
				}

				req.setAttribute("user", us.getUser(uid));
				// ��ǰ̨�����в�Ʒ��list��uid
				req.getRequestDispatcher("show.jsp").forward(req, resp);

				break;
			}
			case "sc": {
				// ���ݴ������Ĵʲ��
				String flag = req.getParameter("search");
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();

				System.out.println(uid + "���ڲ����" + flag + "�Ĳ�");
				List<food> list = fs.search(flag);
				if (list != null) {
					System.out.println("--sysmsg--��ǰ̨����ѯ�Ĳ�list");
					req.setAttribute("list", list);
				} else {
					System.out.println("--sysmsg--��ѯ����");
					req.setAttribute("list", list);
				}

				req.setAttribute("user", us.getUser(uid));
				// ��ǰ̨�����в�Ʒ��list��uid
				req.getRequestDispatcher("show.jsp").forward(req, resp);

				break;
			}
			case "q1": {
				// ��ѯһ���˵���Ϣ
				int fid = Integer.valueOf(req.getParameter("fid")).intValue();
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();
				food foodone = fs.getOne(fid);
				System.out.println(foodone.getName());
				if (foodone.getFid() != null) {
					System.out.println("--sysmsg--��ǰ̨����һ����:" + foodone.getName());
					req.setAttribute("food", foodone);
				} else {
					System.out.println("��ѯһ����ʧ��,����ID:" + fid);
				}
				req.setAttribute("user", us.getUser(uid));
				req.getRequestDispatcher("showOne.jsp").forward(req, resp);
				break;
			}
			case "nb": {
				// ����һ��fid��uid ��bill�����һ����¼
				int fid = Integer.valueOf(req.getParameter("fid")).intValue();
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();

				if (bs.addOne(fid, uid)) {
					// �����ӳɹ������ת��motion��qa ��������

					req.getRequestDispatcher("motion?motion=qa&uid=" + uid).forward(req, resp);
				}
				break;
			}
			case "rb": {
				// ����һ��bid��uid ��bill���Ƴ�һ����¼
				int bid = Integer.valueOf(req.getParameter("bid")).intValue();
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();

				if (bs.removeOne(bid)) {
					// ����Ƴ��ɹ������²������˵�

					req.setAttribute("list", bs.getNoPay(uid));
				}

				req.setAttribute("user", us.getUser(uid));
				req.getRequestDispatcher("pay.jsp").forward(req, resp);
				break;
			}
			case "bill": {
				// ͨ����������UID��ѯ��������δ�����˵�
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();
				if (bs.getNoPay(uid) != null) {

					req.setAttribute("list", bs.getNoPay(uid));

				} else {
					System.out.println("��ѯ�˵�ʧ��,����UID:" + uid);
				}
				req.setAttribute("user", us.getUser(uid));
				req.getRequestDispatcher("pay.jsp").forward(req, resp);

				break;
			}
			case "py": {
				// ����ϵͳ ͨ����������UID
				// �ȼ�����û�setΪ2���ܼ�
				// ִ�пۿ�����ɹ�
				// �ı����и��û�����bill.settlementΪ1
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();
				if (bs.pay(uid)) {
					System.out.println("���˳ɹ�");
					req.setAttribute("user", us.getUser(uid));
					req.getRequestDispatcher("payok.jsp").forward(req, resp);

				}else {
					//����ʧ��ִ�еĲ���
					String message="��������";
					req.getSession().setAttribute("message", message);
					req.setAttribute("list", bs.getNoPay(uid));
					req.setAttribute("user", us.getUser(uid));
					req.getRequestDispatcher("pay.jsp").forward(req, resp);
				}

				break;
			}
			case "exist": {
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();

				resp.setCharacterEncoding("utf-8");
				if (us.exist(uid)) {
					resp.getWriter().write("OK");
				} else {
					resp.getWriter().write("���û�������");
				}
				break;
			}
			case "boss": {
				String acc =req.getParameter("acc");
				String pwd =req.getParameter("pwd");
				if (as.login(acc, pwd)) {
					//�������û� ��Ʒ ��ʦ
					List<user> ulist=us.queryAll();
					List<food> flist=fs.getAll();
					List<chef> clist=cs.queryAll();
					req.setAttribute("ulist", ulist);
					req.setAttribute("flist", flist);
					req.setAttribute("clist", clist);			
					req.getRequestDispatcher("Manage.jsp").forward(req, resp);
					
					
				}
					
					
					
				break;
			}
			default:
				req.getRequestDispatcher("index.jsp");
				break;
			}
		} else {
			System.out.println("--sysmsg--�յ�һ���յ�����");
		}
	}
}
