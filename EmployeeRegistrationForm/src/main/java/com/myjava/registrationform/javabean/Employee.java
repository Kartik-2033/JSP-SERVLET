package com.myjava.registrationform.javabean;
/**
 * @desc Use 'Employee' class to set and get data.
 * @author Kartik Panchal
 */
public class Employee {

	// Create all variables
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private long mobileNumber;
	private String address;

	// Getter and Setter methods
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setFirstName(String firstName) {
		if (firstName.isBlank() || firstName.isEmpty()) {
			throw new RuntimeException("First name cannot be null or empty string.");
		} else {
			this.firstName = firstName;
		}
	}

	public void setLastName(String lastName) {
		if (lastName.isBlank() || lastName.isEmpty()) {
			throw new RuntimeException("Last name cannot be null or empty string.");
		} else {
			this.lastName = lastName;
		}
	}

	public void setUserName(String userName) {
		if (userName.isBlank() || userName.isEmpty()) {
			throw new RuntimeException("User name cannot be null or empty string.");
		} else {
			this.userName = userName;
		}
	}

	public void setPassword(String password) {
		if (password.isBlank() || password.isEmpty()) {
			throw new RuntimeException("Password cannot be null or empty.");
		} else {
			this.password = password;
		}
	}

	public void setMobileNumber(String mobileNumber) {
		if (mobileNumber.isBlank() || mobileNumber.isEmpty()) {
			throw new RuntimeException("Mobile number cannot be null or empty numbers.");
		} else {
			this.mobileNumber = Long.parseLong(mobileNumber);
		}
	}

	public void setAddress(String address) {
		this.address = address;
	}

}