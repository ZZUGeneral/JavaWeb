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

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="UsersPackage")
@XmlRootElement(name="UsersPackage")
public class UsersPackage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -971981123070778605L;

	public UsersPackage() {
	}
	
	@Column(name="SN", nullable=false)	
	@Id	
	@GeneratedValue(generator="MODEL_USERSPACKAGE_SN_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_USERSPACKAGE_SN_GENERATOR", strategy="increment")	
	private int SN;
	
	@Column(name="UserUID", nullable=true, length=10)	
	private int userUID;
	
	@Column(name="PackageID", nullable=true, length=24)	
	private String packageID;

	public void setSN(int value) {
		this.SN = value;
	}
	
	public int getSN() {
		return SN;
	}
	
	public int getUserUID() {
		return userUID;
	}
	
	public void setUserUID(int value) {
		this.userUID = value;
	}
	
	public String getPackageID() {
		return packageID;
	}
	
	public void setPackageID(String value) {
		this.packageID = value;
	}

	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getSN());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("UsersPackage[ ");
			sb.append("SN=").append(getSN()).append(" ");
			sb.append("UserUID=").append(getUserUID()).append(" ");
			sb.append("PackageID=").append(getPackageID()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
