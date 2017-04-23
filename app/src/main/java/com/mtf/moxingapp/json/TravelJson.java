package com.mtf.moxingapp.json;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/12.
 */
public class TravelJson {

    /**
     * code : 1
     * msg : 成功返回相同目的地的未过期行程！
     * data : [{"id":3,"userId":3,"title":"出游","description":"halo,Beijing","beginDate":"Jan 20, 2017 12:00:00 AM","endDate":"Jan 25, 2017 12:00:00 AM","beginPosProv":"广东","beginPosCity":"广州","destPosProv":"北京","destPosCity":"北京","imgUrl":"www.taobao.com","state":0,"longitude":"56.34","latitude":"45.23","isExpired":false,"userInfo":{"id":3,"phoneNum":"13430054316","headimgUrl":"www.taobao.com","posCity":"珠海","longitude":"56.34","sex":true,"latitude":"45.23","userId":3,"posProv":""},"label":{"id":3,"userId":3,"extraversionScore":5,"agreeablenessScore":13,"conscientiousnessScore":23}},{"id":4,"userId":9,"title":"出游","description":"halo, Beijing","beginDate":"Jan 20, 2017 12:00:00 AM","endDate":"Jan 27, 2017 12:00:00 AM","beginPosProv":"广东","beginPosCity":"广州","destPosProv":"北京","destPosCity":"北京","imgUrl":"www.taobao.com","state":0,"longitude":"56.23","latitude":"25.56","isExpired":false,"userInfo":{"id":4,"phoneNum":"13430052345","headimgUrl":"www.taobao.com","posCity":"zhuhai","longitude":"56.23","sex":true,"latitude":"25.56","userId":9,"posProv":" 㶫"},"label":{"id":4,"userId":9,"extraversionScore":34,"agreeablenessScore":12,"conscientiousnessScore":21}}]
     */

    private int code;
    private String msg;
    /**
     * id : 3
     * userId : 3
     * title : 出游
     * description : halo,Beijing
     * beginDate : Jan 20, 2017 12:00:00 AM
     * endDate : Jan 25, 2017 12:00:00 AM
     * beginPosProv : 广东
     * beginPosCity : 广州
     * destPosProv : 北京
     * destPosCity : 北京
     * imgUrl : www.taobao.com
     * state : 0
     * longitude : 56.34
     * latitude : 45.23
     * isExpired : false
     * userInfo : {"id":3,"nickname":"ntf","phoneNum":"13430054316","headimgUrl":"www.taobao.com","posCity":"珠海","longitude":"56.34","sex":true,"latitude":"45.23","userId":3,"posProv":""}
     * label : {"id":3,"userId":3,"extraversionScore":5,"agreeablenessScore":13,"conscientiousnessScore":23}
     */

    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private int userId;
        private String title;
        private String description;
        private Date beginDate;
        private Date endDate;
        private String beginPosProv;
        private String beginPosCity;
        private String destPosProv;
        private String destPosCity;
        private String imgUrl;
        private int state;
        private double longitude;
        private double latitude;
        private boolean isExpired;
        /**
         * id : 3
         * phoneNum : 13430054316
         * headimgUrl : www.taobao.com
         * posCity : 珠海
         * longitude : 56.34
         * sex : true
         * latitude : 45.23
         * userId : 3
         * posProv :
         */

        private UserInfoBean userInfo;
        /**
         * id : 3
         * userId : 3
         * extraversionScore : 5
         * agreeablenessScore : 13
         * conscientiousnessScore : 23
         */

        private LabelBean label;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
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

        public Date getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(Date beginDate) {
            this.beginDate = beginDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
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

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public boolean isIsExpired() {
            return isExpired;
        }

        public void setIsExpired(boolean isExpired) {
            this.isExpired = isExpired;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public LabelBean getLabel() {
            return label;
        }

        public void setLabel(LabelBean label) {
            this.label = label;
        }

        public static class UserInfoBean {
            private int id;
            private String phoneNum;
            private String headimgUrl;
            private String posCity;
            private String longitude;
            private boolean sex;
            private String latitude;
            private int userId;
            private String posProv;
            private String nickname;

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPhoneNum() {
                return phoneNum;
            }

            public void setPhoneNum(String phoneNum) {
                this.phoneNum = phoneNum;
            }

            public String getHeadimgUrl() {
                return headimgUrl;
            }

            public void setHeadimgUrl(String headimgUrl) {
                this.headimgUrl = headimgUrl;
            }

            public String getPosCity() {
                return posCity;
            }

            public void setPosCity(String posCity) {
                this.posCity = posCity;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public boolean isSex() {
                return sex;
            }

            public void setSex(boolean sex) {
                this.sex = sex;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getPosProv() {
                return posProv;
            }

            public void setPosProv(String posProv) {
                this.posProv = posProv;
            }
        }

        public static class LabelBean {
            private int id;
            private int userId;
            private int extraversionScore;
            private int agreeablenessScore;
            private int conscientiousnessScore;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getExtraversionScore() {
                return extraversionScore;
            }

            public void setExtraversionScore(int extraversionScore) {
                this.extraversionScore = extraversionScore;
            }

            public int getAgreeablenessScore() {
                return agreeablenessScore;
            }

            public void setAgreeablenessScore(int agreeablenessScore) {
                this.agreeablenessScore = agreeablenessScore;
            }

            public int getConscientiousnessScore() {
                return conscientiousnessScore;
            }

            public void setConscientiousnessScore(int conscientiousnessScore) {
                this.conscientiousnessScore = conscientiousnessScore;
            }
        }
    }
}
