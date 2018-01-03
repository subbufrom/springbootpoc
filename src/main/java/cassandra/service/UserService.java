package cassandra.service;

import cassandra.entity.FoodEntityCassandra;
import cassandra.entity.FoodEntityElastic;
import cassandra.repository.ElasticRepositoryConfigure;
import cassandra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ElasticRepositoryConfigure elasticRepositoryConfigure;

    public void save(FoodEntityCassandra foodEntityCassandra) {
        userRepository.save(foodEntityCassandra);
    }

    public void saveElastic(FoodEntityElastic foodEntityElastic) {
        elasticRepositoryConfigure.save(foodEntityElastic);
    }

    public List<FoodEntityElastic> searchAll() {
        List<FoodEntityElastic> foods = new ArrayList<>();
        elasticRepositoryConfigure.findAll().forEach(foods::add);
        return foods;
    }

    public FoodEntityElastic findById(String id) {
        return elasticRepositoryConfigure.findOne(id);
    }

    public List<FoodEntityElastic> findrange(int from, int to) {
        List<FoodEntityElastic> range = new ArrayList<>();
        elasticRepositoryConfigure.findByPriceBetween(from, to).forEach(range::add);
        return range;
    }


}
