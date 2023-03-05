package admin;

import products.Product;
import products.ProductHelper;

public interface AdminInterface {
    public void addProducts(Product product, ProductHelper productHelper);
    public int getTotalProducts(ProductHelper productHelper) ;
    public double getMaxProfit(ProductHelper productHelper);
}
