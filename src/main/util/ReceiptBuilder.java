package main.util;

import main.entity.CartItem;
import main.entity.Receipt;
import java.time.format.DateTimeFormatter;

public class ReceiptBuilder {

    public static String buildReceipt(Receipt receipt) {
        StringBuilder sb = new StringBuilder();
        String line = "=".repeat(40);
        String dateStr = receipt.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String currency = PropertiesReader.get("store.currency");

        sb.append(String.format("%s\n", line));
        sb.append(String.format("%s\n", centerText(receipt.getStoreName(), 40)));
        sb.append(String.format("No. Transaction : %s\n", receipt.getTransactionId()));
        sb.append(String.format("Date            : %s\n", dateStr));
        sb.append(String.format("%s\n", line));

        sb.append(String.format("%-20s %5s %13s\n", "Product", "Qty", "Subtotal"));
        sb.append("-".repeat(40)).append("\n");

        for (CartItem item : receipt.getDatas()) {
            sb.append(String.format(
                    "%-20s %5d %3s %,13.2f\n",
                    item.getProduct().getName(),
                    item.getQuantity(),
                    currency,
                    item.getTotalPrice()
            ));
        }

        sb.append("-".repeat(40)).append("\n");

        double tax = receipt.getTax();
        double grandTotal = receipt.getTotal();
        double change = receipt.getChange();
        String pajak = String.format("Tax (%s%%)", PropertiesReader.get("store.tax"));

        sb.append(formatAmountLine("Subtotal", currency, receipt.getSubtotal()));
        sb.append(formatAmountLine(pajak, currency, tax));
        sb.append(formatAmountLine("Total Amount", currency, grandTotal));
        sb.append(formatAmountLine("Paid", currency, receipt.getPaid()));
        sb.append(formatAmountLine("Change", currency, change));

        sb.append(String.format("%s\n", line));
        sb.append(centerText("THANKS FOR SHOPPING", 40)).append("\n");
        sb.append(centerText(PropertiesReader.get("store.name"), 40)).append("\n");
        sb.append(String.format("%s\n", line));

        return sb.toString();
    }

    private static String formatAmountLine(String label, String currency, double amount) {
        return String.format("%-25s %3s %,13.2f\n", label, currency, amount);
    }

    private static String centerText(String text, int width) {
        int padSize = (width - text.length()) / 2;
        return String.format("%" + (padSize + text.length()) + "s", text);
    }
}