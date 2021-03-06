package ts.serviceImpl;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Response;
import org.hibernate.criterion.Restrictions;

import ts.daoImpl.CustomerInfoDao;
import ts.daoImpl.ExpressSheetDao;
import ts.daoImpl.PackageRouteDao;
import ts.daoImpl.TransHistoryDao;
import ts.daoImpl.TransPackageContentDao;
import ts.daoImpl.TransPackageDao;
import ts.daoImpl.UserInfoDao;
import ts.daoImpl.UsersPackageDao;
import ts.model.*;
import ts.model.TransPackageContent.STATUS;
import ts.serviceInterface.IDomainService;

public class DomainService implements IDomainService {

	private ExpressSheetDao expressSheetDao;
	private TransPackageDao transPackageDao;
	private TransHistoryDao transHistoryDao;
	private TransPackageContentDao transPackageContentDao;
	private CustomerInfoDao customerInfoDao;
	private UsersPackageDao usersPackageDao;
	private UserInfoDao userInfoDao;
	private PackageRouteDao packageRouteDao;

	public UsersPackageDao getUsersPackageDao() {
		return usersPackageDao;
	}

	public void setUsersPackageDao(UsersPackageDao usersPackageDao) {
		this.usersPackageDao = usersPackageDao;
	}

	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}

	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}

	public ExpressSheetDao getExpressSheetDao() {
		return expressSheetDao;
	}

	public void setExpressSheetDao(ExpressSheetDao dao) {
		this.expressSheetDao = dao;
	}

	public TransPackageDao getTransPackageDao() {
		return transPackageDao;
	}

	public void setTransPackageDao(TransPackageDao dao) {
		this.transPackageDao = dao;
	}

	public TransHistoryDao getTransHistoryDao() {
		return transHistoryDao;
	}

	public void setTransHistoryDao(TransHistoryDao dao) {
		this.transHistoryDao = dao;
	}

	public TransPackageContentDao getTransPackageContentDao() {
		return transPackageContentDao;
	}

	public void setTransPackageContentDao(TransPackageContentDao dao) {
		this.transPackageContentDao = dao;
	}

	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao dao) {
		this.userInfoDao = dao;
	}

	/*
	 * public Date getCurrentDate() { //产生一个不带毫秒的时间,不然,SQL时间和JAVA时间格式不一致
	 * SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); Date tm =
	 * new Date(); try { tm= sdf.parse(sdf.format(new Date())); } catch
	 * (ParseException e1) { e1.printStackTrace(); } return tm; }
	 */

	public PackageRouteDao getPackageRouteDao() {
		return packageRouteDao;
	}

	public void setPackageRouteDao(PackageRouteDao packageRouteDao) {
		this.packageRouteDao = packageRouteDao;
	}

	@Override
	public List<ExpressSheet> getExpressList(String property, String restrictions, String value) {
		List<ExpressSheet> list = new ArrayList<ExpressSheet>();
		switch (restrictions.toLowerCase()) {
		case "eq":
			list = expressSheetDao.findBy(property, value, "ID", true);
			break;
		case "like":
			list = expressSheetDao.findLike(property, value + "%", "ID", true);
			break;
		}
		return list;
	}

	/*
	 * @Override public List<ExpressSheet> getExpressList(String property, String
	 * restrictions, String value) { Criterion cr1; Criterion cr2 =
	 * Restrictions.eq("Status", 0);
	 * 
	 * List<ExpressSheet> list = new ArrayList<ExpressSheet>();
	 * switch(restrictions.toLowerCase()){ case "eq": cr1 =
	 * Restrictions.eq(property, value); break; case "like": cr1 =
	 * Restrictions.like(property, value); break; default: cr1 =
	 * Restrictions.like(property, value); break; } list =
	 * expressSheetDao.findBy("ID", true,cr1,cr2); return list; }
	 */
	@Override
	public List<ExpressSheet> getExpressListInPackage(String packageId) {
		List<ExpressSheet> list = new ArrayList<ExpressSheet>();
		list = expressSheetDao.getListInPackage(packageId);
		return list;
	}

	@Override
	public Response getExpressSheet(String id) {
		ExpressSheet es = expressSheetDao.get(id);
		if(es!=null) 
			return Response.ok(es).header("EntityClass", "ExpressSheet").build();
		else return Response.ok(es).header("EntityClass", "Error_ExpressSheet").build();

	}

	@Override
	public Response newExpressSheet(String id, int uid) {
				
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date tm = new Date();
		try {
			tm = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		ExpressSheet es = null;
		try {
			es = expressSheetDao.get(id);
		} catch (Exception e1) {
		}

		if (es != null) {
//			if(es.getStatus() != 0)
//				return Response.ok(es).header("EntityClass", "L_ExpressSheet").build(); //已经存在且不能更改
//			else
			return Response.ok(es).header("EntityClass", "E_ExpressSheet").build(); // 已经存在
		}
		try {
			String pkgId = userInfoDao.get(uid).getReceivePackageID();
			ExpressSheet nes = new ExpressSheet();
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+tm);
			nes.setID(id);
			nes.setType(0);
			nes.setStatus(0);
			nes.setAccepter(String.valueOf(uid));
			nes.setAcceptTime(tm);
			System.out.println("==="+nes+"======");
			System.out.println("==="+nes.getAcceptTime()+"======");
			expressSheetDao.save(nes);/*
			System.out.println("=============2=2==2=2=2=2=2=2=2=2=2=2=2=2=2=22==2=22=");
			expressSheetDao.update(nes);
			System.out.println("===========1111111111111111111111111==2=2==2=2=2=2=2=2=2=2=2=2=2=2=2=22==2=22=");*/
			TransPackageContent pkg_add = new TransPackageContent();
			pkg_add.setTransPackageID(pkgId);
			pkg_add.setExpressSheetID(id);
			pkg_add.setStatus(STATUS.STATUS_ACTIVE);
			transPackageContentDao.save(pkg_add);
			return Response.ok(nes).header("EntityClass", "ExpressSheet").build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@Override
	public Response saveExpressSheet(ExpressSheet obj) {
		try {
			expressSheetDao.update(obj);
			return Response.ok(obj).header("EntityClass", "R_ExpressSheet").build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@Override
	public Response updateExpressSheet(String id, ExpressSheet obj) {
		try {
			expressSheetDao.save(obj);
			String expressSheetID = obj.getID();
			List<TransPackageContent> list = new ArrayList<TransPackageContent>();
			list = transPackageContentDao.findBy("ExpressSheetID", id, "SN", true);
			for (TransPackageContent transPackageContent : list) {

				transPackageContent.setExpressSheetID(expressSheetID);
				transPackageContentDao.update(transPackageContent);
			}
			expressSheetDao.removeById(id);
			return Response.ok(obj).header("EntityClass", "R_ExpressSheet").build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@Override
	public Response ReceiveExpressSheetId(String id, int uid) {
		try {
			ExpressSheet nes = expressSheetDao.get(id);
			nes.setAccepter(String.valueOf(uid));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date = sdf.parse(sdf.format(new Date()));
			nes.setAcceptTime(date);
			nes.setStatus(ExpressSheet.STATUS.STATUS_RECEIVED);
			expressSheetDao.save(nes);
			// TransPackage tp = new TransPackage();
			// nes = expressSheetDao.get(id);

			// transPackageDao.save(tp);
			return Response.ok(nes).header("EntityClass", "ExpressSheet").build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@Override
	public Response DispatchExpressSheet(String id, int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response DeliveryExpressSheetId(String id, int uid) {
		TransPackageContent transPackageContent = new TransPackageContent();
		try {
			ExpressSheet nes = expressSheetDao.get(id);
			nes.setDeliver(String.valueOf(uid));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date = sdf.parse(sdf.format(new Date()));
			nes.setDeliverTime(date);
			nes.setStatus(ExpressSheet.STATUS.STATUS_DELIVERED);
			expressSheetDao.save(nes);
			transPackageContent = transPackageContentDao.findBy("SN", true, Restrictions.eq("ExpressSheetID", id),
					Restrictions.eq("status", STATUS.STATUS_ACTIVE)).get(0);
			transPackageContent.setStatus(STATUS.STATUS_OUTOF_PACKAGE);
			transPackageContentDao.update(transPackageContent);

			// TransPackage tp = new TransPackage();
			// nes = expressSheetDao.get(id);

			// transPackageDao.save(tp);
			return Response.ok(nes).header("EntityClass", "ExpressSheet").build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@Override
	public List<TransPackage> getTransPackageList(String property, String restrictions, String value) {
		List<TransPackage> list = new ArrayList<TransPackage>();
		switch (restrictions.toLowerCase()) {
		case "eq":
			list = transPackageDao.findBy(property, value, "ID", true);
			break;
		case "like":
			list = transPackageDao.findLike(property, value + "%", "ID", true);
			break;
		}
		return list;
	}

	@Override
	public Response saveTransPackage(TransPackage obj) {
		try {
			transPackageDao.save(obj);
			return Response.ok(obj).header("EntityClass", "R_TransPackage").build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@Override
	public Response createExpressSheet(ExpressSheet expressSheet) {
		// List<CustomerInfo> customerInfoSnd = new ArrayList<CustomerInfo>();
		// List<CustomerInfo> customerInfoRcv = new ArrayList<CustomerInfo>();
		// System.out.println(expressSheet.getSender());
		System.out.println(expressSheet.getRecever());
		System.out.println(expressSheet.getSender());
		CustomerInfo snd = expressSheet.getSender();
		CustomerInfo rcv = expressSheet.getRecever();

		int customerInfoSndID = customerInfoDao.findByPropertyWithoutID(snd);
		int customerInfoRcvID = customerInfoDao.findByPropertyWithoutID(rcv);

		if (customerInfoSndID == -1) {
			customerInfoDao.save(snd);
			customerInfoSndID = snd.getID();
		}
		if (customerInfoRcvID == -1) {
			customerInfoDao.save(rcv);
			customerInfoRcvID = rcv.getID();
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date tm = new Date();
		try {
			tm = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		String s = sdf.format(tm);
		try {
			String pkgId = userInfoDao.get(1).getReceivePackageID();
			ExpressSheet nes = new ExpressSheet();
			String id = snd.getName() + "_" + s;
			System.out.println(id);
			nes.setID(id);
			nes.setSender(customerInfoDao.get(customerInfoSndID));
			nes.setRecever(customerInfoDao.get(customerInfoRcvID));
			nes.setType(0);
			nes.setAccepter(String.valueOf(1));
			nes.setStatus(ExpressSheet.STATUS.STATUS_CREATED);
			System.out.println(nes);
			expressSheetDao.save(nes);
			TransPackageContent pkg_add = new TransPackageContent();
			pkg_add.setExpressSheetID(id);
			pkg_add.setTransPackageID(pkgId);
			pkg_add.setStatus(STATUS.STATUS_ACTIVE);
			;
			System.out.println(pkg_add);
			transPackageContentDao.save(pkg_add);
			System.out.println(3);
			return Response.ok(id).header("EntityClass", "id").build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@Override
	public Response doLogin(int uid, String pwd) {
		try {
			System.out.println("1");
			UserInfo userInfo = userInfoDao.checkLogin(uid, pwd);
			System.out.println(userInfo);
			return Response.ok(userInfo).header("EntityClass", "UserInfo").build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@Override
	public List<TransPackage> getUsersPackage(int userUID) {
		List<UsersPackage> usersPackageList = new ArrayList<>();
		usersPackageList = usersPackageDao.getTransPackageList(userUID);
		List<TransPackage> transPackageList = new ArrayList<>();
		for (int i = 0; i < usersPackageList.size(); i++) {
			TransPackage transPackage = transPackageDao.findBy("ID", usersPackageList.get(i).getPackageID(), "ID", true)
					.get(0);
			transPackageList.add(transPackage);
		}
		return transPackageList;
	}

	@Override
	public List<ExpressSheet> getExpressListBySndTel(String Tel) {
		List<ExpressSheet> expressSheets = new ArrayList<>();
		List<ExpressSheet> expressSheetList = new ArrayList<>();
		List<CustomerInfo> customerInfos = new ArrayList<>();
		customerInfos = customerInfoDao.findBy("TelCode", Tel, "ID", true);
		System.out.println(customerInfos);
		for (int i = 0; i < customerInfos.size(); i++) {
			expressSheets = expressSheetDao.findBy("Sender", customerInfos.get(i), "ID", true);
			System.out.println(expressSheets);
			for (int j = 0; j < expressSheets.size(); j++) {
				ExpressSheet expressSheet = new ExpressSheet();
				expressSheet = expressSheets.get(j);
				expressSheetList.add(expressSheet);
			}
		}
		return expressSheetList;
	}

	@Override
	public List<ExpressSheet> getExpressListByRecTel(String Tel) {
		List<ExpressSheet> expressSheets = new ArrayList<>();
		List<ExpressSheet> expressSheetList = new ArrayList<>();
		List<CustomerInfo> customerInfos = new ArrayList<>();
		customerInfos = customerInfoDao.findBy("TelCode", Tel, "ID", true);
		for (int i = 0; i < customerInfos.size(); i++) {
			expressSheets = expressSheetDao.findBy("Recever", customerInfos.get(i), "ID", true);
			for (int j = 0; j < expressSheets.size(); j++) {
				ExpressSheet expressSheet = new ExpressSheet();
				expressSheet = expressSheets.get(j);
				expressSheetList.add(expressSheet);
			}
		}
		return expressSheetList;
	}

	@Override
	public Response newTransPackage(int uid, TransPackage obj) {
		List<TransPackage> transPackages = new ArrayList<>();
		UsersPackage usersPackage = new UsersPackage();
		try {
			transPackages = transPackageDao.findBy("ID", obj.getID(), "ID", true);
			if (!transPackages.isEmpty()) {
				return Response.ok(obj).header("EntityClass", "E_TransPackage").build();
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
				Date tm = new Date();
				try {
					tm = sdf.parse(sdf.format(new Date()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				obj.setCreateTime(tm);
				obj.setStatus(1);
				transPackageDao.save(obj);
				usersPackage.setPackageID(obj.getID());
				usersPackage.setUserUID(uid);
				usersPackageDao.save(usersPackage);
				return Response.ok(usersPackage).header("EntityClass", "UsersPackage").build();
			}
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	public int openTransPackage(String pid, String eid) {
		ExpressSheet expressSheet = new ExpressSheet();
		// TransHistory transHistory = new TransHistory();
		// List<UserInfo> userInfos = new ArrayList<>();
		TransPackageContent transPackageContent = new TransPackageContent();
		// UserInfo userInfo = new UserInfo();
		expressSheet = expressSheetDao.get(eid);
		expressSheet.setStatus(2);
		expressSheetDao.update(expressSheet);
		/*
		 * userInfos = userInfoDao.findBy("UID", uid, "UID", true); //传入用户UID不存在 返回1
		 * if(userInfos.isEmpty()){ return 1; } userInfo = userInfos.get(0);
		 * System.out.println(userInfo);
		 */
		transPackageContent = transPackageContentDao
				.findBy("SN", true, Restrictions.eq("ExpressSheetID", eid), Restrictions.eq("TransPackageID", pid))
				.get(0);
		// 传入包裹ID不存在 返回2
		if (transPackageContent == null) {
			return 2;
		}

		TransPackage transPackage = new TransPackage();
		transPackage = transPackageDao.get(pid);
		System.out.println("!!!!!!!!!!" + transPackage);
		// 如果选择的包裹已经没有快件，则不处理
		if (transPackage.getStatus() == 0) {
			return 1;
		}
		transPackage.setStatus(3);
		transPackageDao.save(transPackage);
		transPackageContent.setStatus(STATUS.STATUS_OUTOF_PACKAGE);
		transPackageContentDao.update(transPackageContent);
		/*
		 * TransPackageContent tpc = new TransPackageContent();
		 * tpc.setExpressSheetID(transPackageContent.getExpressSheetID());
		 * tpc.setTransPackageID(userInfo.getReceivePackageID());
		 * tpc.setStatus(STATUS.STATUS_ACTIVE); System.out.println(tpc);
		 * transPackageContentDao.save(tpc);
		 */
		return 0;
	}

	@Override
	public List<UserInfo> getUserList(String property, String restrictions, String value) {
		List<UserInfo> list = new ArrayList<UserInfo>();
		int intValue;
		if (property.equals("UID") || property.equals("URull") || property.equals("Status")) {
			intValue = Integer.parseInt(value);
			switch (restrictions.toLowerCase()) {
			case "eq":
				list = userInfoDao.findBy(property, intValue, "UID", true);
				break;
			case "like":
				list = userInfoDao.findLike(property, intValue + "%", "UID", true);
				break;
			}
		} else {
			switch (restrictions.toLowerCase()) {
			case "eq":
				list = userInfoDao.findBy(property, value, "UID", true);
				break;
			case "like":
				list = userInfoDao.findLike(property, value + "%", "UID", true);
				break;
			}
		}
		return list;
	}

	@Override
	public int packTransPackage(String transPackageID, String expressSheetID) {
		try {
			ExpressSheet expressSheet = new ExpressSheet();
			expressSheet = expressSheetDao.findBy("ID", expressSheetID, "ID", true).get(0);
			TransPackageContent transPackageContent = new TransPackageContent();
			TransPackageContent transPackageContent1 = new TransPackageContent();
			transPackageContent = transPackageContentDao
					.findBy("SN", true, Restrictions.eq("ExpressSheetID", expressSheetID),
							Restrictions.eq("status", STATUS.STATUS_OUTOF_PACKAGE))
					.get(0);
			if (transPackageContent != null) {
				// 状态
				expressSheet.setStatus(3);
				expressSheetDao.update(expressSheet);
				/*
				 * transPackageContent.setStatus(STATUS.STATUS_ACTIVE);
				 * transPackageContentDao.update(transPackageContent);
				 */
				transPackageContent1.setTransPackageID(transPackageID);
				transPackageContent1.setExpressSheetID(expressSheetID);
				transPackageContent1.setStatus(STATUS.STATUS_ACTIVE);
				transPackageContentDao.save(transPackageContent1);
				return 5;// 成功
			} else {
				return 6;//
			}
		} catch (Exception e) {
			return 7;
		}
	}

	// 打包派送
	public int appointDeliver(String transPackageID, String expressSheetID) {
		System.out.println("!!!!!!!!!1");
		ExpressSheet expressSheet = new ExpressSheet();
		// TransHistory transHistory = new TransHistory();
		TransPackage transPackage = new TransPackage();
		try {
			transPackage = transPackageDao.get(transPackageID);
			transPackage.setStatus(4);
			transPackageDao.update(transPackage);
			System.out.println("__________________" + transPackage);
			UserInfo uInfo = userInfoDao.findBy("delivePackageID", transPackageID, "UID", true).get(0);
			System.out.println("++++++++++++++++++++++++++++=" + uInfo.getUID());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date = sdf.parse(sdf.format(new Date()));
			expressSheet = expressSheetDao.get(expressSheetID);
			expressSheet.setDeliver(uInfo.getUID() + "");
			expressSheet.setDeliverTime(date);
			expressSheet.setStatus(5);
			expressSheetDao.update(expressSheet);
			// List<TransPackageContent> transPackageContent = new
			// ArrayList<TransPackageContent>();
			TransPackageContent transPackageContent1 = new TransPackageContent();
			TransPackageContent transPackageContent = new TransPackageContent();
			transPackageContent = transPackageContentDao
					.findBy("SN", false, Restrictions.eq("ExpressSheetID", expressSheetID)).get(0);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~``" + transPackageContent);
			/*
			 * UsersPackage usersPackage = new UsersPackage(); usersPackage =
			 * usersPackageDao.findBy("packageID", transPackageContent.getTransPackageID(),
			 * "SN", true) .get(0);
			 */

			// System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<"+transPackageID);
			if (transPackageContent != null) {
				transPackageContent.setStatus(STATUS.STATUS_OUTOF_PACKAGE);
				transPackageContentDao.update(transPackageContent);
				transPackageContent1.setTransPackageID(transPackageID);
				transPackageContent1.setExpressSheetID(expressSheetID);
				transPackageContent1.setStatus(STATUS.STATUS_ACTIVE);
				transPackageContentDao.save(transPackageContent1);
				return 8;
			} else
				return 9;// 扫码扫到了错误的未被正常拆包的快件
		} catch (Exception e) {
			System.out.println(e.getMessage() + "异常");
			return 10;
		}
	}

	@Override
	public Response getTransPackage(String id) {
		TransPackage es = transPackageDao.get(id);
		return Response.ok(es).header("EntityClass", "y5hTransPackage").build();
	}

	@Override
	public Response expressSigned(String transPackageID, String expressSheetID) {
		try {
			// ExpressSheet expressSheet = new ExpressSheet();
			TransPackageContent transPackageContent = transPackageContentDao
					.findBy("SN", true, Restrictions.eq("ExpressSheetID", expressSheetID),
							Restrictions.eq("TransPackageID", transPackageID))
					.get(0);
			transPackageContent.setStatus(STATUS.STATUS_OUTOF_PACKAGE);
			transPackageContentDao.update(transPackageContent);

			TransPackage transPackage = transPackageDao.get(transPackageID);
			transPackage.setStatus(5);
			transPackageDao.update(transPackage);

			ExpressSheet expressSheet = expressSheetDao.get(expressSheetID);
			// System.out.println("?????????????????????????????"+expressSheet);
			expressSheet.setStatus(6);
			// expressSheetDao.update(expressSheet);
			// System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + expressSheet);
			expressSheetDao.update(expressSheet);
			return Response.ok(expressSheet).header("EntityClass", "F_ExpressSheet").build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	public int saveTransHistory(String PackageID, int uFrom, int uTo) {
		TransHistory transHistory = new TransHistory();
		TransPackage transPackage = new TransPackage();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date = sdf.parse(sdf.format(new Date()));
			// System.out.println(date);
			transHistory.setActTime(date);
			transHistory.setUIDFrom(uFrom);
			transHistory.setUIDTo(uTo);
			transPackage = transPackageDao.findBy("ID", PackageID, "ID", true).get(0);
			System.out.println(transPackage);
			transHistory.setPackeg(transPackage);
			transHistoryDao.save(transHistory);
		} catch (Exception e) {
			return 1;// 异常
		}
		return 0;// 正常存入
	}

	public int setPackageRoute(String PackageID, double x, double y) {

		PackageRoute pRoute = new PackageRoute();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date tm = new Date();
		try {
			tm = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e1) {
			e1.printStackTrace();
			return 1;// 异常
		}

		pRoute.setPackageID(PackageID);
		pRoute.setX(x);
		pRoute.setY(y);
		pRoute.setTm(tm);
		packageRouteDao.save(pRoute);

		return 0;
	}

}