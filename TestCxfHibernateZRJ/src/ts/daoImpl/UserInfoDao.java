package ts.daoImpl;

import ts.daoBase.BaseDao;
import ts.filter.JwtToken;
import ts.model.UserInfo;

import java.util.List;

public class UserInfoDao extends BaseDao<UserInfo, Integer> {
	public UserInfoDao() {
		super(UserInfo.class);
	}

	public UserInfo checkLogin(int uid, String pwd) throws Exception {
		List<UserInfo> users = findBy("PWD", pwd, "UID", true);
		// List<UserInfo> users = findBy("UID", true, Restrictions.eq("PWD", passwd));
		for (UserInfo userInfo : users) {
			if (userInfo.getUID() == uid) {
				String id = Integer.toString(userInfo.getUID());
				String str = new JwtToken().createJWT(id, "User", 6000);
				userInfo.setToken(str);
				return userInfo;
			}
		}
		return null;
	}
}
