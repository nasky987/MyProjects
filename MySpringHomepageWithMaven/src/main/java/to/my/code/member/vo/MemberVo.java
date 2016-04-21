package to.my.code.member.vo;

import java.util.Date;
import java.util.Objects;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberVo {
	@NotEmpty(message = "이메일 주소를 입력하세요.")
	private String email;
	private String password;
	private String name;
	private String birth;
	private String gender;
	private String phoneNumber;
	private Date regDate;
	
	public MemberVo() {
	}
	
	public MemberVo(String email, String password, String name, String birth, String gender, String phoneNumber, Date regDate) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.regDate = regDate;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this);
	}

	@Override
	public String toString() {
		return new StringBuilder().append("[")
				.append("email : ").append(email).append(", ")
				.append("name : ").append(name).append(", ")
				.append("birth : ").append(birth).append(", ")
				.append("gender : ").append(gender).append(", ")
				.append("phoneNumber : ").append(phoneNumber).append(", ")
				.append("regDate : ").append(regDate)
				.append("]").toString();
	}
}
