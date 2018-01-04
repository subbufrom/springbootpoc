package foodapp.repository;

import foodapp.entity.FoodAppEntityForCassandra;
import org.springframework.data.repository.CrudRepository;

public interface CassandraRepository extends CrudRepository<FoodAppEntityForCassandra,String> {

}
