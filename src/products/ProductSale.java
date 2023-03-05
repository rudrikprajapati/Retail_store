package products;

import java.util.Date;

public class ProductSale {
    private final Product product;
    private final Date dateBought;

    public ProductSale(Product product, Date dateBought) {
        this.product = product;
        this.dateBought = dateBought;
    }

    public Product getProduct() {
        return product;
    }

    public Date getDateBought() {
        return dateBought;
    }
}

