
package com.shofiq.simpledagger2.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.shofiq.simpledagger2.models.TvShow;

import java.util.List;

public class TvShowResponse {

    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("tv_shows")
    @Expose
    private List<TvShow> tvShows = null;

    public String getTotal() {
        return total;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPages() {
        return pages;
    }

    public List<TvShow> getTvShows() {
        return tvShows;
    }
}
