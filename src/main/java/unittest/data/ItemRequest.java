package unittest.data;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ItemRequest {
    @JsonSerialize
    private int value;
    @JsonSerialize
    private int price;
    @JsonSerialize
    private String name;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
