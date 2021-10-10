
package com.example.desafioorama.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class FundMainStrategy implements Serializable {

    @SerializedName("explanation")
    @Expose
    private String explanation;
    @SerializedName("fund_macro_strategy")
    @Expose
    private Integer fundMacroStrategy;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Integer getFundMacroStrategy() {
        return fundMacroStrategy;
    }

    public void setFundMacroStrategy(Integer fundMacroStrategy) {
        this.fundMacroStrategy = fundMacroStrategy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
