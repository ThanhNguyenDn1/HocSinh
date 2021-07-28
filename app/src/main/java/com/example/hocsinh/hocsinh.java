package com.example.hocsinh;

public class hocsinh {
    int id;
    String name;
    int old;
    boolean gioitinh;
    String sdt;
    String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    hocsinh(String name, int old, boolean gioitinh, String sdt, String email,int id){
        this.id=id;
        this.name=name;
        this.sdt=sdt;
        this.old=old;
        this.gioitinh=gioitinh;
        this.email=email;
    }

}
