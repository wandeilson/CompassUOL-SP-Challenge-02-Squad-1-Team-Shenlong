package br.com.compassuol.sp.challenge.ecommerce.model;
import java.math.BigDecimal;

public class ProductOrder {

    private Product product;

    private int productId;
    private int quantity;

    public BigDecimal getTotal(){
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
