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
@Table(name="TransPackage")
public class TransPackage implements Serializable {
	public TransPackage() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == model.ORMConstants.KEY_TRANSPACKAGE_EXPREESSHEET) {
			return ORM_expreesSheet;
		}
		else if (key == model.ORMConstants.KEY_TRANSPACKAGE_TRANSHISTORY) {
			return ORM_transHistory;
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
	@GeneratedValue(generator="MODEL_TRANSPACKAGE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_TRANSPACKAGE_ID_GENERATOR", strategy="native")	
	private String ID;
	
	@Column(name="SourceNode", nullable=true, length=8)	
	private String sourceNode;
	
	@Column(name="TargetNode", nullable=true, length=8)	
	private String targetNode;
	
	@Column(name="CreateTime", nullable=true)	
	private java.sql.Timestamp createTime;
	
	@Column(name="Status", nullable=false, length=4)	
	private int status;
	
	@ManyToMany(mappedBy="ORM_transPackage", targetEntity=model.ExpreesSheet.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_expreesSheet = new java.util.HashSet();
	
	@OneToMany(mappedBy="packeg", targetEntity=model.TransHistory.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_transHistory = new java.util.HashSet();
	
	public void setID(String value) {
		this.ID = value;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getORMID() {
		return getID();
	}
	
	public void setSourceNode(String value) {
		this.sourceNode = value;
	}
	
	public String getSourceNode() {
		return sourceNode;
	}
	
	public void setTargetNode(String value) {
		this.targetNode = value;
	}
	
	public String getTargetNode() {
		return targetNode;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	
	public void setStatus(int value) {
		this.status = value;
	}
	
	public int getStatus() {
		return status;
	}
	
	private void setORM_ExpreesSheet(java.util.Set value) {
		this.ORM_expreesSheet = value;
	}
	
	private java.util.Set getORM_ExpreesSheet() {
		return ORM_expreesSheet;
	}
	
	@Transient	
	public final model.ExpreesSheetSetCollection expreesSheet = new model.ExpreesSheetSetCollection(this, _ormAdapter, model.ORMConstants.KEY_TRANSPACKAGE_EXPREESSHEET, model.ORMConstants.KEY_EXPREESSHEET_TRANSPACKAGE, model.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_TransHistory(java.util.Set value) {
		this.ORM_transHistory = value;
	}
	
	private java.util.Set getORM_TransHistory() {
		return ORM_transHistory;
	}
	
	@Transient	
	public final model.TransHistorySetCollection transHistory = new model.TransHistorySetCollection(this, _ormAdapter, model.ORMConstants.KEY_TRANSPACKAGE_TRANSHISTORY, model.ORMConstants.KEY_TRANSHISTORY_PACKEG, model.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getID());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("TransPackage[ ");
			sb.append("ID=").append(getID()).append(" ");
			sb.append("SourceNode=").append(getSourceNode()).append(" ");
			sb.append("TargetNode=").append(getTargetNode()).append(" ");
			sb.append("CreateTime=").append(getCreateTime()).append(" ");
			sb.append("Status=").append(getStatus()).append(" ");
			sb.append("ExpreesSheet.size=").append(expreesSheet.size()).append(" ");
			sb.append("TransHistory.size=").append(transHistory.size()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
