package com.myorg.springApp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.myorg.springApp.util.constant.Province;

@Entity
@Table(name = "REGISTRATION_RECORD")
public final class RegistrationRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REGISTRATION_ID")
	private int registrationId;

	@Column(name = "PROVINCE", nullable = false, length = 25)
	private Province province;

	@Column(name = "PROVINCIAL_SHORT_CODE", nullable = false, length = 6)
	private String provincialShortCode;

	@Column(name = "REGISTRATION_NUMBER", nullable = false)
	private String registrationNumber;

	@Column(name = "REGISTERED_YEAR")
	private int registeredYear;
}
