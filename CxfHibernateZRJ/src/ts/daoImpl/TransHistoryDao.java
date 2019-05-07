package ts.daoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.hibernate.criterion.Restrictions;

import ts.daoBase.BaseDao;
import ts.model.CustomerInfo;
import ts.model.ExpressSheet;
import ts.model.TransHistory;
import ts.model.TransPackage;
import ts.model.TransPackageContent;
import ts.model.UserInfo;
import ts.model.UsersPackage;
import ts.model.TransPackageContent.STATUS;

public class TransHistoryDao extends BaseDao<TransHistory,Integer> {
	private UsersPackageDao usersPackageDao;
	private TransPackageDao transPackageDao;
	private TransPackageContentDao transPackageContentDao;
	private ExpressSheetDao expressSheetDao;
	private CustomerInfoDao customerInfoDao;
	private UserInfoDao userInfoDao;
	private RegionDao regionDao;
	
	
	public TransPackageContentDao getTransPackageContentDao() {
		return transPackageContentDao;
	}
	public void setTransPackageContentDao(TransPackageContentDao transPackageContentDao) {
		this.transPackageContentDao = transPackageContentDao;
	}
	public ExpressSheetDao getExpressSheetDao() {
		return expressSheetDao;
	}
	public void setExpressSheetDao(ExpressSheetDao expressSheetDao) {
		this.expressSheetDao = expressSheetDao;
	}
	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}
	public void setCustomerInfoDao(CustomerInfoDao customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
	public RegionDao getRegionDao() {
		return regionDao;
	}
	public void setRegionDao(RegionDao regionDao) {
		this.regionDao = regionDao;
	}
	public UsersPackageDao getUsersPackageDao() {
		return usersPackageDao;
	}
	public void setUsersPackageDao(UsersPackageDao usersPackageDao) {
		this.usersPackageDao = usersPackageDao;
	}
	public TransPackageDao getTransPackageDao() {
		return transPackageDao;
	}
	public void setTransPackageDao(TransPackageDao transPackageDao) {
		this.transPackageDao = transPackageDao;
	}
	public TransHistoryDao(){
		super(TransHistory.class);
	}	
	//指派转运员：将哪个包裹从哪个网点交给哪个转运员,记录转运历史
	public String appointTransPorter(String packageID, int nodeUID, int userUID) {
		UsersPackage usersPackage = new UsersPackage();
		TransHistory transHistory = new TransHistory();
		TransPackage transPackage = new TransPackage();
		List<TransPackageContent> transPackageContents = new ArrayList<TransPackageContent>();
		UserInfo userInfo = new UserInfo();
		List<UsersPackage> usersPackages = new ArrayList<UsersPackage>();
		usersPackages = usersPackageDao.findBy("packageID", packageID, "SN", true);
		transPackageContents = transPackageContentDao.findBy("SN", true,Restrictions.eq("TransPackageID", packageID),
				Restrictions.eq("status", STATUS.STATUS_ACTIVE));
		
		if (usersPackages.isEmpty()) {
			return "Unavaliable packageID";
		}else{
			for(int i = 0; i < transPackageContents.size(); i++){
				ExpressSheet expressSheet = new ExpressSheet();
				expressSheet = expressSheetDao.get(transPackageContents.get(i).getExpressSheetID());
				expressSheet.setStatus(3);
				expressSheetDao.update(expressSheet);
			}
			userInfo = userInfoDao.get(userUID);
			userInfo.setTransPackageID(packageID);
			userInfoDao.update(userInfo);
			
			usersPackage = usersPackages.get(0);
			usersPackageDao.remove(usersPackage);
			usersPackage.setUserUID(userUID);
			usersPackage.setSN(0);
			usersPackageDao.save(usersPackage);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date;
			try {
				date = sdf.parse(sdf.format(new Date()));
				transHistory.setActTime(date);
				transHistory.setUIDFrom(nodeUID);
				transHistory.setUIDTo(userUID);
				transPackage = transPackageDao.findBy("ID", packageID, "ID", true).get(0);
				System.out.println(transPackage);
				transHistory.setPackeg(transPackage);
				save(transHistory);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Success";
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TransHistory> getTransHistory(String expressSheetID) {
		List<TransPackageContent> transPackageContents = new ArrayList<TransPackageContent>();
//		List<Map<String, Object>> transHistories = new ArrayList<Map<String, Object>>();
		List<TransHistory> histories = new ArrayList<TransHistory>();
		List<TransHistory> transHistories2 = new ArrayList<TransHistory>();
		TransHistory transHistory = new TransHistory();
		ExpressSheet expressSheet = new ExpressSheet();
		CustomerInfo customerInfo = new CustomerInfo();
//		String dpID;
//		String addressFrom;
//		String addressTo;
		
		transPackageContents = transPackageContentDao.findBy("ExpressSheetID", expressSheetID, "SN", true);
		System.out.println(transPackageContents);
		expressSheet = expressSheetDao.get(expressSheetID);
		customerInfo = customerInfoDao.get(expressSheet.getSender().getID());
		if(transPackageContents == null){
//			Map firstLine = new HashMap<String, Object>();
//			firstLine.put("ActTime", expressSheetDao.get(expressSheetID).getAccepteTime());
//			firstLine.put("UIDFrom", customerInfo.getAddress());
//			firstLine.put("UIDTo", "就近的网点");
//			transHistories.add(firstLine);
//			return transHistories;
//			transHistory.setActTime(dateToTime(expressSheetDao.get(expressSheetID).getAccepteTime()));
//			transHistory.setUIDFrom(customerInfo.getAddress());
			
			return null;
		}		
//		Map firstLine = new HashMap<String, Object>();
//		firstLine.put("ActTime", expressSheetDao.get(expressSheetID).getAccepteTime());
//		firstLine.put("UIDFrom", customerInfo.getAddress());
//		System.out.println(transPackageContents.get(0).getTransPackageID());
//		transHistories2 = findBy("packeg",transPackageDao.findBy("ID", transPackageContents.get(0).getTransPackageID(), "ID", true).get(0) , "SN", true);
//		System.out.println(transHistories2);
//		transHistory = transHistories2.get(0);
//		System.out.println("2"+transHistory);
//		dpID = userInfoDao.findBy("UID", transHistory.getUIDFrom(), "UID", true).get(0).getDptID();
//		System.out.println("3"+dpID);
//		firstLine.put("UIDTo", regionDao.getRegionNameByID(dpID.substring(0, 6)));
//		System.out.println("4"+firstLine);
//		transHistories.add(firstLine);		
		//System.out.println(transPackageContents);
		
		TransPackage tp = new TransPackage();
		StringBuffer detailAddr = new StringBuffer();
		detailAddr.append(regionDao.getRegionNameByID(expressSheet.getSender().getRegionCode()));
		detailAddr.append(" ");
		detailAddr.append(expressSheet.getSender().getDepartment()).append(" ");
		detailAddr.append(expressSheet.getSender().getAddress());
		tp.setSourceNode(detailAddr.toString());
		UserInfo userInfo = userInfoDao.get(Integer.valueOf(expressSheet.getAccepter()));
		tp.setTargetNode(userInfo.getName());
		
		TransHistory th1 = new TransHistory();
		th1.setActTime(expressSheet.getAccepteTime());
		th1.setPackeg(tp);
		histories.add(th1);
		for(int i = 0; i < transPackageContents.size();i++){
//			Map map = new HashMap<String, Object>();
			transHistories2 = findBy("packeg",transPackageDao.findBy("ID", transPackageContents.get(i).getTransPackageID(), "ID", true).get(0) , "SN", true);
//			map.put("ActTime", transHistory.getActTime());
//			dpID = userInfoDao.findBy("UID", transHistory.getUIDFrom(), "UID", true).get(0).getDptID();
//			addressFrom = regionDao.getRegionNameByID(dpID.substring(0, 6));
//			dpID = userInfoDao.findBy("UID", transHistory.getUIDTo(), "UID", true).get(0).getDptID();
//			addressTo = regionDao.getRegionNameByID(dpID.substring(0, 6));
//			map.put("UIDFrom", addressFrom);
//			map.put("UIDTo", addressTo);
			for(int j = 0; j < transHistories2.size(); j++){
				TransHistory th = transHistories2.get(j);
				if(th.getActTime().before(expressSheet.getAccepteTime())) continue;
				if(expressSheet.getDeliveTime() != null){
					if(th.getActTime().after(expressSheet.getDeliveTime())) continue;
				}
				histories.add(transHistories2.get(j));
			}
		}
		
		if(expressSheet.getDeliveTime() != null) {
			tp = new TransPackage();
			detailAddr = new StringBuffer();
			detailAddr.append(regionDao.getRegionNameByID(expressSheet.getRecever().getRegionCode()));
			detailAddr.append(" ");
			detailAddr.append(expressSheet.getRecever().getDepartment()).append(" ");
			detailAddr.append(expressSheet.getRecever().getAddress());
			tp.setSourceNode(detailAddr.toString());
			tp.setStatus(-1); //-1表示最后一条
			userInfo = userInfoDao.get(Integer.valueOf(expressSheet.getDeliver()));
			tp.setTargetNode(userInfo.getName());
			th1 = new TransHistory();
			th1.setActTime(expressSheet.getDeliveTime());
			th1.setPackeg(tp);
			histories.add(th1);
		}
		
		int n = histories.size();
		for(int i = 0; i < n; i++){
			for(int j = i + 1; j < n; j++){
				if(histories.get(i).getActTime().before(histories.get(j).getActTime())){
					TransHistory th = histories.get(i);
					histories.set(i,histories.get(j));
					histories.set(j,th);
				}
			}
		}
		
//		System.out.println(transHistories);
		//插入最后一条
		return histories;
	}
	
	@SuppressWarnings("unused")
	public Response appointDeliver(String transPackageID, String expressSheetID) {
		ExpressSheet expressSheet = new ExpressSheet();
		TransHistory transHistory = new TransHistory();
		TransPackage transPackage = new TransPackage();
		try{
			expressSheet = expressSheetDao.get(expressSheetID);
			expressSheet.setStatus(4);
			expressSheetDao.update(expressSheet);
			TransPackageContent transPackageContent = new TransPackageContent();
			TransPackageContent transPackageContent1 = new TransPackageContent();
			transPackageContent = transPackageContentDao.findBy("SN", true,Restrictions.eq("ExpressSheetID", expressSheetID),
																Restrictions.eq("status", STATUS.STATUS_ACTIVE)).get(0);
			UsersPackage usersPackage = new UsersPackage();
			usersPackage = usersPackageDao.findBy("packageID", transPackageContent.getTransPackageID(), "SN", true).get(0);

			if(transPackageContent!=null){
				transPackageContent.setStatus(STATUS.STATUS_OUTOF_PACKAGE);
				transPackageContentDao.update(transPackageContent);
				transPackageContent1.setTransPackageID(transPackageID);
				transPackageContent1.setExpressSheetID(expressSheetID);
				transPackageContent1.setStatus(STATUS.STATUS_ACTIVE);
				transPackageContentDao.save(transPackageContent1);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
				Date date = sdf.parse(sdf.format(new Date()));
				//插入一条history 如果UIDTo插入为-1 则表示此为发送往客户
				transHistory.setActTime(date);
				transHistory.setUIDFrom(usersPackage.getUserUID());
				transHistory.setUIDTo(-1);
				System.out.println(transHistory);
				transPackage = transPackageDao.findBy("ID", transPackageID, "ID", true).get(0);
				System.out.println(transPackage);
				transHistory.setPackeg(transPackage);
				//save(transHistory);
				return Response.ok(transPackageContent).header("EntityClass", "TransPackageContent").build();
			}else{
				return Response.ok(expressSheet).header("EntityClass", "ExpressSheet").build();
			}
		}catch(Exception e)
		{
			return Response.serverError().entity(e.getMessage()).build(); 
		}
	}
	
	public static java.sql.Timestamp strToSqlDate(String strDate, String dateFormat) {
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
		java.util.Date date = null;
		try {
			date = sf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Timestamp dateSQL = new java.sql.Timestamp(date.getTime());
		return dateSQL;
	}
	 
	public static java.sql.Timestamp dateToTime(java.util.Date date) {
		String strDate = dateToStr(date, "yyyy-MM-dd HH:mm:ss SSS");
		return strToSqlDate(strDate, "yyyy-MM-dd HH:mm:ss SSS");
	}
	
	public static String dateToStr(java.util.Date date, String strFormat) {
		SimpleDateFormat sf = new SimpleDateFormat(strFormat);
		String str = sf.format(date);
		return str;
	}
}
