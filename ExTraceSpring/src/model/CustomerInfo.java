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
package model;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="CustomerInfo")
public class CustomerInfo implements Serializable {
	public CustomerInfo() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == model.ORMConstants.KEY_CUSTOMERINFO_EXPREESSENDER) {
			return ORM_expreesSender;
		}
		else if (key == model.ORMConstants.KEY_CUSTOMERINFO_EXPREESRECEIVER) {
			return ORM_expreesReceiver;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="MODEL_CUSTOMERINFO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_CUSTOMERINFO_ID_GENERATOR", strategy="native")	
	private String ID;
	
	@Column(name="Name", nullable=true, length=16)	
	private String name;
	
	@Column(name="TelCode", nullable=true, length=24)	
	private String telCode;
	
	@Column(name="Department", nullable=true, length=64)	
	private String department;
	
	@Column(name="RegionCode", nullable=true, length=6)	
	private String regionCode;
	
	@Column(name="Address", nullable=true, length=64)	
	private String address;
	
	@Column(name="PostCode", nullable=false, length=10)	
	private int postCode;
	
	@OneToMany(mappedBy="sender", targetEntity=model.ExpreesSheet.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_expreesSender = new java.util.HashSet();
	
	@OneToMany(mappedBy="recever", targetEntity=model.ExpreesSheet.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_expreesReceiver = new java.util.HashSet();
	
	public void setID(String value) {
		this.ID = value;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getORMID() {
		return getID();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setTelCode(String value) {
		this.telCode = value;
	}
	
	public String getTelCode() {
		return telCode;
	}
	
	public void setDepartment(String value) {
		this.department = value;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setRegionCode(String value) {
		this.regionCode = value;
	}
	
	public String getRegionCode() {
		return regionCode;
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setPostCode(int value) {
		this.postCode = value;
	}
	
	public int getPostCode() {
		return postCode;
	}
	
	private void setORM_ExpreesSender(java.util.Set value) {
		this.ORM_expreesSender = value;
	}
	
	private java.util.Set getORM_ExpreesSender() {
		return ORM_expreesSender;
	}
	
	@Transient	
	public final model.ExpreesSheetSetCollection expreesSender = new model.ExpreesSheetSetCollection(this, _ormAdapter, model.ORMConstants.KEY_CUSTOMERINFO_EXPREESSENDER, model.ORMConstants.KEY_EXPREESSHEET_SENDER, model.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_ExpreesReceiver(java.util.Set value) {
		this.ORM_expreesReceiver = value;
	}
	
	private java.util.Set getORM_ExpreesReceiver() {
		return ORM_expreesReceiver;
	}
	
	@Transient	
	public final model.ExpreesSheetSetCollection expreesReceiver = new model.ExpreesSheetSetCollection(this, _ormAdapter, model.ORMConstants.KEY_CUSTOMERINFO_EXPREESRECEIVER, model.ORMConstants.KEY_EXPREESSHEET_RECEVER, model.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getID());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("CustomerInfo[ ");
			sb.append("ID=").append(getID()).append(" ");
			sb.append("Name=").append(getName()).append(" ");
			sb.append("TelCode=").append(getTelCode()).append(" ");
			sb.append("Department=").append(getDepartment()).append(" ");
			sb.append("RegionCode=").append(getRegionCode()).append(" ");
			sb.append("Address=").append(getAddress()).append(" ");
			sb.append("PostCode=").append(getPostCode()).append(" ");
			sb.append("ExpreesSender.size=").append(expreesSender.size()).append(" ");
			sb.append("ExpreesReceiver.size=").append(expreesReceiver.size()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
