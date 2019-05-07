package ts.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.criterion.Restrictions;

import ts.daoImpl.CustomerInfoDao;
import ts.daoImpl.ExpressSheetDao;
import ts.daoImpl.PackageRouteDao;
import ts.daoImpl.RegionDao;
import ts.daoImpl.TransHistoryDao;
import ts.daoImpl.TransNodeDao;
import ts.daoImpl.TransPackageContentDao;
import ts.daoImpl.UserInfoDao;
import ts.model.CodeNamePair;
import ts.model.CustomerInfo;
import ts.model.ExpressSheet;
import ts.model.PackageRoute;
import ts.model.Region;
import ts.model.TransHistory;
import ts.model.TransNode;
import ts.model.TransPackageContent;
import ts.model.UserInfo;
import ts.model.TransPackageContent.STATUS;
import ts.serviceInterface.IMiscService;

public class MiscService implements IMiscService{
	//TransNodeCatalog nodes;	//鑷繁鍋氱殑缂撳瓨鍜岄噸瀹氬悜鍏堜笉瑕佷簡,鐢℉ibernate缂撳瓨瀵逛粯涓�涓嬶紝浠ュ悗鍔犱笂鍘�
	//RegionCatalog regions;
	private TransNodeDao transNodeDao;
	private RegionDao regionDao;
	private CustomerInfoDao customerInfoDao;
	private UserInfoDao userInfoDao;
	private PackageRouteDao packageRouteDao;
	private ExpressSheetDao expressSheetDao;
	private TransPackageContentDao transPackageContentDao;
	private TransHistoryDao transHistoryDao;
	
	public void setExpressSheetDao(ExpressSheetDao expressSheetDao) {
		this.expressSheetDao = expressSheetDao;
	}
	
	public TransHistoryDao getTransHistoryDao() {
		return transHistoryDao;
	}

	public void setTransHistoryDao(TransHistoryDao transHistoryDao) {
		this.transHistoryDao = transHistoryDao;
	}

	public void setTransPackageContentDao(TransPackageContentDao transPackageContentDao) {
		this.transPackageContentDao = transPackageContentDao;
	}

	public PackageRouteDao getPackageRouteDao() {
		return packageRouteDao;
	}
	
	public void setPackageRouteDao(PackageRouteDao dao) {
		this.packageRouteDao = dao;
	}
	
	public TransPackageContentDao getTransPackageContentDao() {
		return transPackageContentDao;
	}
	
	public ExpressSheetDao getExpressSheetDao() {
		return expressSheetDao;
	}

	public TransNodeDao getTransNodeDao() {
		return transNodeDao;
	}

	public void setTransNodeDao(TransNodeDao dao) {
		this.transNodeDao = dao;
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

	public void setRegionDao(RegionDao dao) {
		this.regionDao = dao;
	}

	public CustomerInfoDao getCustomerInfoDao() {
		return customerInfoDao;
	}

	public void setCustomerInfoDao(CustomerInfoDao dao) {
		this.customerInfoDao = dao;
	}

	public MiscService(){
//		nodes = new TransNodeCatalog();
//		nodes.Load();
//		regions = new RegionCatalog();
//		regions.Load();
	}

	@Override
	public Response getNode(String ID) {
		TransNode transNode = transNodeDao.get(ID);
		return Response.ok(transNode).header("EntityClass", "TransNode").build();
	}

	@Override
	public List<TransNode> getNodesList(String regionCode, int type) {
		List<TransNode> transNode = transNodeDao.findByRegionCodeAndType(regionCode, type);
		return transNode;
	}

	@Override
	public List<CustomerInfo> getCustomerListByName(String name) {
//		List<CustomerInfo> listci = customerInfoDao.findByName(name);
//		List<CodeNamePair> listCN = new ArrayList<CodeNamePair>();
//		for(CustomerInfo ci : listci){
//			CodeNamePair cn = new CodeNamePair(String.valueOf(ci.getID()),ci.getName());
//			listCN.add(cn);
//		}
//		return listCN;
		return customerInfoDao.findByName(name);
	}

	@Override
	public List<CustomerInfo> getCustomerListByTelCode(String TelCode) {
//		List<CustomerInfo> listci = customerInfoDao.findByTelCode(TelCode);
//		List<CodeNamePair> listCN = new ArrayList<CodeNamePair>();
//		for(CustomerInfo ci : listci){
//			CodeNamePair cn = new CodeNamePair(String.valueOf(ci.getID()),ci.getName());
//			listCN.add(cn);
//		}
//		return listCN;
		return customerInfoDao.findByTelCode(TelCode);
	}

	@Override
	public Response getCustomerInfo(String id) {
		CustomerInfo cstm = customerInfoDao.get(Integer.parseInt(id));
//		try{
//			cstm.setRegionString(regionDao.getRegionNameByID(cstm.getRegionCode()));	//杩欓儴鍒嗗姛鑳芥斁鍒癉AO閲屽幓浜�
//		}catch(Exception e){}
		return Response.ok(cstm).header("EntityClass", "CustomerInfo").build(); 
	}
	
	@Override
	public Response deleteCustomerInfo(int id) {
		customerInfoDao.removeById(id);
		return Response.ok("Deleted").header("EntityClass", "D_CustomerInfo").build(); 
	}

	@Override
	public Response saveCustomerInfo(CustomerInfo obj) {
		try{
			customerInfoDao.save(obj);			
			return Response.ok(obj).header("EntityClass", "R_CustomerInfo").build(); 
		}
		catch(Exception e)
		{
			return Response.serverError().entity(e.getMessage()).build(); 
		}
	}

	@Override
	public List<CodeNamePair> getProvinceList() {		
		List<Region> listrg = regionDao.getProvinceList();
		List<CodeNamePair> listCN = new ArrayList<CodeNamePair>();
		for(Region rg : listrg){
			CodeNamePair cn = new CodeNamePair(rg.getORMID(),rg.getPrv());
			listCN.add(cn);
		}
		return listCN;
	}

	@Override
	public List<CodeNamePair> getCityList(String prv) {
		List<Region> listrg = regionDao.getCityList(prv);
		List<CodeNamePair> listCN = new ArrayList<CodeNamePair>();
		for(Region rg : listrg){
			CodeNamePair cn = new CodeNamePair(rg.getORMID(),rg.getCty());
			listCN.add(cn);
		}
		return listCN;
	}

	@Override
	public List<CodeNamePair> getTownList(String city) {
		List<Region> listrg = regionDao.getTownList(city);
		List<CodeNamePair> listCN = new ArrayList<CodeNamePair>();
		for(Region rg : listrg){
			CodeNamePair cn = new CodeNamePair(rg.getORMID(),rg.getTwn());
			listCN.add(cn);
		}
		return listCN;
	}

	@Override
	public String getRegionString(String code) {
		return regionDao.getRegionNameByID(code);
	}

	@Override
	public Region getRegion(String code) {
		return regionDao.getFullNameRegionByID(code);
	}
	

	@Override
	public void CreateWorkSession(int uid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RefreshSessionList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int doLogin(int uid, String pwd) {
		UserInfo userInfo = userInfoDao.checkLogin(uid, pwd);
		System.out.println(userInfo);
		if(userInfo == null){
			return 0;
		}else{
			return 1;
		}
	}

	@Override
	public TransNode getNodeByTel(String telCode) {
		List<TransNode> list = new ArrayList<TransNode>();
		list = transNodeDao.findBy("TelCode", telCode, "ID", true);
		TransNode transNode = new TransNode();
		if (list.isEmpty()) {
			return null;
		}else{
			transNode = list.get(0);
			return transNode;
		}
	}

	@Override
	public List<TransNode> getNodeByRegionCode(String RegionCode) {
		List<TransNode> list = new ArrayList<TransNode>();
		list = transNodeDao.findByRegionCode(RegionCode);
		return list;
	}

	@Override
	public Response savePackageRoute(PackageRoute obj) {
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			Date date = sdf.parse(sdf.format(new Date()));
			obj.setTm(date);
			System.out.println(obj);
			packageRouteDao.save(obj);
			return Response.ok(obj).header("EntityClass", "PackageRoute").build();
		}catch(Exception e){
			return Response.serverError().entity(e.getMessage()).build(); 
		}
	}

	@Override
	//快件路径
	public List<PackageRoute> getPackageRouteList(String expressSheetID) {
		List<PackageRoute> packageRoutes = new ArrayList<PackageRoute>();
		packageRoutes = packageRouteDao.getPackageRouteList(expressSheetID);
		return packageRoutes;
	}
	
	@Override
	//指派转运员：将哪个包裹从哪个网点交给哪个转运员,记录转运历史
	public String appointTransPorter(String packageID, int nodeUID, int userUID) {
		String result = " ";
		result = transHistoryDao.appointTransPorter(packageID, nodeUID, userUID);
		return result;
	}
	
	@Override
	public Response appointDeliver(String transPackageID, String expressSheetID) {
		return transHistoryDao.appointDeliver(transPackageID, expressSheetID);
	}

	@Override
	public List<TransHistory> getTransHistory(String expressSheetID) {
		return transHistoryDao.getTransHistory(expressSheetID);
	}

	
	@Override
	public Response changeUserInfo(int userUID,UserInfo obj) {
		try{
			List<UserInfo> list = new ArrayList<UserInfo>();
			list = userInfoDao.findBy("UID", obj.getUID(), "UID", true);
			if(list.isEmpty()){
				userInfoDao.save(obj);
				return Response.ok(obj).header("EntityClass", "UserInfo").build();
			}else{
				userInfoDao.update(obj);
				return Response.ok(obj).header("EntityClass", "E_UserInfo").build();
			}
		}		
		catch(Exception e)
		{
			return Response.serverError().entity(e.getMessage()).build(); 
		}
	}
	
}				
						


