package foodapp.entity;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import javax.validation.constraints.NotNull;

@Table("food")
public class FoodAppEntityForCassandra {

    @NotNull
    @PrimaryKey
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String type;
    @NotNull
    private Long price;

    public FoodAppEntityForCassandra(){

    }

    public FoodAppEntityForCassandra(String id, String name, String type, Long price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
