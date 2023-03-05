package products;


import java.util.ArrayList;

import static utils.Utils.print;

public class ProductHelper {
    public ArrayList<Product> products = new ArrayList<>();

    //Adding Some Demo Data!!
    public ProductHelper() {
        products.add(new Product("IPhone 7s",999.99, 5,Availability.IN_STORE, 899.99));
        products.add(new Product("IPhone 8s",1100.99,6,Availability.IN_STORE, 1000.99));
        products.add(new Product("IPhone 9s",1399.99,4,Availability.IN_STORE, 1200.22));
        products.add(new Product("IPhone 10s",1766.99,3,Availability.IN_STORE, 1660.99));
    }

    // Gets Specific Product
    public Product getSpecificProduct(int index) {
        return products.get(index);
    }

    // Display All Products
    public void showProducts() {
        print("Product ID\t| Product Name\t\t| Product Price\t\t| Discounted Price\t\t| Quantity Left\t\t| Product Availability");

        for (Product pd : products) {
            print(pd.getProductId() + "\t\t| " + pd.getProductName() + "\t\t| " + pd.getPrice() + "\t\t| " + pd.getDiscountedPrice() + "\t\t\t| " + pd.getQuantityLeft() + "\t\t\t| " + pd.getAvailability());
        }
    }


    /// Getting Total Products Length
    public int getProductLength() {
        return products.size();
    }

    // Decrease Products Quantity After We User's It
    public void decreaseProductQuantity(int productId) {
        if (products.get(productId).getQuantityLeft() > 1) {
            products.get(productId).decreaseQuantity();
        } else {
            products.get(productId).setAvailability(Availability.OUT_OF_STOCK);
            products.get(productId).decreaseQuantity();
        }
    }

    // Increase Products Quantity After User Returns It
    public void increaseProductQuantity(int productId)
    {
        if(products.get(productId).getQuantityLeft() <= 0)
        {
            products.get(productId).increaseQuantity();
            products.get(productId).setAvailability(Availability.IN_STORE);
        }
        else
        {
            products.get(productId).increaseQuantity();
        }
    }

    public int calculateFine(int days)
    {
        if (days < 0)
        {
            return (days*10); // 100$ Fine For Negative Value
        }
        if (days > 5) {
            return  (days * 10); // $10 per day fine
        } else {
            return 0;
        }
    }

}
