package com.myorg.springApp.util.constant;

public enum Province {
	CENTRAL_PROVINCE("Central Province"),
	NORTHERN_PROVINCE("Northern Province"),
	WESTERN_PROVINCE("Western Province");
	
	private final String province;
	
	private Province(String province) {
		this.province=province;
	}
}
