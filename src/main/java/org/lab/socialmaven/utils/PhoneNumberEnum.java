package org.lab.socialmaven.utils;

public enum PhoneNumberEnum {
    USA("+1", "555", "United States"),
    TH("+66", "02", "Thailand"),
    UK("+44", "20", "United Kingdom"),
    CANADA("+1", "416", "Canada"),
    AUSTRALIA("+61", "2", "Australia"),
    GERMANY("+49", "30", "Germany");

    private final String countryCode;
    private final String cityCode;
    private final String countryName;

    PhoneNumberEnum(String countryCode, String cityCode, String countryName) {
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCountryName() {
        return countryName;
    }

}
