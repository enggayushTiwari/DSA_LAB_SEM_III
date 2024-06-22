import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {

    private List<Integer> prefixProducts;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1); // Initialize with a product of 1
    }

    public void add(int num) {
        if (num == 0) {
            prefixProducts = new ArrayList<>(); // Reset on encountering 0
            prefixProducts.add(1);
        } else {
            int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
            int newProduct = lastProduct * num;
            prefixProducts.add(newProduct);
        }
    }

    public int getProduct(int k) {
        int n = prefixProducts.size();
        if (n < k) {
            return 0; // Not enough numbers in the stream
        } else {
            return prefixProducts.get(n - 1) / prefixProducts.get(n - k - 1);
        }
    }
}
