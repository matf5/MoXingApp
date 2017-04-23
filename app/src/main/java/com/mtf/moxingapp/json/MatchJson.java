package com.mtf.moxingapp.json;

import java.util.List;

/**
 * Created by Administrator on 2017/3/19.
 */
public class MatchJson {

    /**
     * code : 1
     * msg : 成功返回与自己有关的所有联系人信息！
     * data : [{"id":3,"phoneNum":"13430052345","nickname":"小兰","headimgUrl":"www.taobao.com","posCity":"深圳","sex":true,"cdate":"Mar 6, 2017 10:01:14 PM","userId":9,"posProv":"广东"},{"id":4,"phoneNum":"13430054312","nickname":"小明","headimgUrl":"www.taobao.com","posCity":"广州","sex":false,"cdate":"Mar 3, 2017 12:01:21 PM","userId":11,"posProv":"广东"}]
     */

    private int code;
    private String msg;
    /**
     * id : 3
     * phoneNum : 13430052345
     * nickname : 小兰
     * headimgUrl : www.taobao.com
     * posCity : 深圳
     * sex : true
     * cdate : Mar 6, 2017 10:01:14 PM
     * userId : 9
     * posProv : 广东
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
        private String phoneNum;
        private String nickname;
        private String headimgUrl;
        private String posCity;
        private boolean sex;
        private String cdate;
        private int userId;
        private String posProv;

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

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
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

        public boolean isSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }

        public String getCdate() {
            return cdate;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
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
}
