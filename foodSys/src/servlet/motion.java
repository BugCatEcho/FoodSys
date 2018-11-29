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
			System.out.println("--sysmsg--收到请求" + str + ",正在响应");
			switch (str) {
			// qa 查询所有菜
			// qt 查询type特定的菜 传进来tp
			case "qa": {
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();
				System.out.println("用户" + us.getName(uid) + "请求查询所有菜单");
				req.setCharacterEncoding("utf-8");
				List<food> list = fs.getAll();
				if (list != null) {
					System.out.println("--sysmsg--将" + list.size() + "条数据传向前台");
					req.setAttribute("list", list);

				} else {
					System.out.println("--errormsg--查询所有失败");
				}
				req.setAttribute("user", us.getUser(uid));
				// 向前台传所有菜品的list和uid
				req.getRequestDispatcher("show.jsp").forward(req, resp);

				// 转发到前台显示页面
				break;
			}
			case "qt": {
				int typeid = Integer.valueOf(req.getParameter("tp")).intValue();
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();
				List<food> typelist = fs.queryType(typeid);

				if (typelist != null) {
					System.out.println("--sysmsg--向前台传特定种类的菜list");
					req.setAttribute("list", typelist);
				} else {
					System.out.println("--errormsg--查询特定失败");
				}

				req.setAttribute("user", us.getUser(uid));
				// 向前台传所有菜品的list和uid
				req.getRequestDispatcher("show.jsp").forward(req, resp);

				break;
			}
			case "sc": {
				// 根据传过来的词查菜
				String flag = req.getParameter("search");
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();

				System.out.println(uid + "正在查包含" + flag + "的菜");
				List<food> list = fs.search(flag);
				if (list != null) {
					System.out.println("--sysmsg--向前台传查询的菜list");
					req.setAttribute("list", list);
				} else {
					System.out.println("--sysmsg--查询不到");
					req.setAttribute("list", list);
				}

				req.setAttribute("user", us.getUser(uid));
				// 向前台传所有菜品的list和uid
				req.getRequestDispatcher("show.jsp").forward(req, resp);

				break;
			}
			case "q1": {
				// 查询一个菜的信息
				int fid = Integer.valueOf(req.getParameter("fid")).intValue();
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();
				food foodone = fs.getOne(fid);
				System.out.println(foodone.getName());
				if (foodone.getFid() != null) {
					System.out.println("--sysmsg--向前台传了一个菜:" + foodone.getName());
					req.setAttribute("food", foodone);
				} else {
					System.out.println("查询一个菜失败,请求ID:" + fid);
				}
				req.setAttribute("user", us.getUser(uid));
				req.getRequestDispatcher("showOne.jsp").forward(req, resp);
				break;
			}
			case "nb": {
				// 传进一个fid和uid 向bill表添加一条记录
				int fid = Integer.valueOf(req.getParameter("fid")).intValue();
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();

				if (bs.addOne(fid, uid)) {
					// 如果添加成功则查跳转进motion传qa （查所有

					req.getRequestDispatcher("motion?motion=qa&uid=" + uid).forward(req, resp);
				}
				break;
			}
			case "rb": {
				// 传进一个bid和uid 向bill表移除一条记录
				int bid = Integer.valueOf(req.getParameter("bid")).intValue();
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();

				if (bs.removeOne(bid)) {
					// 如果移除成功则重新查所有账单

					req.setAttribute("list", bs.getNoPay(uid));
				}

				req.setAttribute("user", us.getUser(uid));
				req.getRequestDispatcher("pay.jsp").forward(req, resp);
				break;
			}
			case "bill": {
				// 通过传过来的UID查询他的所有未结算账单
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();
				if (bs.getNoPay(uid) != null) {

					req.setAttribute("list", bs.getNoPay(uid));

				} else {
					System.out.println("查询账单失败,请求UID:" + uid);
				}
				req.setAttribute("user", us.getUser(uid));
				req.getRequestDispatcher("pay.jsp").forward(req, resp);

				break;
			}
			case "py": {
				// 结算系统 通过传进来的UID
				// 先计算该用户set为2的总价
				// 执行扣款如果成功
				// 改变所有该用户所有bill.settlement为1
				int uid = Integer.valueOf(req.getParameter("uid")).intValue();
				if (bs.pay(uid)) {
					System.out.println("结账成功");
					req.setAttribute("user", us.getUser(uid));
					req.getRequestDispatcher("payok.jsp").forward(req, resp);

				}else {
					//结账失败执行的操作
					String message="您的余额不足";
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
					resp.getWriter().write("该用户不存在");
				}
				break;
			}
			case "boss": {
				String acc =req.getParameter("acc");
				String pwd =req.getParameter("pwd");
				if (as.login(acc, pwd)) {
					//查所有用户 菜品 厨师
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
			System.out.println("--sysmsg--收到一条空的请求");
		}
	}
}
