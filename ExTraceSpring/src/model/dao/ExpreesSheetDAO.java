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

public interface ExpreesSheetDAO {
	public ExpreesSheet loadExpreesSheetByORMID(PersistentSession session, String ID) throws PersistentException;
	public ExpreesSheet getExpreesSheetByORMID(PersistentSession session, String ID) throws PersistentException;
	public ExpreesSheet loadExpreesSheetByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public ExpreesSheet getExpreesSheetByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public ExpreesSheet[] listExpreesSheetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public ExpreesSheet[] listExpreesSheetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryExpreesSheet(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryExpreesSheet(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateExpreesSheetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateExpreesSheetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public ExpreesSheet loadExpreesSheetByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public ExpreesSheet loadExpreesSheetByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public ExpreesSheet createExpreesSheet();
	public boolean deleteAndDissociate(model.ExpreesSheet expreesSheet, org.orm.PersistentSession session) throws PersistentException;
}
