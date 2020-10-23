
package com.shofiq.simpledagger2.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TvShow {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private Object endDate;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("network")
    @Expose
    private String network;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("image_thumbnail_path")
    @Expose
    private String imageThumbnailPath;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getStartDate() {
        return startDate;
    }

    public Object getEndDate() {
        return endDate;
    }

    public String getCountry() {
        return country;
    }

    public String getNetwork() {
        return network;
    }

    public String getStatus() {
        return status;
    }

    public String getImageThumbnailPath() {
        return imageThumbnailPath;
    }
}
