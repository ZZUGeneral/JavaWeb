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
package model.dao;

import org.orm.*;
import org.hibernate.LockMode;
import model.*;

public interface RegionDAO {
	public Region loadRegionByORMID(PersistentSession session, String regionCode) throws PersistentException;
	public Region getRegionByORMID(PersistentSession session, String regionCode) throws PersistentException;
	public Region loadRegionByORMID(PersistentSession session, String regionCode, org.hibernate.LockMode lockMode) throws PersistentException;
	public Region getRegionByORMID(PersistentSession session, String regionCode, org.hibernate.LockMode lockMode) throws PersistentException;
	public Region[] listRegionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Region[] listRegionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryRegion(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryRegion(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateRegionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateRegionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Region loadRegionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Region loadRegionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Region createRegion();
}
