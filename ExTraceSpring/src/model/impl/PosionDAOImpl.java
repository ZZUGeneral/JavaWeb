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

public class PosionDAOImpl implements model.dao.PosionDAO {
	public Posion loadPosionByORMID(PersistentSession session, int posCode) throws PersistentException {
		try {
			return (Posion) session.load(model.Posion.class, new Integer(posCode));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Posion getPosionByORMID(PersistentSession session, int posCode) throws PersistentException {
		try {
			return (Posion) session.get(model.Posion.class, new Integer(posCode));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Posion loadPosionByORMID(PersistentSession session, int posCode, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Posion) session.load(model.Posion.class, new Integer(posCode), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Posion getPosionByORMID(PersistentSession session, int posCode, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Posion) session.get(model.Posion.class, new Integer(posCode), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryPosion(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.Posion as Posion");
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
	
	public List queryPosion(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.Posion as Posion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Posion", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Posion[] listPosionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPosion(session, condition, orderBy);
			return (Posion[]) list.toArray(new Posion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Posion[] listPosionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPosion(session, condition, orderBy, lockMode);
			return (Posion[]) list.toArray(new Posion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Posion loadPosionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Posion[] posions = listPosionByQuery(session, condition, orderBy);
		if (posions != null && posions.length > 0)
			return posions[0];
		else
			return null;
	}
	
	public Posion loadPosionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Posion[] posions = listPosionByQuery(session, condition, orderBy, lockMode);
		if (posions != null && posions.length > 0)
			return posions[0];
		else
			return null;
	}
	
	public java.util.Iterator iteratePosionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.Posion as Posion");
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
	
	public java.util.Iterator iteratePosionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.Posion as Posion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Posion", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Posion createPosion() {
		return new model.Posion();
	}
	
}
