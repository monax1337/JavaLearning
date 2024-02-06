package learn.product;

public class Product {
    public int calculateProduct(String[] args) {
        int prod = 1;
        for (String arg : args) {
            prod *= Integer.parseInt(arg);
        }

        return prod;
    }

    public void outputProduct(int prod) {
        System.out.println("Product = " + prod);
    }
}
