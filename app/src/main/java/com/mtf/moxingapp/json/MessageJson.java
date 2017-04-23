package com.mtf.moxingapp.json;

import java.util.List;

/**
 * Created by Administrator on 2017/3/24.
 */
public class MessageJson {
    /**
     * code : 1
     * msg : 成功返回与自己有关的所有联系人信息！
     * data : [{"id":1,"sendId":2,"receId":3,"content":"你好","cdate":"Mar 14, 2017 9:36:48 AM"},{"id":2,"sendId":3,"receId":2,"content":"halo，我是b","cdate":"Mar 14, 2017 10:37:01 AM"},{"id":3,"sendId":2,"receId":3,"content":"我是a，hhh","cdate":"Mar 15, 2017 9:37:08 AM"},{"id":4,"sendId":3,"receId":2,"content":"我们的旅行匹配到一起啦，来聊聊吧","cdate":"Mar 20, 2017 9:36:17 PM"}]
     */

    private int code;
    private String msg;
    /**
     * id : 1
     * sendId : 2
     * receId : 3
     * content : 你好
     * cdate : Mar 14, 2017 9:36:48 AM
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
        private int sendId;
        private int receId;
        private String content;
        private String cdate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSendId() {
            return sendId;
        }

        public void setSendId(int sendId) {
            this.sendId = sendId;
        }

        public int getReceId() {
            return receId;
        }

        public void setReceId(int receId) {
            this.receId = receId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCdate() {
            return cdate;
        }

        public void setCdate(String cdate) {
            this.cdate = cdate;
        }
    }
}
