package ts.daoImpl;

import ts.daoBase.BaseDao;
import ts.model.UserInfo;

import java.util.List;


public class UserInfoDao extends BaseDao<UserInfo, Integer> {
	public UserInfoDao(){
		super(UserInfo.class);
	}
	public UserInfo checkLogin(int uid, String pwd){
		List<UserInfo> users = findBy("PWD", pwd, "UID", true);
		//List<UserInfo> users = findBy("UID", true, Restrictions.eq("PWD", passwd));
        for (UserInfo userInfo : users) {
	    if (userInfo.getUID() == uid) return userInfo;
	    }
        return null;
	}
}
