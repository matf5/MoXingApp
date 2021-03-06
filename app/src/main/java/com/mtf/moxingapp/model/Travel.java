package com.mtf.moxingapp.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/2/21.
 */
public class Travel {

    private Integer id;

    private String userId;

    private Integer friendId;

    private String title;

    private String description;

    private String beginDate;

    private String endDate;

    private String beginPosProv;

    private String beginPosCity;

    private String destPosProv;

    private String destPosCity;

    private String imgUrl;

    private Integer state;

    private String longitude;

    private String latitude;

    private Date cdate;

    private Boolean isExpired;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBeginPosProv() {
        return beginPosProv;
    }

    public void setBeginPosProv(String beginPosProv) {
        this.beginPosProv = beginPosProv;
    }

    public String getBeginPosCity() {
        return beginPosCity;
    }

    public void setBeginPosCity(String beginPosCity) {
        this.beginPosCity = beginPosCity;
    }

    public String getDestPosProv() {
        return destPosProv;
    }

    public void setDestPosProv(String destPosProv) {
        this.destPosProv = destPosProv;
    }

    public String getDestPosCity() {
        return destPosCity;
    }

    public void setDestPosCity(String destPosCity) {
        this.destPosCity = destPosCity;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }

}