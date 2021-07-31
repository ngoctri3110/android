package com.example.bai2;

public class Product extends Goods{
    private Catalog Dmuc;

    public Product(String id, String name, Catalog dmuc) {
        super(id, name);
        Dmuc = dmuc;
    }

    public Product(String id, String name) {
        super(id, name);
    }

    public Product() {
    }

    public Catalog getDmuc() {
        return Dmuc;
    }

    public void setDmuc(Catalog dmuc) {
        Dmuc = dmuc;
    }
}
