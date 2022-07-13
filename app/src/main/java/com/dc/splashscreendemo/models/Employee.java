package com.dc.splashscreendemo.models;

import android.util.Log;

public class Employee {
    private final String TAG = Employee.class.getSimpleName();

    private String empName;
    private String empId;
    private String email;
    private String phoneNumber;
    private int age;
    private float empExperience;
    private boolean isEmpProfileActive;

    public Employee(String empName, String empId, String email, String phoneNumber, int age, float empExperience, boolean isEmpProfileActive) {
        this.empName = empName;
        this.empId = empId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.empExperience = empExperience;
        this.isEmpProfileActive = isEmpProfileActive;
    }

    public boolean isEmpProfileActive() {
        return isEmpProfileActive;
    }

    public void setEmpProfileActive(boolean empProfileActive) {
        Log.d(TAG, "setEmpProfileActive: empProfileActive: " + empProfileActive);
        System.out.println(TAG + " setEmpProfileActive: empProfileActive: " + empProfileActive);
        isEmpProfileActive = empProfileActive;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        Log.d(TAG, "setEmpName: empName: " + empName);
        System.out.println(TAG + " setEmpName: empName: " + empName);
        this.empName = empName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getEmpExperience() {
        return empExperience;
    }

    public void setEmpExperience(float empExperience) {
        this.empExperience = empExperience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empId='" + empId + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", empExperience=" + empExperience +
                '}';
    }
}
