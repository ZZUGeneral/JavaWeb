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

public class ExpreesSheetDAOImpl implements model.dao.ExpreesSheetDAO {
	public ExpreesSheet loadExpreesSheetByORMID(PersistentSession session, String ID) throws PersistentException {
		try {
			return (ExpreesSheet) session.load(model.ExpreesSheet.class, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public ExpreesSheet getExpreesSheetByORMID(PersistentSession session, String ID) throws PersistentException {
		try {
			return (ExpreesSheet) session.get(model.ExpreesSheet.class, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public ExpreesSheet loadExpreesSheetByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ExpreesSheet) session.load(model.ExpreesSheet.class, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public ExpreesSheet getExpreesSheetByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (ExpreesSheet) session.get(model.ExpreesSheet.class, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryExpreesSheet(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.ExpreesSheet as ExpreesSheet");
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
	
	public List queryExpreesSheet(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.ExpreesSheet as ExpreesSheet");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ExpreesSheet", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public ExpreesSheet[] listExpreesSheetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryExpreesSheet(session, condition, orderBy);
			return (ExpreesSheet[]) list.toArray(new ExpreesSheet[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public ExpreesSheet[] listExpreesSheetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryExpreesSheet(session, condition, orderBy, lockMode);
			return (ExpreesSheet[]) list.toArray(new ExpreesSheet[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public ExpreesSheet loadExpreesSheetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		ExpreesSheet[] expreesSheets = listExpreesSheetByQuery(session, condition, orderBy);
		if (expreesSheets != null && expreesSheets.length > 0)
			return expreesSheets[0];
		else
			return null;
	}
	
	public ExpreesSheet loadExpreesSheetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		ExpreesSheet[] expreesSheets = listExpreesSheetByQuery(session, condition, orderBy, lockMode);
		if (expreesSheets != null && expreesSheets.length > 0)
			return expreesSheets[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateExpreesSheetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.ExpreesSheet as ExpreesSheet");
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
	
	public java.util.Iterator iterateExpreesSheetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.ExpreesSheet as ExpreesSheet");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("ExpreesSheet", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public ExpreesSheet createExpreesSheet() {
		return new model.ExpreesSheet();
	}
	
	public boolean deleteAndDissociate(model.ExpreesSheet expreesSheet, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(expreesSheet.getSender() != null) {
				expreesSheet.getSender().expreesSender.remove(expreesSheet);
			}
			
			if(expreesSheet.getRecever() != null) {
				expreesSheet.getRecever().expreesReceiver.remove(expreesSheet);
			}
			
			model.TransPackage[] lTransPackages = expreesSheet.transPackage.toArray();
			for(int i = 0; i < lTransPackages.length; i++) {
				lTransPackages[i].expreesSheet.remove(expreesSheet);
			}
			try {
				session.delete(expreesSheet);
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
