package com.example.gk72_recyclerview;

import androidx.annotation.NonNull;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Product {
    private String pName;
    private int pId;
    private double pPreis;

    private static int lastProductId = 0;
    public Product(int id, String name, double preis) {
        pId = id;
        pName = name;
        pPreis = preis;
    }

    public String getName() {
        return pName;
    }

    public String getId() {
        String id = Integer.toString(pId);
        return id;
    }
    public String getPreis() {
        DecimalFormat df = new DecimalFormat("0.00");
        String preis = df.format(pPreis);
        return preis;
    }

    public static ArrayList<Product> createProductList(int nProducts) {
        ArrayList<Product> products = new ArrayList<>();

        for (int i = 0; i < nProducts; i++) {
            Product p = new Product(i, "Product " + i, Math.random() * 100);
            System.out.println(p);
            products.add(p);

        }
        return products;
    }

    @Override
    public String toString() {
        return "[Produkt] " + this.getId() + ", " + this.getName() + ", " + this.getPreis();
    }
}
