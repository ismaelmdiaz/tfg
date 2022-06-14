package com.dichotomy.back.entity;

import javax.persistence.*;

@Entity
public class Producto {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="model", nullable = false)
    private String model;

    @Column(name="brand", nullable = false)
    private String brand;

    @Column(name="stock", nullable = false)
    private int stock;

    @Column(name="typeproduct", nullable = false)
    private String typeproduct;

    @Column(name="price", nullable = false)
    private float price;

    @Column(name="images0", nullable = false)
    private String images0;

    @Column(name="images1", nullable = true)
    private String images1;

    @Column(name="images2", nullable = true)
    private String images2;

    @Column(name="images3", nullable = true)
    private String images3;

    @Column(name="images4", nullable = true)
    private String images4;

    @Column(name="descriptionproduct1", nullable =false)
    private String descriptionproduct1;

    @Column(name="descriptionproduct2", nullable = true)
    private String descriptionproduct2;

    @Column(name="capsule", nullable = true)
    private String capsule;

    @Column(name="materials", nullable = false)
    private String materials;

    public Producto() {
    }

    public Producto(int id, String model, String brand, int stock, String typeproduct, float price, String images0, String images1, String images2, String images3, String images4, String descriptionproduct1, String descriptionproduct2, String capsule, String materials) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.stock = stock;
        this.typeproduct = typeproduct;
        this.price = price;
        this.images0 = images0;
        this.images1 = images1;
        this.images2 = images2;
        this.images3 = images3;
        this.images4 = images4;
        this.descriptionproduct1 = descriptionproduct1;
        this.descriptionproduct2 = descriptionproduct2;
        this.capsule = capsule;
        this.materials = materials;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTypeproduct() {
        return typeproduct;
    }

    public void setTypeproduct(String typeproduct) {
        this.typeproduct = typeproduct;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImages0() {
        return images0;
    }

    public void setImages0(String images0) {
        this.images0 = images0;
    }

    public String getImages1() {
        return images1;
    }

    public void setImages1(String images1) {
        this.images1 = images1;
    }

    public String getImages2() {
        return images2;
    }

    public void setImages2(String images2) {
        this.images2 = images2;
    }

    public String getImages3() {
        return images3;
    }

    public void setImages3(String images3) {
        this.images3 = images3;
    }

    public String getImages4() {
        return images4;
    }

    public void setImages4(String images4) {
        this.images4 = images4;
    }

    public String getDescriptionproduct1() {
        return descriptionproduct1;
    }

    public void setDescriptionproduct1(String descriptionproduct1) {
        this.descriptionproduct1 = descriptionproduct1;
    }

    public String getDescriptionproduct2() {
        return descriptionproduct2;
    }

    public void setDescriptionproduct2(String descriptionproduct2) {
        this.descriptionproduct2 = descriptionproduct2;
    }

    public String getCapsule() {
        return capsule;
    }

    public void setCapsule(String capsule) {
        this.capsule = capsule;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }
}
