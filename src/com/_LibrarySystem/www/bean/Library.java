package com._LibrarySystem.www.bean;

public class Library {
    private int id;
    private String name;
    private String address;
    private int CuratorID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCuratorID() {
        return CuratorID;
    }

    public void setCuratorID(int CuratorID) {
        this.CuratorID = CuratorID;
    }
}
