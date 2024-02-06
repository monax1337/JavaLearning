package learn.main;

import learn.product.Product;
import learn.sum.Sum;

public class InputMain {
    public static void main(String[] args) {
        Sum sum = new Sum();
        int sumResult = sum.calculateSum(args);
        sum.outputSum(sumResult);
        Product prod = new Product();
        int prodResult = prod.calculateProduct(args);
        prod.outputProduct(prodResult);
    }
}
