package admin;

import products.Product;
import products.ProductHelper;

public class Admin implements AdminInterface {

    // Add A New Product In System - Only To Be Done By Admin
    @Override
    public void addProducts(Product product,ProductHelper productHelper)
    {
        productHelper.products.add(product);
    }

    // Get Total Quantity -  All Products
    @Override
    public int getTotalProducts(ProductHelper productHelper) {
        int total = 0;
        for (Product pd : productHelper.products)
        {
            total += pd.getQuantityLeft();
        }
        return total;
    }

    // Get A Estimate Of How Much Profit / Money We Can Make If We Sell All Products
    @Override
    public double getMaxProfit(ProductHelper productHelper) {
        //Assuming We Have Margin Of 50% Average (Including All Products) , Hence We After Selling At It Double Price , We Will Make 50% Profit
        final double PROFIT_MARGIN = 0.5;
        double total = 0;
        for (Product pd : productHelper.products)
        {
            total += (pd.getQuantityLeft()) *(pd.getPrice());
        }
        return total*PROFIT_MARGIN;
    }

}
