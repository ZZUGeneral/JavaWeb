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

public interface TransHistoryDAO {
	public TransHistory loadTransHistoryByORMID(PersistentSession session, int SN) throws PersistentException;
	public TransHistory getTransHistoryByORMID(PersistentSession session, int SN) throws PersistentException;
	public TransHistory loadTransHistoryByORMID(PersistentSession session, int SN, org.hibernate.LockMode lockMode) throws PersistentException;
	public TransHistory getTransHistoryByORMID(PersistentSession session, int SN, org.hibernate.LockMode lockMode) throws PersistentException;
	public TransHistory[] listTransHistoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public TransHistory[] listTransHistoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryTransHistory(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryTransHistory(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateTransHistoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateTransHistoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public TransHistory loadTransHistoryByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public TransHistory loadTransHistoryByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public TransHistory createTransHistory();
	public boolean deleteAndDissociate(model.TransHistory transHistory, org.orm.PersistentSession session) throws PersistentException;
}
