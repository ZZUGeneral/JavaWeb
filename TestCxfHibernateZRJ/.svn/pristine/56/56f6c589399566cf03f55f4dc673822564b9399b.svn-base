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
package ts.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="TransPackage")
@XmlRootElement(name="TransPackage")
public class TransPackage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3050390478904210174L;

	public TransPackage() {
	}
	
	@Column(name="ID", nullable=false)	
	@Id	
//	@GeneratedValue(generator="MODEL_TRANSPACKAGE_ID_GENERATOR")	
//	@org.hibernate.annotations.GenericGenerator(name="MODEL_TRANSPACKAGE_ID_GENERATOR", strategy="assigned")	
	private String ID;
	
	@Column(name="SourceNode", nullable=true, length=8)	
	private String sourceNode;
	
	@Column(name="TargetNode", nullable=true, length=8)	
	private String targetNode;
	
	@Column(name="CreateTime", nullable=true)	
	private Date createTime;
	
	@Column(name="Status", nullable=false, length=4)	
	private int status;
	
//	@ManyToMany(mappedBy="transPackage", targetEntity=ExpreesSheet.class)	
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
//	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
//	private java.util.Set<ExpreesSheet> expreesSheet = new java.util.HashSet<ExpreesSheet>();
//	
//	@OneToMany(mappedBy="packeg", targetEntity=TransHistory.class)	
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
//	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
//	private java.util.Set<TransHistory> transHistory = new java.util.HashSet<TransHistory>();
	
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
	
	public void setCreateTime(Date value) {
		this.createTime = value;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setStatus(int value) {
		this.status = value;
	}
	
	public int getStatus() {
		return status;
	}
	
//	public void setExpreesSheet(java.util.Set<ExpreesSheet> value) {
//		this.expreesSheet = value;
//	}
//	
//	public java.util.Set<ExpreesSheet> getExpreesSheet() {
//		return expreesSheet;
//	}
//	
//	
//	public void setTransHistory(java.util.Set<TransHistory> value) {
//		this.transHistory = value;
//	}
//	
//	public java.util.Set<TransHistory> getTransHistory() {
//		return transHistory;
//	}
	
	
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
//			sb.append("ExpreesSheet.size=").append(getExpreesSheet().size()).append(" ");
//			sb.append("TransHistory.size=").append(getTransHistory().size()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
	@Transient	
	private boolean _saved = false;
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}
	
	
}
