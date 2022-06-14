package com.dichotomy.back.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductoDto {

    @NotBlank
    private String model;

    @NotBlank
    private String brand;

    @Min(0)
    private int stock;

    @NotBlank
    private String typeproduct;

    @Min(0)
    private Float price;

    @NotBlank
    private String images0;

    private String images1;

    private String images2;

    private String images3;

    private String images4;

    @NotBlank
    private String descriptionproduct1;

    private String descriptionproduct2;

    private String capsule;

    @NotBlank
    private String materials;

    public ProductoDto() {
    }

    public ProductoDto(@NotBlank String model, @NotBlank String brand, @Min(0) int stock, @NotBlank String typeproduct, @Min(0) Float price, @NotBlank String images0, String images1, String images2, String images3, String images4, @NotBlank String descriptionproduct1, String descriptionproduct2, String capsule, @NotBlank String materials) {
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
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
