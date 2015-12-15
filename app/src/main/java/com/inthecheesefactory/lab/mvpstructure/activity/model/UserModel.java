package com.inthecheesefactory.lab.mvpstructure.activity.model;

import org.parceler.Parcel;

/**
 * Created by nuuneoi on 12/15/2015.
 */
@Parcel
public class UserModel {

    String username = "";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
