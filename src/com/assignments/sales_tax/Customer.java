package com.assignments.sales_tax;

import java.util.ArrayList;

class Customer {
    private ArrayList<Product> products;

    Customer() {
        this.products = new ArrayList<>();
    }

    void addProduct(Product product){
        this.products.add(product);
    }

    String getReceipt(){
        double totalPrice = 0;
        double tax = 0;
        String receipt = "";
        for (Product product : products) {
            receipt+=product.getFormattedDescription()+"\n";
            tax += product.getTotalTax();
            totalPrice += product.getTotalPrice();
        }
        receipt += "Sales Taxes: "+String.format("%.2f",tax)+"\n";
        receipt += "Total: "+String.format("%.2f",totalPrice);
        return receipt;
    }
}
