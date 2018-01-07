package model.domain;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
	private int userid;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String salt;

	public Person(int userid, String email, String password, String firstName, String lastName,byte[] salt) {
		setUserid(userid);
		setEmail(email);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setSalt(salt);
	}
	
	public Person() {
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		if(userid < 1){
			throw new IllegalArgumentException("A person Id should be strict id.");
		}
		this.userid = userid;
	}

	public void setEmail(String email) {
		if(email.isEmpty()){
			throw new IllegalArgumentException("No email given");
		}
		String USERID_PATTERN = 
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(USERID_PATTERN);
		Matcher m = p.matcher(email);
		if (!m.matches()) {
			throw new IllegalArgumentException("Email not valid");
		}
		this.email = email;
	}

	
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean isCorrectPassword(String password) {
		if(password.isEmpty()){
			throw new IllegalArgumentException("No password given");
		}
		return getPassword().equals(password);
	}

	public void setPassword(String password) {
		if(password.isEmpty()){
			throw new IllegalArgumentException("No password given");
		}
		this.password = setHashedPassword(password);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName.isEmpty()){
			throw new IllegalArgumentException("No firstname given");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName.isEmpty()){
			throw new IllegalArgumentException("No last name given");
		}
		this.lastName = lastName;
	}
	
	@Override
	public String toString(){
		return getFirstName() + " " + getLastName() + ": " + getUserid() + ", " + getEmail();
	}

	public String setHashedPassword(String password) {

		return password;
	}
	public void setSalt(String salt){
		this.salt = salt;
	}
	public void setSalt(byte[] salt) {
		if(salt == null){
			throw new DomainException("The salt of a person can't be empty");
		}
		this.salt = new BigInteger(1,salt).toString(16);
	}

	public String getSalt() {
		return salt;
	}
}
