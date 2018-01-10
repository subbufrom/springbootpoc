package foodapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.validation.constraints.NotNull;

@Document(indexName = "restaurant", type = "food", shards = 1, replicas = 0)
public class FoodAppEntityForElasticSearch {

    @Id
    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String type;
    @NotNull
    private int price;

    public FoodAppEntityForElasticSearch() {

    }

    public FoodAppEntityForElasticSearch(String id, String name, String type, int price) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
