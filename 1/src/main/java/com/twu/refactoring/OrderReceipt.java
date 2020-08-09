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
    private final static double TAX = 0.10;
    private final static String RECEIPT_TITLE = "======Printing Orders======\n";
	private final static String SALES_TAX_STR = "Sales Tax";
	private final static String TOTAL_AMOUNT_STR = "Total Amount";

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder orderReceipt = new StringBuilder();
		orderReceipt.append(RECEIPT_TITLE)
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
            double salesTax = lineItem.totalAmount() * TAX;
            totSalesTx += salesTax;
            tot += lineItem.totalAmount() + salesTax;
		}
		orderReceipt.append(SALES_TAX_STR)
				.append('\t')
				.append(totSalesTx)
				.append(TOTAL_AMOUNT_STR)
				.append('\t')
				.append(tot);
		return orderReceipt.toString();
	}
}