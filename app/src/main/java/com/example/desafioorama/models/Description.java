
package com.example.desafioorama.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Description {

    @SerializedName("objective")
    @Expose
    private String objective;
    @SerializedName("movie_url")
    @Expose
    private Object movieUrl;
    @SerializedName("target_audience")
    @Expose
    private String targetAudience;
    @SerializedName("strengths")
    @Expose
    private String strengths;
    @SerializedName("strategy")
    @Expose
    private String strategy;

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public Object getMovieUrl() {
        return movieUrl;
    }

    public void setMovieUrl(Object movieUrl) {
        this.movieUrl = movieUrl;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getStrengths() {
        return strengths;
    }

    public void setStrengths(String strengths) {
        this.strengths = strengths;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

}
