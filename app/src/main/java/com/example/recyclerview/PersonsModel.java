package com.example.recyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonsModel {


    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("Details")
    @Expose
    private List<String> details = null;
    @SerializedName("bodyType")
    @Expose
    private String bodyType;
    @SerializedName("userDesire")
    @Expose
    private String userDesire;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public List<String> getDetails() {
        return details;
    }


    public void setDetails(List<String> details) {
        this.details = details;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getUserDesire() {
        return userDesire;
    }

    public void setUserDesire(String userDesire) {
        this.userDesire = userDesire;
    }


}
