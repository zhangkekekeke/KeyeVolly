package com.keye.keyevolly.bean;

/**
 * Created by Administrator on 2017-01-18.
 */

public class UpdateResponse {
    private int code;

    private String message;

    private String info;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setPatientInfo(String String) {
        this.info = info;
    }

    public String getPatientInfo() {
        return this.info;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
