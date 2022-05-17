package com.codegym.cinema.dto;

public class PaypalDTO {
    private int price;
    public PaypalDTO(int price) {
        this.price = price;
    }
    public PaypalDTO() {
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
