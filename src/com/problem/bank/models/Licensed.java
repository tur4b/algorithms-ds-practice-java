package com.problem.bank.models;

import java.util.Date;

public class Licensed {
    private String type;
    private String licenseCode;
    private Date verifiedDate;

    public Licensed(){} // if not licensed set to null

    public Licensed(String type, String licenseCode, Date verifiedDate) {
        System.out.println("License constructor is called");
        this.type = type;
        this.licenseCode = licenseCode;
        this.verifiedDate = verifiedDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public Date getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(Date verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    @Override
    public String toString() {
        return "Licensed{" +
                "type='" + type + '\'' +
                ", licenseCode='" + licenseCode + '\'' +
                ", verifiedDate=" + verifiedDate +
                '}';
    }
}
