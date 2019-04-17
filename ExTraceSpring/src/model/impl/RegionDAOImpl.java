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

public class RegionDAOImpl implements model.dao.RegionDAO {
	public Region loadRegionByORMID(PersistentSession session, String regionCode) throws PersistentException {
		try {
			return (Region) session.load(model.Region.class, regionCode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Region getRegionByORMID(PersistentSession session, String regionCode) throws PersistentException {
		try {
			return (Region) session.get(model.Region.class, regionCode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Region loadRegionByORMID(PersistentSession session, String regionCode, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Region) session.load(model.Region.class, regionCode, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Region getRegionByORMID(PersistentSession session, String regionCode, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Region) session.get(model.Region.class, regionCode, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public List queryRegion(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.Region as Region");
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
	
	public List queryRegion(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.Region as Region");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Region", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Region[] listRegionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryRegion(session, condition, orderBy);
			return (Region[]) list.toArray(new Region[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Region[] listRegionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryRegion(session, condition, orderBy, lockMode);
			return (Region[]) list.toArray(new Region[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Region loadRegionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Region[] regions = listRegionByQuery(session, condition, orderBy);
		if (regions != null && regions.length > 0)
			return regions[0];
		else
			return null;
	}
	
	public Region loadRegionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Region[] regions = listRegionByQuery(session, condition, orderBy, lockMode);
		if (regions != null && regions.length > 0)
			return regions[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateRegionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.Region as Region");
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
	
	public java.util.Iterator iterateRegionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From model.Region as Region");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Region", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public Region createRegion() {
		return new model.Region();
	}
	
}
