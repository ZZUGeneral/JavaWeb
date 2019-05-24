package ts.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.criterion.Restrictions;

import ts.daoBase.BaseDao;
import ts.model.CustomerInfo;

public class CustomerInfoDao extends BaseDao<CustomerInfo, Integer>{
	private RegionDao regionDao;

    public RegionDao getRegionDao() {
		return regionDao;
	}

	public void setRegionDao(RegionDao dao) {
		this.regionDao = dao;
	}
	
	public CustomerInfoDao(){
		super(CustomerInfo.class);
	}
	
	public CustomerInfo get(int id) {
		CustomerInfo ci = super.get(id);
		ci.setRegionString(regionDao.getRegionNameByID(ci.getRegionCode()));	//获取区域的名字字符串
		return ci;
	}

	public List<CustomerInfo> findByName(String name) {
		return findLike("name", name+"%", "TelCode", true);
	}

	public List<CustomerInfo> findByTelCode(String telCode) {
		return findBy("TelCode", telCode, "TelCode", true);
	}
	
	public int findByPropertyWithoutID(CustomerInfo customerInfo){
		List<CustomerInfo> customer = new ArrayList<CustomerInfo>();
		customer = findBy("TelCode", true
                ,Restrictions.eq("TelCode", customerInfo.getTelCode())
				,Restrictions.eq("address", customerInfo.getAddress())
				,Restrictions.eq("name", customerInfo.getName())
				,Restrictions.eq("department", customerInfo.getDepartment())
				,Restrictions.eq("postCode", customerInfo.getPostCode())
				,Restrictions.eq("regionCode",customerInfo.getRegionCode()));
		System.out.println(customer);
		if(customer.isEmpty()){
			return -1;
		}else{
			return customer.get(0).getID();
		}
		
		
	}
	
}
