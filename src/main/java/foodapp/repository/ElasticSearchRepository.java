package foodapp.repository;

import foodapp.entity.FoodAppEntityForElasticSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ElasticSearchRepository extends ElasticsearchRepository<FoodAppEntityForElasticSearch, String> {

    List<FoodAppEntityForElasticSearch>  findByPriceBetween(int from, int to);

}
