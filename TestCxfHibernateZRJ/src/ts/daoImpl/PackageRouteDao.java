package ts.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ts.daoBase.BaseDao;
import ts.model.ExpressSheet;
import ts.model.PackageRoute;
import ts.model.TransPackageContent;

public class PackageRouteDao extends BaseDao<PackageRoute,Integer>{
	private ExpressSheetDao expressSheetDao;
	private TransPackageContentDao transPackageContentDao;
	private TransHistoryDao transHistoryDao;
	TransPackageDao transPackageDao;

	public TransPackageDao getTransPackageDao() {
		return transPackageDao;
	}

	public void setTransPackageDao(TransPackageDao transPackageDao) {
		this.transPackageDao = transPackageDao;
	}

	public ExpressSheetDao getExpressSheetDao() {
		return expressSheetDao;
	}

	public void setExpressSheetDao(ExpressSheetDao expressSheetDao) {
		this.expressSheetDao = expressSheetDao;
	}

	public TransPackageContentDao getTransPackageContentDao() {
		return transPackageContentDao;
	}

	public void setTransPackageContentDao(TransPackageContentDao transPackageContentDao) {
		this.transPackageContentDao = transPackageContentDao;
	}

	public TransHistoryDao getTransHistoryDao() {
		return transHistoryDao;
	}

	public void setTransHistoryDao(TransHistoryDao transHistoryDao) {
		this.transHistoryDao = transHistoryDao;
	}

	public PackageRouteDao() {
		super(PackageRoute.class);
	}
	
	public List<PackageRoute> getPackageRouteList(String expressSheetID) {
		List<TransPackageContent> transPackageContents = new ArrayList<TransPackageContent>();
		List<PackageRoute> packageRoutes = new ArrayList<PackageRoute>();
		//存放符合要求的点
		List<PackageRoute> packageRoutesList = new ArrayList<PackageRoute>();
		ExpressSheet expressSheet = new ExpressSheet();
		expressSheet = expressSheetDao.get(expressSheetID);
		if(expressSheet.getID()==null){
			return null;
		}
		Date acceptTime = new Date();
		Date deliverTime = new Date();
		Date now = new Date();
		acceptTime = expressSheet.getAcceptTime();
		//如果快件接受时间不为空，即快件已被接受，则赋值给deliverTime;否则值为null
		if(expressSheet.getDeliverTime()!=null){
			deliverTime = expressSheet.getDeliverTime();
		}else{
			deliverTime = null;
		}
		//获取该快件存在过的所有包裹对应的TransPackageContent
		System.out.println(expressSheet);
		transPackageContents = transPackageContentDao.findBy("ExpressSheetID", expressSheetID, "SN", true);
		System.out.println(transPackageContents);
		System.out.println("?????????"+transPackageContents.size());
		for(int i = 0; i < transPackageContents.size(); i++){
			//获取其中某个包裹对应的PackageRoute
			System.out.println("!!!!!!!!!!!!!!!"+i);
			packageRoutes =findBy("packageID", transPackageContents.get(i).getTransPackageID(), "tm", true);
			System.out.println(i+" "+packageRoutes);
			//若为空，则下一个
			if(packageRoutes.isEmpty()){
				continue;
			}
			//判断此时deliverTime
			System.out.println("!!"+deliverTime);
			if(deliverTime==null){
				//判断该快件是否只被揽收，还未经过任何拆包打包，若已被网点处理过
				System.out.println("=="+transPackageContents.size());
				if(transPackageContents.size()>2){
					System.out.println("{{{{{{{{{{{{{{{{{{{{["+i);
					//若该包裹是揽收包裹
					if(i == 0){
						/*TransHistory transHistory = new TransHistory();
						System.out.println("==================================");
						transHistory = transHistoryDao.findBy("packeg", 
								transPackageContents.get(0).getTransPackageID(), "SN", true).get(0);
						System.out.println(transHistory);*/
						for(int j = 0; j < packageRoutes.size(); j++){
							if(acceptTime.before(packageRoutes.get(j).getTm())&& 
										now.after(packageRoutes.get(j).getTm())){
								packageRoutesList.add(packageRoutes.get(j));
							}else{
								continue;
							}
						}
					//若该包裹是转运包裹
					}else{
							for(int j = 0; j < packageRoutes.size(); j++){
								if(acceptTime.before(packageRoutes.get(j).getTm()) && 
										now.after(packageRoutes.get(j).getTm())){
									packageRoutesList.add(packageRoutes.get(j));
								}else{
									continue;
								}
							}
					}
				//若该快件仅被揽收
				}else{
					for(int j = 0; j < packageRoutes.size(); j++){
						if(acceptTime.before(packageRoutes.get(j).getTm()) && 
								now.after(packageRoutes.get(j).getTm())){
							packageRoutesList.add(packageRoutes.get(j));
						}else{
							continue;
						}
					}
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~"+packageRoutes.size());
				}
			//若该包裹已被最终送达
			}else{
//				if(i == 0){
//					TransHistory transHistory = new TransHistory();
//
//					transHistory = transHistoryDao.findBy("packeg",
//							transPackageDao.get(transPackageContents.get(0).getTransPackageID()), "SN", true).get(0);
//					for(int j = 0; j < packageRoutes.size(); j++){
//						if(acceptTime.before(packageRoutes.get(j).getTm())&&
//									transHistory.getActTime().after(packageRoutes.get(j).getTm())){
//							packageRoutesList.add(packageRoutes.get(j));
//						}else{
//							continue;
//						}
//					}
//				}else{
						for(int j = 0; j < packageRoutes.size(); j++){
							if(acceptTime.before(packageRoutes.get(j).getTm()) && 
									deliverTime.after(packageRoutes.get(j).getTm())){
								packageRoutesList.add(packageRoutes.get(j));
							}else{
								continue;
							}
						}
			}
		}
		System.out.println("@@@"+packageRoutesList);
		return packageRoutesList;
	}	
}				