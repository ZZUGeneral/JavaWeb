package ts.daoImpl;

import org.hibernate.criterion.Restrictions;

import ts.daoBase.BaseDao;
import ts.model.UserInfo;

import java.util.List;


public class UserInfoDao extends BaseDao<UserInfo, Integer> {
	public UserInfoDao(){
		super(UserInfo.class);
	}
	public UserInfo checkLogin(int uid, String pwd){
		List<UserInfo> userInfo = findBy("UID", true,
				Restrictions.eq("UID", uid),
				Restrictions.eq("PWD", pwd));
		if(userInfo.isEmpty()){
			return new UserInfo();
		}else{
			return userInfo.get(0);
		}
	}
}
