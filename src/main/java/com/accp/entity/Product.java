package com.accp.entity;

public class Product {
    private String id;

    private String title;

    private String picUrl;

    private String viewPrice;

    private String nick;

    private String viewSales;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getViewPrice() {
        return viewPrice;
    }

    public void setViewPrice(String viewPrice) {
        this.viewPrice = viewPrice == null ? null : viewPrice.trim();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public String getViewSales() {
        return viewSales;
    }

    public void setViewSales(String viewSales) {
        this.viewSales = viewSales == null ? null : viewSales.trim();
    }
}