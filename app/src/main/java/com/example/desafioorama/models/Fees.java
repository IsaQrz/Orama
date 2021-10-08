
package com.example.desafioorama.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Fees {

    @SerializedName("maximum_administration_fee")
    @Expose
    private String maximumAdministrationFee;
    @SerializedName("anticipated_retrieval_fee_value")
    @Expose
    private String anticipatedRetrievalFeeValue;
    @SerializedName("administration_fee")
    @Expose
    private String administrationFee;
    @SerializedName("anticipated_retrieval_fee")
    @Expose
    private String anticipatedRetrievalFee;
    @SerializedName("performance_fee")
    @Expose
    private String performanceFee;
    @SerializedName("has_anticipated_retrieval")
    @Expose
    private Boolean hasAnticipatedRetrieval;

    public String getMaximumAdministrationFee() {
        return maximumAdministrationFee;
    }

    public void setMaximumAdministrationFee(String maximumAdministrationFee) {
        this.maximumAdministrationFee = maximumAdministrationFee;
    }

    public String getAnticipatedRetrievalFeeValue() {
        return anticipatedRetrievalFeeValue;
    }

    public void setAnticipatedRetrievalFeeValue(String anticipatedRetrievalFeeValue) {
        this.anticipatedRetrievalFeeValue = anticipatedRetrievalFeeValue;
    }

    public String getAdministrationFee() {
        return administrationFee;
    }

    public void setAdministrationFee(String administrationFee) {
        this.administrationFee = administrationFee;
    }

    public String getAnticipatedRetrievalFee() {
        return anticipatedRetrievalFee;
    }

    public void setAnticipatedRetrievalFee(String anticipatedRetrievalFee) {
        this.anticipatedRetrievalFee = anticipatedRetrievalFee;
    }

    public String getPerformanceFee() {
        return performanceFee;
    }

    public void setPerformanceFee(String performanceFee) {
        this.performanceFee = performanceFee;
    }

    public Boolean getHasAnticipatedRetrieval() {
        return hasAnticipatedRetrieval;
    }

    public void setHasAnticipatedRetrieval(Boolean hasAnticipatedRetrieval) {
        this.hasAnticipatedRetrieval = hasAnticipatedRetrieval;
    }

}
