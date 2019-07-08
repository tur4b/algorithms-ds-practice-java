package com.problem.bank.models;

public class PhoneNumber {
    private String type;
    private String phoneNum;

    public PhoneNumber(String type, String phoneNum) {
        System.out.println("PhoneNumber constructor is called");
        this.type = type;
        this.phoneNum = phoneNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "type='" + type + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
