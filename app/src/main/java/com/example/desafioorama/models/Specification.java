
package com.example.desafioorama.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Specification implements Serializable {

    @SerializedName("fund_main_strategy_name")
    @Expose
    private String fundMainStrategyName;
    @SerializedName("fund_suitability_profile")
    @Expose
    private FundSuitabilityProfile fundSuitabilityProfile;
    @SerializedName("fund_risk_profile")
    @Expose
    private FundRiskProfile fundRiskProfile;
    @SerializedName("fund_main_strategy_explanation")
    @Expose
    private String fundMainStrategyExplanation;
    @SerializedName("fund_type")
    @Expose
    private String fundType;
    @SerializedName("fund_class")
    @Expose
    private String fundClass;
    @SerializedName("fund_macro_strategy")
    @Expose
    private FundMacroStrategy fundMacroStrategy;
    @SerializedName("fund_class_anbima")
    @Expose
    private String fundClassAnbima;
    @SerializedName("fund_main_strategy")
    @Expose
    private FundMainStrategy fundMainStrategy;
    @SerializedName("is_qualified")
    @Expose
    private Boolean isQualified;

    public String getFundMainStrategyName() {
        return fundMainStrategyName;
    }

    public void setFundMainStrategyName(String fundMainStrategyName) {
        this.fundMainStrategyName = fundMainStrategyName;
    }

    public FundSuitabilityProfile getFundSuitabilityProfile() {
        return fundSuitabilityProfile;
    }

    public void setFundSuitabilityProfile(FundSuitabilityProfile fundSuitabilityProfile) {
        this.fundSuitabilityProfile = fundSuitabilityProfile;
    }

    public FundRiskProfile getFundRiskProfile() {
        return fundRiskProfile;
    }

    public void setFundRiskProfile(FundRiskProfile fundRiskProfile) {
        this.fundRiskProfile = fundRiskProfile;
    }

    public String getFundMainStrategyExplanation() {
        return fundMainStrategyExplanation;
    }

    public void setFundMainStrategyExplanation(String fundMainStrategyExplanation) {
        this.fundMainStrategyExplanation = fundMainStrategyExplanation;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getFundClass() {
        return fundClass;
    }

    public void setFundClass(String fundClass) {
        this.fundClass = fundClass;
    }

    public FundMacroStrategy getFundMacroStrategy() {
        return fundMacroStrategy;
    }

    public void setFundMacroStrategy(FundMacroStrategy fundMacroStrategy) {
        this.fundMacroStrategy = fundMacroStrategy;
    }

    public String getFundClassAnbima() {
        return fundClassAnbima;
    }

    public void setFundClassAnbima(String fundClassAnbima) {
        this.fundClassAnbima = fundClassAnbima;
    }

    public FundMainStrategy getFundMainStrategy() {
        return fundMainStrategy;
    }

    public void setFundMainStrategy(FundMainStrategy fundMainStrategy) {
        this.fundMainStrategy = fundMainStrategy;
    }

    public Boolean getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Boolean isQualified) {
        this.isQualified = isQualified;
    }

}
