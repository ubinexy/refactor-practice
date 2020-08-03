package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order o;

    public OrderReceipt(Order o) {
        this.o = o;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		addHeader(output);
		o.printLineItems(output, "\t");

		return output.toString();
	}


	private void addHeader(StringBuilder output) {
		output.append("======Printing Orders======\n");
		output.append(o.getCustomerName());
		output.append(o.getCustomerAddress());
	}


	private void addTotalPrice(StringBuilder output) {
		output.append("Sales Tax");
		output.append('\t');
		output.append(o.getTotalSalesTax());
		output.append("Total Amount");
		output.append('\t');
		output.append(o.getTotal());
	}
}