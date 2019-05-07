package ts.model;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="PackageRoute")
@XmlRootElement(name="PackageRoute")
public class PackageRoute implements Serializable {

	private static final long serialVersionUID = -120165903842914592L;

	public PackageRoute(){

    }

	@Column(name="SN", nullable=false)
	@Id
	@GeneratedValue(generator="MODEL_CUSTOMERINFO_ID_GENERATOR")
	@org.hibernate.annotations.GenericGenerator(name="MODEL_CUSTOMERINFO_ID_GENERATOR", strategy="native")
	private int SN;

	@Column(name="PackageID", nullable=true, length=24)
	private String packageID;
	@Column(name="X", nullable=true)
	private float x;
	@Column(name="Y", nullable=true)
	private float y;
	@Column(name="tm", nullable=true)
	private Date tm;
	
	public void setSN(int value) {
		this.SN = value;
	}
	
	public int getSN() {
		return SN;
	}
	
	public int getORMID() {
		return getSN();
	}
	
	public void setX(float value) {
		this.x = value;
	}
	
	public float getX() {
		return x;
	}
	
	public void setY(float value) {
		this.y = value;
	}
	
	public float getY() {
		return y;
	}
	
	public void setTm(Date value) {
		this.tm = value;
	}
	
	public Date getTm() {
		return tm;
	}
	
	public void setPackageID(String value) {
		this.packageID = value;
	}
	
	public String getPackageID() {
		return packageID;
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
			sb.append("PackageRoute[ ");
			sb.append("SN=").append(getSN()).append(" ");
			sb.append("PackageID=").append(getPackageID()).append(" ");
			sb.append("X=").append(getX()).append(" ");
			sb.append("Y=").append(getY()).append(" ");
			sb.append("Tm=").append(getTm()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
