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

public interface TransNodeDAO {
	public TransNode loadTransNodeByORMID(PersistentSession session, String ID) throws PersistentException;
	public TransNode getTransNodeByORMID(PersistentSession session, String ID) throws PersistentException;
	public TransNode loadTransNodeByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public TransNode getTransNodeByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public TransNode[] listTransNodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public TransNode[] listTransNodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryTransNode(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryTransNode(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateTransNodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateTransNodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public TransNode loadTransNodeByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public TransNode loadTransNodeByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public TransNode createTransNode();
}
