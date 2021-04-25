package User;

import Role.Role;

public class User {
	
	private String userId;
	private String userPw;
	private String userName;
	private String sex;
	private String age;
	private String address;
	private String tel;
	private Role role;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	public User(String userName, String sex, String age, String address, String tel, Role role) {
		super();
		this.userName = userName;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.tel = tel;
		this.role = role;
	}
	public User(String userId, String userPw,String userName, String sex, String age, String address, String tel, Role role) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.tel = tel;
		this.role = role;
	}
	public User(User userInfo, String setRole) {
		super();
	}
	public User() {
		
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", sex=" + sex + ", age="
				+ age + ", address=" + address + ", tel=" + tel + ", role=" + role + "]";
	}
	
	
	
	
	
}
