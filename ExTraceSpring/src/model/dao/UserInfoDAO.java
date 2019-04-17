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

public interface UserInfoDAO {
	public UserInfo loadUserInfoByORMID(PersistentSession session, int UID) throws PersistentException;
	public UserInfo getUserInfoByORMID(PersistentSession session, int UID) throws PersistentException;
	public UserInfo loadUserInfoByORMID(PersistentSession session, int UID, org.hibernate.LockMode lockMode) throws PersistentException;
	public UserInfo getUserInfoByORMID(PersistentSession session, int UID, org.hibernate.LockMode lockMode) throws PersistentException;
	public UserInfo[] listUserInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public UserInfo[] listUserInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryUserInfo(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryUserInfo(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateUserInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateUserInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public UserInfo loadUserInfoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public UserInfo loadUserInfoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public UserInfo createUserInfo();
}
