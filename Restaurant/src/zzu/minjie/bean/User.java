package zzu.minjie.bean;

public class User {
	private String userId;
	private String name;  
	private String  address;
	private String phone;
	private int    type;  
	private char  gender; 
	private String birthday;
	private String password;
	private String nick;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", address=" + address + ", phone=" + phone + ", type="
				+ type + ", gender=" + gender + ", birthday=" + birthday + ", password=" + password + ", nick=" + nick
				+ "]";
	}
	
}
