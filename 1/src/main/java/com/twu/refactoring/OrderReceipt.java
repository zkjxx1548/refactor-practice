package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder orderReceipt = new StringBuilder();
		orderReceipt.append("======Printing Orders======\n")
				.append(order.getCustomerName())
				.append(order.getCustomerAddress());
		double totSalesTx = 0d;
		double tot = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			orderReceipt.append(lineItem.getDescription())
					.append('\t')
					.append(lineItem.getPrice())
					.append('\t')
					.append(lineItem.getQuantity())
					.append('\t')
					.append(lineItem.totalAmount())
					.append('\n');
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;
            tot += lineItem.totalAmount() + salesTax;
		}
		orderReceipt.append("Sales Tax")
				.append('\t')
				.append(totSalesTx)
				.append("Total Amount")
				.append('\t').append(tot);
		return orderReceipt.toString();
	}
}