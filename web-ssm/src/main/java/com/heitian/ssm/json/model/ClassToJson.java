package com.heitian.ssm.json.model;

import com.google.gson.Gson;

import javax.json.JsonObject;

public class ClassToJson {
    private int statuscode;
    private JsonObject data;

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }
}
