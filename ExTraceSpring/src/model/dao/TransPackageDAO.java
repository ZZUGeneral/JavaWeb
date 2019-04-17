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

public interface TransPackageDAO {
	public TransPackage loadTransPackageByORMID(PersistentSession session, String ID) throws PersistentException;
	public TransPackage getTransPackageByORMID(PersistentSession session, String ID) throws PersistentException;
	public TransPackage loadTransPackageByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public TransPackage getTransPackageByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public TransPackage[] listTransPackageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public TransPackage[] listTransPackageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryTransPackage(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryTransPackage(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateTransPackageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateTransPackageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public TransPackage loadTransPackageByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public TransPackage loadTransPackageByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public TransPackage createTransPackage();
	public boolean deleteAndDissociate(model.TransPackage transPackage, org.orm.PersistentSession session) throws PersistentException;
}
