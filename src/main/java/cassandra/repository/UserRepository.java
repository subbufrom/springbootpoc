package cassandra.repository;

import cassandra.entity.FoodEntityCassandra;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<FoodEntityCassandra,String> {

}
