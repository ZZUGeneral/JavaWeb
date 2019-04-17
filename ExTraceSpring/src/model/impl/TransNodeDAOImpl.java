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

public class TransNodeDAOImpl implements model.dao.TransNodeDAO {
	public TransNode loadTransNodeByORMID(PersistentSession session, String ID) throws PersistentException {
		try {
			return (TransNode) session.load(model.TransNode.class, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransNode getTransNodeByORMID(PersistentSession session, String ID) throws PersistentException {
		try {
			return (TransNode) session.get(model.TransNode.class, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransNode loadTransNodeByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (TransNode) session.load(model.TransNode.class, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransNode getTransNodeByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (TransNode) session.get(model.TransNode.class, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryTransNode(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.TransNode as TransNode");
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
	
	public List queryTransNode(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.TransNode as TransNode");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("TransNode", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransNode[] listTransNodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTransNode(session, condition, orderBy);
			return (TransNode[]) list.toArray(new TransNode[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransNode[] listTransNodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTransNode(session, condition, orderBy, lockMode);
			return (TransNode[]) list.toArray(new TransNode[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransNode loadTransNodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		TransNode[] transNodes = listTransNodeByQuery(session, condition, orderBy);
		if (transNodes != null && transNodes.length > 0)
			return transNodes[0];
		else
			return null;
	}
	
	public TransNode loadTransNodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		TransNode[] transNodes = listTransNodeByQuery(session, condition, orderBy, lockMode);
		if (transNodes != null && transNodes.length > 0)
			return transNodes[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateTransNodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.TransNode as TransNode");
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
	
	public java.util.Iterator iterateTransNodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.TransNode as TransNode");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("TransNode", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public TransNode createTransNode() {
		return new model.TransNode();
	}
	
}
