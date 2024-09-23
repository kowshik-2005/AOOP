public class Main {
    public static void main(String[] args) {
        SalesData product1 = new SalesData("Product A", 100.0, 10);
        SalesData product2 = new SalesData("Product B", 250.0, 5);

        System.out.println("Product: " + product1.getProductName() + " Total Sales: " + product1.calculateTotalSales());
        System.out.println("Product: " + product2.getProductName() + " Total Sales: " + product2.calculateTotalSales());

        // Using Enum
        PriceCategory category = PriceCategory.MEDIUM;
        System.out.println("Price Category: " + category);

        // Using Record
        SalesRecord record = new SalesRecord("Product C", 150.0, 8);
        System.out.println("Record: " + record.productName() + " Total Sales: " + record.totalSales());

        // Using Annotation
        if (Main.class.isAnnotationPresent(RangeAnnotation.class)) {
            System.out.println("RangeAnnotation is present.");
        }
    }

    @RangeAnnotation(min = 10, max = 1000)
    public void annotatedMethod() {
        // This method is annotated
    }
}
