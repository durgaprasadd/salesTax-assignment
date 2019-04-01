package com.assignments.sales_tax;

public enum Tax {
    SALES_TAX(10),
    CUSTOM_TAX(5);

    private double tax;

    Tax(double tax) {
        this.tax = tax;
    }

    double getTaxAmount(double amount) {
        double tax = (this.tax * amount) / 100;
        double roundedValue = Math.floor(tax * 10) / 10;
        double remainingValue = tax - roundedValue;
        if (remainingValue > 0.049)
            roundedValue += 0.05;
        if (remainingValue > 0.05)
            roundedValue += 0.05;
        return roundedValue;
    }
}
