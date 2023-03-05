package products;

public class Product {
    private static int lastID = 0;
    private final int productId;
    private int quantityLeft;
    private final String productName;
    private final double price;
    private Availability availability;
    private final double discountedPrice;


    // Constructor For Product Class
    public Product(String productName, double price,int quantityLeft , Availability availability, double discountedPrice) {
        this.productId = ++lastID;
        this.productName = productName;
        this.quantityLeft = quantityLeft;
        this.price = price;
        this.availability = availability;
        this.discountedPrice = discountedPrice;
    }

    // Get Discounted Price
    public double getDiscountedPrice() {
        return discountedPrice;
    }
    //Get : Product ID
    public int getProductId() {
        return productId;
    }

    // Get : Quantity Left
    public int getQuantityLeft() {
        return quantityLeft;
    }

    // Decrease Quantity Per Product
    public void decreaseQuantity() {
       --quantityLeft;
    }

    // Increase Quantity Per Product
    public void increaseQuantity() {
        ++quantityLeft;
    }

    // Get : Product Name
    public String getProductName() {
        return productName;
    }

    // Get : Product Price
    public double getPrice() {
        return price;
    }

    // Get - Product Availability
    public Availability getAvailability() {
        return availability;
    }

    //Set - Setting Product Availability
    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

}

