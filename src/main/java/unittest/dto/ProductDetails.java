package unittest.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Objects;

@JsonSerialize
public class ProductDetails {
    public ProductDetails() {
    }
    public ProductDetails(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
    @JsonSerialize
    private Integer productId;

    @JsonSerialize
    private String productName;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDetails that = (ProductDetails) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName);
    }
}
