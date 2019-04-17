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
@Table(name="TransNode")
public class TransNode implements Serializable {
	public TransNode() {
	}
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="MODEL_TRANSNODE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_TRANSNODE_ID_GENERATOR", strategy="native")	
	private String ID;
	
	@Column(name="NodeName", nullable=true, length=32)	
	private String nodeName;
	
	@Column(name="NodeType", nullable=false, length=10)	
	private int nodeType;
	
	@Column(name="RegionCode", nullable=true, length=6)	
	private String regionCode;
	
	@Column(name="PosCode", nullable=true, length=10)	
	private Integer posCode;
	
	@Column(name="TelCode", nullable=false, length=24)	
	private String telCode;
	
	public void setID(String value) {
		this.ID = value;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getORMID() {
		return getID();
	}
	
	public void setNodeName(String value) {
		this.nodeName = value;
	}
	
	public String getNodeName() {
		return nodeName;
	}
	
	public void setNodeType(int value) {
		this.nodeType = value;
	}
	
	public int getNodeType() {
		return nodeType;
	}
	
	public void setRegionCode(String value) {
		this.regionCode = value;
	}
	
	public String getRegionCode() {
		return regionCode;
	}
	
	public void setPosCode(Integer value) {
		this.posCode = value;
	}
	
	public Integer getPosCode() {
		return posCode;
	}
	
	public void setTelCode(String value) {
		this.telCode = value;
	}
	
	public String getTelCode() {
		return telCode;
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
			sb.append("TransNode[ ");
			sb.append("ID=").append(getID()).append(" ");
			sb.append("NodeName=").append(getNodeName()).append(" ");
			sb.append("NodeType=").append(getNodeType()).append(" ");
			sb.append("RegionCode=").append(getRegionCode()).append(" ");
			sb.append("PosCode=").append(getPosCode()).append(" ");
			sb.append("TelCode=").append(getTelCode()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
