package com.assignments.sales_tax;

import java.util.ArrayList;

class Product {
    private int quantity;
    private String description;
    private double price;
    private ArrayList<Tax> taxes;

    Product(int quantity, String description, double price) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.taxes = new ArrayList<>();
    }

    void addTax(Tax tax){
        this.taxes.add(tax);
    }

    double getTotalTax() {
        double totalTax = 0;
        for (Tax tax : this.taxes) {
            totalTax+=tax.getTaxAmount(this.price);
        }
        return totalTax;
    }

    String getFormattedDescription(){
        return ""+quantity+" "+description+": "+String.format("%.2f",this.getTotalPrice());
    }

    double getTotalPrice() {
        return this.price + this.getTotalTax();
    }
}
