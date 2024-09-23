public record SalesRecord(String productName, double price, int quantity) {
    public double totalSales() {
        return price * quantity;
    }
}


