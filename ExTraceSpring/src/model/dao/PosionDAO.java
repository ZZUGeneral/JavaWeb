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

public interface PosionDAO {
	public Posion loadPosionByORMID(PersistentSession session, int posCode) throws PersistentException;
	public Posion getPosionByORMID(PersistentSession session, int posCode) throws PersistentException;
	public Posion loadPosionByORMID(PersistentSession session, int posCode, org.hibernate.LockMode lockMode) throws PersistentException;
	public Posion getPosionByORMID(PersistentSession session, int posCode, org.hibernate.LockMode lockMode) throws PersistentException;
	public Posion[] listPosionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Posion[] listPosionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryPosion(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryPosion(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iteratePosionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iteratePosionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Posion loadPosionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public Posion loadPosionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public Posion createPosion();
}
