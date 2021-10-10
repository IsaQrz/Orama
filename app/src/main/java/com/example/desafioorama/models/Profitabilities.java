
package com.example.desafioorama.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Profitabilities implements Serializable {

    @SerializedName("m60")
    @Expose
    private String m60;
    @SerializedName("m48")
    @Expose
    private String m48;
    @SerializedName("m24")
    @Expose
    private String m24;
    @SerializedName("m36")
    @Expose
    private String m36;
    @SerializedName("month")
    @Expose
    private String month;
    @SerializedName("m12")
    @Expose
    private String m12;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("day")
    @Expose
    private String day;

    public String getM60() {
        return m60;
    }

    public void setM60(String m60) {
        this.m60 = m60;
    }

    public String getM48() {
        return m48;
    }

    public void setM48(String m48) {
        this.m48 = m48;
    }

    public String getM24() {
        return m24;
    }

    public void setM24(String m24) {
        this.m24 = m24;
    }

    public String getM36() {
        return m36;
    }

    public void setM36(String m36) {
        this.m36 = m36;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getM12() {
        return m12;
    }

    public void setM12(String m12) {
        this.m12 = m12;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

}
