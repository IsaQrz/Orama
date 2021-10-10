
package com.example.desafioorama.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Operability implements Serializable {

    @SerializedName("has_operations_on_thursdays")
    @Expose
    private Boolean hasOperationsOnThursdays;
    @SerializedName("retrieval_liquidation_days_type")
    @Expose
    private String retrievalLiquidationDaysType;
    @SerializedName("application_quotation_days_type")
    @Expose
    private String applicationQuotationDaysType;
    @SerializedName("retrieval_quotation_days")
    @Expose
    private Integer retrievalQuotationDays;
    @SerializedName("anticipated_retrieval_quotation_days_type")
    @Expose
    private String anticipatedRetrievalQuotationDaysType;
    @SerializedName("anticipated_retrieval_quotation_days_str")
    @Expose
    private String anticipatedRetrievalQuotationDaysStr;
    @SerializedName("retrieval_quotation_days_type")
    @Expose
    private String retrievalQuotationDaysType;
    @SerializedName("anticipated_retrieval_quotation_days")
    @Expose
    private Integer anticipatedRetrievalQuotationDays;
    @SerializedName("has_operations_on_wednesdays")
    @Expose
    private Boolean hasOperationsOnWednesdays;
    @SerializedName("minimum_balance_permanence")
    @Expose
    private String minimumBalancePermanence;
    @SerializedName("has_operations_on_mondays")
    @Expose
    private Boolean hasOperationsOnMondays;
    @SerializedName("has_grace_period")
    @Expose
    private Boolean hasGracePeriod;
    @SerializedName("application_time_limit")
    @Expose
    private String applicationTimeLimit;
    @SerializedName("retrieval_time_limit")
    @Expose
    private String retrievalTimeLimit;
    @SerializedName("has_operations_on_fridays")
    @Expose
    private Boolean hasOperationsOnFridays;
    @SerializedName("anticipate_retrieval_liquidation_days")
    @Expose
    private Integer anticipateRetrievalLiquidationDays;
    @SerializedName("minimum_initial_application_amount")
    @Expose
    private String minimumInitialApplicationAmount;
    @SerializedName("anticipate_retrieval_liquidation_days_type")
    @Expose
    private String anticipateRetrievalLiquidationDaysType;
    @SerializedName("retrieval_special_type")
    @Expose
    private String retrievalSpecialType;
    @SerializedName("anticipate_retrieval_liquidation_days_str")
    @Expose
    private String anticipateRetrievalLiquidationDaysStr;
    @SerializedName("application_quotation_days_str")
    @Expose
    private String applicationQuotationDaysStr;
    @SerializedName("grace_period_in_days_str")
    @Expose
    private Object gracePeriodInDaysStr;
    @SerializedName("retrieval_quotation_days_str")
    @Expose
    private String retrievalQuotationDaysStr;
    @SerializedName("grace_period_in_days")
    @Expose
    private Integer gracePeriodInDays;
    @SerializedName("retrieval_liquidation_days_str")
    @Expose
    private String retrievalLiquidationDaysStr;
    @SerializedName("minimum_subsequent_retrieval_amount")
    @Expose
    private String minimumSubsequentRetrievalAmount;
    @SerializedName("retrieval_direct")
    @Expose
    private Boolean retrievalDirect;
    @SerializedName("retrieval_liquidation_days")
    @Expose
    private Integer retrievalLiquidationDays;
    @SerializedName("application_quotation_days")
    @Expose
    private Integer applicationQuotationDays;
    @SerializedName("max_balance_permanence")
    @Expose
    private String maxBalancePermanence;
    @SerializedName("maximum_initial_application_amount")
    @Expose
    private String maximumInitialApplicationAmount;
    @SerializedName("has_operations_on_tuesdays")
    @Expose
    private Boolean hasOperationsOnTuesdays;
    @SerializedName("minimum_subsequent_application_amount")
    @Expose
    private String minimumSubsequentApplicationAmount;

    public Boolean getHasOperationsOnThursdays() {
        return hasOperationsOnThursdays;
    }

    public void setHasOperationsOnThursdays(Boolean hasOperationsOnThursdays) {
        this.hasOperationsOnThursdays = hasOperationsOnThursdays;
    }

    public String getRetrievalLiquidationDaysType() {
        return retrievalLiquidationDaysType;
    }

    public void setRetrievalLiquidationDaysType(String retrievalLiquidationDaysType) {
        this.retrievalLiquidationDaysType = retrievalLiquidationDaysType;
    }

    public String getApplicationQuotationDaysType() {
        return applicationQuotationDaysType;
    }

    public void setApplicationQuotationDaysType(String applicationQuotationDaysType) {
        this.applicationQuotationDaysType = applicationQuotationDaysType;
    }

    public Integer getRetrievalQuotationDays() {
        return retrievalQuotationDays;
    }

    public void setRetrievalQuotationDays(Integer retrievalQuotationDays) {
        this.retrievalQuotationDays = retrievalQuotationDays;
    }

    public String getAnticipatedRetrievalQuotationDaysType() {
        return anticipatedRetrievalQuotationDaysType;
    }

    public void setAnticipatedRetrievalQuotationDaysType(String anticipatedRetrievalQuotationDaysType) {
        this.anticipatedRetrievalQuotationDaysType = anticipatedRetrievalQuotationDaysType;
    }

    public String getAnticipatedRetrievalQuotationDaysStr() {
        return anticipatedRetrievalQuotationDaysStr;
    }

    public void setAnticipatedRetrievalQuotationDaysStr(String anticipatedRetrievalQuotationDaysStr) {
        this.anticipatedRetrievalQuotationDaysStr = anticipatedRetrievalQuotationDaysStr;
    }

    public String getRetrievalQuotationDaysType() {
        return retrievalQuotationDaysType;
    }

    public void setRetrievalQuotationDaysType(String retrievalQuotationDaysType) {
        this.retrievalQuotationDaysType = retrievalQuotationDaysType;
    }

    public Integer getAnticipatedRetrievalQuotationDays() {
        return anticipatedRetrievalQuotationDays;
    }

    public void setAnticipatedRetrievalQuotationDays(Integer anticipatedRetrievalQuotationDays) {
        this.anticipatedRetrievalQuotationDays = anticipatedRetrievalQuotationDays;
    }

    public Boolean getHasOperationsOnWednesdays() {
        return hasOperationsOnWednesdays;
    }

    public void setHasOperationsOnWednesdays(Boolean hasOperationsOnWednesdays) {
        this.hasOperationsOnWednesdays = hasOperationsOnWednesdays;
    }

    public String getMinimumBalancePermanence() {
        return minimumBalancePermanence;
    }

    public void setMinimumBalancePermanence(String minimumBalancePermanence) {
        this.minimumBalancePermanence = minimumBalancePermanence;
    }

    public Boolean getHasOperationsOnMondays() {
        return hasOperationsOnMondays;
    }

    public void setHasOperationsOnMondays(Boolean hasOperationsOnMondays) {
        this.hasOperationsOnMondays = hasOperationsOnMondays;
    }

    public Boolean getHasGracePeriod() {
        return hasGracePeriod;
    }

    public void setHasGracePeriod(Boolean hasGracePeriod) {
        this.hasGracePeriod = hasGracePeriod;
    }

    public String getApplicationTimeLimit() {
        return applicationTimeLimit;
    }

    public void setApplicationTimeLimit(String applicationTimeLimit) {
        this.applicationTimeLimit = applicationTimeLimit;
    }

    public String getRetrievalTimeLimit() {
        return retrievalTimeLimit;
    }

    public void setRetrievalTimeLimit(String retrievalTimeLimit) {
        this.retrievalTimeLimit = retrievalTimeLimit;
    }

    public Boolean getHasOperationsOnFridays() {
        return hasOperationsOnFridays;
    }

    public void setHasOperationsOnFridays(Boolean hasOperationsOnFridays) {
        this.hasOperationsOnFridays = hasOperationsOnFridays;
    }

    public Integer getAnticipateRetrievalLiquidationDays() {
        return anticipateRetrievalLiquidationDays;
    }

    public void setAnticipateRetrievalLiquidationDays(Integer anticipateRetrievalLiquidationDays) {
        this.anticipateRetrievalLiquidationDays = anticipateRetrievalLiquidationDays;
    }

    public String getMinimumInitialApplicationAmount() {
        return minimumInitialApplicationAmount;
    }

    public void setMinimumInitialApplicationAmount(String minimumInitialApplicationAmount) {
        this.minimumInitialApplicationAmount = minimumInitialApplicationAmount;
    }

    public String getAnticipateRetrievalLiquidationDaysType() {
        return anticipateRetrievalLiquidationDaysType;
    }

    public void setAnticipateRetrievalLiquidationDaysType(String anticipateRetrievalLiquidationDaysType) {
        this.anticipateRetrievalLiquidationDaysType = anticipateRetrievalLiquidationDaysType;
    }

    public String getRetrievalSpecialType() {
        return retrievalSpecialType;
    }

    public void setRetrievalSpecialType(String retrievalSpecialType) {
        this.retrievalSpecialType = retrievalSpecialType;
    }

    public String getAnticipateRetrievalLiquidationDaysStr() {
        return anticipateRetrievalLiquidationDaysStr;
    }

    public void setAnticipateRetrievalLiquidationDaysStr(String anticipateRetrievalLiquidationDaysStr) {
        this.anticipateRetrievalLiquidationDaysStr = anticipateRetrievalLiquidationDaysStr;
    }

    public String getApplicationQuotationDaysStr() {
        return applicationQuotationDaysStr;
    }

    public void setApplicationQuotationDaysStr(String applicationQuotationDaysStr) {
        this.applicationQuotationDaysStr = applicationQuotationDaysStr;
    }

    public Object getGracePeriodInDaysStr() {
        return gracePeriodInDaysStr;
    }

    public void setGracePeriodInDaysStr(Object gracePeriodInDaysStr) {
        this.gracePeriodInDaysStr = gracePeriodInDaysStr;
    }

    public String getRetrievalQuotationDaysStr() {
        return retrievalQuotationDaysStr;
    }

    public void setRetrievalQuotationDaysStr(String retrievalQuotationDaysStr) {
        this.retrievalQuotationDaysStr = retrievalQuotationDaysStr;
    }

    public Integer getGracePeriodInDays() {
        return gracePeriodInDays;
    }

    public void setGracePeriodInDays(Integer gracePeriodInDays) {
        this.gracePeriodInDays = gracePeriodInDays;
    }

    public String getRetrievalLiquidationDaysStr() {
        return retrievalLiquidationDaysStr;
    }

    public void setRetrievalLiquidationDaysStr(String retrievalLiquidationDaysStr) {
        this.retrievalLiquidationDaysStr = retrievalLiquidationDaysStr;
    }

    public String getMinimumSubsequentRetrievalAmount() {
        return minimumSubsequentRetrievalAmount;
    }

    public void setMinimumSubsequentRetrievalAmount(String minimumSubsequentRetrievalAmount) {
        this.minimumSubsequentRetrievalAmount = minimumSubsequentRetrievalAmount;
    }

    public Boolean getRetrievalDirect() {
        return retrievalDirect;
    }

    public void setRetrievalDirect(Boolean retrievalDirect) {
        this.retrievalDirect = retrievalDirect;
    }

    public Integer getRetrievalLiquidationDays() {
        return retrievalLiquidationDays;
    }

    public void setRetrievalLiquidationDays(Integer retrievalLiquidationDays) {
        this.retrievalLiquidationDays = retrievalLiquidationDays;
    }

    public Integer getApplicationQuotationDays() {
        return applicationQuotationDays;
    }

    public void setApplicationQuotationDays(Integer applicationQuotationDays) {
        this.applicationQuotationDays = applicationQuotationDays;
    }

    public String getMaxBalancePermanence() {
        return maxBalancePermanence;
    }

    public void setMaxBalancePermanence(String maxBalancePermanence) {
        this.maxBalancePermanence = maxBalancePermanence;
    }

    public String getMaximumInitialApplicationAmount() {
        return maximumInitialApplicationAmount;
    }

    public void setMaximumInitialApplicationAmount(String maximumInitialApplicationAmount) {
        this.maximumInitialApplicationAmount = maximumInitialApplicationAmount;
    }

    public Boolean getHasOperationsOnTuesdays() {
        return hasOperationsOnTuesdays;
    }

    public void setHasOperationsOnTuesdays(Boolean hasOperationsOnTuesdays) {
        this.hasOperationsOnTuesdays = hasOperationsOnTuesdays;
    }

    public String getMinimumSubsequentApplicationAmount() {
        return minimumSubsequentApplicationAmount;
    }

    public void setMinimumSubsequentApplicationAmount(String minimumSubsequentApplicationAmount) {
        this.minimumSubsequentApplicationAmount = minimumSubsequentApplicationAmount;
    }

}
