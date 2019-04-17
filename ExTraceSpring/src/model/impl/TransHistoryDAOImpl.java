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

public class TransHistoryDAOImpl implements model.dao.TransHistoryDAO {
	public TransHistory loadTransHistoryByORMID(PersistentSession session, int SN) throws PersistentException {
		try {
			return (TransHistory) session.load(model.TransHistory.class, new Integer(SN));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransHistory getTransHistoryByORMID(PersistentSession session, int SN) throws PersistentException {
		try {
			return (TransHistory) session.get(model.TransHistory.class, new Integer(SN));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransHistory loadTransHistoryByORMID(PersistentSession session, int SN, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (TransHistory) session.load(model.TransHistory.class, new Integer(SN), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransHistory getTransHistoryByORMID(PersistentSession session, int SN, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (TransHistory) session.get(model.TransHistory.class, new Integer(SN), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryTransHistory(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.TransHistory as TransHistory");
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
	
	public List queryTransHistory(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.TransHistory as TransHistory");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("TransHistory", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransHistory[] listTransHistoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTransHistory(session, condition, orderBy);
			return (TransHistory[]) list.toArray(new TransHistory[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransHistory[] listTransHistoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTransHistory(session, condition, orderBy, lockMode);
			return (TransHistory[]) list.toArray(new TransHistory[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransHistory loadTransHistoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		TransHistory[] transHistorys = listTransHistoryByQuery(session, condition, orderBy);
		if (transHistorys != null && transHistorys.length > 0)
			return transHistorys[0];
		else
			return null;
	}
	
	public TransHistory loadTransHistoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		TransHistory[] transHistorys = listTransHistoryByQuery(session, condition, orderBy, lockMode);
		if (transHistorys != null && transHistorys.length > 0)
			return transHistorys[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateTransHistoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.TransHistory as TransHistory");
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
	
	public java.util.Iterator iterateTransHistoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.TransHistory as TransHistory");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("TransHistory", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransHistory createTransHistory() {
		return new model.TransHistory();
	}
	
	public boolean deleteAndDissociate(model.TransHistory transHistory, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(transHistory.getPackeg() != null) {
				transHistory.getPackeg().transHistory.remove(transHistory);
			}
			
			try {
				session.delete(transHistory);
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
