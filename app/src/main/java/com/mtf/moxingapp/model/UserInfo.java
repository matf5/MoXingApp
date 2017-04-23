package com.mtf.moxingapp.model;

/**
 * Created by Administrator on 2017/1/4.
 */
import java.util.Date;

public class UserInfo {
    private String id;

    private String phoneNum;

    private String nickname;

    private String headimgUrl;

    private String positionCity;

    private String positionProv;

    private String longitude;

    private boolean sex;

    private String latitude;

    private Date cdate;

    public UserInfo(String userId) {
        this.userId = userId;
    }

    public String getPositionCity() {
        return positionCity;
    }

    public void setPositionCity(String positionCity) {
        this.positionCity = positionCity;
    }

    public String getPositionProv() {
        return positionProv;
    }

    public void setPositionProv(String positionProv) {
        this.positionProv = positionProv;
    }

    private Date mdate;

    private String userId;

    public Date getMdate() {
        return mdate;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getHeadimgUrl() {
        return headimgUrl;
    }

    public void setHeadimgUrl(String headimgUrl) {
        this.headimgUrl = headimgUrl == null ? null : headimgUrl.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Date getCdate() {
        return cdate;
    }
}
