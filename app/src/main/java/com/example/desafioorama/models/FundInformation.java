
package com.example.desafioorama.models;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class FundInformation implements Serializable {

    @SerializedName("initial_date")
    @Expose
    private String initialDate;
    @SerializedName("performance_audios")
    @Expose
    private List<Object> performanceAudios = null;
    @SerializedName("fees")
    @Expose
    private Fees fees;
    @SerializedName("is_simple")
    @Expose
    private Boolean isSimple;
    @SerializedName("description_seo")
    @Expose
    private String descriptionSeo;
    @SerializedName("operability")
    @Expose
    private Operability operability;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("opening_date")
    @Expose
    private Object openingDate;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("is_closed")
    @Expose
    private Boolean isClosed;
    @SerializedName("simple_name")
    @Expose
    private String simpleName;
    @SerializedName("target_fund")
    @Expose
    private Object targetFund;
    @SerializedName("documents")
    @Expose
    private List<Document> documents = null;
    @SerializedName("specification")
    @Expose
    private Specification specification;
    @SerializedName("quota_date")
    @Expose
    private String quotaDate;
    @SerializedName("tax_classification")
    @Expose
    private String taxClassification;
    @SerializedName("cnpj")
    @Expose
    private String cnpj;
    @SerializedName("description")
    @Expose
    private Description description;
    @SerializedName("performance_videos")
    @Expose
    private List<Object> performanceVideos = null;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    @SerializedName("benchmark")
    @Expose
    private Benchmark benchmark;
    @SerializedName("orama_standard")
    @Expose
    private Boolean oramaStandard;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("fund_situation")
    @Expose
    private FundSituation fundSituation;
    @SerializedName("volatility_12m")
    @Expose
    private String volatility12m;
    @SerializedName("strategy_video")
    @Expose
    private Object strategyVideo;
    @SerializedName("insurance_company_code")
    @Expose
    private Object insuranceCompanyCode;
    @SerializedName("profitabilities")
    @Expose
    private Profitabilities profitabilities;
    @SerializedName("closed_to_capture_explanation")
    @Expose
    private String closedToCaptureExplanation;
    @SerializedName("closing_date")
    @Expose
    private Object closingDate;
    @SerializedName("show_detailed_review")
    @Expose
    private Boolean showDetailedReview;
    @SerializedName("net_patrimony_12m")
    @Expose
    private String netPatrimony12m;
    @SerializedName("is_closed_to_capture")
    @Expose
    private Boolean isClosedToCapture;
    @SerializedName("fund_manager")
    @Expose
    private FundManager fundManager;
    @SerializedName("esg_seal")
    @Expose
    private Boolean esgSeal;

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public List<Object> getPerformanceAudios() {
        return performanceAudios;
    }

    public void setPerformanceAudios(List<Object> performanceAudios) {
        this.performanceAudios = performanceAudios;
    }

    public Fees getFees() {
        return fees;
    }

    public void setFees(Fees fees) {
        this.fees = fees;
    }

    public Boolean getIsSimple() {
        return isSimple;
    }

    public void setIsSimple(Boolean isSimple) {
        this.isSimple = isSimple;
    }

    public String getDescriptionSeo() {
        return descriptionSeo;
    }

    public void setDescriptionSeo(String descriptionSeo) {
        this.descriptionSeo = descriptionSeo;
    }

    public Operability getOperability() {
        return operability;
    }

    public void setOperability(Operability operability) {
        this.operability = operability;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Object getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Object openingDate) {
        this.openingDate = openingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public Object getTargetFund() {
        return targetFund;
    }

    public void setTargetFund(Object targetFund) {
        this.targetFund = targetFund;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public String getQuotaDate() {
        return quotaDate;
    }

    public void setQuotaDate(String quotaDate) {
        this.quotaDate = quotaDate;
    }

    public String getTaxClassification() {
        return taxClassification;
    }

    public void setTaxClassification(String taxClassification) {
        this.taxClassification = taxClassification;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public List<Object> getPerformanceVideos() {
        return performanceVideos;
    }

    public void setPerformanceVideos(List<Object> performanceVideos) {
        this.performanceVideos = performanceVideos;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Benchmark getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(Benchmark benchmark) {
        this.benchmark = benchmark;
    }

    public Boolean getOramaStandard() {
        return oramaStandard;
    }

    public void setOramaStandard(Boolean oramaStandard) {
        this.oramaStandard = oramaStandard;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public FundSituation getFundSituation() {
        return fundSituation;
    }

    public void setFundSituation(FundSituation fundSituation) {
        this.fundSituation = fundSituation;
    }

    public String getVolatility12m() {
        return volatility12m;
    }

    public void setVolatility12m(String volatility12m) {
        this.volatility12m = volatility12m;
    }

    public Object getStrategyVideo() {
        return strategyVideo;
    }

    public void setStrategyVideo(Object strategyVideo) {
        this.strategyVideo = strategyVideo;
    }

    public Object getInsuranceCompanyCode() {
        return insuranceCompanyCode;
    }

    public void setInsuranceCompanyCode(Object insuranceCompanyCode) {
        this.insuranceCompanyCode = insuranceCompanyCode;
    }

    public Profitabilities getProfitabilities() {
        return profitabilities;
    }

    public void setProfitabilities(Profitabilities profitabilities) {
        this.profitabilities = profitabilities;
    }

    public String getClosedToCaptureExplanation() {
        return closedToCaptureExplanation;
    }

    public void setClosedToCaptureExplanation(String closedToCaptureExplanation) {
        this.closedToCaptureExplanation = closedToCaptureExplanation;
    }

    public Object getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Object closingDate) {
        this.closingDate = closingDate;
    }

    public Boolean getShowDetailedReview() {
        return showDetailedReview;
    }

    public void setShowDetailedReview(Boolean showDetailedReview) {
        this.showDetailedReview = showDetailedReview;
    }

    public String getNetPatrimony12m() {
        return netPatrimony12m;
    }

    public void setNetPatrimony12m(String netPatrimony12m) {
        this.netPatrimony12m = netPatrimony12m;
    }

    public Boolean getIsClosedToCapture() {
        return isClosedToCapture;
    }

    public void setIsClosedToCapture(Boolean isClosedToCapture) {
        this.isClosedToCapture = isClosedToCapture;
    }

    public FundManager getFundManager() {
        return fundManager;
    }

    public void setFundManager(FundManager fundManager) {
        this.fundManager = fundManager;
    }

    public Boolean getEsgSeal() {
        return esgSeal;
    }

    public void setEsgSeal(Boolean esgSeal) {
        this.esgSeal = esgSeal;
    }

}
