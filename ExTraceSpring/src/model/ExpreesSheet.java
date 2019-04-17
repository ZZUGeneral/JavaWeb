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
@Table(name="ExpreesSheet")
public class ExpreesSheet implements Serializable {
	public ExpreesSheet() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == model.ORMConstants.KEY_EXPREESSHEET_TRANSPACKAGE) {
			return ORM_transPackage;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == model.ORMConstants.KEY_EXPREESSHEET_SENDER) {
			this.sender = (model.CustomerInfo) owner;
		}
		
		else if (key == model.ORMConstants.KEY_EXPREESSHEET_RECEVER) {
			this.recever = (model.CustomerInfo) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="MODEL_EXPREESSHEET_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_EXPREESSHEET_ID_GENERATOR", strategy="native")	
	private String ID;
	
	@Column(name="Type", nullable=false, length=4)	
	private int type;
	
	@ManyToOne(targetEntity=model.CustomerInfo.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="Sender", referencedColumnName="ID", nullable=false) })	
	private model.CustomerInfo sender;
	
	@ManyToOne(targetEntity=model.CustomerInfo.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="Recever", referencedColumnName="ID", nullable=false) })	
	private model.CustomerInfo recever;
	
	@Column(name="Weight", nullable=true)	
	private Float weight;
	
	@Column(name="TranFee", nullable=true)	
	private Float tranFee;
	
	@Column(name="PacgageFee", nullable=true)	
	private Float pacgageFee;
	
	@Column(name="InsuFee", nullable=true)	
	private Float insuFee;
	
	@Column(name="Accepter", nullable=true, length=16)	
	private String accepter;
	
	@Column(name="Deliver", nullable=true, length=16)	
	private String deliver;
	
	@Column(name="AccepterTime", nullable=true)	
	private java.sql.Timestamp accepterTime;
	
	@Column(name="DeleveTime", nullable=true)	
	private java.sql.Timestamp deleveTime;
	
	@Column(name="Acc1", nullable=true, length=64)	
	private String acc1;
	
	@Column(name="Acc2", nullable=true, length=64)	
	private String acc2;
	
	@Column(name="Status", nullable=true, length=4)	
	private Integer status;
	
	@ManyToMany(targetEntity=model.TransPackage.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="TransPackageContent", joinColumns={ @JoinColumn(name="ExpreesSheetID") }, inverseJoinColumns={ @JoinColumn(name="TransPackageID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_transPackage = new java.util.HashSet();
	
	public void setID(String value) {
		this.ID = value;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getORMID() {
		return getID();
	}
	
	public void setType(int value) {
		this.type = value;
	}
	
	public int getType() {
		return type;
	}
	
	public void setWeight(Float value) {
		this.weight = value;
	}
	
	public Float getWeight() {
		return weight;
	}
	
	public void setTranFee(Float value) {
		this.tranFee = value;
	}
	
	public Float getTranFee() {
		return tranFee;
	}
	
	public void setPacgageFee(Float value) {
		this.pacgageFee = value;
	}
	
	public Float getPacgageFee() {
		return pacgageFee;
	}
	
	public void setInsuFee(Float value) {
		this.insuFee = value;
	}
	
	public Float getInsuFee() {
		return insuFee;
	}
	
	public void setAccepter(String value) {
		this.accepter = value;
	}
	
	public String getAccepter() {
		return accepter;
	}
	
	public void setDeliver(String value) {
		this.deliver = value;
	}
	
	public String getDeliver() {
		return deliver;
	}
	
	public void setAccepterTime(java.sql.Timestamp value) {
		this.accepterTime = value;
	}
	
	public java.sql.Timestamp getAccepterTime() {
		return accepterTime;
	}
	
	public void setDeleveTime(java.sql.Timestamp value) {
		this.deleveTime = value;
	}
	
	public java.sql.Timestamp getDeleveTime() {
		return deleveTime;
	}
	
	public void setAcc1(String value) {
		this.acc1 = value;
	}
	
	public String getAcc1() {
		return acc1;
	}
	
	public void setAcc2(String value) {
		this.acc2 = value;
	}
	
	public String getAcc2() {
		return acc2;
	}
	
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	private void setORM_TransPackage(java.util.Set value) {
		this.ORM_transPackage = value;
	}
	
	private java.util.Set getORM_TransPackage() {
		return ORM_transPackage;
	}
	
	@Transient	
	public final model.TransPackageSetCollection transPackage = new model.TransPackageSetCollection(this, _ormAdapter, model.ORMConstants.KEY_EXPREESSHEET_TRANSPACKAGE, model.ORMConstants.KEY_TRANSPACKAGE_EXPREESSHEET, model.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setSender(model.CustomerInfo value) {
		if (sender != null) {
			sender.expreesSender.remove(this);
		}
		if (value != null) {
			value.expreesSender.add(this);
		}
	}
	
	public model.CustomerInfo getSender() {
		return sender;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Sender(model.CustomerInfo value) {
		this.sender = value;
	}
	
	private model.CustomerInfo getORM_Sender() {
		return sender;
	}
	
	public void setRecever(model.CustomerInfo value) {
		if (recever != null) {
			recever.expreesReceiver.remove(this);
		}
		if (value != null) {
			value.expreesReceiver.add(this);
		}
	}
	
	public model.CustomerInfo getRecever() {
		return recever;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Recever(model.CustomerInfo value) {
		this.recever = value;
	}
	
	private model.CustomerInfo getORM_Recever() {
		return recever;
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getID());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("ExpreesSheet[ ");
			sb.append("ID=").append(getID()).append(" ");
			sb.append("Type=").append(getType()).append(" ");
			if (getSender() != null)
				sb.append("Sender.Persist_ID=").append(getSender().toString(true)).append(" ");
			else
				sb.append("Sender=null ");
			if (getRecever() != null)
				sb.append("Recever.Persist_ID=").append(getRecever().toString(true)).append(" ");
			else
				sb.append("Recever=null ");
			sb.append("Weight=").append(getWeight()).append(" ");
			sb.append("TranFee=").append(getTranFee()).append(" ");
			sb.append("PacgageFee=").append(getPacgageFee()).append(" ");
			sb.append("InsuFee=").append(getInsuFee()).append(" ");
			sb.append("Accepter=").append(getAccepter()).append(" ");
			sb.append("Deliver=").append(getDeliver()).append(" ");
			sb.append("AccepterTime=").append(getAccepterTime()).append(" ");
			sb.append("DeleveTime=").append(getDeleveTime()).append(" ");
			sb.append("Acc1=").append(getAcc1()).append(" ");
			sb.append("Acc2=").append(getAcc2()).append(" ");
			sb.append("Status=").append(getStatus()).append(" ");
			sb.append("TransPackage.size=").append(transPackage.size()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
