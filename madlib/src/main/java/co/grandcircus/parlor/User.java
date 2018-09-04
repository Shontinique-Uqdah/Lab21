package co.grandcircus.parlor;

//Used jdbc so commented out all hibernate functionality
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;


//Mark all entity classes with @Entity so that Hibernate knows about them.
//@Entity
//@Table(name="user")
public class User {

	// Mark the ID, and designate that it is auto-generated
//	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
//	@Column(name="firstName")
	private String firstName;
	
//	@Column(name="lastName")
	private String lastName;
	
//	@Column(name="password")
	private String password;
	
//	@Column(name="email")
	private String email;
	
//	@Column(name="phoneNum")
	private String phoneNum;
	
//	@Column(name="gender")
	private String gender;
	
//	@Column(name="birthdate")
	private String birthdate;
	
//	@Column(name="admin")
	private boolean admin;
	
	
	public User(String firstName, String lastName, String password, String email, String phoneNum, String gender, boolean admin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.phoneNum = phoneNum;
		this.gender = gender;
		this.admin = admin;
	}

	// With Hibernate, you'll generally want to make sure you have a no-arg constructor
	public User() {
		
	}

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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
		
	}
	
	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + ", phoneNum=" + phoneNum + ", gender=" + gender + ", birthdate=" + birthdate
				+ ", admin=" + admin + "]";
	}
	
	
	
	
}
