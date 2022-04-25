package com.barosanu.controller.persistance;

import java.io.Serializable;

public class ValidAccount implements Serializable {
    private String address;
    private String password;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ValidAccount(String address, String password) {
        this.address = address;
        this.password = password;
    }
}
