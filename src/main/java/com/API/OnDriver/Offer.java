package com.API.OnDriver;

public class Offer {
    private double price;
    private double discountedPrice;
    private Driver driver;

    public Offer(double price, Driver driver) {
        this.driver = driver;
        this.price = price;
        discountedPrice = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountedPrice(){
        return discountedPrice;
    }

    public void makeDiscount(int percentage){
        discountedPrice -= 1.0 * price * percentage / 100;
        discountedPrice = Math.max(0.0, discountedPrice);
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "price: " + discountedPrice +
                " || driver name: " + driver.getUsername() + " || driver phone number: " + driver.getMobileNumber()
                + " || driver license: " + driver.getDriverLicense() + " || driver average rating: " + driver.getRating().getAverageRating();
    }
}
