package cassandra.repository;

import cassandra.entity.FoodEntityElastic;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ElasticRepositoryConfigure extends ElasticsearchRepository<FoodEntityElastic, String> {

//    List<FoodEntityElastic> findByFood_id(String id);
//    List<FoodEntityElastic> findAll();
//    List<FoodEntityElastic> findByFood_priceBetween(int from,int to);
    public List<FoodEntityElastic>  findByPriceBetween(int from,int to);
}
