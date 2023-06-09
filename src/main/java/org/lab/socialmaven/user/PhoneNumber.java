package org.lab.socialmaven.user;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {
	private String countryCode;
	private String areaCode;
	private String number;

	private static final Map<String, String> COUNTRY_CODES = new HashMap<>();

	static {
		COUNTRY_CODES.put("US", "+1");
		COUNTRY_CODES.put("UK", "+44");
		COUNTRY_CODES.put("TH", "+66");

	}

	public PhoneNumber() {
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.number = number;
	}

	public PhoneNumber(String countryCode, String areaCode, String number) {
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.number = number;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFormattedNumber() {
		String countryCodePrefix = COUNTRY_CODES.get(countryCode);
		return String.format("%s-%s-%s", countryCodePrefix, areaCode, number);
	}

}
