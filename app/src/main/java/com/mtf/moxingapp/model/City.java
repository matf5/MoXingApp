package com.mtf.moxingapp.model;

/**
 * Created by Administrator on 2017/1/3.
 */
public class City {
    /**
     * CityID : 332
     * name : 中卫市
     * ProID : 26
     * CitySort : 332
     */

    private int CityID;
    private String name;
    private int ProID;
    private int CitySort;

    public int getCityID() {
        return CityID;
    }

    public void setCityID(int CityID) {
        this.CityID = CityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProID() {
        return ProID;
    }

    public void setProID(int ProID) {
        this.ProID = ProID;
    }

    public int getCitySort() {
        return CitySort;
    }

    public void setCitySort(int CitySort) {
        this.CitySort = CitySort;
    }
}
