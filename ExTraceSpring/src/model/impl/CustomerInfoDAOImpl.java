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

public class CustomerInfoDAOImpl implements model.dao.CustomerInfoDAO {
	public CustomerInfo loadCustomerInfoByORMID(PersistentSession session, String ID) throws PersistentException {
		try {
			return (CustomerInfo) session.load(model.CustomerInfo.class, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public CustomerInfo getCustomerInfoByORMID(PersistentSession session, String ID) throws PersistentException {
		try {
			return (CustomerInfo) session.get(model.CustomerInfo.class, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public CustomerInfo loadCustomerInfoByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (CustomerInfo) session.load(model.CustomerInfo.class, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public CustomerInfo getCustomerInfoByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (CustomerInfo) session.get(model.CustomerInfo.class, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryCustomerInfo(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.CustomerInfo as CustomerInfo");
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
	
	public List queryCustomerInfo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.CustomerInfo as CustomerInfo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("CustomerInfo", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public CustomerInfo[] listCustomerInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryCustomerInfo(session, condition, orderBy);
			return (CustomerInfo[]) list.toArray(new CustomerInfo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public CustomerInfo[] listCustomerInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryCustomerInfo(session, condition, orderBy, lockMode);
			return (CustomerInfo[]) list.toArray(new CustomerInfo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public CustomerInfo loadCustomerInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		CustomerInfo[] customerInfos = listCustomerInfoByQuery(session, condition, orderBy);
		if (customerInfos != null && customerInfos.length > 0)
			return customerInfos[0];
		else
			return null;
	}
	
	public CustomerInfo loadCustomerInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		CustomerInfo[] customerInfos = listCustomerInfoByQuery(session, condition, orderBy, lockMode);
		if (customerInfos != null && customerInfos.length > 0)
			return customerInfos[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateCustomerInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.CustomerInfo as CustomerInfo");
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
	
	public java.util.Iterator iterateCustomerInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.CustomerInfo as CustomerInfo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("CustomerInfo", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public CustomerInfo createCustomerInfo() {
		return new model.CustomerInfo();
	}
	
	public boolean deleteAndDissociate(model.CustomerInfo customerInfo, org.orm.PersistentSession session)throws PersistentException {
		try {
			model.ExpreesSheet[] lExpreesSenders = customerInfo.expreesSender.toArray();
			for(int i = 0; i < lExpreesSenders.length; i++) {
				lExpreesSenders[i].setSender(null);
			}
			model.ExpreesSheet[] lExpreesReceivers = customerInfo.expreesReceiver.toArray();
			for(int i = 0; i < lExpreesReceivers.length; i++) {
				lExpreesReceivers[i].setRecever(null);
			}
			try {
				session.delete(customerInfo);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
}
