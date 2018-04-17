package com.example.sajan.app3;

/**
 * Created by deepak on 09/03/18.
 */

public class Product {
    private int id;
    private String title;
    private String shortdesc;
    private double rating;
    private int price;
    private String image;
    private String description;

    public Product(int id, String title, String shortdesc, double rating, int price, String image,String description) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.price = price;
        this.image = image;
        this.description=description;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
   public String getDescription() {
        return description;
    }
}