package unittest.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Events {

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonSerialize
    private Integer id;
    @JsonSerialize
    private String name;

    public Events(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
