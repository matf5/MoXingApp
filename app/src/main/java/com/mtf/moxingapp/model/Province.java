package com.mtf.moxingapp.model;

/**
 * Created by Administrator on 2017/1/3.
 */
public class Province {
    /**
     * ProID : 1
     * name : 北京市
     * ProSort : 1
     * ProRemark : 直辖市
     */

    private int ProID;
    private String name;
    private int ProSort;
    private String ProRemark;

    public int getProID() {
        return ProID;
    }

    public void setProID(int ProID) {
        this.ProID = ProID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProSort() {
        return ProSort;
    }

    public void setProSort(int ProSort) {
        this.ProSort = ProSort;
    }

    public String getProRemark() {
        return ProRemark;
    }

    public void setProRemark(String ProRemark) {
        this.ProRemark = ProRemark;
    }
}
