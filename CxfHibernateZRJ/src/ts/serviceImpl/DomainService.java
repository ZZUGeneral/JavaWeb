package ts.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import org.hibernate.criterion.Restrictions;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import javassist.compiler.ast.Expr;
import ts.daoImpl.CustomerInfoDao;
import ts.daoImpl.ExpressSheetDao;
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

	@Override
	public List<ExpressSheet> getExpressList(String property,
			String restrictions, String value) {
		List<ExpressSheet> list = new ArrayList<ExpressSheet>();
		switch(restrictions.toLowerCase()){
		case "eq":
			list = expressSheetDao.findBy(property, value, "ID", true);
			break;
		case "like":
			list = expressSheetDao.findLike(property, value+"%", "ID", true);
			break;
		}
		return list;
	}
//	@Override
//	public List<ExpressSheet> getExpressList(String property,
//			String restrictions, String value) {
//		Criterion cr1;
//		Criterion cr2 = Restrictions.eq("Status", 0);
//
//		List<ExpressSheet> list = new ArrayList<ExpressSheet>();
//		switch(restrictions.toLowerCase()){
//		case "eq":
//			cr1 = Restrictions.eq(property, value);
//			break;
//		case "like":
//			cr1 = Restrictions.like(property, value);
//			break;
//		default:
//			cr1 = Restrictions.like(property, value);
//			break;
//		}
//		list = expressSheetDao.findBy("ID", true,cr1,cr2);		
//		return list;
//	}

	@Override
	public List<ExpressSheet> getExpressListInPackage(String packageId){
		List<ExpressSheet> list = new ArrayList<ExpressSheet>();
		list = expressSheetDao.getListInPackage(packageId);
		return list;		
	}

	@Override
	public Response getExpressSheet(String id) {
		ExpressSheet es = expressSheetDao.get(id);
		return Response.ok(es).header("EntityClass", "ExpressSheet").build(); 
	}

	@Override
	public Response newExpressSheet(String id, int uid) {

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date tm = new Date();
		try {
			tm= sdf.parse(sdf.format(new Date()));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		ExpressSheet es = null;
		try{
			es = expressSheetDao.get(id);
		} catch (Exception e1) {}

		if(es != null){
//			if(es.getStatus() != 0)
//				return Response.ok(es).header("EntityClass", "L_ExpressSheet").build(); //宸茬粡瀛樺湪,涓斾笉鑳芥洿鏀�
//			else
				return Response.ok(es).header("EntityClass", "E_ExpressSheet").build(); //宸茬粡瀛樺湪
		}
		try{
			String pkgId = userInfoDao.get(uid).getReceivePackageID();
			ExpressSheet nes = new ExpressSheet();
			nes.setID(id);
			nes.setType(0);
			nes.setAccepter(String.valueOf(uid));
			nes.setAccepteTime(tm);
			nes.setStatus(ExpressSheet.STATUS.STATUS_CREATED);
			expressSheetDao.save(nes);
			TransPackageContent pkg_add = new TransPackageContent();
			pkg_add.setTransPackageID(pkgId);
			pkg_add.setExpressSheetID(id);
			pkg_add.setStatus(STATUS.STATUS_ACTIVE);
			transPackageContentDao.save(pkg_add); 
			return Response.ok(nes).header("EntityClass", "ExpressSheet").build(); 
		}
		catch(Exception e)
		{
			return Response.serverError().entity(e.getMessage()).build(); 
		}
	}

	@Override
	public Response saveExpressSheet(ExpressSheet obj) {
		try{
			expressSheetDao.update(obj);			
			return Response.ok(obj).header("EntityClass", "R_ExpressSheet").build(); 
		}
		catch(Exception e)
		{
			return Response.serverError().entity(e.getMessage()).build(); 
		}
	}
	@Override
	public Response updateExpressSheet(String id,ExpressSheet obj) {
		try{
			expressSheetDao.save(obj);	
			String expressSheetID = obj.getID();
			List<TransPackageContent> list = new ArrayList<TransPackageContent>();
			list = transPackageContentDao.findBy("ExpressSheetID",id,"SN",true);
			for(TransPackageContent transPackageContent : list){
				
				transPackageContent.setExpressSheetID(expressSheetID);
				transPackageContentDao.update(transPackageContent);;
			}
			expressSheetDao.removeById(id);
			return Response.ok(obj).header("EntityClass", "R_ExpressSheet").build(); 
		}
		catch(Exception e)
		{
			return Response.serverError().entity(e.getMessage()).build(); 
		}
	}

	@Override
	public Response ReceiveExpressSheetId(String id, int uid) {
		try{
			ExpressSheet nes = expressSheetDao.get(id);
			nes.setAccepter(String.valueOf(uid));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date = sdf.parse(sdf.format(new Date()));
			nes.setAccepteTime(date);
			nes.setStatus(ExpressSheet.STATUS.STATUS_RECEIVED);
			expressSheetDao.save(nes);
			//TransPackage tp = new TransPackage();
			//nes = expressSheetDao.get(id);
			
			//transPackageDao.save(tp);
			return Response.ok(nes).header("EntityClass", "ExpressSheet").build(); 
		}
		catch(Exception e)
		{
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
		try{
			ExpressSheet nes = expressSheetDao.get(id);
			nes.setDeliver(String.valueOf(uid));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date = sdf.parse(sdf.format(new Date()));
			nes.setDeliveTime(date);
			nes.setStatus(ExpressSheet.STATUS.STATUS_DELIVERIED);
			expressSheetDao.save(nes);
			transPackageContent = transPackageContentDao.findBy("SN", true,Restrictions.eq("ExpressSheetID", id),
					Restrictions.eq("status", STATUS.STATUS_ACTIVE)).get(0);
			transPackageContent.setStatus(STATUS.STATUS_OUTOF_PACKAGE);
			transPackageContentDao.update(transPackageContent);
			
			//TransPackage tp = new TransPackage();
			//nes = expressSheetDao.get(id);
			
			//transPackageDao.save(tp);
			return Response.ok(nes).header("EntityClass", "ExpressSheet").build(); 
		}
		catch(Exception e)
		{
			return Response.serverError().entity(e.getMessage()).build(); 
		}
	}

	@Override
	public List<TransPackage> getTransPackageList(String property,
			String restrictions, String value) {
		List<TransPackage> list = new ArrayList<TransPackage>();
		switch(restrictions.toLowerCase()){
		case "eq":
			list = transPackageDao.findBy(property, value, "ID", true);
			break;
		case "like":
			list = transPackageDao.findLike(property, value+"%", "ID", true);
			break;
		}
		return list;
	}

	@Override
	public Response getTransPackage(String id) {
		TransPackage es = transPackageDao.get(id);
		return Response.ok(es).header("EntityClass", "TransPackage").build(); 
	}


	@Override
	public Response saveTransPackage(TransPackage obj) {
		try{
			transPackageDao.save(obj);			
			return Response.ok(obj).header("EntityClass", "R_TransPackage").build(); 
		}
		catch(Exception e)
		{
			return Response.serverError().entity(e.getMessage()).build(); 
		}
	}

	@Override
	public Response createExpressSheet(ExpressSheet expressSheet) {
		//List<CustomerInfo> customerInfoSnd = new ArrayList<CustomerInfo>();
		//List<CustomerInfo> customerInfoRcv = new ArrayList<CustomerInfo>();
        //System.out.println(expressSheet.getSender());
		System.out.println(expressSheet.getRecever());
		System.out.println(expressSheet.getSender());
        CustomerInfo snd = expressSheet.getSender();
        CustomerInfo rcv = expressSheet.getRecever();

		int customerInfoSndID = customerInfoDao.findByPropertyWithoutID(snd);
		int customerInfoRcvID = customerInfoDao.findByPropertyWithoutID(rcv);

		if(customerInfoSndID == -1){
			customerInfoDao.save(snd);
			customerInfoSndID = snd.getID();
		}
		if(customerInfoRcvID == -1){
			customerInfoDao.save(rcv);
			customerInfoRcvID = rcv.getID();
		}

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        Date tm = new Date();
        try {
            tm= sdf.parse(sdf.format(new Date()));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        String s = sdf.format(tm);
		try{
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
			pkg_add.setStatus(STATUS.STATUS_ACTIVE);;
            System.out.println(pkg_add);
			transPackageContentDao.save(pkg_add);
            System.out.println(3);
			return Response.ok(id).header("EntityClass", "id").build();
		}
		catch(Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@Override
	public Response doLogin(int uid, String pwd) {
		try{
			System.out.println("1");
			UserInfo userInfo = userInfoDao.checkLogin(uid, pwd);
			System.out.println(userInfo);
			return Response.ok(userInfo).header("EntityClass", "UserInfo").build();
		}
		catch(Exception e)
		{
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@Override
	public List<TransPackage> getUsersPackage(int userUID) {
		List<UsersPackage> usersPackageList = new ArrayList<>();
		usersPackageList = usersPackageDao.getTransPackageList(userUID);
		List<TransPackage> transPackageList  = new ArrayList<>();
		for(int i = 0; i < usersPackageList.size();i++){
			TransPackage transPackage = transPackageDao.findBy("ID", 
					usersPackageList.get(i).getPackageID(), "ID", true).get(0);
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
		for(int i = 0; i < customerInfos.size();i++){
			expressSheets = expressSheetDao.findBy("Sender", 
					customerInfos.get(i), "ID", true);
			System.out.println(expressSheets);
			for(int j = 0; j < expressSheets.size();j++){
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
		for(int i = 0; i < customerInfos.size();i++){
			expressSheets = expressSheetDao.findBy("Recever", 
					customerInfos.get(i), "ID", true);
			for(int j = 0; j < expressSheets.size();j++){
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
		try{
			transPackages = transPackageDao.findBy("ID", obj.getID(), "ID", true);
			if(!transPackages.isEmpty()){
				return Response.ok(obj).header("EntityClass", "E_TransPackage").build();
			}else{
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                Date tm = new Date();
                try {
                    tm= sdf.parse(sdf.format(new Date()));
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
		}catch(Exception e){
			return Response.serverError().entity(e.getMessage()).build(); 
		}
	}
	
	@Override
	public int openTransPackage(int uid, String id) {
		List<UserInfo> userInfos = new ArrayList<>();
		List<TransPackageContent> transPackageContents = new ArrayList<>();
		UserInfo userInfo = new UserInfo();
		TransPackageContent transPackageContent = new TransPackageContent();
		userInfos = userInfoDao.findBy("UID", uid, "UID", true);
		/*//传入用户UID不存在 返回1
		if(userInfos.isEmpty()){
			return 1;
		}*/
		userInfo = userInfos.get(0);
		System.out.println(userInfo);
		transPackageContents = transPackageContentDao.findBy("TransPackageID", id, "SN", true);
		//传入包裹ID不存在 返回2		
		if(transPackageContents.isEmpty()){
			return 2;
		}
		
		TransPackage transPackage = new TransPackage();
		transPackage = transPackageDao.get(id);
		System.out.println(transPackage);
		if(transPackage.getStatus() == 0){
			return 1;
		}
		transPackage.setStatus(0);
		transPackageDao.save(transPackage);
		System.out.println(transPackageContents);
		for(int i = 0; i < transPackageContents.size(); i++){
			transPackageContent = transPackageContents.get(i);
			if(transPackageContent.getStatus() == 1) continue;
			
			transPackageContent.setStatus(STATUS.STATUS_OUTOF_PACKAGE);
			transPackageContentDao.update(transPackageContent);
			
			TransPackageContent tpc = new TransPackageContent();
			tpc.setExpressSheetID(transPackageContent.getExpressSheetID());
			tpc.setTransPackageID(userInfo.getReceivePackageID());
			tpc.setStatus(STATUS.STATUS_ACTIVE);
			System.out.println(tpc);
			transPackageContentDao.save(tpc);
		}
		return 0;
	}


	@Override
	public List<UserInfo> getUserList(String property,
			String restrictions, String value) {
		List<UserInfo> list = new ArrayList<UserInfo>();
		int intValue;
		if(property.equals("UID")||property.equals("URull")||property.equals("Status")){
			intValue = Integer.parseInt(value);
			switch(restrictions.toLowerCase()){
			case "eq":
				list = userInfoDao.findBy(property, intValue, "UID", true);
				break;
			case "like":
				list = userInfoDao.findLike(property, intValue+"%", "UID", true);
				break;
			}
		}else{
			switch(restrictions.toLowerCase()){
			case "eq":
				list = userInfoDao.findBy(property, value, "UID", true);
				break;
			case "like":
				list = userInfoDao.findLike(property, value+"%", "UID", true);
				break;
			}
		}		
		return list;
	}



	@Override
	public Response packTransPackage(String transPackageID, String expressSheetID) {
		try{
			ExpressSheet expressSheet = new ExpressSheet();
			expressSheet = expressSheetDao.findBy("ID", expressSheetID, "ID", true).get(0);
			TransPackageContent transPackageContent = new TransPackageContent();
			TransPackageContent transPackageContent1 = new TransPackageContent();
			transPackageContent = transPackageContentDao.findBy("SN", true,Restrictions.eq("ExpressSheetID", expressSheetID),
																Restrictions.eq("status", STATUS.STATUS_ACTIVE)).get(0);
			if(transPackageContent!=null){
				//状态
				expressSheet.setStatus(2);
				expressSheetDao.update(expressSheet);
				transPackageContent.setStatus(STATUS.STATUS_OUTOF_PACKAGE);
				transPackageContentDao.update(transPackageContent);
				transPackageContent1.setTransPackageID(transPackageID);
				transPackageContent1.setExpressSheetID(expressSheetID);
				transPackageContent1.setStatus(STATUS.STATUS_ACTIVE);
				transPackageContentDao.save(transPackageContent1);
				return Response.ok(transPackageContent).header("EntityClass", "TransPackageContent").build();
			}else{
				return Response.ok(expressSheet).header("EntityClass", "ExpressSheet").build();
			}
		}catch(Exception e)
		{
			return Response.serverError().entity(e.getMessage()).build(); 
		}
	}	


}
