package kr.green.capsuleCloset.vo;

public class UserVo {
	public String id;
	public String pw;
	public String pw2;
	public String name;
	public String gender;
	public int phoneNum;
	public String email;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw2() {
		return pw2;
	}
	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserVo [id=" + id + ", pw=" + pw + ", pw2=" + pw2 + ", name=" + name + ", gender=" + gender
				+ ", phoneNum=" + phoneNum + ", email=" + email + "]";
	}

	
	
}
