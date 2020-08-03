package com.twu.refactoring;

import java.util.List;

public class Order {
    String name;
    String addr;
    List<LineItem> itemList;
    double totalSalesTax = 0d;
    double total = 0d;


    public Order(String name, String addr, List<LineItem> itemList) {
        this.name = name;
        this.addr = addr;
        this.itemList = itemList;

        double taxRate = 0.10d;
        for (LineItem lineItem : itemList) {
            double salesTax = lineItem.totalAmount() * taxRate;
            totalSalesTax += salesTax;
            total += lineItem.totalAmount() + salesTax;
        }
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return itemList;
    }

    public double getTotal() {
        return total;
    }

    public double getTotalSalesTax() {
        return totalSalesTax;
    }

    public void printLineItems(StringBuilder output, String divider) {
        for (LineItem lineItem : itemList) {
            output.append(lineItem.getDescription());
            output.append(divider);
            output.append(lineItem.getPrice());
            output.append(divider);
            output.append(lineItem.getQuantity());
            output.append(divider);
            output.append(lineItem.totalAmount());
            output.append(divider);
        }
    }
}
