/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package model.impl;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;
import model.*;

public class UserInfoDAOImpl implements model.dao.UserInfoDAO {
	public UserInfo loadUserInfoByORMID(PersistentSession session, int UID) throws PersistentException {
		try {
			return (UserInfo) session.load(model.UserInfo.class, new Integer(UID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public UserInfo getUserInfoByORMID(PersistentSession session, int UID) throws PersistentException {
		try {
			return (UserInfo) session.get(model.UserInfo.class, new Integer(UID));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public UserInfo loadUserInfoByORMID(PersistentSession session, int UID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (UserInfo) session.load(model.UserInfo.class, new Integer(UID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public UserInfo getUserInfoByORMID(PersistentSession session, int UID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (UserInfo) session.get(model.UserInfo.class, new Integer(UID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryUserInfo(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.UserInfo as UserInfo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryUserInfo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.UserInfo as UserInfo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("UserInfo", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public UserInfo[] listUserInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryUserInfo(session, condition, orderBy);
			return (UserInfo[]) list.toArray(new UserInfo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public UserInfo[] listUserInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryUserInfo(session, condition, orderBy, lockMode);
			return (UserInfo[]) list.toArray(new UserInfo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public UserInfo loadUserInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		UserInfo[] userInfos = listUserInfoByQuery(session, condition, orderBy);
		if (userInfos != null && userInfos.length > 0)
			return userInfos[0];
		else
			return null;
	}
	
	public UserInfo loadUserInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		UserInfo[] userInfos = listUserInfoByQuery(session, condition, orderBy, lockMode);
		if (userInfos != null && userInfos.length > 0)
			return userInfos[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateUserInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.UserInfo as UserInfo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateUserInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.UserInfo as UserInfo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("UserInfo", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public UserInfo createUserInfo() {
		return new model.UserInfo();
	}
	
}
