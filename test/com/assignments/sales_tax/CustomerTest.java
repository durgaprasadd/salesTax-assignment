package com.assignments.sales_tax;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    void input1() throws IOException {
        Customer customer = new Customer();
        Product book = new Product(1, "book", 12.49);
        Product music_cd = new Product(1, "music CD", 14.99);
        music_cd.addTax(Tax.SALES_TAX);
        Product chocolate_bar = new Product(1, "chocolate bar", 0.85);
        customer.addProduct(book);
        customer.addProduct(music_cd);
        customer.addProduct(chocolate_bar);

        equalsFile("output1", customer.getReceipt());
    }

    @Test
    void input2() throws IOException {
        Customer customer = new Customer();
        Product importedBoxOfChocolates = new Product(1, "imported box of chocolates", 10.00);
        importedBoxOfChocolates.addTax(Tax.CUSTOM_TAX);
        Product importedBottleOfPerfume = new Product(1, "imported bottle of perfume", 47.50);
        importedBottleOfPerfume.addTax(Tax.SALES_TAX);
        importedBottleOfPerfume.addTax(Tax.CUSTOM_TAX);
        customer.addProduct(importedBoxOfChocolates);
        customer.addProduct(importedBottleOfPerfume);

        equalsFile("output2", customer.getReceipt());
    }

    @Test
    void input3() throws IOException {
        Customer customer = new Customer();
        Product importedBottleOfPerfume = new Product(1, "imported bottle of perfume", 27.99);
        importedBottleOfPerfume.addTax(Tax.SALES_TAX);
        importedBottleOfPerfume.addTax(Tax.CUSTOM_TAX);
        Product bottleOfPerfume = new Product(1, "bottle of perfume", 18.99);
        bottleOfPerfume.addTax(Tax.SALES_TAX);
        Product packetOfHeadachePills = new Product(1, "packet of headache pills", 9.75);
        Product importedBoxOfChocolates = new Product(1, "imported box of chocolates", 11.25);
        importedBoxOfChocolates.addTax(Tax.CUSTOM_TAX);
        customer.addProduct(importedBottleOfPerfume);
        customer.addProduct(bottleOfPerfume);
        customer.addProduct(packetOfHeadachePills);
        customer.addProduct(importedBoxOfChocolates);

        equalsFile("output3", customer.getReceipt());
    }

    private void equalsFile(String fileName, String actualValue) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("test/data" + '/' + fileName));
        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));
        String thisFileLine;
        while ((thisFileLine = file.readLine()) != null) {
            assertEquals(thisFileLine, actualStream.readLine(), "in file: " + fileName);
        }
    }
}