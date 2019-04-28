package unittest.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Coupons {
    private int id;
    private String name;

    public Coupons(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
