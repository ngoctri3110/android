package com.example.bai5;

public class EmployeeFullTime extends Employee{

    @Override
    public double TinhLuong() {
        return 500;
    }

    @Override
    public String toString() {
        return super.toString() + " --> Full time = " + TinhLuong();
    }
}
