public class SalesData implements SalesAnalyzer {
    private String productName;
    private double price;
    private int quantity;

    public SalesData(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double calculateTotalSales() {
        return price * quantity;
    }

    @Override
    public String getProductName() {
        return productName;
    }
}
