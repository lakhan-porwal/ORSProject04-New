package in.co.rays.proj4.bean;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class UserBean extends BaseBean {

	public static final String ACTIVE = "Active";
	public static final String INACTIVE = "Inactive";

	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String confirmPassword;
	private Date dob;
	private String mobileNo;
	private long roleId;
	private int unSuccessfullLogin;
	private String gender;
	private Timestamp lastLogin;
	private String lock = INACTIVE;
	private String registeredIP;
	private String lastLoginIP;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public int getUnSuccessfullLogin() {
		return unSuccessfullLogin;
	}

	public void setUnSuccessfullLogin(int unSuccessfullLogin) {
		this.unSuccessfullLogin = unSuccessfullLogin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLock() {
		return lock;
	}

	public void setLock(String lock) {
		this.lock = lock;
	}

	public String getRegisteredIP() {
		return registeredIP;
	}

	public void setRegisteredIP(String registeredIP) {
		this.registeredIP = registeredIP;
	}

	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	@Override
	public String getValue() {
		return firstName + " " + lastName;
	}

	@Override
	public void setResultSet(ResultSet rs) {
		super.setResultSet(rs);

		try {
			setFirstName(rs.getString("FIRST_NAME"));
			setLastName(rs.getString("LAST_NAME"));
			setLogin(rs.getString("LOGIN"));
			setPassword(rs.getString("PASSWORD"));
			setDob(rs.getTimestamp("DOB"));
			setMobileNo(rs.getString("MOBILE_NO"));
			setRoleId(rs.getLong("ROLE_ID"));
			setUnSuccessfullLogin(rs.getInt("UNSUCCESSFUL_LOGIN"));
			setGender(rs.getString("GENDER"));
			setLastLogin(rs.getTimestamp("LAST_LOGIN"));
			setLock(rs.getString("USER_LOCK"));
			setRegisteredIP(rs.getString("REGISTERED_IP"));
			setLastLoginIP(rs.getString("LAST_LOGIN_IP"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
