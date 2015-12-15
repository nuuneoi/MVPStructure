package com.inthecheesefactory.lab.mvpstructure.dao;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by nuuneoi on 10/8/2015 AD.
 */
@Parcel
public class DessertItemCollectionDao {

    @SerializedName("success") private boolean success;
    @SerializedName("data")    private List<DessertItemDao> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DessertItemDao> getData() {
        return data;
    }

    public void setData(List<DessertItemDao> data) {
        this.data = data;
    }
}
