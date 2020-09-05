package com.bacter.bacterflashalerts.bacter.flashalert.model;

import android.graphics.drawable.Drawable;

public class AppInfo {
    private String pack, lable;
    private Drawable icon;

    public AppInfo() {
    }

    public String getPack() {

        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public AppInfo(String pack, String lable, Drawable icon) {
        this.pack = pack;
        this.lable = lable;
        this.icon = icon;
    }
}
