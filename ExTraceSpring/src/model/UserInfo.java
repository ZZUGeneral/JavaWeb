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
@Table(name="UserInfo")
public class UserInfo implements Serializable {
	public UserInfo() {
	}
	
	@Column(name="UID", nullable=false)	
	@Id	
	@GeneratedValue(generator="MODEL_USERINFO_UID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_USERINFO_UID_GENERATOR", strategy="native")	
	private int UID;
	
	@Column(name="PWD", nullable=true, length=8)	
	private String PWD;
	
	@Column(name="Name", nullable=true, length=16)	
	private String name;
	
	@Column(name="URull", nullable=false, length=4)	
	private int URull;
	
	@Column(name="TelCode", nullable=false, length=24)	
	private String telCode;
	
	@Column(name="Status", nullable=false, length=4)	
	private int status;
	
	@Column(name="DptID", nullable=true, length=16)	
	private String dptID;
	
	private void setUID(int value) {
		this.UID = value;
	}
	
	public int getUID() {
		return UID;
	}
	
	public int getORMID() {
		return getUID();
	}
	
	public void setPWD(String value) {
		this.PWD = value;
	}
	
	public String getPWD() {
		return PWD;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setURull(int value) {
		this.URull = value;
	}
	
	public int getURull() {
		return URull;
	}
	
	public void setTelCode(String value) {
		this.telCode = value;
	}
	
	public String getTelCode() {
		return telCode;
	}
	
	public void setStatus(int value) {
		this.status = value;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setDptID(String value) {
		this.dptID = value;
	}
	
	public String getDptID() {
		return dptID;
	}
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getUID());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("UserInfo[ ");
			sb.append("UID=").append(getUID()).append(" ");
			sb.append("PWD=").append(getPWD()).append(" ");
			sb.append("Name=").append(getName()).append(" ");
			sb.append("URull=").append(getURull()).append(" ");
			sb.append("TelCode=").append(getTelCode()).append(" ");
			sb.append("Status=").append(getStatus()).append(" ");
			sb.append("DptID=").append(getDptID()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
