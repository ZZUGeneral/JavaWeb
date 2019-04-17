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

public class TransPackageDAOImpl implements model.dao.TransPackageDAO {
	public TransPackage loadTransPackageByORMID(PersistentSession session, String ID) throws PersistentException {
		try {
			return (TransPackage) session.load(model.TransPackage.class, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransPackage getTransPackageByORMID(PersistentSession session, String ID) throws PersistentException {
		try {
			return (TransPackage) session.get(model.TransPackage.class, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransPackage loadTransPackageByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (TransPackage) session.load(model.TransPackage.class, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransPackage getTransPackageByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (TransPackage) session.get(model.TransPackage.class, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryTransPackage(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.TransPackage as TransPackage");
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
	
	public List queryTransPackage(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.TransPackage as TransPackage");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("TransPackage", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransPackage[] listTransPackageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTransPackage(session, condition, orderBy);
			return (TransPackage[]) list.toArray(new TransPackage[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransPackage[] listTransPackageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTransPackage(session, condition, orderBy, lockMode);
			return (TransPackage[]) list.toArray(new TransPackage[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransPackage loadTransPackageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		TransPackage[] transPackages = listTransPackageByQuery(session, condition, orderBy);
		if (transPackages != null && transPackages.length > 0)
			return transPackages[0];
		else
			return null;
	}
	
	public TransPackage loadTransPackageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		TransPackage[] transPackages = listTransPackageByQuery(session, condition, orderBy, lockMode);
		if (transPackages != null && transPackages.length > 0)
			return transPackages[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateTransPackageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.TransPackage as TransPackage");
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
	
	public java.util.Iterator iterateTransPackageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.TransPackage as TransPackage");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("TransPackage", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransPackage createTransPackage() {
		return new model.TransPackage();
	}
	
	public boolean deleteAndDissociate(model.TransPackage transPackage, org.orm.PersistentSession session)throws PersistentException {
		try {
			model.ExpreesSheet[] lExpreesSheets = transPackage.expreesSheet.toArray();
			for(int i = 0; i < lExpreesSheets.length; i++) {
				lExpreesSheets[i].transPackage.remove(transPackage);
			}
			model.TransHistory[] lTransHistorys = transPackage.transHistory.toArray();
			for(int i = 0; i < lTransHistorys.length; i++) {
				lTransHistorys[i].setPackeg(null);
			}
			try {
				session.delete(transPackage);
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
