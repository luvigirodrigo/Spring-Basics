package com.myorg.springApp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DRIVER", catalog = "spring_app_db", schema = "spring_app_schema")
public final class Driver implements Comparable<Driver>, Cloneable, Serializable {
	// Declaring serialVersionUID
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DRIVER_ID")
	private int driverId;

	@Column(name = "FIRST_NAME", nullable = false, length = 50)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false, length = 50)
	private String lastName;

	@Column(name = "DATE_OF_BIRTH", nullable = false)
	private LocalDate dob;

	@Column(name = "AGE", nullable = false, length = 3)
	private int age;

	@Column(name = "NIC_NUMBER", length = 20, nullable = false)
	private String nicNumber;

	@Column(name = "DRIVING_LICENSE_NUMBER", nullable = false)
	private String drivingLicenseNumber;

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNicNumber() {
		return nicNumber;
	}

	public void setNicNumber(String nicNumber) {
		this.nicNumber = nicNumber;
	}

	public String getDrivingLicenseNumber() {
		return drivingLicenseNumber;
	}

	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivingLicenseNumber = drivingLicenseNumber;
	}

	// Implementing default natural sorting order (DNSO)
	public int compareTo(Driver driver) {
		return (this.driverId > driver.getDriverId()) ? 1 : (this.driverId < driver.getDriverId()) ? -1 : 0;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", age=" + age + ", nicNumber=" + nicNumber + ", drivingLicenseNumber=" + drivingLicenseNumber + "]";
	}

	@Override
	public int hashCode() {
		return this.driverId;
	}

	public Object clone() throws CloneNotSupportedException {
		// Implementation of shallow cloning
		return super.clone();
	}

	/**
	 * Calculate age - Used to calculate the age of a driver based on the provided
	 * birthday
	 * 
	 * Note : 
	 *   If we want to convert String to LocalDate, then parse() method should be used
	 *   	[ ex : LocalDate.parse("2014-05-04") ]
	 *   If we want to convert LocalDate to String, then format() method should be used
	 *   	[ ex : String date = LocalDate.parse("2014-05-04").format(DateTimeFormatter.ISO_DATE_TIME); ]
	 * 
	 * @param birthday - birthday/date of birth
	 * @returns calculated age
	 */
	private int calculateAge(LocalDate birthday) {
		return Period.between(birthday, LocalDate.now()).getYears();
	}

	public Driver() {
	}

	public Driver(int driverId) {
		super();
		this.driverId = driverId;
	}

	public Driver(String firstName, String lastName, LocalDate dob, String nicNumber, String drivingLicenseNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.age = calculateAge(this.dob);
		this.nicNumber = nicNumber;
		this.drivingLicenseNumber = drivingLicenseNumber;
	}

	public Driver(int driverId, String firstName, String lastName, LocalDate dob, String nicNumber, String drivingLicenseNumber) {
		super();
		this.driverId = driverId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.age = calculateAge(this.dob);
		this.nicNumber = nicNumber;
		this.drivingLicenseNumber = drivingLicenseNumber;
	}
}
