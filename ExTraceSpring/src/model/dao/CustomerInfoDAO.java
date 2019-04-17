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

public interface CustomerInfoDAO {
	public CustomerInfo loadCustomerInfoByORMID(PersistentSession session, String ID) throws PersistentException;
	public CustomerInfo getCustomerInfoByORMID(PersistentSession session, String ID) throws PersistentException;
	public CustomerInfo loadCustomerInfoByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public CustomerInfo getCustomerInfoByORMID(PersistentSession session, String ID, org.hibernate.LockMode lockMode) throws PersistentException;
	public CustomerInfo[] listCustomerInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public CustomerInfo[] listCustomerInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryCustomerInfo(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryCustomerInfo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateCustomerInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateCustomerInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CustomerInfo loadCustomerInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public CustomerInfo loadCustomerInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public CustomerInfo createCustomerInfo();
	public boolean deleteAndDissociate(model.CustomerInfo customerInfo, org.orm.PersistentSession session) throws PersistentException;
}
