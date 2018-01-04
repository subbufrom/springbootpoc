package foodapp.service;

import foodapp.entity.FoodAppEntityForCassandra;
import foodapp.entity.FoodAppEntityForElasticSearch;
import foodapp.repository.ElasticSearchRepository;
import foodapp.repository.CassandraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodAppService {

    @Autowired
    private CassandraRepository cassandraRepository;

    @Autowired
    private ElasticSearchRepository elasticSearchRepository;

    public void save(FoodAppEntityForCassandra foodAppEntityForCassandra) {
        cassandraRepository.save(foodAppEntityForCassandra);
    }

    public void saveElastic(FoodAppEntityForElasticSearch foodAppEntityForElasticSearch) {
        elasticSearchRepository.save(foodAppEntityForElasticSearch);
    }

    public List<FoodAppEntityForElasticSearch> searchAll() {
        List<FoodAppEntityForElasticSearch> foods = new ArrayList<>();
        elasticSearchRepository.findAll().forEach(foods::add);
        return foods;
    }

    public FoodAppEntityForElasticSearch findById(String id) {
        return elasticSearchRepository.findOne(id);
    }

    public List<FoodAppEntityForElasticSearch> findInRange(int from, int to) {
        List<FoodAppEntityForElasticSearch> range = new ArrayList<>();
        elasticSearchRepository.findByPriceBetween(from, to).forEach(range::add);
        return range;
    }

    public void delete(String id) {
        cassandraRepository.delete(id);
        elasticSearchRepository.delete(id);
    }


}
