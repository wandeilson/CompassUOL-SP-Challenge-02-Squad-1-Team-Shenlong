package br.com.compassuol.sp.challenge.ecommerce.model;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.util.Optional;


public class ProductOrder {

    @ManyToOne
    private Product product;

    private int productId;
    private int quantity;

   public ProductOrder(Product product, int quatity){
    this.product = product;
    this.quantity = quantity;
   }

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
