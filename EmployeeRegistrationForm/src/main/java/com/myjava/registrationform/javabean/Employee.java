package com.myjava.registrationform.javabean;

/**
 * @desc JavaBean class used in jsp action tags.
 * @author Kartik Panchal
 */
public class Employee {

	//Creating all variables
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private long mobileNumber;
	private String address;

	// Getter And setter method
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
			throw new RuntimeException("Subclasses of Valueables cannot take in an empty String or null value for the \\\"first Name\\\" constructor");
		} else {
			this.firstName = firstName;
		}
	}

	public void setLastName(String lastName) {
		if (lastName.isBlank() || lastName.isEmpty()) {
			throw new RuntimeException("Subclasses of Valueables cannot take in an empty String or null value for the \\\"Last Name\\\" constructor");
		} else {
			this.lastName = lastName;
		}
	}

	public void setUserName(String userName) {
		if (userName.isBlank() || userName.isEmpty()) {
			throw new RuntimeException("Subclasses of Valueables cannot take in an empty String or null value for the \\\"User Name\\\" constructor");
		} else {
			this.userName = userName;
		}
	}

	public void setPassword(String password) {
		if (password.isBlank() || password.isEmpty()) {
			throw new RuntimeException("Subclasses of Valueables cannot take in an empty String or null value for the \\\"Password\\\" constructor");
		} else {
			this.password = password;
		}
	}

	public void setMobileNumber(String mobileNumber) {
		if (mobileNumber.isBlank() || mobileNumber.isEmpty()) {
			throw new RuntimeException("Subclasses of Valueables cannot take in an empty String or null value for the \\\"Mobile Number\\\" constructor");
		} else { 
			this.mobileNumber = Long.parseLong(mobileNumber);
		}
	}

	public void setAddress(String address) {
			this.address = address;
	}

}