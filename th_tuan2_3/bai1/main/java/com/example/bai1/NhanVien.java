package com.example.bai1;

public class NhanVien {
    private String id;
    private String name;
    Boolean gender;

    public NhanVien() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.id + "-" + this.name;
    }
}
