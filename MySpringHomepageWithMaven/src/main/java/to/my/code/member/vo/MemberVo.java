package to.my.code.member.vo;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberVo {
	private Long no;
	
	@Email(message="이메일 주소가 유효하지 않습니다.")
	private String email;
	
	@NotEmpty(message="암호를 입력하세요.")
	private String password;
	
	@NotEmpty(message="이름을 입력하세요.")
	private String name;
	
	@Length(min=8, max=8, message="생년월일을 입력하세요.")
	private String birth;
	
	@Pattern(regexp="[M|F]", message="성별은 M 또는 F여야 합니다.")
	private String gender;
	
	private String phoneNumber;
	private Date regDate;
	private Date loginDate;
	
	public MemberVo() {
	}
	
	public MemberVo(Long no, String email, String password, String name, String birth,
					String gender, String phoneNumber, Date regDate, Date loginDate) {
		this.no = no;
		this.email = email;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.regDate = regDate;
		this.loginDate = loginDate;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
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

	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((loginDate == null) ? 0 : loginDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVo other = (MemberVo) obj;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (loginDate == null) {
			if (other.loginDate != null)
				return false;
		} else if (!loginDate.equals(other.loginDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("[")
				.append("no : ").append(no).append(", ")
				.append("email : ").append(email).append(", ")
				.append("name : ").append(name).append(", ")
				.append("birth : ").append(birth).append(", ")
				.append("gender : ").append(gender).append(", ")
				.append("phoneNumber : ").append(phoneNumber).append(", ")
				.append("regDate : ").append(regDate).append(", ")
				.append("loginDate : ").append(loginDate)
				.append("]").toString();
	}
}
