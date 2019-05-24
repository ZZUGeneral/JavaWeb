package ts.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import ts.daoBase.BaseDao;
import ts.model.Region;
import ts.model.TransPackage;
import ts.model.UsersPackage;

public class UsersPackageDao extends BaseDao<UsersPackage, Integer> {
	public UsersPackageDao(){
		super(UsersPackage.class);
	}
	
	public List<UsersPackage> getTransPackageList(int userUID){
		List<UsersPackage> list = new ArrayList<>();
		list = findBy("SN", true,Restrictions.eq("userUID", userUID));
		if(list.isEmpty()){
			return null;
		}else{
			return list;
		}	
	}
}
